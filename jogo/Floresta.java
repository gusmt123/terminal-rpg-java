package jogo;

import java.util.Scanner;

public class Floresta extends Local{
    
    private Scanner scanner = new Scanner(System.in);
    private Inventario inventario;

    public Floresta(String nome, Inventario inventario)
    {
        super(nome);
        this.inventario = inventario;
    }

    @Override
    public void interagir_local(){
        System.out.println("Você está na Floresta. Você pode:");
        System.out.println("1. Falar com os habitantes");
        System.out.println("2. Voltar para o menu principal");

        String opcao = scanner.nextLine();
        switch (opcao) {
            case "1":
                inventario.adicionarItem(new Item("espada"));
                System.out.println("Os habitantes da floresta te deram uma espada!");
                // Aqui você pode adicionar lógica para interagir com os habitantes
                break;
            case "2":
                System.out.println("Voltando para o menu principal...");
                // Aqui você pode adicionar lógica para voltar ao menu principal
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                interagir_local(); // Chama novamente o método para tentar outra vez
        }

    }

    @Override
    public String locomover() {
        mostrar_local();
        System.out.println("Você pode se locomover para:");
        System.out.println("1. Castelo");
        System.out.println("2. Caverna");

        String opcao = scanner.nextLine();
        switch (opcao) {
            case "1":
                System.out.println("Você se locomoveu para o Castelo.");
                return "castelo";
            case "2":

                System.out.println("Você se locomoveu para a Caverna.");
                return "caverna";
            default:

                System.out.println("Opção inválida. Tente novamente.");
                return locomover(); // Chama novamente o método para tentar outra vez
            }
    }




}
