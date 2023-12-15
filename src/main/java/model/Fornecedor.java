package model;

public class Fornecedor {
    private int id;
    private String tpFornecedor;
    private String cpfCnpj;
    private String nome;
    private String nomeFantasia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTpFornecedor() {
        return tpFornecedor;
    }

    public void setTpFornecedor(String tpFornecedor) {
        this.tpFornecedor = tpFornecedor;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String toString() {
        return "\n***** FORNECEDOR *****" +
                "\nID: " + id +
                "\nTp Fornecedor: " + tpFornecedor +
                "\nCPF/CNPJ: " + cpfCnpj +
                "\nNome: " + nome +
                "\nNome Fantasia: " + nomeFantasia;
    }
}
