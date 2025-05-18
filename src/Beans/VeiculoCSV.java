
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

public class VeiculoCSV {
    
    private static String veiculos = "./dados/veiculos.csv";

    public static boolean AdicionarVeiculo(Veiculo v) throws IOException {
        try {
            Path path = Paths.get(veiculos);
            Files.createDirectories(path.getParent());
            boolean arquivoExiste = new File(veiculos).exists();
            //escritor do arquivo
            FileWriter escritor = new FileWriter(veiculos, StandardCharsets.ISO_8859_1, true);

            if (!arquivoExiste) {
                escritor.write("Marca;Modelo;Combustivel;Km;Placa\n");
            }
            escritor.write(
                    v.getMarca() + ";"
                    + v.getModelo() + ";"
                    + v.getCombustivel() + ";"
                    + v.getKm() + ";"
                    + v.getPlaca()
                    + "\n"
            );

            escritor.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Veiculo> lista = new ArrayList<>();

    public static ArrayList<Veiculo> listaVeiculos(){
     try{
         BufferedReader leitor = new BufferedReader (new FileReader (veiculos));
         String linha;
         boolean primeiraLinha = true;
         
         while ((linha = leitor.readLine()) != null){
             if (primeiraLinha){
                 primeiraLinha = false;
                 continue;
             }
             String [] partes = linha.split(";");
             
             String marca = partes[0];
             String modelo = partes[1];
             String combustivel = partes[2];
             int km = Integer.parseInt(partes[3]);
             String placa = partes[4];
             
             Veiculo v = new Veiculo(marca, modelo, combustivel, km , placa);
             
             lista.add(v);
         }
         leitor.close();
         
     }catch(IOException e){
     }
     return lista;
    }
}
