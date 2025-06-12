package com.bamboobyte.APIAutoGyn.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarVeiculoDTO;
import com.bamboobyte.APIAutoGyn.DTO.VeiculoDTO;
import com.bamboobyte.APIAutoGyn.Entities.Cliente;
import com.bamboobyte.APIAutoGyn.Entities.Modelo;
import com.bamboobyte.APIAutoGyn.Entities.Veiculo;
import com.bamboobyte.APIAutoGyn.Repositories.ClienteRepository;
import com.bamboobyte.APIAutoGyn.Repositories.ModeloRepository;
import com.bamboobyte.APIAutoGyn.Repositories.VeiculoRepository;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ModeloRepository modeloRepository;
    private final ClienteRepository clienteRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, ModeloRepository modeloRepository,
            ClienteRepository clienteRepository) {
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

    public String criarVeiculo(CadastrarVeiculoDTO dto) {
        if (dto == null || dto.getPlaca() == null || dto.getPlaca().isEmpty()) {
            throw new RuntimeException("Dados do veículo inválidos.");
        }

        Modelo modelo = modeloRepository.findById(dto.getIdModelo())
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado com ID: " + dto.getIdModelo()));

        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + dto.getIdCliente()));

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setAnoFabricacao(dto.getAnoFabricacao());
        veiculo.setKm(dto.getkm());
        veiculo.setModelo(modelo);
        veiculo.setCliente(cliente);

        veiculoRepository.save(veiculo);

        return "Veículo cadastrado com sucesso!";
    }
}
