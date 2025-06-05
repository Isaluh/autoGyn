package com.bamboobyte.APIAutoGyn.Services;

import com.bamboobyte.APIAutoGyn.DTO.*;
import com.bamboobyte.APIAutoGyn.Entities.Veiculo;
import com.bamboobyte.APIAutoGyn.Repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<VeiculoDTO> listarVeiculosCadastrados() {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return veiculos.stream()
                       .map(VeiculoDTO::new)
                       .collect(Collectors.toList());
    }

    public List<AcessorioDTO> listarAcessorios() {
        return null;
    }

    @Transactional
    public String criarVeiculo(CadastrarVeiculoDTO novoVeiculoDTO) {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(novoVeiculoDTO.getPlaca());
        veiculo.setKm(novoVeiculoDTO.getkm());
        veiculo.setAnoFabricacao(novoVeiculoDTO.getAnoFabricacao());
        veiculo.setNumPatrimonio(novoVeiculoDTO.getNumeroPatrimonio());
        veiculo.setNumChassi(novoVeiculoDTO.getNumeroChassi());
        veiculo.setAnoModelo(novoVeiculoDTO.getAnoModelo());
        veiculoRepository.save(veiculo);

        return "Veículo cadastrado com sucesso!";
    }

    @Transactional
    public String atualizarVeiculo(String placa, AtualizarVeiculoDTO atualizarVeiculoDTO) {
        Veiculo veiculo = veiculoRepository.findById(placa).orElse(null);

        if (veiculo == null) {
            return "Veículo não encontrado!";
        }

        veiculo.setKm(atualizarVeiculoDTO.getKm());
        veiculo.setAnoFabricacao(atualizarVeiculoDTO.getAnoFabricacao());
        veiculo.setAnoModelo(atualizarVeiculoDTO.getAnoModelo());

        veiculoRepository.save(veiculo);
        return "Veículo atualizado com sucesso!";
    }

    public VeiculoDTO encontrarPorPlaca(String placa) {
        Veiculo veiculo = veiculoRepository.findById(placa).orElse(null);
        return (veiculo != null) ? new VeiculoDTO(veiculo) : null;
    }
}
