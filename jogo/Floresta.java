package jogo;

import java.util.Scanner;

public class Floresta extends Local{
    
    private Scanner scanner = new Scanner(System.in);

    public Floresta(String nome)
    {
        super(nome);
    }

    @Override
    public void interagir_local(){

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
