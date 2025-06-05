package com.bamboobyte.APIAutoGyn.Services;

import com.bamboobyte.APIAutoGyn.Entities.Acessorio;
import com.bamboobyte.APIAutoGyn.Repositories.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcessorioService {

    private final AcessorioRepository acessorioRepository;

    @Autowired
    public AcessorioService(AcessorioRepository acessorioRepository) {
        this.acessorioRepository = acessorioRepository;
    }

    public Acessorio salvarAcessorio(Acessorio acessorio) {
        return acessorioRepository.save(acessorio);
    }

    public List<Acessorio> listarAcessorios() {
        return acessorioRepository.findAll();
    }

    public Acessorio buscarAcessorioPorId(Long id) {
        if (!acessorioRepository.existsById(id)) {
            throw new RuntimeException("Acessório não encontrado com ID: " + id);
        }
        return acessorioRepository.getReferenceById(id); // ou acessorioRepository.findById(id).get()
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
        acessorio.setVeiculo(acessorioAtualizado.getVeiculo());
        return acessorioRepository.save(acessorio);
    }
}
