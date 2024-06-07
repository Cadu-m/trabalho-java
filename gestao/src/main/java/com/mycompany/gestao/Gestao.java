package com.mycompany.gestao;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Gestao {
    private static final Map<String, Produto> estoque = new HashMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            
            do {
                System.out.println("\n1. Adicionar produto");
                System.out.println("2. Atualizar quantidade");
                System.out.println("3. Remover produto");
                System.out.println("4. Exibir estoque");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcao) {
                    case 1 -> adicionarProduto(scanner);
                    case 2 -> atualizarQuantidade(scanner);
                    case 3 -> removerProduto(scanner);
                    case 4 -> exibirEstoque();
                    case 5 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcao != 5);
        }   
        catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
        }
    }

    private static void adicionarProduto(Scanner scanner) {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); 

        Produto produto = new Produto(nome, quantidade);
        estoque.put(nome, produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void atualizarQuantidade(Scanner scanner) {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        if (estoque.containsKey(nome)) {
            System.out.print("Nova quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // consumir nova linha

            Produto Produto = estoque.get(nome);
            Produto.setQuantidade(quantidade);
            System.out.println("Quantidade atualizada com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void removerProduto(Scanner scanner) {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        if (estoque.containsKey(nome)) {
            estoque.remove(nome);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void exibirEstoque() {
        if (estoque.isEmpty()) {
            System.out.println("Estoque vazio!");
        } else {
            System.out.println("Estoque:");
            for (Produto Produto : estoque.values()) {
                System.out.println(Produto);
            }
        }
    }
}