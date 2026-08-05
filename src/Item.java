public class Item{
    private String nome;
    private String descricao;
    private boolean coletavel; // true = pode pegar, false = objeto fixo do cenário

    // Construtor
    public Item(String nome, String descricao, boolean coletavel){
        this.nome = nome;
        this.descricao = descricao;
        this.coletavel = coletavel;
    }
    // Getters e Setters = pegar e conjunto
    public String pegarNome(){
        return nome;
    }
    public String pegarDescricao(){
        return descricao;
    }
    public boolean eColetavel(){
        return coletavel;
    }
}
