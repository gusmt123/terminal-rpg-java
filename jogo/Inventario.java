package jogo;

import java.util.List;
import java.util.ArrayList;

public class Inventario {
    private List<Item> itens;

    public List<Item> getItens() {
        return itens; // ✅ corrigido: método getter para acessar a lista de itens
    }

    public Inventario() { // ✅ corrigido: método construtor com parênteses
        itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item); // ✅ adicionando objetos do tipo Item
    }

    public int contar_Item(String nome) {
        int quantidade = 0;
        for (Item item : itens) {
            if (item.getNome().equals(nome)) {
                quantidade++;
            }
        }
        return quantidade; // ✅ retornando a quantidade de itens
    }

    public void mostrarItens() {
        if (itens.isEmpty()) {
            System.out.println("O inventário está vazio");
            return;
        }

        boolean poçãoMostrada = false;

        for (Item item : itens) {
            String nome = item.getNome();

            if (nome.equalsIgnoreCase("Espada")) {
                System.out.println("- Espada!");
            } 
            else if (nome.equalsIgnoreCase("Poção") && !poçãoMostrada) {
                int quantidadePoção = contar_Item("Poção");
                System.out.println("- Poção! Quantidade: " + quantidadePoção);
                poçãoMostrada = true; // garante que só imprime uma vez
            } 
            // Caso queira mostrar outros itens também, adicione mais condições aqui
        }
    }

}
