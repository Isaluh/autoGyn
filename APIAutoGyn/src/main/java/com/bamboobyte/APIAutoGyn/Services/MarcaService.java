package com.bamboobyte.APIAutoGyn.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarMarcaDTO;
import com.bamboobyte.APIAutoGyn.DTO.ListaMarcaDTO;
import com.bamboobyte.APIAutoGyn.DTO.MarcaDTO;
import com.bamboobyte.APIAutoGyn.Entities.Marca;
import com.bamboobyte.APIAutoGyn.Repositories.MarcaRepository;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepositorio;

    public MarcaService(MarcaRepository marcaRepositorio) {
        this.marcaRepositorio = marcaRepositorio;
    }

    public List<MarcaDTO> listarTodos() {
        List<Marca> marcas = marcaRepositorio.findAll();
        return marcas.stream()
                .map(MarcaDTO::new)
                .collect(Collectors.toList());
    }

    public List<ListaMarcaDTO> listarMarcasComModelos() {
        List<Marca> marcas = marcaRepositorio.findAll();
        return marcas.stream()
                    .map(ListaMarcaDTO::new)
                    .collect(Collectors.toList());
    }

    public Marca incluirMarca(CadastrarMarcaDTO dto) {
        if (dto.getNome() == null || dto.getNome().isEmpty()) {
            throw new RuntimeException("O nome da marca é obrigatório.");
        }

        Marca marca = new Marca();
        marca.setNome(dto.getNome());
        return marcaRepositorio.save(marca);
    }

    public Marca buscarPorId(Long id) {
        Optional<Marca> optMarca = marcaRepositorio.findById(id);
        if (optMarca.isPresent()) {
            return optMarca.get();
        }
        throw new RuntimeException("Marca não encontrada com ID: " + id);
    }

    public Marca atualizarMarca(Long id, CadastrarMarcaDTO dto) {
        Marca marcaExistente = buscarPorId(id);
        marcaExistente.setNome(dto.getNome());
        return marcaRepositorio.save(marcaExistente);
    }

    public void excluirMarca(Long id) {
        if (!marcaRepositorio.existsById(id)) {
            throw new RuntimeException("Marca não encontrada para exclusão com ID: " + id);
        }
        marcaRepositorio.deleteById(id);
    }
}
