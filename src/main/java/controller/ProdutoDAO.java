package controller;

import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProdutoDAO {
    Connection conexao;
    public ProdutoDAO() throws SQLException {
        this.conexao = ConexaoSQLite.getConexao();
    }

    // LISTAR TODOS OS PRODUTOS
    public ArrayList<Produto> buscarTodos() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto;";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ResultSet resultSetProduto = preparedStatement.executeQuery();

        while (resultSetProduto.next()) {
            Produto produto = new Produto();
            produto.setId(resultSetProduto.getInt("Id"));
            produto.setNome(resultSetProduto.getString("Nome"));
            produto.setDescricao(resultSetProduto.getString("Descricao"));
            produto.setCategoria(resultSetProduto.getString("Categoria"));
            produtos.add(produto);
        }
        return produtos;
    }

    // SELECIONAR UM PRODUTO
    public Produto buscarUmId(int id) throws SQLException {
        String sql = "SELECT * FROM produto WHERE Id = ?;";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        Produto produto = new Produto();
        produto.setId(resultSet.getInt("Id"));
        produto.setNome(resultSet.getString("Nome"));
        produto.setDescricao(resultSet.getString("Descricao"));
        produto.setCategoria(resultSet.getString("Categoria"));
        return produto;
    }

    // INSERIR NOVO PRODUTO
    public Produto cadastrar() throws SQLException {
        String sql = "INSERT INTO produto VALUES(null, ?, ?, ?);";
        String sql2 = "SELECT MAX(Id) as Id,nome,descricao,categoria FROM produto;";

        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInforme o nome do produto: ");
        String nome = sc.nextLine();
        System.out.print("\nInforme a descrição do produto: ");
        String descricao = sc.nextLine();
        System.out.print("\nInforme a categoria do produto: ");
        String categoria = sc.nextLine();
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);
        preparedStatement.setString(3, categoria);
        preparedStatement.executeUpdate();

        PreparedStatement prepareStatement2 = conexao.prepareStatement(sql2);
        ResultSet resultSet = prepareStatement2.executeQuery();

        Produto produto = new Produto();
        produto.setId(resultSet.getInt("Id"));
        produto.setNome(resultSet.getString("Nome"));
        produto.setDescricao(resultSet.getString("Descricao"));
        produto.setCategoria(resultSet.getString("Categoria"));
        return produto;
    }


    // ALTERAR UM PRODUTO
    public void alterar(int id, String campo, String valor) throws SQLException {
        String sql = "UPDATE produto SET " + campo + " = '" + valor + " ' WHERE Id = " + id + ";";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }


    // DELETAR UM PRODUTO
    public void deletar() throws SQLException {
        String sql = "DELETE FROM produto WHERE Id = ?;";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);

        Scanner sc = new Scanner(System.in);
        System.out.print("\nInforme o Id do produto: ");
        int id = sc.nextInt();
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }
    public void cabecalho() {
        System.out.println("\n+----------------------------------------------------------------------------------------------------------+");
        System.out.println(String.format("| %-5s | %-20s | %-50s | %-20s |", "ID", "NOME", "DESCRIÇÃO", "CATEGORIA"));
        System.out.println("+----------------------------------------------------------------------------------------------------------+");
    }
}