import java.util.HashMap;
import java.util.Map;

public class Sala{
    private String nome;
    private String descricao;
    private Map<String, Sala> saidas; // Conecta a direção ("norte","sul", etc.) com outra Sala
    private String itemPresente; // Nome do item/documento que está na sala

    //Construtor
    public Sala(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
        this.saidas = new HashMap<>();
        this.itemPresente = null;
    }


    //Define qual sala fica em qual direção
    public void definirSala(String direcao, Sala salaVizinha){
        saidas.put(direção.toLowerCase(), salaVizinha);
    }
    public Sala pegarSaida(String direcao){
        return saidas.get(direcao.toLowerCase());
    }
    //Getters e Setters para nome, descrição e itens
    public String pegarNome(){
        return nome;
    }
    public String pegarDescricao(){
        return descricao;
    }
    public String pegarItemPresente(){
        return itemPresente;
    }
    public String conjuntoItemPresente(String itemPresente){
        this.itemPresente = itemPresente;
    }
}
