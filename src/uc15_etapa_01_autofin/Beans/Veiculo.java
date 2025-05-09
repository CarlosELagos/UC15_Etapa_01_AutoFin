package uc15_etapa_01_autofin.Beans;

public class Veiculo {

    private String marca;
    private String modelo;
    private String combustivel;
    private int km;
    private String placa;

    public Veiculo() {
    }

    public Veiculo(String marca, String modelo, String combustivel, int km, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.combustivel = combustivel;
        this.km = km;
        this.placa = placa;
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
