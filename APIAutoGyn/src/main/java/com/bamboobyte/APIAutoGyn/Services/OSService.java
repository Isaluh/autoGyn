package com.bamboobyte.APIAutoGyn.Services;

import java.util.List;
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
                .map(os -> new ListaOSDTO(os))
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

    public String aprovarOS(Long id) {
        OS os = osRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada com ID: " + id));

        if (os.getEtapa() != Etapa.ORCAMENTO) {
            return "ETAPA deve ser Orçamento para poder ser aprovada. Etapa atual: " + os.getEtapa();
        }

        if (os.getItensServico() == null || os.getItensServico().isEmpty()) {
            os.setEtapa(Etapa.FINALIZADO);
        } else {
            os.setEtapa(Etapa.APROVADO);
        }

        osRepository.save(os);
        return "Ordem de Serviço aprovada com sucesso!";
    }

    public String iniciarExecucaoOS(Long id) {
        OS os = osRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada com ID: " + id));

        if (os.getEtapa() != Etapa.APROVADO) {
            return "ETAPA deve ser 'Aprovada' para poder entrar em execução. Etapa atual: " + os.getEtapa();
        }

        os.setEtapa(Etapa.EXECUCAO);
        osRepository.save(os);
        return "Execução da Ordem de Serviço iniciada!";
    }

    public String cancelarOS(Long idOs) {
        OS os = osRepository.findById(idOs)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada com ID: " + idOs));

        devolverEstoque(os);
        osRepository.deleteById(idOs);
        return "Ordem de Serviço cancelada com sucesso!";
    }

    public String pagarOS(Long idOs, Double valorPago) {
        OS os = osRepository.findById(idOs)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada com ID: " + idOs));

        if (valorPago == null || valorPago <= 0) {
            throw new RuntimeException("Valor pago deve ser maior que zero.");
        }

        os.setValorPago(valorPago);
        os.setEtapa(Etapa.PAGO);
        osRepository.save(os);
        return "Ordem de Serviço paga com sucesso!";
    }
}
