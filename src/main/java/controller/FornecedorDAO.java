package controller;

import model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class FornecedorDAO {
    Connection conn;

    public FornecedorDAO() throws SQLException {
        this.conn = ConexaoSQLite.getConexao();
    }

    // LISTAR TODOS OS FORNECEDORES
    public ArrayList<Fornecedor> getAll() throws SQLException {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(resultSet.getInt("Id"));
            fornecedor.setTpFornecedor(resultSet.getString("Tp Fornecedor"));
            fornecedor.setCpfCnpj(resultSet.getString("CPF_CNPJ"));
            fornecedor.setNome(resultSet.getString("Nome"));
            fornecedor.setNomeFantasia(resultSet.getString("Nome Fantasia"));

            fornecedores.add(fornecedor);
        }
        return fornecedores;
    }

    // SELECIONAR UM FORNECEDOR
    public Fornecedor getOne(int id) throws SQLException {
        String sql = "SELECT * FROM fornecedor WHERE Id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(resultSet.getInt("Id"));
        fornecedor.setTpFornecedor(resultSet.getString("Tp Fornecedor"));
        fornecedor.setCpfCnpj(resultSet.getString("CPF_CNPJ"));
        fornecedor.setNome(resultSet.getString("Nome"));
        fornecedor.setNomeFantasia(resultSet.getString("Nome Fantasia"));

        return fornecedor;
    }

    // INSERIR NOVO FORNECEDOR
    public Fornecedor insert() throws SQLException {
        String sql = "INSERT INTO fornecedor VALUES(null, ?, ?, ?);";
        String sql2 = "SELECT MAX(Id) as Id,nome,descricao,categoria FROM fornecedor;";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInforme o nome do fornecedor: ");
        String nome = sc.nextLine();
        System.out.print("\nInforme a descrição do fornecedor: ");
        String descricao = sc.nextLine();
        System.out.print("\nInforme a categoria do fornecedor: ");
        String categoria = sc.nextLine();
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);
        preparedStatement.setString(3, categoria);
        preparedStatement.executeUpdate();

        PreparedStatement prepareStatement2 = conn.prepareStatement(sql2);
        ResultSet resultSet = prepareStatement2.executeQuery();

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(resultSet.getInt("Id"));
        fornecedor.setTpFornecedor(resultSet.getString("Tp Fornecedor"));
        fornecedor.setCpfCnpj(resultSet.getString("CPF_CNPJ"));
        fornecedor.setNome(resultSet.getString("Nome"));
        fornecedor.setNomeFantasia(resultSet.getString("Nome Fantasia"));

        return fornecedor;
    }


    // ALTERAR UM FORNECEDOR
    public void update(int id, String campo, String valor) throws SQLException {
        String sql = "UPDATE produto SET " + campo + " = '" + valor + " ' WHERE Id = " + id + ";";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }


    // DELETAR UM FORNECEDOR
    public void delet() throws SQLException {
        String sql = "DELETE FROM produto WHERE Id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        Scanner sc = new Scanner(System.in);
        System.out.print("\nInforme o Id do fornecedor: ");
        int id = sc.nextInt();
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }

}
