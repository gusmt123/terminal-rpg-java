package jogo;

import java.util.Scanner;

public class Torre extends Local{
    
    private Jogador jogador;
    private Inventario inventario;
    private Scanner scanner = new Scanner(System.in);

    public Torre(String nome, Inventario inventario, Jogador jogador){
        super(nome);
        this.inventario = inventario;
        this.jogador = jogador;
    }

    @Override
    public void interagir_local(){
        System.out.println("Escolha uma opção a seguir:");
        System.out.println("1. Procurar por itens");
        System.out.println("2. Lutar com um dragão");

        String opcao = scanner.nextLine();

        switch (opcao) {
            case "1":
                inventario.adicionarItem(new Item("Poção"));
                System.out.println("Você encontrou uma poção na torre!");
                break;
            case "2":
                System.out.println("Você se deparou com um dragão! Prepare-se para lutar!");
                Criatura dragao = new Criatura("Dragão", 1);
                Combate combate = new Combate(inventario, jogador, dragao);
                combate.menu_Combate();
                break;

            default:
                break;
        }


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
