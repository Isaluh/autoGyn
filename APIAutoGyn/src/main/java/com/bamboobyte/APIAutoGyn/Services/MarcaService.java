package com.bamboobyte.APIAutoGyn.Services;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarMarcaDTO;
import com.bamboobyte.APIAutoGyn.DTO.MinimalMarcaDTO;
import com.bamboobyte.APIAutoGyn.Entities.Marca;
import com.bamboobyte.APIAutoGyn.Repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepositorio;

    @Autowired
    public MarcaService(MarcaRepository marcaRepositorio) {
        this.marcaRepositorio = marcaRepositorio;
    }

    public List<MinimalMarcaDTO> listarTodos() {
        List<Marca> marcas = marcaRepositorio.findAll();
        return marcas.stream()
                .map(MinimalMarcaDTO::new)
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
