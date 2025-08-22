package jogo;

public class Jogador extends Personagem {

    private int dinheiro;


    public Jogador(String nome, int hp, int ataque, int defesa, int nivel, int experiencia) {
        super(nome, hp, ataque, defesa, nivel, experiencia);
        this.dinheiro = 0;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void ganharDinheiro(int quantidade) {
        this.dinheiro += quantidade;
    }


    
}
