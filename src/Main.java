import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Sala> mapaSalas = new HashMap<>();
    private static Map<String, Item> mapaItens = new HashMap<>();

    public static void main(String[] args) {
        inicializarMundo(); // Cria as salas e itens do jogo
        boolean noMenu = true;

        while (noMenu) {
            Configuracao.limparTela(); // Limpa a tela antes de exibir o menu
            exibirMenuPrincipal();
            System.out.print("Escolha uma opção > ");
            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    continuarJogo();
                    break;
                case "2":
                    iniciarNovoJogo();
                    break;
                case "3":
                    Configuracao.menuConfiguracoes(scanner);
                    break;
                case "4":
                    exibirSobre();
                    break;
                case "5":
                    System.out.println("\nSaindo do jogo... Até a próxima!");
                    noMenu = false;
                    break;
                default:
                    System.out.println("\nOpção inválida! Digite 1, 2, 3, 4 ou 5.");
            }
        }
        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n==================================================");
        System.out.println("    ECOS DO PASSADO: O SEGREDO DA CASA ABANDONADA   ");
        System.out.println("==================================================");
        System.out.println("1. Continuar Jogo");
        System.out.println("2. Iniciar Novo Jogo");
        System.out.println("3. Configuração");
        System.out.println("4. Sobre");
        System.out.println("5. Sair");
        System.out.println("==================================================");
    }

    private static void inicializarMundo() {

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
        Sala quartoInfantil = new Sala("Quarto Infantil",
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

        // Conexões
        sacada.definirSala("norte", salaEstar);

        salaEstar.definirSala("sul", sacada);
        salaEstar.definirSala("saida", sacada);
        salaEstar.definirSala("norte", cozinha);
        salaEstar.definirSala("cozinha", cozinha);
        salaEstar.definirSala("leste", salaJantar);
        salaEstar.definirSala("sala de jantar", salaJantar);
        salaEstar.definirSala("jantar", salaJantar);
        salaEstar.definirSala("nordeste", banheiro);
        salaEstar.definirSala("banheiro", banheiro);

        salaJantar.definirSala("norte", banheiro);
        salaJantar.definirSala("banheiro", banheiro);
        salaJantar.definirSala("subir", hall);
        salaJantar.definirSala("subir escada", hall);
        salaJantar.definirSala("descer", porao);
        salaJantar.definirSala("descer escada", porao);
        salaJantar.definirSala("oeste", salaEstar);
        salaJantar.definirSala("sala", salaEstar);
        salaJantar.definirSala("sala de estar", salaEstar);

        cozinha.definirSala("sul", salaEstar);
        cozinha.definirSala("sala de estar", salaEstar);
        cozinha.definirSala("sala", salaEstar);
        banheiro.definirSala("sul", salaJantar);
        banheiro.definirSala("sala de jantar", salaJantar);
        banheiro.definirSala("jantar", salaJantar);
        porao.definirSala("subir", salaJantar);
        porao.definirSala("subir escada", salaJantar);

        hall.definirSala("leste", quartoMorador);
        hall.definirSala("quarto do morador", quartoMorador);
        hall.definirSala("quarto morador", quartoMorador);
        hall.definirSala("quarto grande", quartoMorador);
        hall.definirSala("nordeste", quartoInfantil);
        hall.definirSala("quarto", quartoInfantil);
        hall.definirSala("quarto pequeno", quartoInfantil);
        hall.definirSala("norte", escritorio);
        hall.definirSala("escritorio", escritorio);
        hall.definirSala("descer escada", salaJantar);
        hall.definirSala("descer", salaJantar);

        quartoMorador.definirSala("sul", hall);
        quartoMorador.definirSala("hall", hall);
        quartoMorador.definirSala("corredor", hall);
        quartoInfantil.definirSala("sul", hall);
        quartoInfantil.definirSala("corredor", hall);
        quartoInfantil.definirSala("hall", hall);
        escritorio.definirSala("sul", hall);
        escritorio.definirSala("corredor", hall);
        escritorio.definirSala("hall", hall);
        salaSecreta.definirSala("sul", escritorio);
        salaSecreta.definirSala("corredor", escritorio);
        salaSecreta.definirSala("hall", escritorio);
        escritorio.definirSala("leste", salaSecreta);
        escritorio.definirSala("sala secreta", salaSecreta);
        escritorio.definirSala("secreta", salaSecreta);

        // Guardando salas no mapa do jogo
        mapaSalas.put("Sacada da Casa", sacada);

        mapaSalas.put("Sala de Estar", salaEstar);
        mapaSalas.put("Sala de Jantar", salaJantar);
        mapaSalas.put("Cozinha", cozinha);
        mapaSalas.put("Banheiro", banheiro);

        mapaSalas.put("Porão", porao);

        mapaSalas.put("Hall", hall);
        mapaSalas.put("Quarto do Morador", quartoMorador);
        mapaSalas.put("Quarto", quartoInfantil);
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
        mapaItens.put("chave da porta principal", chaveSaida);
        mapaItens.put("chave da porta", chaveSaida);
        mapaItens.put("chave do porão", chavePorao);
        mapaItens.put("chave do quarto", chaveQuarto);
        mapaItens.put("chave do quarto do morador", chaveQuartoMorador);
        mapaItens.put("chave do escritorio", chaveEscritorio);
        mapaItens.put("chave do guarda-roupa", chaveGuardaRoupa);
        mapaItens.put("galão de gasolina", galaoGasolina);
        mapaItens.put("galao de gasolina", galaoGasolina); // Variação sem acento por garantia
        mapaItens.put("pilhas", pilhas);
        mapaItens.put("gravador de áudio", gravadorAudio);
        mapaItens.put("gravador de audio", gravadorAudio); // Variação sem acento
        mapaItens.put("fita cassete #01", fita1);
        mapaItens.put("fita cassete #02", fita2);
        mapaItens.put("fita cassete #03", fita3);
        mapaItens.put("fita cassete #04", fita4);

        // Itens fixos (não coletáveis)

        // itens da cozinha -- Falta descricao
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

        mapaItens.put("armário da cozinha", armarioCozinha);
        mapaItens.put("armario da cozinha", armarioCozinha);
        mapaItens.put("armario", armarioCozinha);
        mapaItens.put("geladeira", geladeira);
        mapaItens.put("fogão", fogao);
        mapaItens.put("fogao", fogao);
        mapaItens.put("ilha da cozinha", ilhaCozinha);
        mapaItens.put("ilha", ilhaCozinha);
        mapaItens.put("cristaleira", cristaleira);
        mapaItens.put("estante da cozinha", estanteCozinha);
        mapaItens.put("estante", estanteCozinha);

        // itens da sala de estar
        Item gaveteiro = new Item("Gaveteiro", "Um gaveteiro de madeira com gavetas emperradas.", false);
        Item sofa = new Item("Sofá", "Sofa de tecido, bastante acabado, não dá nem para sentar, seria desconfortavel.",
                false);
        Item lareira = new Item("Lareira", "Lareira de predra, apenas com cinzas.", false);

        mapaItens.put("gaveteiro", gaveteiro);
        mapaItens.put("sofá", sofa);
        mapaItens.put("sofa", sofa);
        mapaItens.put("lareira", lareira);

        // itens do porão
        Item gerador = new Item("Gerador", "Um gerador antigo, coberto de poeira e ferrugem.", false);
        Item prateleiraNorte = new Item("Prateleira Norte",
                "Prateleira esta com alguns mantimentos consumiveis, mas no momento nada parece comestivel.", false);
        Item prateleiraCentro = new Item("Prateleira Centro",
                "Prateleira esta com algumas caixa que contem decorações festivas.", false);
        Item prateleiraSul = new Item("Prateleira Sul", "Prateleira esta cheia com coisas de manuteção e conserto.",
                false);
        Item interrutorEnergia = new Item("Interruptor Energia",
                "Painel de energia coberto de poeira e teias de aranha.", false);

        mapaItens.put("gerador", gerador);
        mapaItens.put("prateleira norte", prateleiraNorte);
        mapaItens.put("prateleira centro", prateleiraCentro);
        mapaItens.put("prateleira sul", prateleiraSul);

        mapaItens.put("interruptor energia", interrutorEnergia);

        // itens banheiro
        Item vasoSanitario = new Item("Vaso Sanitario", "Não estou com vontade de usar.", false);
        Item piaBanheiro = new Item("Armario com Pia",
                "Uma pia com armario em baixo, contendo alguns itens de limpeza e higiene vencidos.", false);
        Item boxChuveiro = new Item("Chuveiro", "Cortinas de plastico tentam esconder a parte do chuveiro.", false);
        Item espelho = new Item("Espelho",
                "O espelho em cima da pia esta bastante estilhaçado, mal da para me ver no espelho.", false);

        mapaItens.put("vaso sanitario", vasoSanitario);
        mapaItens.put("vaso", vasoSanitario);
        mapaItens.put("sanitario", vasoSanitario);
        mapaItens.put("armario com pia", piaBanheiro);
        mapaItens.put("armario", piaBanheiro);
        mapaItens.put("pia", piaBanheiro);
        mapaItens.put("chuveiro", boxChuveiro);
        mapaItens.put("espelho", espelho);

        // itens sala de jantar -- falta descrição
        Item mesaJantar = new Item("Mesa de Jantar", "Mesa de jantar de madeira com quatro cadeiras de madeira.",
                false);
        Item estante = new Item("Estante", "", false);

        mapaItens.put("mesa de jantar", mesaJantar);
        mapaItens.put("mesa", mesaJantar);
        mapaItens.put("estante", estante);

        // itens quarto do morador -- falta descrição
        Item camaCasal = new Item("Cama de Casal", "", false);
        Item mesaCabeceiraEsquerda = new Item("Mesa Cabeceira Esquerda", "", false);
        Item mesaCabeceiraDireita = new Item("Mesa Cabeceira Direita", "", false);
        Item guardaRoupaGrande = new Item("Guarda-Roupa Grande", "", false);
        Item esqueleto = new Item("Esqueleto Humano", "Nossa... o que realmente aconteceu? de quem é esse esqueleto?",
                false);

        mapaItens.put("cama de casal", camaCasal);
        mapaItens.put("cama de casal", camaCasal);
        mapaItens.put("mesa cabeceira esquerda", mesaCabeceiraEsquerda);
        mapaItens.put("mesa cabeceira direita", mesaCabeceiraDireita);
        mapaItens.put("guarda-roupa grande", guardaRoupaGrande);
        mapaItens.put("guarda roupa grande", guardaRoupaGrande);
        mapaItens.put("esqueleto humano", esqueleto);
        mapaItens.put("esqueleto", esqueleto);

        // itens do escritorio -- FALTA DESCRICAO
        Item estanteLivros = new Item("Estante de Livros", "", false);
        Item estanteFalsa = new Item("Estante Pequena", "", false);
        Item escrivaninha = new Item("Escrivaninha", "", false);

        mapaItens.put("estante de livros", estanteLivros);
        mapaItens.put("estante pequena", estanteFalsa);
        mapaItens.put("escrivaninha", escrivaninha);

        // itens quarto de visita
        Item camaSolteiro = new Item("Cama de Solteiro", "", false);
        Item caixasPapelao = new Item("Caixas de Papelão", "", false);
        Item guardaRoupaPequeno = new Item("Guarda-Roupa Pequeno", "", false);
        Item mesaCabeceira = new Item("Mesa Cabeceira", "", false);

        mapaItens.put("cama de solteiro", camaSolteiro);
        mapaItens.put("caixas de papelão", caixasPapelao);
        mapaItens.put("caixas de papelao", caixasPapelao);
        mapaItens.put("guarda-roupa pequeno", guardaRoupaPequeno);
        mapaItens.put("guarda roupa pequeno", guardaRoupaPequeno);
        mapaItens.put("mesa cabeceira", mesaCabeceira);

        // itens sala secreta
        Item mesaInvestigativa = new Item("Mesa Investigava", "", false);
        Item quadroDetetive = new Item("Quadro de investigação", "", false);

        mapaItens.put("mesa investigativa", mesaInvestigativa);
        mapaItens.put("quadro de investigação", quadroDetetive);
        mapaItens.put("quadro de investigaçao", quadroDetetive);
        mapaItens.put("quadro de investigacao", quadroDetetive);

        // Escondento itens dentro de outros
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

        quartoInfantil.conjuntoItemPresente(camaSolteiro);
        quartoInfantil.conjuntoItemPresente(caixasPapelao);
        quartoInfantil.conjuntoItemPresente(guardaRoupaPequeno);
        quartoInfantil.conjuntoItemPresente(mesaCabeceira);

        salaSecreta.conjuntoItemPresente(quadroDetetive);
        salaSecreta.conjuntoItemPresente(mesaInvestigativa);

        porao.trancar("Chave do Porão");
        quartoInfantil.trancar("Chave do Quarto");
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

    private static void exibirIntroducaoEEntrar(Jogador jogador) {
        Configuracao.limparTela();
        System.out.println("==================================================");
        System.out.println("   ECOS DO PASSADO: O SEGREDO DA CASA ABANDONADA  ");
        System.out.println("==================================================\n");

        // Introdução na Sacada
        Configuracao.digitar("De noite, ao redor da fogueira do acampamento, ouvindo histórias de lendas urbanas,");
        Configuracao.digitar("me desafiaram a passar a noite na casa abandonada na floresta. O conto diz que ");
        Configuracao.digitar("a casa pertenceu a um assassino que matou várias crianças uns 30 (trinta) anos atrás. ");
        Configuracao.digitar("Para não parecer covarde, aceitei. Espero não me arrepender depois.");

        Configuracao.digitar("\nComo forma de garantir que eu realmente entrasse na casa, me acompanharam até ela. ");
        Configuracao.digitar("Uma casa feita com troncos de madeira, sua aparencia, dominada por vegetação");
        Configuracao
                .digitar("e pichações de vândalos, esconde a beleza perdida pelo tempo. Meus colegas atrás de mim,");
        Configuracao.digitar("me acompanhando com o olhar, subo as escadas da sacada. Tento não olhar para trás para ");
        Configuracao.digitar(
                "evitar desistir, giro a maçaneta que range um pouco mais baixo que o ranger da porta abrindo");

        System.out.println("\n[ Pressione ENTER para entrar na casa... ]");
        scanner.nextLine();

        // Entrada Automática
        Sala salaEstar = mapaSalas.get("Sala de Estar");
        jogador.conjuntoSalaAtual(salaEstar);

        Configuracao.limparTela();
        Configuracao.digitar("Ouço a conversa dos meus colegas ao fundo se distanciando, me viro para olhar e...");
        Configuracao.digitar("BANG! A porta de entrada se fecha bruscamente atrás de mim com um vento misterioso.");
        Configuracao.digitar("Ouço o estalo da tranca da porta travando. Estou preso dentro da casa agora!");
        Configuracao.digitar("por que tinha que acontecer logo comigo? tudo por causa desse desafio tolo que aceitei.");
        Configuracao.digitar("pelo menos eu tenho uma lanterna.");

        System.out.println("\n[ Pressione ENTER para começar a investigar... ]");
        scanner.nextLine();
    }

    public static void verificarEExibirFinal(Jogador jogador) {

        Configuracao.limparTela();
        // VARIÁVEIS DE CHECAGEM DE PROGRESSO
        boolean ouviuFitaFinal = jogador.possuiItem("Fita Cassete #04"); // Ou checar flag de reprodução
        boolean explorouPorao = GerenciadorInteracao.isGeradorLigado();
        boolean descobriuSalaSecreta = jogador.possuiItem("Chave do Guarda-Roupa"); // Exemplo de item chave do andar de
                                                                                    // cima

        // FINAL 3: O Investigador / Verdade Absoluta
        // Jogador explorou o porão, o 1º andar e ouviu as revelações finais
        if (ouviuFitaFinal && explorouPorao) {
            Configuracao.digitar("==================================================");
            Configuracao.digitar("          FINAL 3/3: ECOS DA VERDADE              ");
            Configuracao.digitar("==================================================\n");
            Configuracao.digitar("");
            Configuracao.digitar("");
        }
        // FINAL 2: A Fuga Incompleta
        // Jogador explorou parte da casa (ex: ligou o gerador ou subiu as escadas), mas
        // não juntou todas as peças
        else if (explorouPorao || descobriuSalaSecreta) {
            Configuracao.digitar("==================================================");
            Configuracao.digitar("          FINAL 2/3: DÚVIDAS NO ESCURO            ");
            Configuracao.digitar("==================================================\n");
            Configuracao.digitar("Saio da casa com uma sensação incômoda, quase como se algo estivesse faltando. ");
            Configuracao.digitar("Encontrei coisas estranhas lá dentro, mas a história parece incompleta.");
            Configuracao.digitar("Algo sombrio aconteceu aqui, e eu talvez nunca saiba a verdade.");
        }
        // FINAL 1: Covardia / Fuga Precoce
        // Jogador pegou a chave no térreo e saiu imediatamente sem explorar quase nada
        else {
            Configuracao.digitar("==================================================");
            Configuracao.digitar("            FINAL 1/3: FUGA PRECOCE               ");
            Configuracao.digitar("==================================================\n");
            Configuracao.digitar("O medo fala mais alto, não tenho conragem de continuar na casa.");
            Configuracao.digitar("Assim que encontro a chave no térreo, nem me dou ao trabalho de olhar o resto.");
            Configuracao.digitar("Abro o porta para o lado de fora e corro para o mais longe possivel.");
            Configuracao.digitar("A casa permanece um mistério intocado, do qual não tive coragem de desvendar");
        }
        System.out.println("\n--------------------------------------------------");
        System.out.println("                  CRÉDITOS                        ");
        System.out.println("  Ecos do Passado - Desenvolvido em Java          ");
        System.out.println("  Feito por H_Adryelle_Lima                       ");
        System.out.println("  Obrigado por jogar!                             ");
        System.out.println("--------------------------------------------------");
        System.out.println("\n[ Pressione ENTER para retornar ao Menu Principal... ]");
        scanner.nextLine();
    }

    private static void exibirSobre() {
        System.out.println("\n--- SOBRE O JOGO ---");
        System.out.println("Um suspense interativo baseado em texto.");
        System.out.println("Explore a cabana abandonada e descubra a verdade sobre os acontecimentos de 1984.");
        System.out.println("Desenvolvido em Java (MVP).");
        System.out.println("\nPressione ENTER para voltar ao menu...");
        scanner.nextLine();
    }

    private static void iniciarNovoJogo() {
        Configuracao.digitar("\nIniciando novo jogo...");
        System.out.println("\n--------------------------------------------------");
        System.out.print("Digite o seu nome para começar > ");
        String nomeDigitado = scanner.nextLine().trim();

        if (nomeDigitado.isEmpty()) {
            nomeDigitado = "Investigador";
            // Nome padrão caso o jogador aprete ENTER sem digitar
        }
        Configuracao.digitar("\nBem-vindo, " + nomeDigitado + ". Sua investigação começa agora...");

        // Criar o jogador com o nome digitado na sala inicial (sacada)
        Jogador jogador = new Jogador(nomeDigitado, mapaSalas.get("Sacada da Casa"));
        exibirIntroducaoEEntrar(jogador);
        rodarLoopJogo(jogador);
    }

    private static void continuarJogo() {
        if (!GerenciadorSave.existeSave()) {
            System.out.println("\n[!] Nenhum jogo salvo foi encontrado!");
            return;
        }
        String[] dados = GerenciadorSave.carregarDados();
        String nomeJogadorSalvo = dados[0];
        String nomeSalaSalva = dados[1];
        String itensSalvos = dados[2];

        // Restaurar Sala
        Sala salaCarregada = mapaSalas.get(nomeSalaSalva);
        if (salaCarregada == null) {
            salaCarregada = mapaSalas.get("Sacada da Casa");
        }
        // Recria o jogador com nome gravado no save
        Jogador jogador = new Jogador(nomeJogadorSalvo, salaCarregada);

        // Restaura os itens da mochila
        if (!itensSalvos.isEmpty()) {
            String[] nomesItens = itensSalvos.split(",");
            for (String nomeItem : nomesItens) {
                Item item = mapaItens.get(nomeItem.trim().toLowerCase());
                if (item != null) {
                    jogador.adicionarItem(item);
                }
            }
        }
        Configuracao.digitar("\n [Jogo carregado com sucesso! Restaurando progresso... ]");
        Configuracao.digitar("\n[Bem-vindo de volta, " + jogador.pegarNome() + "! Jogo carregado com sucesso...]");
        rodarLoopJogo(jogador);
    }

    // --- LOOP PRINCIPAL DE GAMEPLAY ---
    private static void rodarLoopJogo(Jogador jogador) {
        boolean jogando = true;
        String ultimaNotificacao = "";

        while (jogando) {
            Configuracao.limparTela();
            Sala salaAtual = jogador.pegarSalaAtual();

            // Cabeçalho superior
            System.out.println("==================================================");
            System.out.println("  ECOS DO PASSADO  |  LOCAL: " + salaAtual.pegarNome().toUpperCase());
            System.out.println("==================================================\n");

            // Descrição do ambiente atual
            Configuracao.digitar(salaAtual.pegarDescricao());
            System.out.println("--------------------------------------------------");

            // Painel de Notificação (Só aparece se houver uma notificação recente)
            if (!ultimaNotificacao.isEmpty()) {
                System.out.println("\n------------------------------------------------------------------");
                Configuracao.digitar(ultimaNotificacao);
                System.out.println("------------------------------------------------------------------");
                ultimaNotificacao = ""; // Limpa para a próxima rodada
            }
            System.out.println("\n--------------------------------------------------");
            System.out.print(":<< ");
            String entrada = scanner.nextLine().trim();

            // Comando direto de salvar a qualquer momento
            if (entrada.equalsIgnoreCase("salvar")) {
                GerenciadorSave.salvarJogo(jogador);
                System.out.println("\n[ Pressione ENTER para continuar... ]");
                scanner.nextLine();
                continue;
            }
            // Comando direto para abrir a mochila
            if (entrada.equalsIgnoreCase("inventario") || entrada.equalsIgnoreCase("mochila")) {
                Configuracao.limparTela();
                jogador.exibirInventario();
                System.out.println("\n[ Pressione ENTER para continuar... ]");
                scanner.nextLine();
                continue;
            }

            // Processa os comandos (MOVER, EXAMINAR, PEGAR, etc.)
            Comando comando = Parser.analisar(entrada);
            String acao = comando.pegarAcao();
            String alvo = comando.pegarAlvo();

            if (!comando.temAcao()) {
                System.out.println(
                        "\nNão entendi o comando. Tente verbos como 'ir', 'examinar', 'pegar', 'mochila' ou 'salvar'.");
                System.out.println("[ Pressione ENTER para tentar novamente... ]");
                scanner.nextLine();
                continue;
            }

            switch (comando.pegarAcao()) {
                case "MOVER":
                    // 1. Declarar e inicializar a variável 'direcao' com o alvo do comando
                    String direcao = comando.pegarAlvo();

                    // 2. Tratar sinônimos para padronizar o nome da saída
                    if (direcao.equalsIgnoreCase("subir") || direcao.equalsIgnoreCase("cima")
                            || direcao.equalsIgnoreCase("escada")) {
                        direcao = "subir";
                    } else if (direcao.equalsIgnoreCase("descer") || direcao.equalsIgnoreCase("baixo")
                            || direcao.equalsIgnoreCase("porao")) {
                        direcao = "descer";
                    }

                    // 3. Buscar a próxima sala com a direção tratada
                    Sala proxima = salaAtual.pegarSaida(direcao);

                    if (proxima != null) {
                        if (proxima.estaTrancada()) {
                            System.out.println("\nA porta para " + proxima.pegarNome() + " está TRANCADA!");
                            System.out.println("[ Pressione ENTER para continuar... ]");
                            scanner.nextLine();
                        } else {
                            jogador.conjuntoSalaAtual(proxima);

                            if (proxima.pegarNome().equalsIgnoreCase("Sacada")) {
                                verificarEExibirFinal(jogador);
                                jogando = false;
                            }
                        }

                    } else {
                        System.out.println("\nNão há passagem nessa direção!");
                        System.out.println("[ Pressione ENTER para continuar... ]");
                        scanner.nextLine();
                    }
                    break;

                case "EXAMINAR":
                    Item itemAlvo = jogador.buscarItemNoInventario(alvo);

                    // Se não encontrou no inventário, busca nos itens da sala atual
                    if (itemAlvo == null) {
                        for (Item item : salaAtual.pegarItens()) {
                            // Verifica se o nome do item contém a palavra digitada pelo jogador
                            if (item.pegarNome().equalsIgnoreCase(alvo) ||
                                    item.pegarNome().toLowerCase().contains(alvo.toLowerCase())) {
                                itemAlvo = item;
                                break;
                            }
                        }
                    }

                    if (itemAlvo != null) {
                        // Exibe a descrição apenas UMA vez no topo
                        Configuracao.digitar(itemAlvo.pegarDescricao());

                        // Se o móvel estiver trancado
                        if (itemAlvo.estaTrancado()) {
                            Configuracao.digitar("\n[!] O objeto está trancado. Preciso da "
                                    + itemAlvo.pegarChaveNecessaria() + " para abri-lo.");
                        } else {
                            // Se tiver documento/texto para ler
                            if (itemAlvo.eTextoLendo()) {
                                System.out.println("\n--- CONTEÚDO DO DOCUMENTO ---");
                                Configuracao.digitar(itemAlvo.pegarConteudoTexto());
                                System.out.println("-----------------------------");
                            }

                            // Se for um móvel com item escondido
                            if (itemAlvo.temItemEscondido()) {
                                Item encontrado = itemAlvo.pegarItemEscondido();
                                Configuracao.digitar(
                                        "\n[!] Procurando melhor, encontro: " + encontrado.pegarNome() + "!");
                                salaAtual.conjuntoItemPresente(encontrado);
                                itemAlvo.esconderItem(null); // Esvazia o móvel
                            }
                        }
                    } else {
                        Configuracao.digitar("Eu não vejo esse objeto aqui.");
                    }

                    System.out.println("\n[ Pressione ENTER para continuar... ]");
                    scanner.nextLine();
                    break;

                case "PEGAR":
                    Item itemParaPegar = null;

                    // Busca na lista de itens da sala atual o item solicitado pelo jogador
                    for (Item item : salaAtual.pegarItens()) {
                        if (item.pegarNome().equalsIgnoreCase(alvo) ||
                                item.pegarNome().toLowerCase().contains(alvo.toLowerCase())) {
                            itemParaPegar = item;
                            break;
                        }
                    }

                    if (itemParaPegar != null) {
                        if (itemParaPegar.eColetavel()) {
                            jogador.adicionarItem(itemParaPegar);
                            salaAtual.removerItem(itemParaPegar); // Remove apenas este item da sala
                            ultimaNotificacao = "Dentro está " + itemParaPegar.pegarNome() + ". Pego o item.";
                        } else {
                            System.out.println("\nPara quê vou querer pegar isso?");
                        }
                    } else {
                        System.out.println("\nNão há esse item para pegar aqui.");
                    }

                    System.out.println("\n[ Pressione ENTER para continuar... ]");
                    scanner.nextLine();
                    break;
                case "USAR":
                    GerenciadorInteracao.processarUso(jogador, comando.pegarAlvo(), scanner, mapaSalas);
                    break;

                case "SAIR":
                    Configuracao.digitar("\nRetornando ao Menu Principal...");
                    jogando = false;
                    break;
            }
        }
    }
}
