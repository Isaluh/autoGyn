package com.bamboobyte.APIAutoGyn.service;

import com.bamboobyte.APIAutoGyn.dto.CadastrarClienteDTO;
import com.bamboobyte.APIAutoGyn.dto.ClienteDTO;
import com.bamboobyte.APIAutoGyn.entity.*;
import com.bamboobyte.APIAutoGyn.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
	
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente salvar(CadastrarClienteDTO dto) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.logradouro());
        endereco.setComplemento(dto.complemento());
        endereco.setNumero(dto.numero());
        endereco.setCep(dto.cep());
        endereco.setCidade(dto.cidade());
        endereco.setUf(dto.uf());

        Telefone tel1 = new Telefone();
        tel1.setDdd(dto.ddd());
        tel1.setNumero(dto.telefone());

        Telefone tel2 = null;
        if (dto.ddd2() != null && dto.telefone2() != null) {
            tel2 = new Telefone();
            tel2.setDdd(dto.ddd2());
            tel2.setNumero(dto.telefone2());
        }

        PJ pj = null;
        PF pf = null;
        if (dto.isPJ()) {
            pj = new PJ();
            pj.setCnpj(dto.cnpj());
            pj.setInscricaoEstadual(dto.inscricaoEstadual());
            pj.setNomeContato(dto.nomeContato());
        } else {
            pf = new PF();
            pf.setCpf(dto.cpf());
        }

        Cliente cliente = new Cliente(dto.nome(), dto.email(), endereco, tel1, tel2, pj, pf);
        return repository.save(cliente);
    }

    public List<ClienteDTO> listarTodos() {
        return repository.findAll().stream()
                .map(cliente -> {
                    String doc = cliente.getPessoaFisica() != null
                            ? cliente.getPessoaFisica().getCpf()
                            : cliente.getPessoaJuridica().getCnpj();
                    return new ClienteDTO(cliente.getId(), "[" + doc + "] | " + cliente.getNome());
                })
                .collect(Collectors.toList());
    }
}
