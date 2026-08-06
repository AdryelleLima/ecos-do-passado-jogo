import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GerenciadorSave {
    // Caminho direcionado para a pasta saves/
    private static final String PASTA_SAVE = "saves";
    private static final String CAMINHO_ARQUIVO = PASTA_SAVE + "/save.txt";
    
    // Salva o estado atual do jogo no arquivo saces/save.txt
    public static void salvarJogo(Jogador jogador){
        //Garante que o diterorio 'saves/' exista antes de criar o arquivo
        File diretorio = new File(PASTA_SAVE);
        if(!diretorio.exists()){
            diretorio.mkdirs();// Cria a pasta saves/ se ela não existir
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))){
            // Linha 1: Nome da Sala atual
            writer.write(jogador.pegarSalaAtual().pegarNome());
            writer.newLine();
            
            // Linha 2 em diante: Itens que o jogador possui no inventário
            // Os itens serão salvos separados por vírgula
            StringBuilder itens = new StringBuilder();
            // Acessando os itens para montar a lista
            writer.write(itens.toString());
            
            Configuracao.digitar("\n [Jogo salvo com sucesso em 'saves/save.txt'!]");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    // Verifica se existe um save salvo na pasta
    public static boolean existeSave(){
        File arquivo = new File(CAMINHO_ARQUIVO);
        return arquivo.exists() && arquivo.length() > 0;
    }

    // Carrega a sala e itens salvos
    public static String[] carregarDados(){
        if(!existeSave()) return null;

        try(BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))){
            String nomeSala = reader.readLine();
            String itensSalvos = reader.readLine();

            return new String[]{nomeSala, itensSalvos != null ? itensSalvos : ""};
        } catch (IOException e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
            return null;
        }
    }
}
