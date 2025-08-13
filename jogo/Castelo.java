package jogo;

import java.util.Scanner;

public class Castelo extends Local {

    private Inventario inventario;
    private Scanner scanner = new Scanner(System.in);  
    
    public Castelo(String nome, Inventario inventario){
        super(nome);
        this.inventario = inventario;
    }



    @Override
    public void interagir_local(){
        System.out.println("Escolha uma das opcoes abaixo:");
        System.out.println("1. Procurar por itens");
        System.out.println("2. Voltar");

        String opcao = scanner.nextLine();

        switch (opcao) {
            case "1":
                inventario.adicionarItem(new Item("Escudo"));
                System.out.println("Você encontrou um escudo no castelo!");
                break;
        
            case "2":
                System.out.println("Você decidiu voltar.");
                return; // Retorna para o menu anterior ou encerra a interação
            default:
                break;
        }


    }

    @Override
    public String locomover(){
        mostrar_local();
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

}
