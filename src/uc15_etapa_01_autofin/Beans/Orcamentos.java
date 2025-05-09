package uc15_etapa_01_autofin.Beans;
public class Orcamentos {
    
    private int item;
    private String descricao;
    private int qtd;
    private Double valor;
    private Double total;
    private String cliente;
    private String placa;
    private static int contador = 1;

    public Orcamentos() {
    }

    public Orcamentos(int item, String descricao, int qtd, Double valor, Double total, String cliente, String placa) {
        this.item = item;
        this.descricao = descricao;
        this.qtd = qtd;
        this.valor = valor;
        this.total = total;
        this.cliente = cliente;
        this.placa = placa;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }
    
    public void setItem() {
        this.item = contador++;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    
    
}
