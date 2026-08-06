import java.util.ArrayList;
import java.util.List;

public class Jogador{
    private String nome;
    private Sala salaAtual;
    private List <Item> inventario; // Guarda objetos da classe Item!

    // Construtor
    public Jogador(String nome, Sala salaInicial){
        this.nome = nome;
        this.salaAtual = salaInicial;
        this.inventario = new ArrayList<>();
    }

    // Método de localização
    public Sala pegarSalaAtual(){
        return salaAtual;
    }
    public void conjuntoSalaAtual(Sala novaSala){
        this.salaAtual = novaSala;
    }
    
    // Médoto do inventario
    public void adicionarItem(Item item){
        inventario.add(item);
        System.out.println("--> Item adicionado ao inventário: " + item.pegarNome());
    }
    public boolean removeItem(Item item){
        return inventario.remove(item);
    }
     // Busca um item no inventário pelo nome digitado
    public Item buscarItemNoInventario(String nomeItem){
        for(Item item : inventario){
            if(item.pegarNome().equalsIgnoreCase(nomeItem)){
                return item;
            }
        }
        return null; // retorna null se o item não estiver no inventário
    }
    
    // verifica se o jogador possui determinado item pelo nome
    public boolean possuiItem(String nomeItem){
        return buscarItemNoInventario(nomeItem) != null;
    }

    public void exibirInventario(){
        System.out.println("\n--- MOCHILA ---");
        if(inventario.isEmpty()){
            System.out.println("Sua mochila está vazia. ");
        }else{
            for(Item item : inventario){
                System.out.println("- " + item.pegarNome() + ": " + item.pegarDescricao());
            }
        }
    }
    public String pegarNome(){
        return nome;
    }
    // Método necessário para o GerenciadorSave ler os itens da mochila
    public List<Item> pegarInventario() {
        return inventario;
    }
}
