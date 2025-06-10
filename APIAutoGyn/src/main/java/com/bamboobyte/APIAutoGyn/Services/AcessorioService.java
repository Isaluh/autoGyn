package com.bamboobyte.APIAutoGyn.Services;

import com.bamboobyte.APIAutoGyn.DTO.AcessorioDTO;
import com.bamboobyte.APIAutoGyn.Entities.Acessorio;
import com.bamboobyte.APIAutoGyn.Repositories.AcessorioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcessorioService {

    private final AcessorioRepository acessorioRepository;

    public AcessorioService(AcessorioRepository acessorioRepository) {
        this.acessorioRepository = acessorioRepository;
    }

    public Acessorio salvarAcessorio(AcessorioDTO dto) {
        Acessorio acessorio = new Acessorio();
        acessorio.setDescricao(dto.getDescricao());
        
        return acessorioRepository.save(acessorio);
    }

    public List<AcessorioDTO> listarAcessorios() {
        List<Acessorio> acessorios = acessorioRepository.findAll();
        return AcessorioDTO.convertAcessorios(acessorios);
    }

    public Acessorio buscarAcessorioPorId(Long id) {
        if (!acessorioRepository.existsById(id)) {
            throw new RuntimeException("Acessório não encontrado com ID: " + id);
        }
        return acessorioRepository.getReferenceById(id); 
    }

    public void excluirAcessorio(Long id) {
        if (!acessorioRepository.existsById(id)) {
            throw new RuntimeException("Acessório não encontrado para exclusão com ID: " + id);
        }
        acessorioRepository.deleteById(id);
    }

    public Acessorio atualizarAcessorio(Long id, Acessorio acessorioAtualizado) {
        if (!acessorioRepository.existsById(id)) {
            throw new RuntimeException("Acessório não encontrado com ID: " + id);
        }
        Acessorio acessorio = acessorioRepository.getReferenceById(id);
        acessorio.setDescricao(acessorioAtualizado.getDescricao());
        return acessorioRepository.save(acessorio);
    }
}