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

public class ProdutosCSV {

    private static String produtos = "./dados/produtos.csv";
    

    public static boolean AdicionarProdutos(Produtos p) throws IOException {
        try {

            Path path = Paths.get(produtos);
            Files.createDirectories(path.getParent());
            boolean arquivoExiste = new File(produtos).exists();

            FileWriter escritor = new FileWriter(produtos, StandardCharsets.ISO_8859_1, true);

            if (!arquivoExiste) {
                escritor.write("Nome;Quantidade;Valor;Data\n");

            }

            escritor.write(
                    p.getNomeProduto() + ";"
                    + p.getQuantidade() + ";"
                    + p.getValor() + ";"
                    + p.getData() + "\n"
            );

            escritor.flush();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
/*    
    public static ArrayList<Produtos> lista = new ArrayList<>();
    
    public static ArrayList<Produtos> listaProdutos() {
    
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(produtos));
            String linha;
            boolean primeiraLinha = true;
            
            while((linha = leitor.readLine()) != null){
                if(primeiraLinha){
                 primeiraLinha = false;
                 continue;
                }
                String[] partes = linha.split(";");
                
                String nome = partes[0];
                int quantidade = Integer.parseInt(partes[1]);
                double valor = Double.parseDouble(partes[2]);
                String data = partes[3];
                
                Produtos p = new Produtos(nome, quantidade, valor, data);
                
                lista.add(p);
                
            }
            leitor.close();
        }catch(IOException e){
        }
        return lista;
    }

    public static boolean excluir(int id) {
        try {
            if (id < 0) {
                JOptionPane.showMessageDialog(null, "Selecione um item para excluir da tabela.");

            } else {
                lista.remove(id);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir.");
        }
        return false;
    }
*/
}
