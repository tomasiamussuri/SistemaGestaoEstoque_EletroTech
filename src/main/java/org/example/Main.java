package org.example;

import controller.ProdutoDAO;
import controller.FornecedorDAO;
import model.Produto;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        // MENU PRINCIPAL

        do {
            System.out.println("\n_________________________________" +
                    "\n\t***** ELETROTECH *****" +
                    "\n_________________________________" +
                    "\n[1] Cadastro de Produto" +
                    "\n[2] Cadastro de Fornecedor" +
                    "\n[0] Sair");
            System.out.print("\nEscolha a opção desejada: ");

            opcao = sc.nextInt();


            if (opcao == 0) {

            // MENU: PRODUTO
            } else if (opcao == 1) {
                int opcaoProduto = 0;
                do {
                    System.out.println("\n*** Cadastro de Produtos ***" +
                            "\n[1] Listar" +
                            "\n[2] Buscar" +
                            "\n[3] Inserir" +
                            "\n[4] Alterar" +
                            "\n[5] Deletar" +
                            "\n[0] Voltar");
                    System.out.print("\nEscolha a opção desejada: ");
                    opcaoProduto = sc.nextInt();

                    if (opcaoProduto == 0) {

                    } else if (opcaoProduto == 1) { //LISTAR PRODUTOS CADASTRADOS
                        ArrayList<Produto> produtos = new ArrayList<>();
                        //System.out.print(produtoDAO.getAll());
                        produtos = produtoDAO.getAll();

                        for (Produto produto:produtos) {
                            System.out.println(produto);
                        }

                    } else if (opcaoProduto == 2) { //BUSCAR UM PRODUTO
                        System.out.print("\nInforme o id do produto: ");
                        int id = sc.nextInt();
                        System.out.println(produtoDAO.getOne(id));

                    } else if (opcaoProduto == 3) { //CADASTRAR NOVO PRODUTO
                        Produto produto = produtoDAO.insert();
                        //System.out.println(produtoDAO.insert());
                        System.out.println("\nProduto cadastrado com sucesso!");
                        System.out.println(produto);

                    } else if (opcaoProduto == 4) { //ALTERAR DADOS DE UM PRODUTO
                        //produtoDAO.update();

                        int opcaoProdutoAlterar = 0;
                        System.out.print("\nInforme o Id do produto que deseja alterar: ");
                        int id = sc.nextInt();
                        System.out.print(produtoDAO.getOne(id));

                        do {
                            System.out.println();
                            System.out.println("\n*** Alterar cadastro de produto ***" +
                                    "\n[1] Nome" +
                                    "\n[2] Descrição" +
                                    "\n[3] Categoria" +
                                    "\n[0] Voltar");
                            System.out.print("\nEscolha a opção desejada: ");
                            opcaoProdutoAlterar = sc.nextInt();

                            if (opcaoProdutoAlterar == 0) {

                            } else if (opcaoProdutoAlterar == 1) { //ALTERAR NOME DO PRODUTO
                                System.out.print("\nInforme o novo nome do produto: ");
                                sc.nextLine();
                                String nome = sc.nextLine();
                                produtoDAO.update(id, "Nome", nome);
                                System.out.println("\nNome alterado com sucesso!");
                                System.out.println(produtoDAO.getOne(id));

                            } else if (opcaoProdutoAlterar == 2) { //ALTERAR DESCRIÇÃO DO PRODUTO
                                System.out.print("\nInforme a nova descrição do produto: ");
                                sc.nextLine();
                                String descricao = sc.nextLine();
                                produtoDAO.update(id, "Descricao", descricao);
                                System.out.println("\nDescrição alterada com sucesso!");
                                System.out.println(produtoDAO.getOne(id));

                            } else if (opcaoProdutoAlterar ==3) { //ALTERAR CATEGORIA DO PRODUTO
                                System.out.print("\nInforme a nova categoria do produto: ");
                                sc.nextLine();
                                String categoria = sc.nextLine();
                                produtoDAO.update(id, "Categoria", categoria);
                                System.out.println("\nCategoria alterada com sucesso!");
                                System.out.println(produtoDAO.getOne(id));

                            } else {
                                System.out.println("\nOpção inválida, tente novamente!");
                            }

                        } while (opcaoProdutoAlterar != 0);


                    } else if (opcaoProduto == 5) { //DELETAR UM PRODUTO
                        produtoDAO.delet();
                        System.out.println("\nProduto deletado com sucesso!");

                    } else {
                        System.out.println("\nOpção inválida, tente novamente!");
                    }
                } while (opcaoProduto != 0);

            // MENU: FORNECEDOR
            } else if (opcao == 2) {
                int opcaoFornecedor = 0;
                do{
                    System.out.println("\n*** Cadastro de Fornecedores ***" +
                            "\n[1] Listar" +
                            "\n[2] Buscar" +
                            "\n[3] Inserir" +
                            "\n[4] Alterar" +
                            "\n[5] Deletar" +
                            "\n[0] Voltar");
                    System.out.println("\nEscolha a opção desejada: ");
                    opcaoFornecedor = sc.nextInt();
                } while (opcaoFornecedor != 0);

            } else {
                System.out.println("\nOpção inválida, tente novamente!");
            }
        } while (opcao != 0);

    }
}