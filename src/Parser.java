import java.util.Arrays;
import java.util.List;

public class Parser {
    //Listar/Arrays de Palavras-Chave
    private static final List<String> VERBOS_MOVER = Arrays.asList("ir", "caminhar", "andar", "mover", "entrar", "subir", "descer", "suba", "desça");
    private static final List<String> VERBOS_EXAMINAR = Arrays.asList("olhar","ver","examinar","observar", "ler", "checar");
    private static final List<String> VERBOS_PEGAR = Arrays.asList("pegar","coletar","guardar","agarrar");
    private static final List<String> VERBOS_USAR = Arrays.asList("usar", "colocar", "inserir", "abrir", "destrancar", "ligar","utilizar");
    private static final List<String> VERBOS_SAIR = Arrays.asList("sair","desistir","fechar");

    public static Comando analisar(String entrada){
        if(entrada == null || entrada.trim().isEmpty()){
            return new Comando("", "");
        }
        String[] palavras = entrada.toLowerCase().trim().split("\\s+");
        String acaoIdentificada = "";
        StringBuilder alvoBuilder = new StringBuilder();

        for (String palavra : palavras) {
            if (VERBOS_MOVER.contains(palavra)) {
                acaoIdentificada = "MOVER";
                if (palavra.equals("subir") || palavra.equals("suba")) {
                    if (alvoBuilder.length() == 0) alvoBuilder.append("subir");
                } else if (palavra.equals("descer") || palavra.equals("desça")) {
                    if (alvoBuilder.length() == 0) alvoBuilder.append("descer");
                }
            } else if (VERBOS_EXAMINAR.contains(palavra)) {
                acaoIdentificada = "EXAMINAR";
            } else if (VERBOS_PEGAR.contains(palavra)) {
                acaoIdentificada = "PEGAR";
            } else if (VERBOS_USAR.contains(palavra)) {
                acaoIdentificada = "USAR";
            } else if (VERBOS_SAIR.contains(palavra)) {
                acaoIdentificada = "SAIR";
            } else if (palavra.length() >= 2 && !palavra.equals("da") && !palavra.equals("de") && !palavra.equals("do")) {
                if (alvoBuilder.length() > 0) {
                    alvoBuilder.append(" ");
                }
                alvoBuilder.append(palavra);
            }
        }
        return new Comando(acaoIdentificada, alvoBuilder.toString());
    }
}
