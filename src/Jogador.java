import java.util.ArrayList;
import java.util.List;

public class Jogador{
    private String nomeJ;
    private Sala salaAtual;
    private List <String> inventario;

    // Construtor
    public Jogador(String nomeJ, Sala salaIncial){
        this.nomeJ = nomeJ;
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
    public void adicionarItem(String item){
        inventario.add(item);
        System.out.println("--> Item adicionado ao inventário: " + item);
    }
    public boolean removeItem(String item){
        return inventario.remove(item);
    }
    public boolean possuiItem(String item){
        return inventario.contains(item);
    }

    public void exibirInventario(){
        System.out.println("\n--- MOCHILA ---");
        if(inventario.isEmpty()){
            System.out.println("Sua mochila está vazia. ");
        }else{
            for(String item : inventario){
                System.out.println("- " + item);
            }
        }
    }
    public String pegarNomeJ(){
        return nomeJ;
    }
}
