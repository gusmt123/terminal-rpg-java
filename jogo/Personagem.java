package jogo;


public class Personagem {
    public String nome;
    public int hp;
    public int ataque;
    public int defesa;
    public int xp;
    public int nivel;

    public Personagem(String nome,int hp, int ataque, int defesa, int nivel, int xp){
        this.hp = hp;
        this.ataque = ataque;
        this.defesa = defesa;
        this.nome = nome;
        this.xp = 0;
        this.nivel = 1;
    }

    public int getNivel(){
        return nivel;
    }

    public int getXp(){
        return xp;
    }

    public void status() {
        System.out.println("Nome: " + nome);
        System.out.println("HP: " + hp);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defesa: " + defesa);
        System.out.println("Nível: " + nivel);
        System.out.println("XP: " + xp);
    }

    public void ganharXp(int quantidade) {
        this.xp += quantidade;
        if (this.xp >= 100) {
            subirNivel();
        }
    }

    public void subirNivel() {
        this.nivel++;
        this.xp = 0;

        // Aumenta status a cada nível
        this.hp += 20;
        this.ataque += 5;
        this.defesa += 3;

        System.out.println(nome + " subiu para o nível " + nivel + "!");
    }
}
