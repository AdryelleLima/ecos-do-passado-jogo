
public class Item{
    private String nome;
    private String descricao;
    private String descricaoAposBusca;
    private boolean coletavel; // true = pode pegar, false = objeto fixo do cenário
    private Item itemEscondido; // Guarda o item escondido dentro deste item, se houver.
    private String conteudoTexto;


    private boolean trancado = false;
    private String chaveNecessaria = "";

    // Construtor
    public Item(String nome, String descricao, boolean coletavel){
        this.nome = nome;
        this.descricao = descricao;
        this.descricaoAposBusca = null;
        this.coletavel = coletavel;
        this.itemEscondido = null;
        this.conteudoTexto = null;
    }

    public boolean estaTrancado() {
        return trancado;
    }

    public void trancar(String nomeChave) {
        this.trancado = true;
        this.chaveNecessaria = nomeChave;
    }

    public boolean destrancarCom(String nomeChave) {
        if (trancado && chaveNecessaria.equalsIgnoreCase(nomeChave)) {
            this.trancado = false;
            return true;
        }
        return false;
    }
    public String pegarChaveNecessaria() {
        return chaveNecessaria;
    }
    public void ConjuntoDescricaoApoBusca(String novaDescricao){
        this.descricaoAposBusca = novaDescricao;
    }
    public String pegarDescricaoAposBusca(){
        return descricaoAposBusca;
    }
    // --- MÉTODOS PARA CONTEÚDO DE LEITURA ---
    public String pegarConteudoTexto() {
        if(!temItemEscondido() && descricaoAposBusca != null){
            return descricaoAposBusca;
        }
        return descricao;
    }
    public void conjuntoConteudoTexto(String conteudoTexto) {
        this.conteudoTexto = conteudoTexto;
    }

    public boolean eTextoLendo() {
        return conteudoTexto != null && !conteudoTexto.isEmpty();
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
