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
        Sala sacada = new Sala("Sacada", "");
        Sala salaEstar = new Sala("Sala de Estar", "");
        Sala cozinha = new Sala("Cozinha", "");
        Sala banheiro = new Sala("Banheiro", "");
        Sala salaJantar = new Sala("Sala de Jantar", "");

        Sala escada1 = new Sala("Escada 1° andar", "");
        Sala escada0 = new Sala("Escada do Porão", "");

        Sala porao = new Sala("Porão", "");

        Sala hall = new Sala("hall", "");
        Sala quartoMorador = new Sala("Quarto Morador", "");
        Sala quartoInfantil = new Sala("Quarto Infantil", "");
        Sala escritorio = new Sala("Escritorio", "");
        Sala salaSecreta = new Sala("Sala Secreta", "");

        // Conexões
        sacada.definirSala("norte", salaEstar);

        salaEstar.definirSala("norte", cozinha);
        salaEstar.definirSala("leste", salaJantar);
        salaEstar.definirSala("nordeste", banheiro);

        salaJantar.definirSala("norte", banheiro);
        salaJantar.definirSala("sudeste", escada1);
        salaJantar.definirSala("leste", escada0);
        salaJantar.definirSala("oeste", salaEstar);

        cozinha.definirSala("sul", salaEstar);
        banheiro.definirSala("sul", salaJantar);
        escada1.definirSala("norte", hall);
        escada0.definirSala("sul", porao);

        hall.definirSala("leste", quartoMorador);
        hall.definirSala("nordeste", quartoInfantil);
        hall.definirSala("norte", escritorio);

        quartoMorador.definirSala("sul", hall);
        quartoInfantil.definirSala("sul", hall);
        escritorio.definirSala("sul", hall);
        salaSecreta.definirSala("sul", escritorio);
        escritorio.definirSala("leste", salaSecreta);

        // Guardando salas no mapa do jogo
        mapaSalas.put("Sacada da Casa", sacada);

        mapaSalas.put("Sala de Estar", salaEstar);
        mapaSalas.put("Sala de Jantar", salaJantar);
        mapaSalas.put("Cozinha", cozinha);
        mapaSalas.put("Banheiro", banheiro);

        mapaSalas.put("Escada para 1°", escada1);
        mapaSalas.put("Escada para Porão", escada0);

        mapaSalas.put("Porão", porao);

        mapaSalas.put("Hall", hall);
        mapaSalas.put("Quarto do Morador", quartoMorador);
        mapaSalas.put("Quarto Infantil", quartoInfantil);
        mapaSalas.put("Escritorio", escritorio);
        mapaSalas.put("Sala Secreta", salaSecreta);

        // Criando Itens --- criar e adicionar mais itens

        // Itens coletaveis
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

        // itens da sala
        Item gaveteiro = new Item("Gaveteiro", "Um gaveteiro de madeira com gavetas emperradas.", false);
        Item sofa = new Item("Sofá", "Sofa de tecido, bastante acabado, não dá nem para sentar, seria desconfortavel.",
                false);
        Item lareira = new Item("Lareira", "Lareira de predra, apenas com cinzas.", false);

        // itens do porão
        Item gerador = new Item("Gerador", "Um gerador antigo, coberto de poeira e ferrugem.", false);
        Item pateleiraNorte = new Item("Prateleira Norte",
                "Prateleira esta com alguns mantimentos consumiveis, mas no momento nada parece comestivel.", false);
        Item prateleiraCentro = new Item("Prateleira Centro",
                "Prateleira esta com algumas caixa que contem decorações festivas.", false);
        Item prateleiraSul = new Item("Prateleira Sul", "Prateleira esta cheia com coisas de manuteção e conserto.",
                false);
        Item interrutorEnergia = new Item("Interruptor Energia",
                "Painel de energia coberto de poeira e teias de aranha.", false);

        // itens banheiro
        Item vasoSanitario = new Item("Vaso Sanitario", "Não estou com vontade de usar.", false);
        Item piaBanheiro = new Item("Armario com Pia",
                "Uma pia com armario em baixo, contendo alguns itens de limpeza e higiene vencidos.", false);
        Item boxChuveiro = new Item("Chuveiro", "Cortinas de plastico tentam esconder a parte do chuveiro.", false);
        Item espelho = new Item("Espelho",
                "O espelho em cima da pia esta bastante estilhaçado, mal da para me ver no espelho.", false);

        // itens sala de jantar -- falta descrição
        Item mesaJantar = new Item("Mesa de Jantar", "Mesa de jantar de madeira com quatro cadeiras de madeira.",
                false);
        Item estante = new Item("Estante", "", false);

        // itens quarto do morador -- falta descrição
        Item camaCasal = new Item("Cama de Casal", "", false);
        Item mesaCabeceiraEsqueda = new Item("Mesa Cabeceira Esquerda", "", false);
        Item mesaCabeceiraDireita = new Item("Mesa Cabeceira Direita", "", false);
        Item guardaRoupaGrande = new Item("Guarda-Roupa Grande", "", false);
        Item esqueleto = new Item("Esqueleto Humano", "Nossa... o que realmente aconteceu? de quem é esse esqueleto?",
                false);

        // itens do escritorio -- FALTA DESCRICAO
        Item estanteLivros = new Item("Estante de Livros Grande", "", false);
        Item estanteFalsa = new Item("Estante Pequena", "", false);
        Item escrivaninha = new Item("Escrivaninha", "", false);

        // itens quarto de visita
        Item camaSolteiro = new Item("Cama de Solteiro", "", false);
        Item caixasPapelao = new Item("Caixas de Papelão", "", false);
        Item guardaRoupaPequeno = new Item("Guarda-Roupa Pequeno", "", false);
        Item mesaCabeceira = new Item("Mesa Cabeceira", "", false);

        // itens sala secreta
        Item mesaInvestigativa = new Item("Mesa Investigava", "", false);
        Item quadroDetetive = new Item("Quadro de investigação", "", false);

        // Escondento itens dentro de outros
        armarioCozinha.esconderItem(chaveQuarto);

        guardaRoupaGrande.esconderItem(esqueleto);
        esqueleto.esconderItem(fita4);
        mesaCabeceiraEsqueda.esconderItem(chavePorao);
        camaCasal.esconderItem(fita3);

        camaSolteiro.esconderItem(fita2);
        mesaCabeceira.esconderItem(chaveQuartoMorador);

        mesaInvestigativa.esconderItem(chaveGuardaRoupa);

        mesaJantar.esconderItem(fita1);

        piaBanheiro.esconderItem(pilhas);

        prateleiraSul.esconderItem(chaveEscritorio);

        escrivaninha.esconderItem(gravadorAudio);

        // Colocando itens no mapa de itens para acesso rápido
        // mapaItens.put("chave porão", chavePorao);

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
        porao.conjuntoItemPresente(pateleiraNorte);

        banheiro.conjuntoItemPresente(espelho);
        banheiro.conjuntoItemPresente(piaBanheiro);
        banheiro.conjuntoItemPresente(vasoSanitario);
        banheiro.conjuntoItemPresente(boxChuveiro);

        salaJantar.conjuntoItemPresente(mesaJantar);
        salaJantar.conjuntoItemPresente(estante);

        quartoMorador.conjuntoItemPresente(guardaRoupaGrande);
        quartoMorador.conjuntoItemPresente(camaCasal);
        quartoMorador.conjuntoItemPresente(mesaCabeceiraDireita);
        quartoMorador.conjuntoItemPresente(mesaCabeceiraEsqueda);
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

        /*
         * Definindo o texto legível do bilhete
         * anotacaoGerador.conjuntoConteudoTexto(
         * "\"O gerador no porão está falhando. Para reativar o circuito da estante,\n"
         * +
         * "é necessário colocar combustível e acionar o interrupter principal.\"");
         */

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
        while (jogando) {
            Configuracao.limparTela();

            Sala salaAtual = jogador.pegarSalaAtual();

            // Cabeçalho superior (igual ao monitor CRT da imagem)
            System.out.println("==================================================");
            System.out.println("  ECOS DO PASSADO  |  LOCAL: " + salaAtual.pegarNome().toUpperCase());
            System.out.println("==================================================\n");

            // Descrição do ambiente atual
            Configuracao.digitar(salaAtual.pegarDescricao());

            if (salaAtual.pegarItemPresente() != null) {
                System.out.println("\nObservando o local, você nota: " + salaAtual.pegarItemPresente().pegarNome());
            }
            System.out.println("\n--------------------------------------------------");
            System.out.print(":> ");
            String entrada = scanner.nextLine();

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
            if (!comando.temAcao()) {
                System.out.println(
                        "\nNão entendi o comando. Tente verbos como 'ir', 'examinar', 'pegar', 'mochila' ou 'salvar'.");
                System.out.println("[ Pressione ENTER para tentar novamente... ]");
                scanner.nextLine();
                continue;
            }

            switch (comando.pegarAcao()) {
                case "MOVER":
                    Sala proxima = salaAtual.pegarSaida(comando.pegarAlvo());
                    if (proxima != null) {
                        if (proxima.estaTrancada()) {
                            System.out.println("\nA porta para " + proxima.pegarNome()
                                    + " está TRANCADA! Você precisa de uma chave.");
                            System.out.println("[ Pressione ENTER para continuar... ]");
                            scanner.nextLine();
                        } else {
                            jogador.conjuntoSalaAtual(proxima); // Movel o jogador se estiver livre
                        }
                    } else {
                        System.out.println("\nNão há passagem nessa direção!");
                        System.out.println("[ Pressione ENTER para continuar... ]");
                        scanner.nextLine();
                    }
                    break;

                case "EXAMINAR":
                    Configuracao.limparTela();
                    String alvo = comando.pegarAlvo();
                    Item itemAlvo = jogador.buscarItemNoInventario(alvo);

                    if (itemAlvo == null && salaAtual.pegarItemPresente() != null) {
                        if (salaAtual.pegarItemPresente().pegarNome().equalsIgnoreCase(alvo)) {
                            itemAlvo = salaAtual.pegarItemPresente();
                        }
                    }

                    if (itemAlvo != null) {
                        // Exibe a descrição apenas UMA vez no topo
                        Configuracao.digitar(itemAlvo.pegarDescricao());

                        // Se o móvel estiver trancado
                        if (itemAlvo.estaTrancado()) {
                            Configuracao.digitar("\n[!] O objeto está trancado. Você precisa da "
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
                                        "\n[!] Procurando melhor, você encontrou: " + encontrado.pegarNome() + "!");
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
                    Item itemNaSala = salaAtual.pegarItemPresente();
                    if (itemNaSala != null && itemNaSala.pegarNome().equalsIgnoreCase(comando.pegarAlvo())) {
                        if (itemNaSala.eColetavel()) {
                            jogador.adicionarItem(itemNaSala);
                            salaAtual.conjuntoItemPresente(null); // Remove da sala
                        } else {
                            System.out.println("\nEsse objeto é muito pesado, não consigo pegar.");
                        }
                    } else {
                        System.out.println("\nNão há esse item para pegar aqui.");
                    }

                    System.out.println("\n[ Pressione ENTER para continuar... ]");
                    scanner.nextLine();
                    break;
                case "USAR":
                    GerenciadorInteracao.processarUso(jogador, comando.pegarAlvo(), scanner);
                    break;

                case "SAIR":
                    Configuracao.digitar("\nRetornando ao Menu Principal...");
                    jogando = false;
                    break;
            }
        }
    }
}
