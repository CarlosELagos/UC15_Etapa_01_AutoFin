package DAO;

import Beans.Produtos;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    private Conexao conexao;
    private Connection conn;
    
    public ProdutosDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.conectar();
    }
    
    public void cadastroDeProdutos(Produtos produtos) {

        String sql = "INSERT INTO produtos (nome,quantidade,valor,data) VALUES" + "(?,?,?,?)";

        try {
            SimpleDateFormat banco = new SimpleDateFormat("yyyy-MM-dd");
            String dataBanco = banco.format(produtos.getData());
            
            
            PreparedStatement s = this.conn.prepareStatement(sql);
            s.setString(1, produtos.getNomeProduto());
            s.setInt(2, produtos.getQuantidade());
            s.setDouble(3, produtos.getValor());
            s.setString(4, dataBanco);

            s.execute();
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Produto não cadastrado");
        }

    }

    public List<Produtos> geraTabelaProdutos() {

        String sql = "SELECT * FROM produtos";
        List<Produtos> lista = new ArrayList<>();
        try (PreparedStatement p = this.conn.prepareStatement(sql); ResultSet rs = p.executeQuery()) {

            while (rs.next()) {

                Produtos pr = new Produtos();
                pr.setId(rs.getInt("id_produtos"));
                pr.setNomeProduto(rs.getString("nome"));
                pr.setQuantidade(rs.getInt("quantidade"));
                pr.setValor(rs.getDouble("valor"));
                pr.setData(rs.getDate("data"));
                
                lista.add(pr);

            }

        } catch (Exception e) {
            System.out.println("Erro ao gerar tabela: " + e.getMessage());

        }
        return lista;
    }

}
