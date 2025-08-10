package jogo;

public class Personagem {
    protected int hp, ataque, defesa;

    public Personagem(int hp, int ataque, int defesa) {
        this.hp = hp;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public void status() {
        System.out.println("HP: " + hp + ", Ataque: " + ataque + ", Defesa: " + defesa);
    }

}
