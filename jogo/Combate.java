package jogo;
public class Combate {
    private Inventario inventario;
    private Personagem jogador, adversario;

    public Combate(Inventario inventario, Personagem jogador, Personagem adversario) {
        this.inventario = inventario;
        this.jogador = jogador;
        this.adversario = adversario;
    }   

    public void usaItem(Item item) {
        inventario.mostrarItens();
        int num_item = 1;
        for (Item i : inventario.getItens()) {
            if (i.getNome().equals(item.getNome())) {
                if(i.getNome().equals("poção")){
                    System.out.println("Você usou uma poção e recuperou 10 de HP!");
                    jogador.hp += 10;
                    if(jogador.hp > 100) {
                        jogador.hp = 100; // Limita o HP máximo a 100
                    }
                } else if(i.getNome().equals("espada")) {
                    System.out.println("Você empunhou a espada!");
                    adversario.hp -= 2 * jogador.ataque; // Aumenta o ataque do jogador
                    System.out.println("O " + adversario.nome + " está com" + adversario.hp + " de HP.");    
                }
                return;
            }
            num_item++;
        }

    }   

}
