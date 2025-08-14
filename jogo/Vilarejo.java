package jogo;

import java.util.Scanner;

public class Vilarejo extends Local implements Posicao{

    private Inventario inventario;
    private Scanner scanner = new Scanner(System.in);

    public Vilarejo(String nome, Inventario inventario){
        super(nome);
        this.inventario = inventario;
    }


    @Override
    public void interagir_local(){
        System.out.println("Escolha uma opção a seguir:");
        System.out.println("1. Conversar com um aldeão");
        System.out.println("2. Procurar por itens no vilarejo");
        
        String opcao = scanner.nextLine();

        switch (opcao) {
            case "1":
                System.out.println("Voocê encontrou um aldeão. Ele lhe contou sobre a história do vilarejo");
                break;
            case "2":
                inventario.adicionarItem(new Item("Poção de ataque"));
                System.out.println("Você encontrou uma poção de ataque no vilarejo!");
                break;
            default:
                break;
        }
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
