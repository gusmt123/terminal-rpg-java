package jogo;

import java.util.Scanner;

public class Torre extends Local{
    
    private Inventario inventario;

    public Torre(String nome, Inventario inventario){
        super(nome);
        this.inventario = inventario;
    }

    @Override
    public void interagir_local(){

    }

    @Override
    public String locomover() {
        mostrar_local();
        System.out.println("Você pode se locomover para:");
        System.out.println("1. Vilarejo");


        Scanner scanner = new Scanner(System.in);
        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1":
                System.out.println("Você se locomoveu para a vilarejo.");
                return "vilarejo";
            default:
                System.out.println("Opção inválida. Tente novamente.");
                return locomover(); // Chama novamente o método para tentar outra vez
        }
    }

}
