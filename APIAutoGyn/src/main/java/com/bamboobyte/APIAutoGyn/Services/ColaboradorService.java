package com.bamboobyte.APIAutoGyn.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bamboobyte.APIAutoGyn.DTO.ListaColaboradorDTO;
import com.bamboobyte.APIAutoGyn.Entities.Colaborador;
import com.bamboobyte.APIAutoGyn.Repositories.ColaboradorRepository;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    public List<ListaColaboradorDTO> listarTodos() {
        return colaboradorRepository.findAll().stream()
            .map(colaborador -> {
              
                return new ListaColaboradorDTO("[" + colaborador.getCpf(), "] | " + colaborador.getNome());
            })
            .collect(Collectors.toList());
    }


    public Colaborador incluirColaborador(Colaborador novoColaborador) {
        if (novoColaborador.getCpf() == null || novoColaborador.getCpf().isEmpty()) {
            throw new RuntimeException("O CPF do colaborador é obrigatório.");
        }

        Colaborador colaborador = new Colaborador(novoColaborador);
        return colaboradorRepository.save(colaborador);
    }

    public Colaborador buscarPorId(Long id) {
        Optional<Colaborador> colaboradorOptional = colaboradorRepository.findById(id);
        if (colaboradorOptional.isPresent()) {
            return colaboradorOptional.get();
        } else {
            throw new RuntimeException("Colaborador não encontrado com ID: " + id);
        }
    }

    public Colaborador atualizarColaborador(Long id, Colaborador Colaborador) {
        Colaborador colaboradorExistente = buscarPorId(id);

        colaboradorExistente.setNome(Colaborador.getNome());
        colaboradorExistente.setCpf(Colaborador.getCpf());

        return colaboradorRepository.save(colaboradorExistente);
    }

    public void excluirColaborador(Long id) {
        if (!colaboradorRepository.existsById(id)) {
            throw new RuntimeException("Colaborador não encontrado para exclusão com ID: " + id);
        }
        colaboradorRepository.deleteById(id);
    }
}
