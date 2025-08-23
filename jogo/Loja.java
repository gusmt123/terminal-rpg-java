package jogo;

import java.util.Scanner;

public class Loja {
    
    private Inventario inventario;
    private Jogador jogador;

    public Loja(Inventario inventario, Jogador jogador){
        this.inventario = inventario;
        this.jogador = jogador;
    }

    public void comprar(){
        System.out.println("Bem-vindo à loja! Aqui estão os itens disponíveis para compra:");
        System.out.println("1. Poção - 10 moedas");
        System.out.println("2. Poção de Ataque - 15 moedas");
        System.out.println("3. Poção de Defesa - 12 moedas");
        System.out.println("Escolha o número do item que deseja comprar ou 'sair' para encerrar a compra.");

        Scanner scanner = new Scanner(System.in);
        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1":
                if(jogador.getDinheiro() < 10) {
                    System.out.println("Você não tem dinheiro suficiente para comprar este item.");
                    return;
                }
                inventario.adicionarItem(new Item("Poção"));
                System.out.println("Você comprou uma Poção!");
                break;
            case "2":
                if(jogador.getDinheiro() < 15) {
                    System.out.println("Você não tem dinheiro suficiente para comprar este item.");
                    return;
                }
                inventario.adicionarItem(new Item("Poção de Ataque"));
                System.out.println("Você comprou uma Poção de Ataque!");
                break;
            case "3":
                if(jogador.getDinheiro() < 12) {
                    System.out.println("Você não tem dinheiro suficiente para comprar este item.");
                    return;
                }
                inventario.adicionarItem(new Item("Poção de Defesa"));
                System.out.println("Você comprou uma Poção de Defesa!");
                break;
            case "sair":
                System.out.println("Obrigado por visitar a loja!");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }



}
