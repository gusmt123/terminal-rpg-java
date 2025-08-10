package jogo;

import java.util.Scanner;

public class Menu_Inicial {

    private Scanner scanner;
    private Local local;
    private Inventario inventario;

    public Menu_Inicial(){
        scanner = new Scanner(System.in);
        
    }

    public void exibir_Menu(){
        
        boolean continuar_jogando = true;

        while(continuar_jogando){
        
            System.out.println("Selecione uma opção: ");
            System.out.println("1. Criar novo jogo");
            System.out.println("2. Abrir jogo salvo");
            System.out.println("3. Sair");

            String opcao = scanner.nextLine();

            switch (opcao){

                case "1":
                    criar_Jogo();
                    break;

                case "2":
                    abrir_Jogo();
                    break;

                case "3":

                    System.out.println("Obrigado por jogar!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Selecione uma opção válida");
            }

        }

    }

    public void abrir_Jogo(){

    }

    public void criar_Jogo(){
        Inventario inventario = new Inventario();
        Posicao posicao = new Floresta("Floresta");
        Menu__Jogo menu_jogo = new Menu__Jogo(inventario, posicao);
        menu_jogo.Menu_Jogo();
    }

}
