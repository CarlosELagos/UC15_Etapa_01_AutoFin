package uc15_etapa_01_autofin.Beans;

public class Fornecedores {

    private String nome;
    private String cnpj;
    private String telefone;
    private String endereco;

    public Fornecedores() {
    }

    public Fornecedores(String nome, String cnpj, String telefone, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereço(String endereco) {
        this.endereco = endereco;
    }

}
