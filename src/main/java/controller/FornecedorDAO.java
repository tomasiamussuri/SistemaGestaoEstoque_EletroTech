package controller;

import model.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FornecedorDAO {
    Connection conexao;

    public FornecedorDAO() throws SQLException {
        this.conexao = ConexaoSQLite.getConexao();
    }

    // LISTAR TODOS OS FORNECEDORES
    public ArrayList<Fornecedor> buscarTodos() throws SQLException {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor;";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ResultSet resultSetFornecedor = preparedStatement.executeQuery();

        while (resultSetFornecedor.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(resultSetFornecedor.getInt("Id"));
            fornecedor.setCpfCnpj(resultSetFornecedor.getString("CPF_CNPJ"));
            fornecedor.setNome(resultSetFornecedor.getString("Nome"));
            fornecedor.setNomeFantasia(resultSetFornecedor.getString("NomeFantasia"));
            fornecedores.add(fornecedor);
        }
        return fornecedores;
    }

    // SELECIONAR UM FORNECEDOR
    public Fornecedor buscarUmId(int id) throws SQLException {
        String sql = "SELECT * FROM fornecedor WHERE Id = ?;";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(resultSet.getInt("Id"));
        fornecedor.setCpfCnpj(resultSet.getString("CPF_CNPJ"));
        fornecedor.setNome(resultSet.getString("Nome"));
        fornecedor.setNomeFantasia(resultSet.getString("NomeFantasia"));
        return fornecedor;
    }

    // INSERIR NOVO FORNECEDOR
    public Fornecedor cadastrar() throws SQLException {
        String sql = "INSERT INTO fornecedor VALUES(null, ?, ?, ?);";
        String sql2 = "SELECT MAX(Id) as ID, CPF_CNPJ, Nome, NomeFantasia FROM fornecedor;";

        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInforme o CPF ou CNPJ do fornecedor: ");
        String nome = sc.nextLine();
        System.out.print("\nInforme o nome do fornecedor: ");
        String descricao = sc.nextLine();
        System.out.print("\nInforme ao nome fantasia do fornecedor: ");
        String categoria = sc.nextLine();
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);
        preparedStatement.setString(3, categoria);
        preparedStatement.executeUpdate();

        PreparedStatement prepareStatement2 = conexao.prepareStatement(sql2);
        ResultSet resultSet = prepareStatement2.executeQuery();

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(resultSet.getInt("Id"));
        fornecedor.setCpfCnpj(resultSet.getString("CPF_CNPJ"));
        fornecedor.setNome(resultSet.getString("Nome"));
        fornecedor.setNomeFantasia(resultSet.getString("NomeFantasia"));

        return fornecedor;
    }

    // ALTERAR UM FORNECEDOR
    public void alterar(int id, String campo, String valor) throws SQLException {
        String sql = "UPDATE fornecedor SET " + campo + " = '" + valor + " ' WHERE Id = " + id + ";";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }

    // DELETAR UM FORNECEDOR
    public void deletar() throws SQLException {
        String sql = "DELETE FROM fornecedor WHERE Id = ?;";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);

        Scanner sc = new Scanner(System.in);
        System.out.print("\nInforme o Id do fornecedor: ");
        int id = sc.nextInt();
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }

    // CABEÇALHO DE IMPRESSÃO DE DADOS
    public void cabecalho() {
        System.out.println("\n+------------------------------------------------------------------------------------------------+");
        System.out.println(String.format("| %-5s | %-20s | %-40s | %-20s |", "ID", "CPF/CNPJ", "Nome", "Nome Fantasia"));
        System.out.println("+------------------------------------------------------------------------------------------------+");
    }

}
