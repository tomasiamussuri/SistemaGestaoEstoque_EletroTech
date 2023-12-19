package org.example;

import controller.ProdutoDAO;
import model.Produto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("***** ELETROTECH *****" +
                    "\n[1] Produto" +
                    "\n[2] Fornecedor");
            System.out.println("Escolha a opção desejada: ");

            opcao = sc.nextInt();

            // menu produto
            if (opcao == 1) {
                int opcaoProduto = 0;
                do {
                    System.out.println("*** Cadastro de Produtos ***" +
                            "\n[1] Listar" +
                            "\n[2] Buscar" +
                            "\n[3] Inserir" +
                            "\n[4] Alterar" +
                            "\n[5] Deletar");
                    System.out.print("\nEscolha a opção desejada: ");
                    opcao = sc.nextInt();
                } while (opcaoProduto != 0);

                if (opcaoProduto == 1) {
                    produtoDAO.getAll();
                } else if (opcaoProduto == 2) {
                    System.out.println("Informe o id do produto: ");
                    int id = sc.nextInt();
                    produtoDAO.getOne(id = sc.nextInt());
                } else if (opcaoProduto == 3) {
                    produtoDAO.insert();
                } else if (opcaoProduto == 4) {
                    //produtoDAO.update();
                } else if (opcaoProduto == 5) {
                    produtoDAO.delet();
                } else {
                    System.out.println("Opção inválida <produto>, tente novamente!");
                }


            } else if (opcao == 2) {
                int opcaoFornecedor = 0;
                do{
                    System.out.println("*** Cadastro de Fornecedores ***" +
                            "\n[1] Listar" +
                            "\n[2] Buscar" +
                            "\n[3] Inserir" +
                            "\n[4] Alterar" +
                            "\n[5] Deletar");
                    System.out.println("\nEscolha a opção desejada: ");
                    opcaoFornecedor = sc.nextInt();
                } while (opcaoFornecedor != 0);

            } else {
                System.out.println("Opção inválida, tente novamente!");
            }
        } while (opcao != 0);


        ArrayList<Produto> produtos = new ArrayList<>();
        //System.out.print(produtoDAO.getAll());

        produtoDAO.insert();
        //produtoDAO.update();
        produtoDAO.delet();
        //produtoDAO.getOne();
        produtos = produtoDAO.getAll();

        for (Produto produto:produtos) {
            System.out.println(produto);
        }

    }
}