package Beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FornecedoresCSV {
    
    private static String fornecedores = "./dados/fornecedores.csv";
    
    public static boolean AdicionarFornecedores(Fornecedores f) throws IOException{
        try{
            Path path = Paths.get(fornecedores);
            Files.createDirectories(path.getParent());
            boolean arquivoExiste = new File(fornecedores).exists();
            //escritor de arquivo
            FileWriter escritor = new FileWriter(fornecedores, StandardCharsets.ISO_8859_1,true);
            
            if (!arquivoExiste){
                escritor.write("Nome;C.N.P.J.;Telefone;Data\n");
            }
            escritor.write(
                    f.getNome() + ";"
                    + f.getCnpj() + ";"
                    + f.getTelefone() + ";"
                    + f.getEndereco() + "\n"
                    
            );
            
            escritor.flush();
            return true;
            
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
        
    }
    
    public static ArrayList<Fornecedores> lista = new ArrayList<>();
    
    public static ArrayList<Fornecedores> listaFornecedores() {
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(fornecedores));
            String linha;
            boolean primeiraLinha = true;
            
            while ((linha = leitor.readLine()) != null){
                if (primeiraLinha){
                    primeiraLinha = false;
                    continue;
                }
                String [] partes = linha.split(";");
                
                String nome = partes[0];
                String cnpj = partes[1];
                String telefone = partes[2];
                String endereco = partes[3];
                Fornecedores f = null;
                
                
                
                lista.add(f);
                
            }
            leitor.close();
        }
        catch(IOException e){
        
        }
        return lista;
    }
    
    public static boolean excluir(int id) {

        try {
            if (id < 0) {
                JOptionPane.showMessageDialog(null, "Selecione um item para excluir.");
            } else {
                lista.remove(id);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao excluir!");
        }
        return false;
    }

}
