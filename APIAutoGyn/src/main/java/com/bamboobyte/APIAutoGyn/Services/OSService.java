package com.bamboobyte.APIAutoGyn.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarOSDTO;
import com.bamboobyte.APIAutoGyn.DTO.ListaOSDTO;
import com.bamboobyte.APIAutoGyn.DTO.OSDTO;
import com.bamboobyte.APIAutoGyn.Entities.Etapa;
import com.bamboobyte.APIAutoGyn.Entities.ItemPeca;
import com.bamboobyte.APIAutoGyn.Entities.OS;
import com.bamboobyte.APIAutoGyn.Repositories.ColaboradorRepository;
import com.bamboobyte.APIAutoGyn.Repositories.OSRepository;
import com.bamboobyte.APIAutoGyn.Repositories.PecaRepository;
import com.bamboobyte.APIAutoGyn.Repositories.ServicoRepository;
import com.bamboobyte.APIAutoGyn.Repositories.VeiculoRepository;

@Service
public class OSService {

    private final OSRepository osRepository;
    private final PecaRepository pecaRepository;
    private final VeiculoRepository veiculoRepository;
    private final ServicoRepository servicoRepository;
    private final ColaboradorRepository colaboradorRepository;

    public OSService(OSRepository osRepository, PecaRepository pecaRepository, VeiculoRepository veiculoRepository,
            ServicoRepository servicoRepository, ColaboradorRepository colaboradorRepository) {
        this.osRepository = osRepository;
        this.pecaRepository = pecaRepository;
        this.veiculoRepository = veiculoRepository;
        this.servicoRepository = servicoRepository;
        this.colaboradorRepository = colaboradorRepository;
    }

    public List<ListaOSDTO> listarOSCadastradas() {
        List<OS> osList = osRepository.findAll();
        return osList.stream()
                .map(ListaOSDTO::new)
                .collect(Collectors.toList());
    }

    public OSDTO getOs(Long idOs) {
        OS os = osRepository.findById(idOs)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada com ID: " + idOs));
        return new OSDTO(os);
    }

    public Long criarOS(CadastrarOSDTO novaOS) {
        OS os = new OS(
                novaOS,
                veiculoRepository,
                servicoRepository,
                colaboradorRepository,
                pecaRepository);
        OS osSalvo = osRepository.save(os);

        if (osSalvo != null) {
            retirarEstoque(osSalvo);
        }

        return osSalvo.getId();
    }

    private void retirarEstoque(OS os) {
        for (ItemPeca item : os.getItensPeca()) {
            item.getPeca().setQuantidadeEstoque(item.getPeca().getQuantidadeEstoque() - item.getQuantidade());
            pecaRepository.save(item.getPeca());
        }
    }

    private void devolverEstoque(OS os) {
        for (ItemPeca item : os.getItensPeca()) {
            item.getPeca().setQuantidadeEstoque(item.getPeca().getQuantidadeEstoque() + item.getQuantidade());
            pecaRepository.save(item.getPeca());
        }
    }

    public String aprovarExecucaoOS(Long id) {
        OS os = osRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada com ID: " + id));

        if (!os.getEtapa().equals(Etapa.ORCAMENTO)) {
            throw new RuntimeException("Somente OS em 'Orçamento' podem ser aprovadas.");
        }

        os.setEtapa(Etapa.EXECUCAO);
        osRepository.save(os);
        return "Execução da Ordem de Serviço iniciada!";
    }

    public String cancelarOS(Long idOs) {
        OS os = osRepository.findById(idOs)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada com ID: " + idOs));
        os.setEtapa(Etapa.CANCELADO);
        devolverEstoque(os);
        osRepository.save(os);

        return "Ordem de Serviço cancelada com sucesso!";
    }

    public String pagarOS(Long idOs, Double valorPago) {
        OS os = osRepository.findById(idOs)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada com ID: " + idOs));

        if (!os.getEtapa().equals(Etapa.EXECUCAO)) {
            throw new RuntimeException("Só é possível pagar OS em execução.");
        }

        if (valorPago == null || valorPago <= 0) {
            throw new RuntimeException("Valor pago deve ser maior que zero.");
        }

        Double valorPagoAtual = os.getValorPago();
        if (valorPagoAtual == null) {
            valorPagoAtual = 0.0;
        }

        double valorRestante = os.getValorTotal() - valorPagoAtual;

        if (valorPago > valorRestante) {
            throw new RuntimeException("Valor pago excede o valor restante da OS.");
        }

        os.setValorPago(valorPagoAtual + valorPago);

        if (os.getValorPago() >= os.getValorTotal()) {
            os.setEtapa(Etapa.FINALIZADO);
        }

        osRepository.save(os);

        return os.getEtapa().equals(Etapa.FINALIZADO)
                ? "Pagamento concluído e OS finalizada!"
                : "Pagamento parcial registrado com sucesso!";
    }


    public OS buscarEntidadeOSPorId(Long id) {
        return osRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OS não encontrada com ID: " + id));
    }
}
