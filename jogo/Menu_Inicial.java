package jogo;

import java.util.Scanner;

public class Menu_Inicial {

    private Scanner scanner;
    private Local local;
    private Inventario inventario;
    private Personagem jogador;


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

        public void abrir_Jogo() {
            
        Gerenciador_Salvar gerenciador = new Gerenciador_Salvar();
        Gerenciador_Salvar.JogoSalvo dados = gerenciador.carregar_Jogo();

        if (dados == null) {
            System.out.println("Falha ao carregar o jogo salvo.");
            return;
        }

        Posicao posicao = null;
        switch (dados.localAtual.toLowerCase()) {
            case "floresta":
                posicao = new Floresta("Floresta", dados.inventario);
                break;
            case "castelo":
                posicao = new Castelo("Castelo", dados.inventario);
                break;
            case "caverna":
                posicao = new Caverna("Caverna", dados.inventario, dados.jogador);
                break;
            case "vilarejo":
                posicao = new Vilarejo("Vilarejo", dados.inventario);
                break;
            case "torre":
                posicao = new Torre("Torre", dados.inventario, dados.jogador);
                break;
            default:
                System.out.println("Local desconhecido no save.");
                return;
        }

        Menu__Jogo menu = new Menu__Jogo(dados.inventario, posicao, dados.jogador);
        menu.Menu_Jogo();
}


    public void criar_Jogo(){
        Inventario inventario = new Inventario();
        Posicao posicao = new Floresta("Floresta", inventario);
        String nome_jogador;
        System.out.println("Digite o seu nome:");
        nome_jogador = scanner.nextLine();
        jogador = new Personagem(20,5,1,nome_jogador);
        Menu__Jogo menu_jogo = new Menu__Jogo(inventario, posicao, jogador);
        menu_jogo.Menu_Jogo();
    }

}
