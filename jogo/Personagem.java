package jogo;

public class Personagem {
    protected int hp, ataque, defesa;
    protected String nome;

    public String getNome(String nome) {
        return nome;
    }

    public Personagem(int hp, int ataque, int defesa, String nome) {
        this.hp = hp;
        this.ataque = ataque;
        this.defesa = defesa;
        this.nome = nome;
    }

    public void status() {
        System.out.println("HP: " + hp + ", Ataque: " + ataque + ", Defesa: " + defesa);
    }

}
