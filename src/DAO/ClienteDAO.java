package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Beans.Cliente;
import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




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
    
    public List<Cliente> geraTabelaCliente() {
        //pega os dados no BD
        String sql = "SELECT * FROM cliente";
        //gera a tabela
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Cliente> lista = new ArrayList<>();

            while (rs.next()) {
                Cliente c = new Cliente();

                c.setId(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("CPF"));
                c.setRg(rs.getString("RG"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setCelular(rs.getString("celular"));
                lista.add(c);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }

    }

}
