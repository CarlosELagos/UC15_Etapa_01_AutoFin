package Beans;

public class Veiculo {

    private int id;
    private String marca;
    private String modelo;
    private String combustivel;
    private int km;
    private String placa;
    private int cliente;

    public Veiculo() {
    }

    public Veiculo(int id, String marca, String modelo, String combustivel, int km, String placa, int cliente) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.combustivel = combustivel;
        this.km = km;
        this.placa = placa;
        this.cliente = cliente;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
