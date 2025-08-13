package jogo;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class Gerenciador_Salvar {

    private static final String caminho_save = "jogo_salvo.txt";

    // Salvar dados do jogador, inventário e posição
    public void salvar_jogo(Personagem jogador, Inventario inventario, String localAtual) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho_save))) {
            // Jogador
            writer.write(jogador.nome);
            writer.newLine();
            writer.write(jogador.hp + "");
            writer.newLine();
            writer.write(jogador.ataque + "");
            writer.newLine();
            writer.write(jogador.defesa + "");
            writer.newLine();

            // Local atual
            writer.write(localAtual);
            writer.newLine();

            // Inventário (um item por linha)
            for (Item item : inventario.getItens()) {
                writer.write("ITEM:" + item.getNome());
                writer.newLine();
            }

            System.out.println("Jogo salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    // Retorna os dados carregados em um objeto de jogo
    public JogoSalvo carregar_Jogo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho_save))) {
            String nome = reader.readLine();
            int hp = Integer.parseInt(reader.readLine());
            int ataque = Integer.parseInt(reader.readLine());
            int defesa = Integer.parseInt(reader.readLine());

            String local = reader.readLine();

            Personagem jogador = new Personagem(hp, ataque, defesa, nome);
            Inventario inventario = new Inventario();

            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("ITEM:")) {
                    String nomeItem = linha.substring(5);
                    inventario.adicionarItem(new Item(nomeItem));
                }
            }

            return new JogoSalvo(jogador, inventario, local);

        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
            return null;
        }
    }

    // Classe auxiliar para agrupar os dados do jogo carregado
    public static class JogoSalvo {
        public Personagem jogador;
        public Inventario inventario;
        public String localAtual;

        public JogoSalvo(Personagem jogador, Inventario inventario, String localAtual) {
            this.jogador = jogador;
            this.inventario = inventario;
            this.localAtual = localAtual;
        }
    }
}
