package jogo;

import java.util.Scanner;

public class Menu__Jogo {
 
    private Inventario inventario;
    private Posicao posicao;
    private Scanner scanner;
    private Jogador jogador;

    public Menu__Jogo(Inventario inventario, Posicao posicao, Jogador jogador)
    {
        scanner = new Scanner(System.in);
        this.inventario = inventario;
        this.posicao = posicao;
        this.jogador = jogador;
    }

    public void mudarPosicao(String localizacao)
    {
        if (localizacao.equals("floresta")) {
            posicao = new Floresta("Floresta", inventario);
        } else if (localizacao.equals("caverna")) {
            posicao = new Caverna("Caverna", inventario, jogador);
        } else if (localizacao.equals("castelo")) {
            posicao = new Castelo("Castelo", inventario);
        } else if (localizacao.equals("vilarejo")) {
            posicao = new Vilarejo("Vilarejo", inventario, jogador);
        } else if (localizacao.equals("torre")) {
            posicao = new Torre("Torre", inventario, jogador);
        }
        else if (localizacao.equals("deserto")) {
            posicao = new Deserto("Deserto", inventario, jogador);
        } 
    }

    public void Menu_Jogo()
    {
        boolean continuar_jogando = true;
        
        
        while(continuar_jogando){
            System.out.println("Selecione uma opção: ");
            System.out.println("1. Ver oq tem no meu inventario");
            System.out.println("2. Ver onde estou");
            System.out.println("3. Interagir local");
            System.out.println("4. Locomover");
            System.out.println("5. Ver nível e XP");
            System.out.println("6. Visualizar dinheiro");
            System.out.println("7. Salvar");
            System.out.println("8. Sair");


            String opcao;
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    
                    inventario.mostrarItens();

                    break;
            
                case "2":
                    posicao.mostrar_local();
                    break;

                case "3":
                    posicao.interagir_local();
                    break;

                case "4":
                    String localizacao = posicao.locomover();
                    mudarPosicao(localizacao);
                    
                    
                    break;

                case "5":
                    System.out.println("Nível: " + jogador.getNivel());
                    System.out.println("XP: " + jogador.getXp());
                    break;

                case "6":
                    System.out.println("Dinheiro: " + jogador.getDinheiro());
                    break;

                case "7":
                    Gerenciador_Salvar salvador = new Gerenciador_Salvar();
                    salvador.salvar_jogo(jogador, inventario, ((Local) posicao).get_Nome().toLowerCase());
                    break;

                case "8":
                    System.out.println("Obrigado por jogar!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }

        }

    }


}
