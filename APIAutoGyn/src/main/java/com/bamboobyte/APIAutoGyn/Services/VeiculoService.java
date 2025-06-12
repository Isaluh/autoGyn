package com.bamboobyte.APIAutoGyn.Services;

import com.bamboobyte.APIAutoGyn.DTO.*;
import com.bamboobyte.APIAutoGyn.Entities.Modelo;
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


    public String criarVeiculo(CadastrarVeiculoDTO cadastrarVeiculoDTO) {
        if (cadastrarVeiculoDTO == null || cadastrarVeiculoDTO.getPlaca() == null || cadastrarVeiculoDTO.getPlaca().isEmpty()) {
            throw new RuntimeException("Dados do veículo inválidos.");
        }

        Modelo modelo = modeloRepository.findById(cadastrarVeiculoDTO.getIdModelo())
            .orElseThrow(() -> new RuntimeException("Modelo não encontrado com ID: " + cadastrarVeiculoDTO.getIdModelo()));

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(cadastrarVeiculoDTO.getPlaca());
        veiculo.setIdCliente(cadastrarVeiculoDTO.getIdCliente()); 
        veiculo.setAnoFabricacao(cadastrarVeiculoDTO.getAnoFabricacao());
        veiculo.setModelo(modelo);  
        veiculo.setKm(cadastrarVeiculoDTO.getkm());

      
        veiculoRepository.save(veiculo);

        return "Veículo cadastrado com sucesso!";
    }

    public VeiculoDTO encontrarPorPlaca(String placa) {
        Veiculo veiculo = veiculoRepository.findById(placa)
            .orElseThrow(() -> new RuntimeException("Veículo não encontrado com placa: " + placa));

        return new VeiculoDTO(veiculo);
    }
}
