package jogo;

import java.util.Scanner;

public class Menu__Jogo {
 
    private Inventario inventario;
    private Posicao posicao;
    private Scanner scanner;

    public Menu__Jogo(Inventario inventario, Posicao posicao)
    {
        scanner = new Scanner(System.in);
        this.inventario = inventario;
        this.posicao = posicao;
    }

    public void mudarPosicao(String localizacao)
    {
        if (localizacao.equals("floresta")) {
            posicao = new Floresta("Floresta");
        } else if (localizacao.equals("caverna")) {
            posicao = new Caverna("Caverna");
        } else if (localizacao.equals("castelo")) {
            posicao = new Castelo("Castelo");
        } else if (localizacao.equals("vilarejo")) {
            posicao = new Vilarejo("Vilarejo");
        } else if (localizacao.equals("torre")) {
            posicao = new Torre("Torre");
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
            System.out.println("5. Salvar");
            System.out.println("6. Sair");


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

                    break;

                case "6":
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
