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


    public String criarVeiculo(CadastrarVeiculoDTO novoVeiculoDTO) {
        if (novoVeiculoDTO == null || novoVeiculoDTO.getPlaca() == null || novoVeiculoDTO.getPlaca().isEmpty()) {
            throw new RuntimeException("Dados do veículo inválidos.");
        }

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(novoVeiculoDTO.getPlaca());
        veiculo.setKm(novoVeiculoDTO.getkm());
        veiculo.setAnoFabricacao(novoVeiculoDTO.getAnoFabricacao());

        veiculoRepository.save(veiculo);
        return "Veículo cadastrado com sucesso!";
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
