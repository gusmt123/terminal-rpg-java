package jogo;

import java.util.Scanner;
import java.util.Random;

public class Combate {
    private Inventario inventario;
    private Personagem jogador, adversario;
    private Random random = new Random();

    public Combate(Inventario inventario, Personagem jogador, Personagem adversario) {
        this.inventario = inventario;
        this.jogador = jogador;
        this.adversario = adversario;
    }   

 
    public int danoAtaque(int ataque) {
        return random.nextInt(ataque) + 1; // Dano aleatório entre 1 e ataque
    }

    public void menu_Combate(){

        boolean continuar_combate = true;

        while(continuar_combate){

        System.out.println("Você está em combate com " + adversario.nome);
        System.out.println("HP do " + adversario.nome + ": " + adversario.hp);
        System.out.println("HP do " + jogador.nome + ": " + jogador.hp);
        System.out.println("Selecione uma ação:");
        System.out.println("1. Atacar");
        System.out.println("2. Usar item");
        System.out.println("3. Mostrar seus status");
        System.out.println("4. Mostrar status do seu adversário");
        System.out.println("5. Fugir");

        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();

        switch (opcao) {
            case "1":
                int dano = danoAtaque(jogador.ataque);
                adversario.hp -= (dano / Math.floor((jogador.defesa / 2)));
                if(verificarVitoria()) {
                    continuar_combate = false;
                    jogador.ganharXp(10 * adversario.nivel);
                    break;
                }
                jogador.hp -= adversario.ataque;
                if(verificarVitoria()) {
                    continuar_combate = false;
                    Menu_Derrota menu_derrota = new Menu_Derrota();
                    menu_derrota.exibir_Menu_Derrota();
                    break;
                }
                System.out.println("Você atacou o " + adversario.nome + " e causou " + dano + " de dano.");
                break;
            case "2":
                usarItem();
                verificarVitoria();
                jogador.hp -= adversario.ataque;
                if(verificarVitoria()) {
                    continuar_combate = false;
                    Menu_Derrota menu_derrota = new Menu_Derrota();
                    menu_derrota.exibir_Menu_Derrota();
                    break;
                }
                break;
            case "3":
                jogador.status();
                break;
            case "4":
                adversario.status();
                break;    
            case "5":
                System.out.println("Você fugiu do combate!");
                continuar_combate = false;
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                menu_Combate();
        }
    }
    }

    public void usarItem() {
        inventario.mostrarItens();
        System.out.println("Digite o nome do item que deseja usar:");
        Scanner scanner = new Scanner(System.in);
        String nomeItem = scanner.nextLine();

        if (nomeItem.equals("Pocao")) {
                System.out.println("Você usou uma poção e recuperou 10 de HP!");
                jogador.hp += 10;
                if(jogador.hp > 100) {
                    jogador.hp = 100; // Limita o HP máximo a 100
                }
                inventario.getItens().removeIf(item -> item.getNome().equalsIgnoreCase("Pocao"));
            }else if(nomeItem.equals("Pocao de ataque")) {
                System.out.println("Você usou uma poção de ataque e aumentou seu ataque em 2!");
                jogador.ataque += 2; // Aumenta o ataque do jogador
                inventario.getItens().removeIf(item -> item.getNome().equalsIgnoreCase("Poção de ataque"));
            } else if(nomeItem.equals("Escudo")) {
                System.out.println("Você usou o escudo ele aumentou sua defesa!");
                jogador.defesa += 2; // Aumenta a defesa do jogador
                inventario.getItens().removeIf(item -> item.getNome().equalsIgnoreCase("Escudo"));
            }
            
            else if(nomeItem.equals("Espada")) {
                System.out.println("Você empunhou a espada!");
                adversario.hp -= 2 * jogador.ataque; // Aumenta o ataque do jogador
                System.out.println("O " + adversario.nome + " está com " + adversario.hp + " de HP.");    
                verificarVitoria();
            }
            return;
        }
    public boolean verificarVitoria() {
        if (adversario.hp <= 0) {
            System.out.println("Você derrotou o " + adversario.nome + "!");
            return true;
        } else if (jogador.hp <= 0) {
            System.out.println("Você foi derrotado pelo " + adversario.nome + "...");
            return true;
        }
        return false;
    }
}   


