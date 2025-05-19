package Beans;

public class Veiculo {

    private int id;
    
    private String modelo;
    private String marca;
    private String combustivel;
    private String placa;
    private int km;
    private int cliente;

    public Veiculo(int id, String modelo, String marca, String combustivel, String placa, int km, int cliente) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.combustivel = combustivel;
        this.placa = placa;
        this.km = km;
        this.cliente = cliente;
    }

    public Veiculo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
}
