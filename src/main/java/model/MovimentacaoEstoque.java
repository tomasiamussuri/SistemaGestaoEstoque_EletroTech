package model;

import java.time.LocalDate;

public class MovimentacaoEstoque {
    private int id;
    private LocalDate data;
    private String tpMovimentacao;
    private int fkIdFornecedorProduto;
    private float quantidade;
    private String lote;
    private LocalDate validade;
    private float custo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTpMovimentacao() {
        return tpMovimentacao;
    }

    public void setTpMovimentacao(String tpMovimentacao) {
        this.tpMovimentacao = tpMovimentacao;
    }

    public int getFkIdFornecedorProduto() {
        return fkIdFornecedorProduto;
    }

    public void setFkIdFornecedorProduto(int fkIdFornecedorProduto) {
        this.fkIdFornecedorProduto = fkIdFornecedorProduto;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    @Override
    public String toString() {
        return "\n***** MOVIMENTAÇÃO DE ESTOQUE *****" +
                "\nID: " + id +
                "\nData: " + data +
                "\nTp Movimentacao: " + tpMovimentacao +
                "\nFK_Id FornecedorProduto: " + fkIdFornecedorProduto +
                "\nQuantidade: " + quantidade +
                "\nLote: " + lote +
                "\nValidade: " + validade +
                "\nCusto: " + custo;
    }
}
