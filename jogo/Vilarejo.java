package jogo;

import java.util.Scanner;

public class Vilarejo extends Local implements Posicao{

    public Vilarejo(String nome){
        super(nome);
    }


    @Override
    public void interagir_local(){

    }

    @Override
    public String locomover() {
        mostrar_local();
        System.out.println("Você pode se locomover para:");
        System.out.println("1. Floresta");
        System.out.println("2. Torre");

        Scanner scanner = new Scanner(System.in);
        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1":
                System.out.println("Você se locomoveu para a Floresta.");
                return "floresta";
            case "2":
                System.out.println("Você se locomoveu para a Torre.");
                return "torre";

            default:
                System.out.println("Opção inválida. Tente novamente.");
                return locomover(); // Chama novamente o método para tentar outra vez
        }
    }

  
}
