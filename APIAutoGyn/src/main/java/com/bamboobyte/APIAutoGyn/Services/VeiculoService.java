package com.bamboobyte.APIAutoGyn.Services;

import com.bamboobyte.APIAutoGyn.DTO.*;
import com.bamboobyte.APIAutoGyn.Entities.Acessorio;
import com.bamboobyte.APIAutoGyn.Entities.Cliente;
import com.bamboobyte.APIAutoGyn.Entities.Modelo;
import com.bamboobyte.APIAutoGyn.Entities.Propriedade;
import com.bamboobyte.APIAutoGyn.Entities.Veiculo;
import com.bamboobyte.APIAutoGyn.Repositories.AcessorioRepository;
import com.bamboobyte.APIAutoGyn.Repositories.ClienteRepository;
import com.bamboobyte.APIAutoGyn.Repositories.ModeloRepository;
import com.bamboobyte.APIAutoGyn.Repositories.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ModeloRepository modeloRepository;
    private final AcessorioRepository acessorioRepository;
    private final ClienteRepository clienteRepository;

    public VeiculoService(VeiculoRepository veiculoRepository,
                      ModeloRepository modeloRepository,
                      AcessorioRepository acessorioRepository, ClienteRepository clienteRepository) {
        this.veiculoRepository = veiculoRepository;
        this.modeloRepository = modeloRepository;
        this.acessorioRepository = acessorioRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<VeiculoDTO> listarVeiculosCadastrados() {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return veiculos.stream()
                       .map(VeiculoDTO::new)
                       .collect(Collectors.toList());
    }

    public List<AcessorioDTO> listarAcessorios() {
        return null;
    }

    public String criarVeiculo(CadastrarVeiculoDTO novoVeiculoDTO) {
        if (novoVeiculoDTO == null || novoVeiculoDTO.getPlaca() == null || novoVeiculoDTO.getPlaca().isEmpty()) {
            throw new RuntimeException("Dados do veículo inválidos.");
        }

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(novoVeiculoDTO.getPlaca());
        veiculo.setKm(novoVeiculoDTO.getkm());
        veiculo.setAnoFabricacao(novoVeiculoDTO.getAnoFabricacao());
        veiculo.setNumPatrimonio(novoVeiculoDTO.getNumeroPatrimonio());
        veiculo.setNumChassi(novoVeiculoDTO.getNumeroChassi());
        veiculo.setAnoModelo(novoVeiculoDTO.getAnoModelo());

        if (novoVeiculoDTO.getIdModelo() != null) {
            Modelo modelo = modeloRepository.findById(novoVeiculoDTO.getIdModelo())
                    .orElseThrow(() -> new RuntimeException("Modelo não encontrado com id: " + novoVeiculoDTO.getIdModelo()));
            veiculo.setModelo(modelo);
        }

        if (novoVeiculoDTO.getIdCliente() != null) {
            Cliente cliente = clienteRepository.findById(novoVeiculoDTO.getIdCliente())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + novoVeiculoDTO.getIdCliente()));

            Propriedade propriedade = new Propriedade();
            propriedade.setCliente(cliente);
            propriedade.setVeiculo(veiculo);
            propriedade.setDataInicio(new Date());

            veiculo.setPropriedades(List.of(propriedade));
        }

        if (novoVeiculoDTO.getAcessorios() != null && !novoVeiculoDTO.getAcessorios().isEmpty()) {
            List<Acessorio> acessorios = acessorioRepository.findAllById(novoVeiculoDTO.getAcessorios());

            for (Acessorio acessorio : acessorios) {
                acessorio.setVeiculo(veiculo);
            }

            veiculo.setAcessorios(acessorios);
        }

        veiculoRepository.save(veiculo);
        return "Veículo cadastrado com sucesso!";
    }


    public String atualizarVeiculo(String placa, AtualizarVeiculoDTO atualizarVeiculoDTO) {
        Veiculo veiculo = veiculoRepository.findById(placa)
            .orElseThrow(() -> new RuntimeException("Veículo não encontrado com placa: " + placa));

        veiculo.setKm(atualizarVeiculoDTO.getKm());
        veiculo.setAnoFabricacao(atualizarVeiculoDTO.getAnoFabricacao());
        veiculo.setAnoModelo(atualizarVeiculoDTO.getAnoModelo());

        veiculoRepository.save(veiculo);
        return "Veículo atualizado com sucesso!";
    }

    public VeiculoDTO encontrarPorPlaca(String placa) {
        Veiculo veiculo = veiculoRepository.findById(placa)
            .orElseThrow(() -> new RuntimeException("Veículo não encontrado com placa: " + placa));

        return new VeiculoDTO(veiculo);
    }

    public String deletarVeiculoPorId(String placa) {
        Veiculo veiculo = veiculoRepository.findById(placa)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com id: " + placa));

        veiculoRepository.delete(veiculo);
        return "Veículo deletado com sucesso!";
    }

}
