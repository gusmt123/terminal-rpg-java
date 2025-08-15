package jogo;

public class Criatura extends Personagem {
    public Criatura(String nome, int dificuldade) {
        super(nome, 10 + dificuldade * 2, 3 + dificuldade, 2 + dificuldade, dificuldade, 0);
    }
}
