package model;

public class Fornecedor {
    private int id;
    private String cpfCnpj;
    private String nome;
    private String nomeFantasia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        //Formata cada fornecedor em uma tabela
        return String.format("| %-5d | %-20s | %-40s | %-20s |", id, cpfCnpj, nome, nomeFantasia);
        /*
        return "\n***** FORNECEDOR *****" +
                "\nID: " + id +
                "\nCPF/CNPJ: " + cpfCnpj +
                "\nNome: " + nome +
                "\nNome Fantasia: " + nomeFantasia;
         */
    }
}
