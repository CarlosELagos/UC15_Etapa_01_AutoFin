/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author carlo
 */

import Beans.Orcamentos;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class OrcamentoDAO {

    private Conexao conexao;
    private Connection conn;

    public OrcamentoDAO() {

        this.conexao = new Conexao();
        this.conn = this.conexao.conectar();

    }

    public void insereItem (Orcamentos orcamentos) {

        String sql = "INSERT INTO orcamento (servico,quantidade,valor,cliente,carro) VALUES" + "(?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, orcamentos.getDescricao());
            stmt.setInt(2, orcamentos.getQtd());
            stmt.setDouble(3, orcamentos.getValor());
            stmt.setString(4, orcamentos.getCliente());
            stmt.setString(5, orcamentos.getPlaca());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Item inserido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir no orçamento: " + e.getMessage());
        }

    }
    
    
    public List<Orcamentos> geraTabelaOrcamento() {

        String sql = "SELECT * FROM orcamento";

        List<Orcamentos> lista = new ArrayList<>();

        try {

            PreparedStatement orc = this.conn.prepareStatement(sql);
            ResultSet rs = orc.executeQuery();

            while (rs.next()) {

                Orcamentos or = new Orcamentos();

                or.setItem(rs.getInt("id_orcamento"));
                or.setDescricao(rs.getString("servico"));
                or.setQtd(rs.getInt("quantidade"));
                or.setCliente(rs.getString("cliente"));
                or.setPlaca(rs.getString("carro"));

                lista.add(or);

            }

        } catch (Exception e) {

            System.out.println("Erro ao cadastrar item em orçamento:  " + e.getMessage());

        }
        return lista;
    }

}
