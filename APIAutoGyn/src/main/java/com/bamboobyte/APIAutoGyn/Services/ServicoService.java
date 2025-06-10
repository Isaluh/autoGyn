package com.bamboobyte.APIAutoGyn.Services;

import org.springframework.stereotype.Service;

import com.bamboobyte.APIAutoGyn.DTO.ServicoDTO;
import com.bamboobyte.APIAutoGyn.Entities.Servico;
import com.bamboobyte.APIAutoGyn.Repositories.ServicoRepository;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public ServicoDTO salvarServico(ServicoDTO dto) {
        validarServico(dto);

        Servico servico = dto.toEntity();
        Servico salvo = servicoRepository.save(servico);

        return new ServicoDTO(salvo);
    }

    public List<ServicoDTO> listarTodosServicos() {
        return servicoRepository.findAll().stream()
                .map(ServicoDTO::new)
                .toList();
    }

    public ServicoDTO buscarServicoPorId(Long id) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com ID: " + id));

        return new ServicoDTO(servico);
    }

    public ServicoDTO atualizarServico(Long id, ServicoDTO dto) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com ID: " + id));

        if (dto.getDescricao() != null && !dto.getDescricao().isEmpty()) {
            servico.setDescricao(dto.getDescricao());
        }

        if (dto.getValor() != null && dto.getValor() > 0) {
            servico.setValor(dto.getValor());
        }

        Servico atualizado = servicoRepository.save(servico);
        return new ServicoDTO(atualizado);
    }

    public void excluirServico(Long id) {
        if (!servicoRepository.existsById(id)) {
            throw new RuntimeException("Serviço não encontrado para exclusão com ID: " + id);
        }
        servicoRepository.deleteById(id);
    }

    private void validarServico(ServicoDTO dto) {
        if (dto.getDescricao() == null || dto.getDescricao().isBlank()) {
            throw new RuntimeException("A descrição do serviço é obrigatória.");
        }
        if (dto.getValor() == null || dto.getValor() <= 0) {
            throw new RuntimeException("O valor do serviço deve ser maior que zero.");
        }
    }
}