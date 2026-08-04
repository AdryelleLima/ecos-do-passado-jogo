public class Comando{
    private String acao;
    private String alvo;

    public Comando(String acao, String alvo){
        this.acao = acao;
        this.alvo = alvo;
    }
    public String pegarAcao() { return acao; }
    public String pegarAlvo() { return alvo; }
    public boolean temAcao() { return acao != null && !acao.isEmpty(); }
}