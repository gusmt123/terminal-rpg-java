package jogo;

import java.util.Random;

public class Criatura extends Personagem {

    private Random random = new Random();

    public int dificuldade() {
        int dificuldade_max = 3;
        int dificuldade_min = 1;
        return random.nextInt(dificuldade_max - dificuldade_min + 1) + dificuldade_min;
    }


    public Criatura(String nome, int nivel) {
        super(nome, 10 + nivel * 2, 3 + nivel, 2 + nivel, nivel, 0);
        this.ataque +=  dificuldade();
        this.defesa += dificuldade();
        this.hp += dificuldade();
    }
}
