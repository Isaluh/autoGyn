package com.bamboobyte.APIAutoGyn.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bamboobyte.APIAutoGyn.Entities.Servico;
import com.bamboobyte.APIAutoGyn.Repositories.ServicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public Servico salvarServico(Servico servico) {
        if (servico.getDescricao() == null || servico.getDescricao().isEmpty()) {
            throw new RuntimeException("A descrição do serviço é obrigatória.");
        }
        if (servico.getValor() == null || servico.getValor() <= 0) {
            throw new RuntimeException("O valor do serviço deve ser maior que zero.");
        }
        return servicoRepository.save(servico); 
    }

    public List<Servico> listarTodosServicos() {
        return servicoRepository.findAll(); 
    }

    public Servico buscarServicoPorId(Long id) {
        Optional<Servico> servicoOptional = servicoRepository.findById(id);
        if (servicoOptional.isPresent()) {
            return servicoOptional.get();
        } else {
            throw new RuntimeException("Serviço não encontrado com ID: " + id);
        }
    }

    public Servico atualizarServico(Long id, Servico servicoAtualizado) {
        if (!servicoRepository.existsById(id)) {
            throw new RuntimeException("Serviço não encontrado com ID: " + id);
        }

        Servico servicoExistente = servicoRepository.findById(id).get();

        if (servicoAtualizado.getDescricao() != null && !servicoAtualizado.getDescricao().isEmpty()) {
            servicoExistente.setDescricao(servicoAtualizado.getDescricao());
        }

        if (servicoAtualizado.getValor() != null && servicoAtualizado.getValor() > 0) {
            servicoExistente.setValor(servicoAtualizado.getValor());
        }

        return servicoRepository.save(servicoExistente);
    }

    public void excluirServico(Long id) {
        if (!servicoRepository.existsById(id)) {
            throw new RuntimeException("Serviço não encontrado para exclusão com ID: " + id);
        }
        servicoRepository.deleteById(id);
    }
}
