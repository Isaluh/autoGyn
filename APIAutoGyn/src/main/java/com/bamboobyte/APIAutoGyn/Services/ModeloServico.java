package com.bamboobyte.APIAutoGyn.Services;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarModeloDTO;
import com.bamboobyte.APIAutoGyn.DTO.ModeloDTO;
import com.bamboobyte.APIAutoGyn.Entities.Marca;
import com.bamboobyte.APIAutoGyn.Entities.Modelo;
import com.bamboobyte.APIAutoGyn.Repositories.MarcaRepository;
import com.bamboobyte.APIAutoGyn.Repositories.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModeloServico {

    private final ModeloRepository modeloRepositorio;
    private final MarcaRepository marcaRepositorio;

    @Autowired
    public ModeloServico(ModeloRepository modeloRepositorio, MarcaRepository marcaRepositorio) {
        this.modeloRepositorio = modeloRepositorio;
        this.marcaRepositorio = marcaRepositorio;
    }

    public List<ModeloDTO> listarTodos() {
        List<Modelo> modelos = modeloRepositorio.findAll();
        return modelos.stream()
                .map(ModeloDTO::new)
                .collect(Collectors.toList());
    }

    public Modelo incluirModelo(CadastrarModeloDTO dto) {
        if (dto.getNome() == null || dto.getNome().isEmpty()) {
            throw new RuntimeException("O nome do modelo é obrigatório.");
        }
        if (dto.getMarcaId() == null) {
            throw new RuntimeException("A marca do modelo é obrigatória.");
        }

        Optional<Marca> optMarca = marcaRepositorio.findById(dto.getMarcaId());
        if (!optMarca.isPresent()) {
            throw new RuntimeException("Marca não encontrada com ID: " + dto.getMarcaId());
        }

        Modelo modelo = new Modelo();
        modelo.setNome(dto.getNome());
        modelo.setMarca(optMarca.get());

        return modeloRepositorio.save(modelo);
    }

    public Modelo buscarPorId(Long id) {
        Optional<Modelo> optModelo = modeloRepositorio.findById(id);
        if (optModelo.isPresent()) {
            return optModelo.get();
        }
        throw new RuntimeException("Modelo não encontrado com ID: " + id);
    }

    public Modelo atualizarModelo(Long id, CadastrarModeloDTO dto) {
        Modelo modeloExistente = buscarPorId(id);

        if (dto.getNome() == null || dto.getNome().isEmpty()) {
            throw new RuntimeException("O nome do modelo é obrigatório.");
        }
        if (dto.getMarcaId() == null) {
            throw new RuntimeException("A marca do modelo é obrigatória.");
        }

        Optional<Marca> optMarca = marcaRepositorio.findById(dto.getMarcaId());
        if (!optMarca.isPresent()) {
            throw new RuntimeException("Marca não encontrada com ID: " + dto.getMarcaId());
        }

        modeloExistente.setNome(dto.getNome());
        modeloExistente.setMarca(optMarca.get());

        return modeloRepositorio.save(modeloExistente);
    }

    public void excluirModelo(Long id) {
        if (!modeloRepositorio.existsById(id)) {
            throw new RuntimeException("Modelo não encontrado para exclusão com ID: " + id);
        }
        modeloRepositorio.deleteById(id);
    }
}
