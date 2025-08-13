package jogo;

import java.util.Scanner;

public class Menu_Derrota {
    
    public void exibir_Menu_Derrota(){
        System.out.println("Você foi derrotado!");
        System.out.println("1. Reiniciar jogo");
        System.out.println("2. Sair");

        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();
        switch (opcao) {
            case "1":
                Inicio_Jogo.main(null);
                break;
        
            case "2":
                System.out.println("Obrigado por jogar!");
                System.exit(0);
                break;

            default:
                System.out.println("Selecione uma opção válida");
                exibir_Menu_Derrota();
                break;
        }

    }

}
