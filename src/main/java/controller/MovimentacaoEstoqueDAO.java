package controller;

import model.MovimentacaoEstoque;

import java.lang.invoke.StringConcatFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;

public class MovimentacaoEstoqueDAO {
    Connection conexao;

    public MovimentacaoEstoqueDAO() throws SQLException {
        this.conexao = ConexaoSQLite.getConexao();
    }

    public void inserir(MovimentacaoEstoque movimentacao) throws SQLException {
        String sql = "INSERT INTO MovimentacaoEstoque (idFornecedorProduto, data, quantidade, tipoMovimentacao, custo, lote, validade) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, movimentacao.getId());
            preparedStatement.setDate(2, java.sql.Date.valueOf(movimentacao.getData()));
            preparedStatement.setDouble(3, movimentacao.getQuantidade());
            preparedStatement.setString(4, movimentacao.getTipoMovimentacao());
            preparedStatement.setDouble(5, movimentacao.getCusto());
            preparedStatement.setInt(6, movimentacao.getLote());
            preparedStatement.setDate(7, java.sql.Date.valueOf(movimentacao.getValidade()));
            preparedStatement.executeUpdate();
       }
    }

    public void alterar(MovimentacaoEstoque movimentacao) throws SQLException {
        String sql = "UPDATE MovimentacaoEstoque SET idFornecedorProduto = ?, data =?, quantidade = ?, tipoMovimentacao = ?, custo = ?, lote = ?, validade = ? WHERE id = ?;";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, movimentacao.getId());
            preparedStatement.setDate(2, java.sql.Date.valueOf(movimentacao.getData()));
            preparedStatement.setDouble(3, movimentacao.getQuantidade());
            preparedStatement.setString(4, movimentacao.getTipoMovimentacao());
            preparedStatement.setDouble(5, movimentacao.getCusto());
            preparedStatement.setInt(6, movimentacao.getLote());
            preparedStatement.setDate(7, java.sql.Date.valueOf(movimentacao.getValidade()));
            preparedStatement.setInt(8, movimentacao.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM MovimentacaoEstoque WHERE id = ?;";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public ArrayList<MovimentacaoEstoque> buscarTodos() throws SQLException {
        ArrayList<MovimentacaoEstoque> movimentacoes = new ArrayList<>();
        String sql = "SELECT me.id, me.FK_Id_Fornecedor_Produto as idFornecedorProduto, p.nome as produto, f.nome as fornecedor,me.data,me.Quantidade,me.Tipo_Movimentacao,me.Custo,me.Lote,me.Validade FROM Movimentacao_Estoque AS me\n" +
        "INNER JOIN Fornecedor_Produto AS fp\n" +
        "ON me.Id = fp.Id\n" +
        "INNER JOIN Produto p\n" +
        "ON p.id = fp.FK_Id_Produto\n" +
        "INNER JOIN Fornecedor f\n" +
        "ON f.id = fp.FK_Id_Fornecedor;";
        
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery()) {
        while (rs.next()) {
           MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
           movimentacao.setId(rs.getInt("id"));
           movimentacao.setfkIdFornecedorProduto(rs.getInt("fkIdFornecedorProduto"));
           movimentacao.setProduto(rs.getString("produto"));
           movimentacao.setFornecedor(rs.getString("fornecedor"));
           movimentacao.setData(rs.getDate("data").toLocalDate());
           movimentacao.setQuantidade(rs.getDouble("quantidade"));
           movimentacao.setTipoMovimentacao(rs.getString("tipo_Movimentacao"));
           movimentacao.setCusto(rs.getDouble("custo"));
           movimentacao.setLote(rs.getInt("lote"));
           movimentacao.setValidade(rs.getDate("validade").toLocalDate());
           movimentacoes.add(movimentacao);
       }

       return movimentacoes;
    }

    public MovimentacaoEstoque buscarPorId(int id) throws SQLException {
        String sql = "SELECT me.id,me.FK_Id_Fornecedor_Produto, p.nome as produto, f.nome as fornecedor,me.data,me.Quantidade,me.Tipo_Movimentacao,me.Custo,me.Lote,me.Validade FROM Movimentacao_Estoque AS me\n" +
                "INNER JOIN Fornecedor_Produto AS fp\n" +
                "ON me.Id = fp.Id\n" +
                "INNER JOIN Produto p\n" +
                "ON p.id = fp.FK_Id_Produto\n" +
                "INNER JOIN Fornecedor f\n" +
                "ON f.id = fp.FK_Id_Fornecedor\n" +
                "WHERE me.id = ?;";

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
                    movimentacao.setId(rs.getInt("id"));
                    movimentacao.setIdFornecedorProduto(rs.getInt("FK_Id_Fornecedor_Produto"));
                    movimentacao.setProduto(rs.getString("produto"));
                    movimentacao.setFornecedor(rs.getString("fornecedor"));

                    // Convertendo timestamp Unix para LocalDate
                    long dataMillis = rs.getLong("data");
                    LocalDate data = Instant.ofEpochMilli(dataMillis).atZone(ZoneId.systemDefault()).toLocalDate();
                    movimentacao.setData(data);

                    movimentacao.setQuantidade(rs.getDouble("quantidade"));
                    movimentacao.setTipoMovimentacao(rs.getString("tipo_Movimentacao"));
                    movimentacao.setCusto(rs.getDouble("custo"));
                    movimentacao.setLote(rs.getInt("lote"));

                    // Convertendo timestamp Unix para LocalDate para o campo 'validade'
                    long validadeMillis = rs.getLong("validade");
                    LocalDate validade = Instant.ofEpochMilli(validadeMillis).atZone(ZoneId.systemDefault()).toLocalDate();
                    movimentacao.setValidade(validade);

                    return movimentacao;
                }
            }
        }
        return null; // Retorna null se não encontrar um registro com o ID especificado
    }
}
