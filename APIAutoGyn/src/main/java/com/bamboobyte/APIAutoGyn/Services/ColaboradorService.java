package com.bamboobyte.APIAutoGyn.Services;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarColaboradorDTO;
import com.bamboobyte.APIAutoGyn.DTO.ColaboradorDTO;
import com.bamboobyte.APIAutoGyn.Entities.Colaborador;
import com.bamboobyte.APIAutoGyn.Repositories.ColaboradorRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    public List<ColaboradorDTO> listarTodos() {
        List<Colaborador> colaboradores = colaboradorRepository.findAll();
        return colaboradores.stream()
                .map(colaborador -> new ColaboradorDTO(colaborador))
                .collect(Collectors.toList());
    }

    public Colaborador incluirColaborador(CadastrarColaboradorDTO novoColaboradorDTO) {
        if (novoColaboradorDTO.getCpf() == null || novoColaboradorDTO.getCpf().isEmpty()) {
            throw new RuntimeException("O CPF do colaborador é obrigatório.");
        }

        Colaborador colaborador = new Colaborador();
        colaborador.setCpf(novoColaboradorDTO.getCpf());
        colaborador.setNome(novoColaboradorDTO.getNome());

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

    public Colaborador atualizarColaborador(Long id, CadastrarColaboradorDTO colaboradorDTO) {
        Colaborador colaboradorExistente = buscarPorId(id);

        colaboradorExistente.setNome(colaboradorDTO.getNome());
        colaboradorExistente.setCpf(colaboradorDTO.getCpf());

        return colaboradorRepository.save(colaboradorExistente);
    }

    public void excluirColaborador(Long id) {
        if (!colaboradorRepository.existsById(id)) {
            throw new RuntimeException("Colaborador não encontrado para exclusão com ID: " + id);
        }
        colaboradorRepository.deleteById(id);
    }
}
