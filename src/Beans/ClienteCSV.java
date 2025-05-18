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


public class ClienteCSV {

    private static String Clientes = "./dados/clientes.csv";

    public static boolean adicionarCliente(Cliente c) throws IOException {
        try {
            Path path = Paths.get(Clientes);
            Files.createDirectories(path.getParent());
            boolean arquivoExiste = new File(Clientes).exists();
            //Escritor
            FileWriter escritor = new FileWriter(Clientes, StandardCharsets.ISO_8859_1, true);
            if (!arquivoExiste) {
                escritor.write("Nome;CPF;RG;Endereco;Telefone;Celular\n");

            }
            escritor.write(
                    c.getNome() + ";"
                    + c.getCpf() + ";"
                    + c.getRg() + ";"
                    + c.getEndereco() + ";"
                    + c.getTelefone() + ";"
                    + c.getCelular() + "\n"
            );
            escritor.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }
    
    public static ArrayList<Cliente> lista = new ArrayList<>();

    public static ArrayList<Cliente> listaClientes() {
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(Clientes));
            String linha;

            boolean primeiraLinha = true;

            while ((linha = leitor.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                String[] partes = linha.split(";");
                String nome = partes[0];
                String cpf = partes[1];
                String rg = partes[2];
                String endereco = partes[3];
                String telefone = partes[4];
                String celular = partes[5];

                Cliente c = new Cliente(nome, cpf, rg, endereco, telefone, celular);

                lista.add(c);
            }
            leitor.close();
        } catch (IOException e) {

        }
        return lista;

    }

}
