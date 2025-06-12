package com.bamboobyte.APIAutoGyn.Services;

import com.bamboobyte.APIAutoGyn.DTO.*;
import com.bamboobyte.APIAutoGyn.Entities.Modelo;
import com.bamboobyte.APIAutoGyn.Entities.Veiculo;
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
    private final ClienteRepository clienteRepository;

    public VeiculoService(VeiculoRepository veiculoRepository,
                      ModeloRepository modeloRepository, ClienteRepository clienteRepository) {
        this.veiculoRepository = veiculoRepository;
        this.modeloRepository = modeloRepository;
        this.clienteRepository = clienteRepository;
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

        // Veiculo veiculo = new Veiculo();
        // veiculo.setPlaca(cadastrarVeiculoDTO.getPlaca());
        // veiculo.setIdCliente(cadastrarVeiculoDTO.getIdCliente()); 
        // veiculo.setAnoFabricacao(cadastrarVeiculoDTO.getAnoFabricacao());
        // veiculo.setModelo(modelo);  
        // veiculo.setKm(cadastrarVeiculoDTO.getkm());

      
        // veiculoRepository.save(veiculo);

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
