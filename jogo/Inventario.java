package jogo;

import java.util.List;
import java.util.ArrayList;

public class Inventario {
    private List<Item> itens;

    public Inventario() { // ✅ corrigido: método construtor com parênteses
        itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item); // ✅ adicionando objetos do tipo Item
    }

    public void mostrarItens() {
        if(itens.isEmpty()){
            System.out.println("O inventário está vazio");
        }
        for (Item item : itens) {
            System.out.println("- " + item.getNome()); // ✅ usando método da classe Item
        }
    }
}
