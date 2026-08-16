import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Sala{
    private String nome;
    private String descricao;
    private Map<String, Sala> saidas; // Conecta a direção ("norte","sul", etc.) com outra Sala
    private List<Item> itensNaSala; // Alterado de Item único para Lista
    private boolean trancada = false;
    private String chaveNecessaria = "";

    //Construtor
    public Sala(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
        this.saidas = new HashMap<>();
        this.itensNaSala = new ArrayList<>();
    }
    public boolean estaTrancada(){
        return trancada;
    }
    public void trancar(String nomeChave){
        this.trancada = true;
        this.chaveNecessaria = nomeChave;
    }
    public boolean destrancarCom(String nomeChave){
        if(trancada && chaveNecessaria.equalsIgnoreCase(nomeChave)){
            this.trancada = false;
            return true;
        }
        return false;
    }
    //Define qual sala fica em qual direção
    public void definirSala(String direcao, Sala salaVizinha){
        saidas.put(direcao.toLowerCase(), salaVizinha);
    }
    public Sala pegarSaida(String direcao){
        return saidas.get(direcao.toLowerCase());
    }
    //Getters e Setters = pegar e conjunto para nome, descrição e itens
    public String pegarNome(){
        return nome;
    }
    public String pegarDescricao(){
        return descricao;
    }
    // Adiciona um item à lista da sala
    public void conjuntoItemPresente(Item item) {
        if (item != null) {
            this.itensNaSala.add(item);
        }
    }

    // Remove um item da lista da sala
    public void removerItem(Item item) {
        this.itensNaSala.remove(item);
    }

    // Retorna a lista completa de itens da sala
    public List<Item> pegarItens() {
        return itensNaSala;
    }
}
