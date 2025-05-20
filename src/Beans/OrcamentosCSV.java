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

public class OrcamentosCSV {

    private static String orcamentos = "./dados/orcamentos.csv";

    public static boolean adicionarItem(Orcamentos o) {
        try {
            Path path = Paths.get(orcamentos);
            Files.createDirectories(path.getParent());
            boolean arquivoExiste = new File(orcamentos).exists();
            //escritor
            FileWriter escritor = new FileWriter(orcamentos, StandardCharsets.ISO_8859_1, true);

            if (!arquivoExiste) {
                escritor.write("Item;Descrição;Qtd;Valor;Total;Cliente;Placa\n");
            }
            escritor.write(
                    o.getItem() + ";"
                    + o.getDescricao() + ";"
                    + o.getQtd() + ";"
                    + o.getValor() + ";"
                    + o.getTotal() + ";"
                    + o.getCliente() + ";"
                    + o.getPlaca() + "\n"
            );
            escritor.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();//retorna erro
        }
        return false;
    }

    public static ArrayList<Orcamentos> lista = new ArrayList<>();

    public static ArrayList<Orcamentos> listaOrcamentos() {
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(orcamentos));
            String linha;
            boolean primeiralinha = true;

            while ((linha = leitor.readLine()) != null) {
                if (primeiralinha) {
                    primeiralinha = false;
                    continue;
                }

                String[] part = linha.split(";");

                int item = Integer.parseInt(part[0]);
                String descricao = part[1];
                int qtd = Integer.parseInt(part[2]);
                Double valor = Double.parseDouble(part[3]);
                Double total = Double.parseDouble(part[4]);
                String cliente = part[5];
                String placa = part[6];

                Orcamentos o = new Orcamentos(item, descricao, qtd, valor, total, cliente, placa);
                lista.add(o);
            }
            leitor.close();
        } catch (IOException e) {

        }
        return lista;

    }

    public static boolean excluir(int id) {

        try {
            if (id < 0) {
                JOptionPane.showMessageDialog(null, "Selecione um item para excluir!");
            } else {
                lista.remove(id);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
        }
        return false;
    }

}
