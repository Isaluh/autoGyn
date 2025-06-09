package com.bamboobyte.APIAutoGyn.Services;

import org.springframework.stereotype.Service;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarClienteDTO;
import com.bamboobyte.APIAutoGyn.DTO.ClienteDTO;
import com.bamboobyte.APIAutoGyn.Entities.Cliente;
import com.bamboobyte.APIAutoGyn.Entities.Endereco;
import com.bamboobyte.APIAutoGyn.Entities.PF;
import com.bamboobyte.APIAutoGyn.Entities.PJ;
import com.bamboobyte.APIAutoGyn.Entities.Telefone;
import com.bamboobyte.APIAutoGyn.Repositories.ClienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(CadastrarClienteDTO dto) {
        Cliente novoCliente = new Cliente(dto); 
        return clienteRepository.save(novoCliente);
    }

    public List<ClienteDTO> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(cliente -> {
                    String doc = cliente.getPessoaFisica() != null
                            ? cliente.getPessoaFisica().getCpf()
                            : cliente.getPessoaJuridica().getCnpj();
                    return new ClienteDTO(cliente.getId(), "[" + doc + "] | " + cliente.getNome());
                })
                .collect(Collectors.toList());
    }

    public Cliente buscarClientePorId(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado com ID: " + id);
        }
        return clienteRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Erro ao buscar cliente com ID: " + id));
    }

    public void excluirCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado para exclusão com ID: " + id); 
        }
        clienteRepository.deleteById(id);
    }

    // public Cliente atualizarCliente(Long id, CadastrarClienteDTO clienteAtualizadoDTO) {
    //     if (!clienteRepository.existsById(id)) {
    //         throw new RuntimeException("Cliente não encontrado para atualização com ID: " + id); 
    //     }

    //     Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() ->
    //         new RuntimeException("Erro ao buscar cliente para atualização com ID: " + id));

    //     clienteExistente.setNome(clienteAtualizadoDTO.nome());
    //     clienteExistente.setEmail(clienteAtualizadoDTO.email());

    //     if (clienteAtualizadoDTO.logradouro() != null) {
    //         Endereco enderecoAtualizado = new Endereco();
    //         enderecoAtualizado.setLogradouro(clienteAtualizadoDTO.logradouro());
    //         enderecoAtualizado.setComplemento(clienteAtualizadoDTO.complemento());
    //         enderecoAtualizado.setNumero(clienteAtualizadoDTO.numero());
    //         enderecoAtualizado.setCep(clienteAtualizadoDTO.cep());
    //         enderecoAtualizado.setCidade(clienteAtualizadoDTO.cidade());
    //         enderecoAtualizado.setUf(clienteAtualizadoDTO.uf());
    //         clienteExistente.setEndereco(enderecoAtualizado); 
    //     }

    //     if (clienteAtualizadoDTO.ddd() != null && clienteAtualizadoDTO.telefone() != null) {
    //         Telefone telefoneAtualizado1 = new Telefone();
    //         telefoneAtualizado1.setDdd(clienteAtualizadoDTO.ddd());
    //         telefoneAtualizado1.setTelefone(clienteAtualizadoDTO.telefone());
    //         clienteExistente.setTelefonePrincipal(telefoneAtualizado1);  
    //     }

    //     if (clienteAtualizadoDTO.ddd2() != null && clienteAtualizadoDTO.telefone2() != null) {
    //         Telefone telefoneAtualizado2 = new Telefone();
    //         telefoneAtualizado2.setDdd(clienteAtualizadoDTO.ddd2());
    //         telefoneAtualizado2.setTelefone(clienteAtualizadoDTO.telefone2());
    //         clienteExistente.setTelefoneSecundario(telefoneAtualizado2);  
    //     }

    //     if (clienteAtualizadoDTO.isPJ()) {
    //         PJ pjAtualizado = new PJ();
    //         pjAtualizado.setCnpj(clienteAtualizadoDTO.cnpj());
    //         pjAtualizado.setInscricaoEstadual(clienteAtualizadoDTO.inscricaoEstadual());
    //         pjAtualizado.setContato(clienteAtualizadoDTO.nomeContato());
    //         clienteExistente.setPessoaJuridica(pjAtualizado); 
    //         clienteExistente.setPessoaFisica(null); 
    //     } else if (clienteAtualizadoDTO.isPF()) {
    //         PF pfAtualizado = new PF();
    //         pfAtualizado.setCpf(clienteAtualizadoDTO.cpf());
    //         clienteExistente.setPessoaFisica(pfAtualizado);  
    //         clienteExistente.setPessoaJuridica(null);  
    //     }

    //     return clienteRepository.save(clienteExistente);  
    // }
}
