package com.bamboobyte.APIAutoGyn.service;

import com.bamboobyte.APIAutoGyn.entity.Acessorio;
// import com.bamboobyte.APIAutoGyn.config.ConexaoBD;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AcessorioService {

    // public static List<Acessorio> getAll() throws SQLException {
    //     List<Acessorio> acessorios = new LinkedList<>();
    //     String sql = "SELECT * FROM acessorio";

    //     try (Connection conn = ConexaoBD.getInstance().getConnection();
    //          PreparedStatement stmt = conn.prepareStatement(sql);
    //          ResultSet rs = stmt.executeQuery()) {

    //         while (rs.next()) {
    //             acessorios.add(new Acessorio(rs));
    //         }
    //     }
    //     return acessorios;
    // }

    // public static boolean insert(String descricao) throws SQLException {
    //     String sql = "INSERT INTO acessorio (descricao) VALUES (?)";

    //     try (Connection conn = ConexaoBD.getInstance().getConnection();
    //          PreparedStatement stmt = conn.prepareStatement(sql)) {

    //         stmt.setString(1, descricao);
    //         int rowsAffected = stmt.executeUpdate();
    //         return rowsAffected > 0;
    //     }
    // }
}
