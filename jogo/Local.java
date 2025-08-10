package jogo;
public abstract class Local implements Posicao{
 
    protected String nome;
    protected Personagem[] personagens_local;

    public String get_Nome(){
        return nome;
    }

    public void set_Nome(String nome){
        this.nome = nome;
    }

    public Local(String nome){
        this.nome = nome;
    }

    @Override
    public void mostrar_local(){
        System.out.println("Você está no(a): " + nome);
    }

}
