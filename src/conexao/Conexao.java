
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public Connection conectar(){
        String url = "jdbc:mysql://localhost/autofin";
        String user = "root";
        String password = "Minas$0.7";
        
        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!!");
            
            return conn;
        } catch (SQLException e){
            System.out.println("Erro ao conectar: "+ e.getMessage());
        }
        return null;
    }
    
}
