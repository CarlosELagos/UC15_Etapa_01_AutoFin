package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Beans.Cliente;
import conexao.Conexao;
import java.sql.SQLException;




public class ClienteDAO {

    private Conexao conexao;
    private Connection conn;

    public ClienteDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.conectar();
    }

    public void cadastrarCliente(Cliente cliente) {

        String sql = "INSERT INTO cliente (nome,CPF,RG,endereco,telefone,celular) VALUES" + "(?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getCelular());

            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar" + e.getMessage());
        }
    }

}
