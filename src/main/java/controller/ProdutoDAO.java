package controller;

import model.Produto;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ProdutoDAO {
    Connection conn;
    public ProdutoDAO()throws SQLException {
        this.conn = ConexaoSQLite.getConexao();
    }

    // select no banco de dados
    public ArrayList<Produto> getAll() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Produto produto = new Produto();
            produto.setId(resultSet.getInt("Id"));
            produto.setNome(resultSet.getString("Nome"));
            produto.setDescricao(resultSet.getString("Descricao"));
            produto.setCategoria(resultSet.getString("Categoria"));

            produtos.add(produto);
        }

        return produtos;
    }

    // insert no banco de dados
    public void insert() throws SQLException {
        String sql = "INSERT INTO produto VALUES(null, ?, ?, ?);";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o nome do produto: ");
        String nome = sc.nextLine();
        System.out.print("Informe a descrição do produto: ");
        String descricao = sc.nextLine();
        System.out.println("Informe a categoria do produto: ");
        String categoria = sc.nextLine();
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);
        preparedStatement.setString(3, categoria);
        preparedStatement.executeUpdate();
    }


}
