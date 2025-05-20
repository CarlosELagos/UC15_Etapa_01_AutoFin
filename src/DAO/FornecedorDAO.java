package DAO;

import Beans.Fornecedores;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedorDAO {

    private Conexao conexao;
    private Connection conn;

    public FornecedorDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.conectar();
    }

    public void cadastrarForncedor(Fornecedores fornecedores) {
        String sql = "INSERT INTO fornecedor (nome,cnpj,endereco,telefone) VALUES" + "(?,?,?,?)";

        try {
            PreparedStatement s = this.conn.prepareStatement(sql);
            s.setString(1, fornecedores.getNome());
            s.setString(2, fornecedores.getCnpj());
            s.setString(3, fornecedores.getEndereco());
            s.setInt(4, fornecedores.getTelefone());
            s.execute();
            System.out.println("Fornecedor cadastrado");
            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar fornecedor");
        }
    }

    public List<Fornecedores> geraTabelaFornecedor() {
        String sql = "SELECT * FROM fornecedor";

        try {

            PreparedStatement s = this.conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            List<Fornecedores> lista = new ArrayList<>();

            while (rs.next()) {

                Fornecedores f = new Fornecedores();
                f.setId(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("nome"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEndereco(rs.getString("endereco"));
                f.setTelefone(rs.getInt("telefone"));

                lista.add(f);

            }
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao gerar tabela: " + e.getMessage());
            return null;
        }

    }

}
