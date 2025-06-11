package com.bamboobyte.APIAutoGyn.Services;

import com.bamboobyte.APIAutoGyn.DTO.*;
import com.bamboobyte.APIAutoGyn.Entities.Veiculo;
import com.bamboobyte.APIAutoGyn.Repositories.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<VeiculoDTO> listarVeiculosCadastrados() {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return veiculos.stream()
                       .map(VeiculoDTO::new)
                       .collect(Collectors.toList());
    }


    @Transactional
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
}
