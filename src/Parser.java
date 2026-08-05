import java.util.Arrays;
import java.util.List;

public class Parser {
    //Listar/Arrays de Palavras-Chave
    private static final List<String> VERBOS_MOVER = Arrays.asList("ir","caminhar", "andar", "mover", "entrar");
    private static final List<String> VERBOS_EXAMINAR = Arrays.asList("olhar","ver","examinar","observar", "ler", "checar");
    private static final List<String> VERBOS_PEGAR = Arrays.asList("pegar","coletar","guardar","agarrar");
    private static final List<String> VERBOS_SAIR = Arrays.asList("sair","desistir","fechar");

    public static Comando analisar(String entrada){
        if(entrada == null || entrada.trim().isEmpty()){
            return new Comando("", "");
        }
        String[] palavras = entrada.toLowerCase().trim().split("\\s+");
        String acaoIdentificada = "";
        String alvoIdentificado = "";

        for(String palavra: palavras){
            //checar contra as listas de verbos
            if (VERBOS_MOVER.contains(palavra)){
                acaoIdentificada = "MOVER";
            }else if(VERBOS_EXAMINAR.contains(palavra)){
                acaoIdentificada = "EXAMINAR";
            }else if(VERBOS_PEGAR.contains(palavra)){
                acaoIdentificada = "PEGAR";
            }else if(VERBOS_SAIR.contains(palavra)){
                acaoIdentificada = "SAIR";
            }
            //se não for um verbo conhecido, consderamos como potencial alvo(ex:"norte", "lareira")
            else if (palavra.length() > 2){
                alvoIdentificado = palavra;
            }
        }
        return new Comando(acaoIdentificada, alvoIdentificado);
    }
}
