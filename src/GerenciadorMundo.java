import java.util.HashMap;
import java.util.Map;

public class GerenciadorMundo {
    private Map<String, Sala> mapaSalas = new HashMap<>();
    private Map<String, Item> mapaItens = new HashMap<>();

    // Método auxiliar para registrar vários sinônimos de uma só vez
    private void conectar(Sala origem, Sala destino, String... sinonimos) {
        for (String s : sinonimos) {
            origem.definirSala(s, destino);
        }
    }

    // Método auxiliar para associar um Item a múltiplos nomes/sinônimos no mapa
    private void registrarItem(Item item, String... sinonimos) {
        for (String s : sinonimos) {
            mapaItens.put(s.toLowerCase(), item);
        }
    }

    public void inicializarMundo() {
        // Criando Salas -- Falta Descrição
        Sala sacada = new Sala("Sacada",
                "");
        Sala salaEstar = new Sala("Sala de Estar",
                "\"Aponto a lanterna para o centro do cômodo, à minha esquerda vejo\n" +
                        " um sofá de tecido surrado e tomado pelo mofo. À frente do sofá há\n" +
                        "uma lareira de pedra coberta de cinzas frias. Atrás de mim, junto à \n" +
                        "parede da entrada, noto um gaveteiro de madeira. Vejo uma porta à minha\n" +
                        "frente ao julgo ser da cozinha, enquanto a direita vejo a sala de jantar.\"");
        Sala cozinha = new Sala("Cozinha",
                "\"Olhando para frente, vejo a ilha da cozinha dividindo o espaço.\n" +
                        "Ao fundo mais a frente, ilumino uma geladeira antiga cheia de ímãs\n" +
                        "desgastados, um armário de madeira com pia e um fogão com panelas \n" +
                        "esquecidas sobre os queimadores. À minha esqueda vejo uma cristaleira\n" +
                        "de vidro e, à direita, uma estante pequena. A única sáida que enxergo\n" +
                        "é voltando ao sul para a sala de estar\"");
        Sala banheiro = new Sala("Banheiro",
                "\"\n" +
                        "\n" +
                        "\n" +
                        " \"");
        Sala salaJantar = new Sala("Sala de Jantar",
                "\"\n" +
                        "\n" +
                        "\n" +
                        " \"");

        Sala porao = new Sala("Porão",
                "\"\n" +
                        "\n" +
                        "\n" +
                        " \"");

        Sala hall = new Sala("hall",
                "\"\n" +
                        "\n" +
                        "\n" +
                        " \"");
        Sala quartoMorador = new Sala("Quarto Morador",
                "\"\n" +
                        "\n" +
                        "\n" +
                        " \"");
        Sala quarto = new Sala("Quarto",
                "\"\n" +
                        "\n" +
                        "\n" +
                        " \"");
        Sala escritorio = new Sala("Escritorio",
                "\"\n" +
                        "\n" +
                        "\n" +
                        " \"");
        Sala salaSecreta = new Sala("Sala Secreta",
                "\"\n" +
                        "\n" +
                        "\n" +
                        " \"");

        // Conexões simplificadas com o método conectar()
        conectar(sacada, salaEstar, "norte", "frente", "sala", "sala de estar", "estar");

        conectar(salaEstar, sacada, "sul", "saida");
        conectar(salaEstar, cozinha, "norte", "cozinha");
        conectar(salaEstar, salaJantar, "leste", "sala de jantar", "jantar");
        conectar(salaEstar, banheiro, "nordeste", "banheiro");

        conectar(salaJantar, banheiro, "norte", "banheiro");
        conectar(salaJantar, hall, "subir", "subir escada");
        conectar(salaJantar, porao, "descer", "descer escada");
        conectar(salaJantar, salaEstar, "oeste", "sala", "sala de estar");

        conectar(cozinha, salaEstar, "sul", "sala de estar", "sala");
        conectar(banheiro, salaJantar, "sul", "sala de jantar", "jantar");
        conectar(porao, salaJantar, "subir", "subir escada");

        conectar(hall, quartoMorador, "leste", "quarto do morador", "quarto morador", "quarto grande");
        conectar(hall, quarto, "nordeste", "quarto", "quarto pequeno");
        conectar(hall, escritorio, "norte", "escritorio");
        conectar(hall, salaJantar, "descer escada", "descer");

        conectar(quartoMorador, hall, "sul", "hall", "corredor");
        conectar(quarto, hall, "sul", "corredor", "hall");
        conectar(escritorio, hall, "sul", "corredor", "hall");
        conectar(escritorio, salaSecreta, "leste", "sala secreta", "secreta");
        conectar(salaSecreta, escritorio, "sul", "corredor", "hall");

        // Guardando salas no mapa do jogo
        mapaSalas.put("Sacada", sacada);

        mapaSalas.put("Sala de Estar", salaEstar);
        mapaSalas.put("Sala de Jantar", salaJantar);
        mapaSalas.put("Cozinha", cozinha);
        mapaSalas.put("Banheiro", banheiro);

        mapaSalas.put("Porão", porao);

        mapaSalas.put("Hall", hall);
        mapaSalas.put("Quarto do Morador", quartoMorador);
        mapaSalas.put("Quarto", quarto);
        mapaSalas.put("Escritorio", escritorio);
        mapaSalas.put("Sala Secreta", salaSecreta);

        // Criando Itens --- criar e adicionar mais itens

        // Itens coletaveis
        Item chaveSaida = new Item("Chave da Porta Principal", "Uma chave de quatro pontas antiga, parece complexa.",
                true);
        Item chavePorao = new Item("Chave do Porão", "Uma chave antiga e enferrujada.", true);
        Item chaveQuarto = new Item("Chave do Quarto", "Uma chave dourada pequena.", true);
        Item chaveQuartoMorador = new Item("Chave do Quarto do Morador", "Uma chave pequena e desgastada.", true);
        Item chaveEscritorio = new Item("Chave do Escritorio", "Uma chave ornamentada bonita, porém tá enferrujada",
                true);
        Item chaveGuardaRoupa = new Item("Chave do Guarda-Roupa",
                "Uma chave simples, por incrivel que pareça esta em boas condições", true);
        Item galaoGasolina = new Item("Galão de Gasolina", "Contém combustível suficiente para o gerador.", true);
        Item pilhas = new Item("Pilhas", "Duas pilhas grandes de 1,5V ainda lacradas.", true);
        Item gravadorAudio = new Item("Gravador de Áudio", "Um gravador cassete portátil de 1984.", true);
        Item fita1 = new Item("Fita Cassete #01", "Uma fita gasta rotulada 'porque?'.", true);
        Item fita2 = new Item("Fita Cassete #02", "Uma fita preta rotulada 'acusações'.", true);
        Item fita3 = new Item("Fita Cassete #03", "Uma fita com a etiqueta 'pistas'.", true);
        Item fita4 = new Item("Fita Cassete #04", "Uma fita com a etiqueta 'decisão'.", true);

        // Registrando coletáveis no mapaItens
        registrarItem(chaveSaida, "chave da porta principal", "chave da porta", "chave principal");
        registrarItem(chavePorao, "chave do porão", "chave do porao");
        registrarItem(chaveQuarto, "chave do quarto");
        registrarItem(chaveQuartoMorador, "chave do quarto do morador");
        registrarItem(chaveEscritorio, "chave do escritorio", "chave do escritório");
        registrarItem(chaveGuardaRoupa, "chave do guarda-roupa", "chave do guarda roupa");
        registrarItem(galaoGasolina, "galão de gasolina", "galao de gasolina", "gasolina", "galao");
        registrarItem(pilhas, "pilhas", "pilha");
        registrarItem(gravadorAudio, "gravador de áudio", "gravador de audio", "gravador");
        registrarItem(fita1, "fita cassete #01", "fita 1", "fita cassete 1");
        registrarItem(fita2, "fita cassete #02", "fita 2", "fita cassete 2");
        registrarItem(fita3, "fita cassete #03", "fita 3", "fita cassete 3");
        registrarItem(fita4, "fita cassete #04", "fita 4", "fita cassete 4");
        

        // Itens fixos (não coletáveis)

        // itens da cozinha -- Falta descricao====================================
        
        Item armarioCozinha = new Item("Armário da Cozinha",
                "Um armário antigo de madeira com portas de vidro opaco. Com uma pia em cima dele.", false);
        Item geladeira = new Item("Geladeira",
                "Uma geladeira de aparência retro, bem desgastada com varios imãs espalhados na porta.", false);
        Item fogao = new Item("Fogão", "Fogão velho, ainda com panelas em cima.", false);
        Item ilhaCozinha = new Item("Ilha da cozinha",
                "Ilha de madeira, tem alguns banquinhos acabados cheio de teias.", false);
        Item cristaleira = new Item("Cristaleira", "Um armário com portas de vidro espondo varios copos e pratos.",
                false);
        Item estanteCozinha = new Item("Estante da Cozinha", "", false);

        registrarItem(armarioCozinha, "armário da cozinha", "armario da cozinha", "armario");
        registrarItem(geladeira, "geladeira");
        registrarItem(fogao, "fogão", "fogao");
        registrarItem(ilhaCozinha, "ilha da cozinha", "ilha");
        registrarItem(cristaleira, "cristaleira");
        registrarItem(estanteCozinha, "estante da cozinha","estante");

        // itens da sala de estar===================================================
        
        Item gaveteiro = new Item("Gaveteiro", "Um gaveteiro de madeira com gavetas emperradas.", false);
        Item sofa = new Item("Sofá", "Sofa de tecido, bastante acabado, não dá nem para sentar, seria desconfortavel.",
                false);
        Item lareira = new Item("Lareira", "Lareira de predra, apenas com cinzas.", false);

        registrarItem(sofa, "sofá", "sofa");
        registrarItem(gaveteiro, "gaveteiro");
        registrarItem(lareira, "lareira");

        // itens do porão=============================================================
        
        Item gerador = new Item("Gerador", "Um gerador antigo, coberto de poeira e ferrugem.", false);
        Item prateleiraNorte = new Item("Prateleira Norte",
                "Prateleira esta com alguns mantimentos consumiveis, mas no momento nada parece comestivel.", false);
        Item prateleiraCentro = new Item("Prateleira Centro",
                "Prateleira esta com algumas caixa que contem decorações festivas.", false);
        Item prateleiraSul = new Item("Prateleira Sul", "Prateleira esta cheia com coisas de manuteção e conserto.",
                false);
        Item interrutorEnergia = new Item("Interruptor Energia",
                "Painel de energia coberto de poeira e teias de aranha.", false);

        registrarItem(gerador, "gerador");
        registrarItem(prateleiraNorte, "prateleira norte");
        registrarItem(prateleiraCentro, "prateleira centro");
        registrarItem(prateleiraSul, "prateleira sul");
        registrarItem(interrutorEnergia, "interruptor energia", "interruptor", "painel de energia");

        // itens banheiro==============================================================

        Item vasoSanitario = new Item("Vaso Sanitario", "Não estou com vontade de usar.", false);
        Item piaBanheiro = new Item("Armario com Pia",
                "Uma pia com armario em baixo, contendo alguns itens de limpeza e higiene vencidos.", false);
        Item boxChuveiro = new Item("Chuveiro", "Cortinas de plastico tentam esconder a parte do chuveiro.", false);
        Item espelho = new Item("Espelho",
                "O espelho em cima da pia esta bastante estilhaçado, mal da para me ver no espelho.", false);

        registrarItem(vasoSanitario, "vaso sanitario", "vaso sanitário", "vaso", "sanitario");
        registrarItem(piaBanheiro, "armario com pia", "armário com pia", "pia", "armario banheiro");
        registrarItem(boxChuveiro, "chuveiro", "box");
        registrarItem(espelho, "espelho");

        // itens sala de jantar -- falta descrição====================================

        Item mesaJantar = new Item("Mesa de Jantar", "Mesa de jantar de madeira com quatro cadeiras de madeira.",
                false);
        Item estante = new Item("Estante", "", false);

        registrarItem(mesaJantar,"mesa de jantar", "mesa");
        registrarItem(estante, "estante");

        // itens quarto do morador -- falta descrição=================================

        Item camaCasal = new Item("Cama de Casal", "", false);
        Item mesaCabeceiraEsquerda = new Item("Mesa Cabeceira Esquerda", "", false);
        Item mesaCabeceiraDireita = new Item("Mesa Cabeceira Direita", "", false);
        Item guardaRoupaGrande = new Item("Guarda-Roupa Grande", "", false);
        Item esqueleto = new Item("Esqueleto Humano", "Nossa... o que realmente aconteceu? de quem é esse esqueleto?",
                false);

        registrarItem(camaCasal, "cama de casal", "cama casal", "cama");
        registrarItem(mesaCabeceiraEsquerda, "mesa cabeceira esquerda", "cabeceira esquerda");
        registrarItem(mesaCabeceiraDireita, "mesa cabeceira direita", "cabeceira direita");
        registrarItem(guardaRoupaGrande, "guarda-roupa grande", "guarda roupa grande", "guarda roupa", "guarda-roupa");
        registrarItem(esqueleto, "esqueleto humano", "esqueleto");

        // itens do escritorio -- FALTA DESCRICAO========================================

        Item estanteLivros = new Item("Estante de Livros", "", false);
        Item estanteFalsa = new Item("Estante Pequena", "", false);
        Item escrivaninha = new Item("Escrivaninha", "", false);

        registrarItem(estanteLivros, "estante de livros grande", "estante livros");
        registrarItem(estanteFalsa, "estante pequena", "estante falsa");
        registrarItem(escrivaninha, "escrivaninha", "mesa de trabalho");

        // itens quarto de visita========================================================

        Item camaSolteiro = new Item("Cama de Solteiro", "", false);
        Item caixasPapelao = new Item("Caixas de Papelão", "", false);
        Item guardaRoupaPequeno = new Item("Guarda-Roupa Pequeno", "", false);
        Item mesaCabeceira = new Item("Mesa Cabeceira", "", false);

        registrarItem(camaSolteiro, "cama de solteiro", "cama solteiro");
        registrarItem(caixasPapelao, "caixas de papelão", "caixas de papelao", "caixas", "papelao");
        registrarItem(guardaRoupaPequeno, "guarda-roupa pequeno", "guarda roupa pequeno");
        registrarItem(mesaCabeceira, "mesa cabeceira", "cabeceira");

        // itens sala secreta===========================================================

        Item mesaInvestigativa = new Item("Mesa Investigava", "", false);
        Item quadroDetetive = new Item("Quadro de investigação", "", false);

        registrarItem(mesaInvestigativa, "mesa investigativa", "mesa de investigacao","mesa");
        registrarItem(quadroDetetive, "quadro de investigação", "quadro de investigaçao", "quadro de investigacao", "quadro");

        // Escondento itens dentro de outros============================================

        armarioCozinha.esconderItem(chaveQuarto);
        guardaRoupaGrande.esconderItem(esqueleto);
        esqueleto.esconderItem(fita4);
        mesaCabeceiraEsquerda.esconderItem(chavePorao);
        camaCasal.esconderItem(fita3);
        camaSolteiro.esconderItem(fita2);
        mesaCabeceira.esconderItem(chaveQuartoMorador);
        mesaInvestigativa.esconderItem(chaveGuardaRoupa);
        mesaJantar.esconderItem(fita1);
        gaveteiro.esconderItem(chaveSaida);
        piaBanheiro.esconderItem(pilhas);
        prateleiraSul.esconderItem(chaveEscritorio);
        escrivaninha.esconderItem(gravadorAudio);

        // Colocando itens nas Salas
        
        cozinha.conjuntoItemPresente(armarioCozinha);
        cozinha.conjuntoItemPresente(geladeira);
        cozinha.conjuntoItemPresente(fogao);
        cozinha.conjuntoItemPresente(ilhaCozinha);
        cozinha.conjuntoItemPresente(cristaleira);
        cozinha.conjuntoItemPresente(estanteCozinha);

        salaEstar.conjuntoItemPresente(gaveteiro);
        salaEstar.conjuntoItemPresente(sofa);
        salaEstar.conjuntoItemPresente(lareira);

        porao.conjuntoItemPresente(gerador);
        porao.conjuntoItemPresente(interrutorEnergia);
        porao.conjuntoItemPresente(prateleiraSul);
        porao.conjuntoItemPresente(prateleiraCentro);
        porao.conjuntoItemPresente(prateleiraNorte);

        banheiro.conjuntoItemPresente(espelho);
        banheiro.conjuntoItemPresente(piaBanheiro);
        banheiro.conjuntoItemPresente(vasoSanitario);
        banheiro.conjuntoItemPresente(boxChuveiro);

        salaJantar.conjuntoItemPresente(mesaJantar);
        salaJantar.conjuntoItemPresente(estante);

        quartoMorador.conjuntoItemPresente(guardaRoupaGrande);
        quartoMorador.conjuntoItemPresente(camaCasal);
        quartoMorador.conjuntoItemPresente(mesaCabeceiraDireita);
        quartoMorador.conjuntoItemPresente(mesaCabeceiraEsquerda);
        quartoMorador.conjuntoItemPresente(galaoGasolina);

        escritorio.conjuntoItemPresente(estanteLivros);
        escritorio.conjuntoItemPresente(estanteFalsa);
        escritorio.conjuntoItemPresente(escrivaninha);

        quarto.conjuntoItemPresente(camaSolteiro);
        quarto.conjuntoItemPresente(caixasPapelao);
        quarto.conjuntoItemPresente(guardaRoupaPequeno);
        quarto.conjuntoItemPresente(mesaCabeceira);

        salaSecreta.conjuntoItemPresente(quadroDetetive);
        salaSecreta.conjuntoItemPresente(mesaInvestigativa);

        porao.trancar("Chave do Porão");
        quarto.trancar("Chave do Quarto");
        quartoMorador.trancar("Chave do Quarto do Morador");
        escritorio.trancar("Chave do Escritorio");
        guardaRoupaGrande.trancar("Chave do Guarda-Roupa");
        sacada.trancar("Chave da Porta Principal");
        salaSecreta.trancar("Mecanismo Elétrico");
        /*
         * Definindo o texto legível do bilhete
         * anotacaoGerador.conjuntoConteudoTexto(
         * "\"O gerador no porão está falhando. Para reativar o circuito da estante,\n"
         * +
         * "é necessário colocar combustível e acionar o interrupter principal.\"");
         */

    }

    public Map<String, Sala> getMapaSalas() {
        return mapaSalas;
    }

    public Map<String, Item> getMapaItens() {
        return mapaItens;
    }

    public Sala getSalaInicial() {
        return mapaSalas.get("Sacada"); // Retorna a sala onde o jogo começa
    }
}
