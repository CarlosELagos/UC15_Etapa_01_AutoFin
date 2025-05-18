package DAO;

import Beans.Veiculo;
import java.sql.Connection;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    private Conexao conexao;
    private Connection conn;

    public VeiculoDAO() {

        this.conexao = new Conexao();
        this.conn = this.conexao.conectar();

    }

    public void cadastrarVeiculo(Veiculo veiculo) {

        String sql = "INSERT INTO carro (modelo,marca,combustivel,placa,quilometragem) VALUES" + "(?,?,?,?,?)";

        try {

            PreparedStatement s = this.conn.prepareStatement(sql);
            s.setString(1, veiculo.getModelo());
            s.setString(2, veiculo.getMarca());
            s.setString(3, veiculo.getCombustivel());
            s.setString(4, veiculo.getPlaca());
            s.setInt(5, veiculo.getKm());
            s.executeQuery();
            
            System.out.println("Veiculo cadastrado");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar veiculo: " + e.getMessage());
        }
    }

    public List<Veiculo> geraTabelaVeiculo() {
        //pega dados no DBA
        String sql = "SELECT * FROM carro";
        //gera tabela
        try {
            PreparedStatement st = this.conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Veiculo> lista = new ArrayList<>();

            while (rs.next()) {

                Veiculo v = new Veiculo();
                
                v.setId(rs.getInt("id_carro"));
                v.setModelo(rs.getString("modelo"));
                v.setMarca(rs.getString("marca"));
                v.setCombustivel(rs.getString("combustivel"));
                v.setPlaca(rs.getString("placa"));
                v.setKm(rs.getInt("quilometragem"));
                lista.add(v);

            }
            return lista;

        } catch (Exception e) {
            System.out.println("Erro ao gerar tabela: " + e.getMessage());
            return null;
        }
    }

}
