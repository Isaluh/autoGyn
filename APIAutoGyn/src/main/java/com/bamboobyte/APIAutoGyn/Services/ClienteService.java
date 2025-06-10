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
                String doc;

                if (cliente.getPessoaFisica() != null) {
                    doc = cliente.getPessoaFisica().getCpf();
                } else if (cliente.getPessoaJuridica() != null) {
                    doc = cliente.getPessoaJuridica().getCnpj();
                } else {
                    doc = "Cliente deve ser PF ou PJ, mas não ambos nem nenhum";
                }
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

    public Cliente atualizarCliente(Long id, CadastrarClienteDTO clienteAtualizadoDTO) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado para atualização com ID: " + id); 
        }

        Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() ->
            new RuntimeException("Erro ao buscar cliente para atualização com ID: " + id));

        clienteExistente.setNome(clienteAtualizadoDTO.getNome());
        clienteExistente.setEmail(clienteAtualizadoDTO.getEmail());

        if (clienteAtualizadoDTO.getLogradouro() != null) {
            Endereco enderecoAtualizado = new Endereco();
            enderecoAtualizado.setLogradouro(clienteAtualizadoDTO.getLogradouro());
            enderecoAtualizado.setComplemento(clienteAtualizadoDTO.getComplemento());
            enderecoAtualizado.setNumero(clienteAtualizadoDTO.getNumero());
            enderecoAtualizado.setCep(clienteAtualizadoDTO.getCep());
            enderecoAtualizado.setCidade(clienteAtualizadoDTO.getCidade());
            enderecoAtualizado.setUf(clienteAtualizadoDTO.getUf());
            clienteExistente.setEndereco(enderecoAtualizado); 
        }

        if (clienteAtualizadoDTO.getDdd() != null && clienteAtualizadoDTO.getTelefone() != null) {
            Telefone telefoneAtualizado1 = new Telefone();
            telefoneAtualizado1.setDdd(clienteAtualizadoDTO.getDdd());
            telefoneAtualizado1.setTelefone(clienteAtualizadoDTO.getTelefone());
            clienteExistente.setTelefonePrincipal(telefoneAtualizado1);  
        }

        if (clienteAtualizadoDTO.getDdd2() != null && clienteAtualizadoDTO.getTelefone2() != null) {
            Telefone telefoneAtualizado2 = new Telefone();
            telefoneAtualizado2.setDdd(clienteAtualizadoDTO.getDdd2());
            telefoneAtualizado2.setTelefone(clienteAtualizadoDTO.getTelefone2());
            clienteExistente.setTelefoneSecundario(telefoneAtualizado2);  
        }

        if (clienteAtualizadoDTO.isPJ()) {
            PJ pjAtualizado = new PJ();
            pjAtualizado.setCnpj(clienteAtualizadoDTO.getCnpj());
            pjAtualizado.setInscricaoEstadual(clienteAtualizadoDTO.getInscricao_estadual());
            pjAtualizado.setNomeContato(clienteAtualizadoDTO.getNomeContato());
            clienteExistente.setPessoaJuridica(pjAtualizado); 
            clienteExistente.setPessoaFisica(null); 
        } else if (clienteAtualizadoDTO.isPF()) {
            PF pfAtualizado = new PF();
            pfAtualizado.setCpf(clienteAtualizadoDTO.getCpf());
            clienteExistente.setPessoaFisica(pfAtualizado);  
            clienteExistente.setPessoaJuridica(null);  
        }

        return clienteRepository.save(clienteExistente);  
    }
}
