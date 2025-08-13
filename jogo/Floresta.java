package jogo;

import java.util.Scanner;

public class Floresta extends Local {

    private Scanner scanner = new Scanner(System.in);
    private Inventario inventario;

    public Floresta(String nome, Inventario inventario) {
        super(nome);
        this.inventario = inventario;
    }

    @Override
    public void interagir_local() {
        System.out.println("Você está na Floresta. Você pode:");
        System.out.println("1. Falar com os habitantes");
        System.out.println("2. Voltar para o menu principal");

        String opcao = scanner.nextLine();

        switch (opcao) {
            case "1":

                boolean possuiEspada = inventario.getItens().stream()
    .anyMatch(item -> item.getNome().equalsIgnoreCase("Espada"));

                if (possuiEspada) {
                    System.out.println("Você já possui uma espada.");
                    return;
                }

                inventario.adicionarItem(new Item("Espada"));
                System.out.println("Os habitantes da floresta te deram uma espada!");
                break;

            case "2":
                System.out.println("Voltando para o menu principal...");
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
                interagir_local();
                break;
        }
    }

    @Override
    public String locomover() {
        mostrar_local();

        System.out.println("Você pode se locomover para:");
        System.out.println("1. Castelo");
        System.out.println("2. Caverna");
        System.out.println("3. Vilarejo");

        String opcao = scanner.nextLine();

        switch (opcao) {
            case "1":
                System.out.println("Você se locomoveu para o Castelo.");
                return "castelo";

            case "2":
                System.out.println("Você se locomoveu para a Caverna.");
                return "caverna";

            case "3":
                System.out.println("Você se locomoveu para o Vilarejo.");
                return "vilarejo";
            
            default:
                System.out.println("Opção inválida. Tente novamente.");
                return locomover();
        }
    }
}
