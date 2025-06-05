package com.bamboobyte.APIAutoGyn.service;

import com.bamboobyte.APIAutoGyn.config.ConexaoBD;
import com.bamboobyte.APIAutoGyn.entity.Cliente;
import com.bamboobyte.APIAutoGyn.dto.CadastrarClienteDTO;
import com.bamboobyte.APIAutoGyn.dto.ClienteDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClienteService {

    public static Long inserirCliente(CadastrarClienteDTO novoClienteDTO) throws SQLException {
        Cliente novoCliente = new Cliente(novoClienteDTO);
        String sql = 
            "INSERT INTO cliente (nome, email, logradouro, complemento, numero, " +
            "cep, cidade, uf, ddd, telefone, ddd2, telefone2, " +
            "cnpj, contato, inscricao_estadual, cpf) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    //     try (Connection conn = ConexaoBD.getInstance().getConnection();
    //          PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

    //         stmt.setString(1, novoCliente.getNome());
    //         stmt.setString(2, novoCliente.getEmail());

    //         stmt.setString(3, novoCliente.getEndereco().getLogradouro());
    //         stmt.setString(4, novoCliente.getEndereco().getComplemento());
    //         stmt.setString(5, novoCliente.getEndereco().getNumero());
    //         stmt.setString(6, novoCliente.getEndereco().getCep());
    //         stmt.setString(7, novoCliente.getEndereco().getCidade());
    //         stmt.setString(8, novoCliente.getEndereco().getUf());

    //         stmt.setInt(9, novoCliente.getTelefone().getDdd());
    //         stmt.setInt(10, novoCliente.getTelefone().getTelefone());

    //         if (novoCliente.getTelefone2().isPresent()) {
    //             stmt.setInt(11, novoCliente.getTelefone2().get().getDdd());
    //             stmt.setInt(12, novoCliente.getTelefone2().get().getTelefone());
    //         } else {
    //             stmt.setNull(11, Types.INTEGER);
    //             stmt.setNull(12, Types.INTEGER);
    //         }

    //         if (novoCliente.getPessoaJuridica().isPresent()) {
    //             stmt.setString(13, novoCliente.getPessoaJuridica().get().getCnpj());
    //             stmt.setString(14, novoCliente.getPessoaJuridica().get().getContato());
    //             stmt.setString(15, novoCliente.getPessoaJuridica().get().getInscricaoEstadual());
    //             stmt.setNull(16, Types.VARCHAR);
    //         } else if (novoCliente.getPessoaFisica().isPresent()) {
    //             stmt.setNull(13, Types.VARCHAR);
    //             stmt.setNull(14, Types.VARCHAR);
    //             stmt.setNull(15, Types.VARCHAR);
    //             stmt.setString(16, novoCliente.getPessoaFisica().get().getCpf());
    //         } else {
    //             stmt.setNull(13, Types.VARCHAR);
    //             stmt.setNull(14, Types.VARCHAR);
    //             stmt.setNull(15, Types.VARCHAR);
    //             stmt.setNull(16, Types.VARCHAR);
    //         }

    //         stmt.executeUpdate();

    //         try (ResultSet rs = stmt.getGeneratedKeys()) {
    //             if (rs.next()) {
    //                 return rs.getLong(1);
    //             }
    //         }
    //     }

    //     return null;
    // }

    // public static List<ClienteDTO> listarTodosFormatados() throws SQLException {
    //     List<ClienteDTO> lista = new LinkedList<>();
    //     String sql = "SELECT * FROM cliente";

    //     try (Connection conn = ConexaoBD.getInstance().getConnection();
    //          PreparedStatement stmt = conn.prepareStatement(sql);
    //          ResultSet rs = stmt.executeQuery()) {

    //         while (rs.next()) {
    //             Cliente cliente = new Cliente(rs);
    //             lista.add(new ClienteDTO(cliente));
    //         }
    //     }

    //     return lista;
    // }
}
