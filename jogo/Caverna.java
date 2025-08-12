package jogo;

import java.util.Scanner;

public class Caverna extends Local {

    private Scanner scanner = new Scanner(System.in);
    private Inventario inventario;
    private Personagem jogador;

    public Caverna(String nome, Inventario inventario, Personagem jogador){ 
        super(nome);
        this.inventario = inventario;
        this.jogador = jogador;
    }


    @Override
    public void interagir_local(){
        System.out.println("Você entrou na caverna. O ambiente é escuro e úmido.");
        System.out.println("Você pode:");
        System.out.println("1. Procurar por itens");
        System.out.println("2. Lutar contra um monstro");

        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();

        switch (opcao) {
            case "1":

                boolean possuiPocao = inventario.getItens().stream()
                    .anyMatch(item -> item.getNome().equalsIgnoreCase("Poção"));

                if(possuiPocao) {
                    System.out.println("Você já achou todos os itens aqui.");
                    return;
                }

                inventario.adicionarItem(new Item("Poção"));
                System.out.println("Você encontrou uma poção na caverna!");
                break;
            case "2":
                System.out.println("Você se deparou com um monstro! Prepare-se para lutar!");
                Personagem monstro = new Personagem(20, 3, 1, "Monstro");
                Combate combate = new Combate(inventario, jogador , monstro);
                combate.menu_Combate();
                // Aqui você pode adicionar lógica para lutar contra o monstro
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
        System.out.println("1. Floresta");
        
        Scanner scanner = new Scanner(System.in);
        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1":
                System.out.println("Você se locomoveu para o Floresta.");
                return "floresta";

            default:
                System.out.println("Opção inválida. Tente novamente.");
                return locomover(); // Chama novamente o método para tentar outra vez
        
        }
    }


}
