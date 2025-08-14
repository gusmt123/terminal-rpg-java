package jogo;

import java.util.List;
import java.util.ArrayList;

public class Inventario {
    private List<Item> itens;

    public List<Item> getItens() {
        return itens;
    }

    public Inventario() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public int contar_Item(String nome) {
        int quantidade = 0;
        for (Item item : itens) {
            if (item.getNome().equals(nome)) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public void mostrarItens() {
        if (itens.isEmpty()) {
            System.out.println("O inventário está vazio");
            return;
        }

        // Categorias configuráveis: escalável e fácil de modificar
        List<String> itensEmpilhaveis = List.of("Poção","Poção de ataque");
        List<String> itensUnicos = List.of("Espada", "Escudo");

        List<String> exibidos = new ArrayList<>();

        // Mostrar itens empilháveis com quantidade
        for (String nome : itensEmpilhaveis) {
            int quantidade = contar_Item(nome);
            if (quantidade > 0) {
                System.out.println(quantidade + " x " + nome);
                exibidos.add(nome);
            }
        }

        // Mostrar itens únicos apenas uma vez
        for (String nome : itensUnicos) {
            if (contar_Item(nome) > 0 && !exibidos.contains(nome)) {
                System.out.println(nome);
                exibidos.add(nome);
            }
        }

        // Mostrar qualquer item não listado nas categorias anteriores
        for (Item item : itens) {
            String nome = item.getNome();
            if (!exibidos.contains(nome)) {
                System.out.println(nome);
                exibidos.add(nome);
            }
        }
    }
}
