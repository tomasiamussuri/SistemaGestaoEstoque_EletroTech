package org.example;

import controller.ProdutoDAO;
import controller.FornecedorDAO;
import controller.FornecedorProdutoDAO;
import controller.MovimentacaoEstoqueDAO;

import model.Produto;
import model.Fornecedor;
import model.FornecedorProduto;
import model.MovimentacaoEstoque;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        FornecedorProdutoDAO fornecedorProdutoDAO = new FornecedorProdutoDAO();
        MovimentacaoEstoqueDAO movimentacaoEstoqueDAO = new MovimentacaoEstoqueDAO();

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        // MENU PRINCIPAL
        do {
            System.out.println("\n________________________________________" +
                    "\n\t\t***** ELETROTECH *****" +
                    "\n________________________________________" +
                    "\n[1] Cadastro de Produto" +
                    "\n[2] Cadastro de Fornecedor" +
                    "\n[3] Cadastro de Produto x Fornecedor" +
                    "\n[4] Cadastro de Movimentação de Estoque" +
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
                        produtos = produtoDAO.buscarTodos();

                        produtoDAO.cabecalho();;
                        for (Produto produto:produtos) {
                            System.out.println(produto);
                        }

                    } else if (opcaoProduto == 2) { //SELECIONAR UM PRODUTO
                        System.out.print("\nInforme o id do produto: ");
                        int id = sc.nextInt();
                        produtoDAO.cabecalho();;
                        System.out.println(produtoDAO.buscarUmId(id));

                    } else if (opcaoProduto == 3) { //CADASTRAR NOVO PRODUTO
                        Produto produto = produtoDAO.cadastrar();
                        //System.out.println(produtoDAO.insert());
                        System.out.println("\nProduto cadastrado com sucesso!");
                        System.out.println(produto);

                    } else if (opcaoProduto == 4) { //ALTERAR DADOS DE UM PRODUTO
                        int opcaoProdutoAlterar = 0;
                        System.out.print("\nInforme o Id do produto que deseja alterar: ");
                        int id = sc.nextInt();
                        produtoDAO.cabecalho();
                        System.out.print(produtoDAO.buscarUmId(id));

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
                                produtoDAO.alterar(id, "Nome", nome);
                                System.out.println("\nNome alterado com sucesso!");
                                produtoDAO.cabecalho();
                                System.out.println(produtoDAO.buscarUmId(id));

                            } else if (opcaoProdutoAlterar == 2) { //ALTERAR DESCRIÇÃO DO PRODUTO
                                System.out.print("\nInforme a nova descrição do produto: ");
                                sc.nextLine();
                                String descricao = sc.nextLine();
                                produtoDAO.alterar(id, "Descricao", descricao);
                                System.out.println("\nDescrição alterada com sucesso!");
                                produtoDAO.cabecalho();;
                                System.out.println(produtoDAO.buscarUmId(id));

                            } else if (opcaoProdutoAlterar ==3) { //ALTERAR CATEGORIA DO PRODUTO
                                System.out.print("\nInforme a nova categoria do produto: ");
                                sc.nextLine();
                                String categoria = sc.nextLine();
                                produtoDAO.alterar(id, "Categoria", categoria);
                                System.out.println("\nCategoria alterada com sucesso!");
                                produtoDAO.cabecalho();
                                System.out.println(produtoDAO.buscarUmId(id));

                            } else {
                                System.out.println("\nOpção inválida, tente novamente!");
                            }

                        } while (opcaoProdutoAlterar != 0);


                    } else if (opcaoProduto == 5) { //DELETAR UM PRODUTO
                        produtoDAO.deletar();
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
                    System.out.print("\nEscolha a opção desejada: ");
                    opcaoFornecedor = sc.nextInt();

                    if (opcaoFornecedor == 0) {

                    } else if (opcaoFornecedor == 1) { //LISTAR TODOS OS FORNECEDORES
                        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
                        fornecedores = fornecedorDAO.buscarTodos();
//                        System.out.println("\n+------------------------------------------------------------------------------------------------+");
//                        System.out.println(String.format("| %-5s | %-20s | %-40s | %-20s |", "ID", "CPF/CNPJ", "Nome", "Nome Fantasia"));
//                        System.out.println("+------------------------------------------------------------------------------------------------+");
                        fornecedorDAO.cabecalho();
                        for (Fornecedor fornecedor: fornecedores) {
                            System.out.println(fornecedor);
                        }

                    } else if (opcaoFornecedor == 2) { //SELECIONAR UM FORNECEDOR
                        System.out.print("\nInforme o Id do fornecedor: ");
                        int id = sc.nextInt();
                        fornecedorDAO.cabecalho();;
                        System.out.println(fornecedorDAO.buscarUmId(id));

                    } else if (opcaoFornecedor == 3) { //CADASTRAR NOVO FORNECEDOR
                        Fornecedor fornecedor = fornecedorDAO.cadastrar();
                        System.out.println("\nFornecedor cadastrado com sucesso!");
                        fornecedorDAO.cabecalho();
                        System.out.println(fornecedor);

                    } else if (opcaoFornecedor == 4) { //ALTERAR DADOS DE UM FORNECEDOR
                        int opcaoFornecedorAlterar = 0;
                        System.out.print("\nInforme o Id do fornecedor que deseja alterar: ");
                        int id = sc.nextInt();
                        fornecedorDAO.cabecalho();
                        System.out.print(fornecedorDAO.buscarUmId(id));

                        do {
                            System.out.println();
                            System.out.println("\n*** Alterar cadastro de fornecedor ***" +
                                    "\n[1] CPF ou CNPJ" +
                                    "\n[2] Nome" +
                                    "\n[3] Nome Fantasia" +
                                    "\n[0] Voltar");
                            System.out.print("\nEscolha a opção desejada: ");
                            opcaoFornecedorAlterar = sc.nextInt();

                            if (opcaoFornecedorAlterar == 0) {

                            } else if (opcaoFornecedorAlterar == 1) { //ALTERAR CPF OU CNPJ DO FORNECEDOR
                                System.out.print("\nInforme o novo CPF ou CNPJ do fornecedor: ");
                                sc.nextLine();
                                String cpf_cnpj = sc.nextLine();
                                fornecedorDAO.alterar(id, "CPF_CNPJ", cpf_cnpj);
                                System.out.println("\nCPF ou CNPJ alterado com sucesso!");
                                fornecedorDAO.cabecalho();
                                System.out.println(fornecedorDAO.buscarUmId(id));

                            } else if (opcaoFornecedorAlterar == 2) { //ALTERAR NOME DO FORNECEDOR
                                System.out.print("\nInforme o novo nome do fornecedor: ");
                                sc.nextLine();
                                String nome = sc.nextLine();
                                fornecedorDAO.alterar(id, "Nome", nome);
                                System.out.println("\nNome alterada com sucesso!");
                                fornecedorDAO.cabecalho();
                                System.out.println(fornecedorDAO.buscarUmId(id));

                            } else if (opcaoFornecedorAlterar ==3) { //ALTERAR NOME FANTASIA DO FORNECEDOR
                                System.out.print("\nInforme o novo nome de fantasia do fornecedor: ");
                                sc.nextLine();
                                String nomeFantasia = sc.nextLine();
                                fornecedorDAO.alterar(id, "NomeFantasia", nomeFantasia);
                                System.out.println("\nNome de Fantasia alterado com sucesso!");
                                fornecedorDAO.cabecalho();
                                System.out.println(fornecedorDAO.buscarUmId(id));

                            } else {
                                System.out.println("\nOpção inválida, tente novamente!");
                            }

                        } while (opcaoFornecedorAlterar != 0);

                    } else if (opcaoFornecedor == 5) { //DELETAR UM FORNECEDOR
                        fornecedorDAO.deletar();
                        System.out.println("\nFornecedor deletado com sucesso!");
                    } else {
                        System.out.println("Opção inválida, tente novamente!");
                    }

                } while (opcaoFornecedor != 0);

            // MENU: PRODUTO x FORNECEDOR
            } else if (opcao == 3) {
                int opcaoFornecedorProduto = 0;
                do {
                    System.out.println("\n*** Cadastro de Fornecedor X Produto ***" +
                            "\n[1] Listar" +
                            "\n[2] Buscar" + //por nome de produto e nome de fornecedor
                            "\n[3] Inserir" +
                            "\n[4] Alterar" +
                            "\n[5] Deletar" +
                            "\n[0] Voltar");
                    System.out.print("\nEscolha a opção desejada: ");
                    opcaoFornecedorProduto = sc.nextInt();

                    if (opcaoFornecedorProduto == 0) {
 
                    } else if (opcaoFornecedorProduto == 1) { //LISTAR TODOS OS PRODUTOS X FORNECEDORES
                        ArrayList<FornecedorProduto> fornecedoresProdutos = new ArrayList<>();
                        fornecedoresProdutos = fornecedorProdutoDAO.buscarTodos();
                        fornecedorDAO.cabecalho();
                        for (FornecedorProduto fornecedorProduto: fornecedoresProdutos) {
                            System.out.println(fornecedorProduto);
                        }
 
                    } else if (opcaoFornecedorProduto == 2) { //SELECIONAR UM PRODUTO X FORNECEDOR
                        System.out.println("\nInforme o Id do produto x fornecedor: ");
                        int id = sc.nextInt();
                        fornecedorProdutoDAO.cabecalho();
                        System.out.println(fornecedorProdutoDAO.buscarUmId(id));

                    } else if (opcaoFornecedorProduto == 3) { //CADASTRAR NOVO PRODUTO X FORNECEDOR
                        FornecedorProduto fornecedorProduto = fornecedorProdutoDAO.cadastrar();
                        System.out.println("\nProduto x Fornecedor cadastrado com sucesso!");
                        fornecedorProdutoDAO.cabecalho();
                        System.out.println(fornecedorProduto);
                    
                    } else if (opcaoFornecedorProduto == 4) { //ALTERAR DADOS PRODUTO X FORNECEDOR
                        int opcaoFornecedorProdutoAlterar = 0;
                        System.out.println("\nInforme o ID do produto x fornecedor que deseja alterar: ");

                        int id = sc.nextInt();
                        fornecedorProdutoDAO.cabecalho();
                        System.out.println(fornecedorProdutoDAO.buscarUmId(id));

                        do {
                            System.out.println();
                            System.out.println("\n*** Alterar cadastro do produto x fornecedor ***" +
                            "\n[1] Id Produto" +
                            "\n[2] Id Fornecedor" +
                            "\n[0] Voltar");
                            System.out.println("\nEscolha a opção desejada: ");
                            opcaoFornecedorProdutoAlterar = sc.nextInt();

                            if (opcaoFornecedorProdutoAlterar == 0) {

                            } else if (opcaoFornecedorProdutoAlterar == 1) { //ALTERAR ID DO PRODUTO
                                System.out.println("\nInforme o novo ID do produto: ");
                                sc.nextLine();
                                int fk_id_produto = sc.nextInt();
                                fornecedorProdutoDAO.alterar(id, null, fk_id_produto);
                                System.out.println("\nId do produto alterado com sucesso!");
                                fornecedorProdutoDAO.cabecalho();
                                System.out.println(fornecedorProdutoDAO.buscarUmId(id));
                            
                            } else if (opcaoFornecedorProdutoAlterar == 2) { //ALTERAR ID DO FORNECEDOR
                                System.out.println("\nInforme o novo ID do fornecedor: ");
                                sc.nextLine();
                                int fk_id_fornecedor = sc.nextInt();
                                fornecedorProdutoDAO.alterar(id, null, fk_id_fornecedor);
                                System.out.println("Id do fornecedor alterado com sucesso!");
                                fornecedorProdutoDAO.cabecalho();
                                System.out.println(fornecedorProdutoDAO.buscarUmId(id));
                            
                            } else {
                                System.out.println("\nOpção inválida, tente novamente!");
                            }
                        } while (opcaoFornecedorProdutoAlterar != 0);
                    
                    } else if (opcaoFornecedorProduto == 5) { //DELETAR PRODUTO X FORNECEDOR
                        fornecedorProdutoDAO.deletar();
                        System.out.println("\nProduto x Fornecedor deletado com sucesso!");
                    } else {
                        System.out.println("\nOpção inválida, tente novamente!");
                    }

                } while (opcaoFornecedorProduto != 0);
            
            //MENU: MOVIMENTACAO ESTOQUE
            } else if (opcao == 4) {
                int opcaoMovimentacao = 0;

                do {
                    System.out.println("\n*** Movimentação de Estoque ***" +
                    "\n[1] Listar" +
                    "\n[2] Buscar" + //por produto, fornecedor, data
                    "\n[3] Inserir" +
                    "\n[4] Alterar" +
                    "\n[5] Deletar" +
                    "\n[0] Voltar");
                    System.out.print("\nEscolha a opção desejada: ");
                    opcaoMovimentacao = sc.nextInt();

                    if (opcaoMovimentacao == 0) {

                    } else if (opcaoMovimentacao == 1) { //LISTAR TODAS AS MOVIMENTAÇÕES DE ESTOQUE
                        ArrayList<MovimentacaoEstoque> movimentacaoEstoque = new ArrayList<>();
                        movimentacaoEstoque = movimentacaoEstoqueDAO.buscarTodos();
                        MovimentacaoEstoqueDAO.cabecalho();
                        for (MovimentacaoEstoque movimentacaoEstoque: movimentacoes) {
                            System.out.println(fornecedorProduto);
                    } else if (opcaoMovimentacao == 2) {
                        
                    } else if (opcaoMovimentacao == 3) {

                    } else if (opcaoMovimentacao == 4) {

                    } else if (opcaoMovimentacao == 5) {

                    } else {
                        System.out.println("\nOpção inválida, tente novamente!");
                    }

                } while (opcaoMovimentacao != 0);

            } else {
                System.out.println("\nOpção inválida, tente novamente!");
            }
        } while (opcao != 0);

    }
}