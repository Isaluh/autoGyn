package com.bamboobyte.APIAutoGyn.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarPecaDTO;
import com.bamboobyte.APIAutoGyn.DTO.ListaPecaDTO;
import com.bamboobyte.APIAutoGyn.Entities.Peca;
import com.bamboobyte.APIAutoGyn.Repositories.PecaRepository;

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

    public List<ListaPecaDTO> listarPecas() {
        List<Peca> pecas = pecaRepository.findAll();
        return pecas.stream()
                .map(ListaPecaDTO::new)
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

}
