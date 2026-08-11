public class Item{
    private String nome;
    private String descricao;
    private boolean coletavel; // true = pode pegar, false = objeto fixo do cenário
    private Item itemEscondido; // Guarda o item escondido dentro deste item, se houver.
    // Construtor
    public Item(String nome, String descricao, boolean coletavel){
        this.nome = nome;
        this.descricao = descricao;
        this.coletavel = coletavel;
        this.itemEscondido = null;
    }
    // Metodos para gerenciar itens escondidos
    public Item pegarItemEscondido(){
        return itemEscondido;
    }
    public void esconderItem(Item item){
        this.itemEscondido = item;
    }
    public boolean temItemEscondido(){
        return itemEscondido != null;
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
