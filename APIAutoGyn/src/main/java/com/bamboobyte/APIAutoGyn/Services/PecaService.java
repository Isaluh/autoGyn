package com.bamboobyte.APIAutoGyn.Services;

import com.bamboobyte.APIAutoGyn.DTO.AtualizarPecaDTO;
import com.bamboobyte.APIAutoGyn.DTO.CadastrarPecaDTO;
import com.bamboobyte.APIAutoGyn.DTO.PecaListaDTO;
import com.bamboobyte.APIAutoGyn.Entities.Peca;
import com.bamboobyte.APIAutoGyn.Repositories.PecaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PecaService {

    private final PecaRepository pecaRepository;

    public PecaService(PecaRepository pecaRepository) {
        this.pecaRepository = pecaRepository;
    }

    public String cadastrarPeca(CadastrarPecaDTO novaPeca) {
        Peca peca = new Peca(novaPeca);
        pecaRepository.save(peca); 
        return "Peça cadastrada com sucesso.";
    }

    public List<PecaListaDTO> listarPecas() {
        List<Peca> pecas = pecaRepository.findAll();
        return pecas.stream()
                .map(PecaListaDTO::new)
                .collect(Collectors.toList());
    }

    public Peca findById(Long idPeca) {
        return pecaRepository.findById(idPeca)
                .orElseThrow(() -> new RuntimeException("Peça não encontrada com ID: " + idPeca));
    }

    public boolean addNoEstoque(Long idPeca, Integer quantidade) {
        Peca peca = pecaRepository.findById(idPeca)
                .orElseThrow(() -> new RuntimeException("Peça não encontrada com ID: " + idPeca));
        
        peca.setQuantidadeEstoque(peca.getQuantidadeEstoque() + quantidade);
        pecaRepository.save(peca); 
        
        return true;
    }

    public String atualizarPeca(Long idPeca, AtualizarPecaDTO atualizarPeca) {
        Peca peca = pecaRepository.findById(idPeca)
                .orElseThrow(() -> new RuntimeException("Peça não encontrada com ID: " + idPeca));

        peca.setDescricao(atualizarPeca.getDescricao());
        peca.setValorUnitario(atualizarPeca.getValorUnitario());
        peca.setQuantidadeEstoque(atualizarPeca.getQuantidadeEstoque());
        
        pecaRepository.save(peca);
        return "Peça atualizada com sucesso.";
    }
}
