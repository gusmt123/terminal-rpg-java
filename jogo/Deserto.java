package jogo;

import java.util.Scanner;

public class Deserto extends Local implements Posicao {

    private String nome;
    private Inventario inventario;
    private Jogador jogador;    

    public Deserto(String nome, Inventario inventario, Jogador jogador) {
        super("Deserto");
        this.nome = nome;
        this.inventario = inventario;
        this.jogador = jogador;
    }

    @Override
    public String locomover() {
        System.out.println("Você pode se locomover para:");
        System.out.println("1. Floresta");

        Scanner scanner = new Scanner(System.in);
        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1":
                System.out.println("Você se locomoveu para a Floresta.");
                return "floresta";

            default:
                System.out.println("Opção inválida. Tente novamente.");
                return locomover(); // Chama novamente o método para tentar outra vez
        }
    }

    @Override
    public void interagir_local() {
        System.out.println("Oq deseja fazer?");
        System.out.println("1. Procurar por itens");

        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();

        switch (opcao) {
            case "1":
                jogador.ganharDinheiro(10);
                System.out.println("Você encontrou 10 moedas de ouro no deserto!");
                break;
        
            default:
                break;
        }

    }

    @Override
    public void mostrar_local() {
        System.out.println("Você está em um deserto.");
    }

}
