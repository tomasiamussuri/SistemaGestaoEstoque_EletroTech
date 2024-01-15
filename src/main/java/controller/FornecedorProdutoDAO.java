package controller;

import model.FornecedorProduto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FornecedorProdutoDAO {
    Connection conexao;

    public FornecedorProdutoDAO() throws SQLException {
        this.conexao = ConexaoSQLite.getConexao();
    }

// LISTAR TODOS OS FORNECEDORES
    public ArrayList<FornecedorProduto> buscarTodos() throws SQLException {
        ArrayList<FornecedorProduto> fornecedoresProdutos = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor_produto;";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ResultSet resultSetFornecedorProduto = preparedStatement.executeQuery();

        while (resultSetFornecedorProduto.next()) {
            FornecedorProduto fornecedorProduto = new FornecedorProduto();
            fornecedorProduto.setId(resultSetFornecedorProduto.getInt("Id"));
            fornecedorProduto.setFkIdProduto(resultSetFornecedorProduto.getInt("FK_ID_Produto"));
            fornecedorProduto.setFkIdFornecedor(resultSetFornecedorProduto.getInt("FK_ID_Fornecedor"));
            fornecedoresProdutos.add(fornecedorProduto);
        }
        return fornecedoresProdutos;
    }

// SELECIONAR UM FORNECEDOR
    public FornecedorProduto buscarUmId(int id) throws SQLException {
        String sql = "SELECT * FROM fornecedor_produto WHERE Id = ?;";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        FornecedorProduto fornecedorProduto = new FornecedorProduto();
        fornecedorProduto.setId(resultSet.getInt("Id"));
        fornecedorProduto.setFkIdProduto(resultSet.getInt("FK_ID_Produto"));
        fornecedorProduto.setFkIdFornecedor(resultSet.getInt("FK_ID_Fornecedor"));
        return fornecedorProduto;
    }

// INSERIR NOVO FORNECEDOR X PRODUTO
    public FornecedorProduto cadastrar() throws SQLException {
        String sql = "INSERT INTO fornecedor_produto VALUES(null, ?, ?);";
        String sql2 = "SELECT MAX(Id) as ID, FK_ID_Produto, FK_ID_Fornecedor FROM fornecedor_produto;";

        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInforme o ID do produto: ");
        int fk_id_produto = sc.nextInt();
        System.out.print("\nInforme o ID do fornecedor: ");
        int fk_id_fornecedor = sc.nextInt();
        preparedStatement.setInt(1, fk_id_produto);
        preparedStatement.setInt(2, fk_id_fornecedor);
        preparedStatement.executeUpdate();

        PreparedStatement prepareStatement2 = conexao.prepareStatement(sql2);
        ResultSet resultSet = prepareStatement2.executeQuery();

        FornecedorProduto fornecedorProduto = new FornecedorProduto();
        fornecedorProduto.setId(resultSet.getInt("Id"));
        fornecedorProduto.setFkIdProduto(resultSet.getInt("FK_ID_Produto"));
        fornecedorProduto.setFkIdFornecedor(resultSet.getInt("FK_ID_Fornecedor"));

        return fornecedorProduto;
    }


// ALTERAR UM FORNECEDOR
public void alterar(int id, String campo, int valor) throws SQLException {
    String sql = "UPDATE fornecedor_produto SET " + campo + " = '" + valor + " ' WHERE Id = " + id + ";";
    PreparedStatement preparedStatement = conexao.prepareStatement(sql);
    preparedStatement.executeUpdate();
}

// DELETAR UM FORNECEDOR
public void deletar() throws SQLException {
    String sql = "DELETE FROM fornecedor_produto WHERE Id = ?;";
    PreparedStatement preparedStatement = conexao.prepareStatement(sql);

    Scanner sc = new Scanner(System.in);
    System.out.print("\nInforme o Id do produto x fornecedor: ");
    int id = sc.nextInt();
    preparedStatement.setInt(1, id);
    preparedStatement.executeUpdate();

}

// CABEÇALHO DE IMPRESSÃO DE DADOS
public void cabecalho() {
    System.out.println("\n+------------------------------------------------------------------------------------------------+");
    System.out.println(String.format("| %-5s | %-20s | %-40s | %-20s |", "ID", "FK_ID_Produto", "FK_ID_Fornecedor", "Nome Fantasia"));
    System.out.println("+------------------------------------------------------------------------------------------------+");
}

}
