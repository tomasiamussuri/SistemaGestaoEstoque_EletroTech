package model;

public class FornecedorProduto {
    private int id;
    private int fkIdProduto;
    private int fkIdFornecedor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkIdProduto() {
        return fkIdProduto;
    }

    public void setFkIdProduto(int fkIdProduto) {
        this.fkIdProduto = fkIdProduto;
    }

    public int getFkIdFornecedor() {
        return fkIdFornecedor;
    }

    public void setFkIdFornecedor(int fkIdFornecedor) {
        this.fkIdFornecedor = fkIdFornecedor;
    }
}
