import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Sala> mapaSalas = new HashMap<>();
    private static Map<String, Item> mapaItens = new HashMap<>();

    public static void main(String[] args) {
        GerenciadorMundo gerenciadorMundo = new GerenciadorMundo();
        gerenciadorMundo.inicializarMundo();

        mapaSalas = gerenciadorMundo.getMapaSalas();
        mapaItens = gerenciadorMundo.getMapaItens();

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
        Configuracao.limparTela();
        Configuracao.exibirCabecalho();
        
        System.out.println("1. Continuar Jogo");
        System.out.println("2. Iniciar Novo Jogo");
        System.out.println("3. Configuração");
        System.out.println("4. Sobre");
        System.out.println("5. Sair");
        System.out.println("==================================================");
    }

    private static void exibirAguardar() {
        System.out.println("\n<< WAIT >>");
        scanner.nextLine();
    }

    private static void exibirIntroducaoEEntrar(Jogador jogador) {
        Configuracao.limparTela();
        Configuracao.exibirCabecalho();

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

        System.out.println("\n--------------------------------------------------");
        System.out.println("PRESSIONE ENTER PARA CONTINUAR");
        System.out.println("--------------------------------------------------");
        exibirAguardar();

        // Entrada Automática
        Sala salaEstar = mapaSalas.get("Sala de Estar");
        jogador.conjuntoSalaAtual(salaEstar);

        Configuracao.limparTela();
        Configuracao.exibirCabecalho();

        Configuracao.limparTela();
        Configuracao.digitar("Ouço a conversa dos meus colegas ao fundo se distanciando, me viro para olhar e...");
        Configuracao.digitar("BANG! A porta de entrada se fecha bruscamente atrás de mim com um vento misterioso.");
        Configuracao.digitar("Ouço o estalo da tranca da porta travando. Estou preso dentro da casa agora!");
        Configuracao.digitar("por que tinha que acontecer logo comigo? tudo por causa desse desafio tolo que aceitei.");
        Configuracao.digitar("pelo menos eu tenho uma lanterna.");

        System.out.println("\n--------------------------------------------------");
        System.out.println("PRESSIONE ENTER PARA COMEÇAR A INVESTIGAR");
        System.out.println("--------------------------------------------------");
        exibirAguardar();
    }

    public static void verificarEExibirFinal(Jogador jogador) {

        Configuracao.limparTela();
        // VARIÁVEIS DE CHECAGEM DE PROGRESSO
        boolean ouviuFitaFinal = jogador.possuiItem("Fita Cassete #04"); // Ou checar flag de reprodução
        boolean explorouPorao = GerenciadorInteracao.isGeradorLigado();
        boolean descobriuSalaSecreta = jogador.possuiItem("Chave do Guarda-Roupa"); // Exemplo de item chave do andar de
          
        Configuracao.exibirCabecalho();

        // FINAL 3: O Investigador / Verdade Absoluta
        // Jogador explorou o porão, o 1º andar e ouviu as revelações finais
        if (ouviuFitaFinal && explorouPorao) {
            Configuracao.digitar("FINAL 3/3: ECOS DA VERDADE\n");
            Configuracao.digitar("");
            Configuracao.digitar("");
        }
        // FINAL 2: A Fuga Incompleta
        // Jogador explorou parte da casa (ex: ligou o gerador ou subiu as escadas), mas
        // não juntou todas as peças
        else if (explorouPorao || descobriuSalaSecreta) {
            Configuracao.digitar("FINAL 2/3: DÚVIDAS NO ESCURO\n");
            Configuracao.digitar("Saio da casa com uma sensação incômoda, quase como se algo estivesse faltando. ");
            Configuracao.digitar("Encontrei coisas estranhas lá dentro, mas a história parece incompleta.");
            Configuracao.digitar("Algo sombrio aconteceu aqui, e eu talvez nunca saiba a verdade.");
        }
        // FINAL 1: Covardia / Fuga Precoce
        // Jogador pegou a chave no térreo e saiu imediatamente sem explorar quase nada
        else {
            Configuracao.digitar("FINAL 1/3: FUGA PRECOCE\n");
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
        exibirAguardar();
    }

    private static void exibirSobre() {
        Configuracao.limparTela();
        Configuracao.exibirCabecalho();

        System.out.println("Um suspense interativo baseado em texto.");
        System.out.println("Explore a cabana abandonada e descubra a verdade sobre os acontecimentos de 1984.");
        System.out.println("Desenvolvido em Java (MVP).");
        System.out.println("\n--------------------------------------------------");
        System.out.println("PRESSIONE ENTER PARA VOLTAR");
        System.out.println("--------------------------------------------------");
        exibirAguardar();
    }

    private static void iniciarNovoJogo() {
        Configuracao.limparTela();
        Configuracao.exibirCabecalho();

        Configuracao.digitar("\nIniciando novo jogo...");
        System.out.println("\n--------------------------------------------------");
        System.out.print("Digite o seu nome para começar > ");
        String nomeDigitado = scanner.nextLine().trim();

        if (nomeDigitado.isEmpty()) {
            nomeDigitado = "Investigador";
            // Nome padrão caso o jogador aprete ENTER sem digitar
        }
        Configuracao.digitar("\nBem-vindo, " + nomeDigitado + ". Sua investigação começa agora...");
        exibirAguardar();

        // Criar o jogador com o nome digitado na sala inicial (sacada)
        Jogador jogador = new Jogador(nomeDigitado, mapaSalas.get("Sacada"));
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
            salaCarregada = mapaSalas.get("Sacada");
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
        exibirAguardar();
        rodarLoopJogo(jogador);
    }

    // --- LOOP PRINCIPAL DE GAMEPLAY ---
    private static void rodarLoopJogo(Jogador jogador) {
        boolean jogando = true;
        String ultimaNotificacao = "";

        while (jogando) {
            Sala salaAtual = jogador.pegarSalaAtual();

            // Cabeçalho superior
            Configuracao.limparTela();
            Configuracao.exibirCabecalho("LOCAL: " + salaAtual.pegarNome());

            // Descrição do ambiente atual
            Configuracao.digitar(salaAtual.pegarDescricao());
            System.out.println();
            if (!salaAtual.pegarItens().isEmpty()) {
                System.out.print("No local observo: ");
                for (int i = 0; i < salaAtual.pegarItens().size(); i++) {
                    Item it = salaAtual.pegarItens().get(i);
                    System.out.print(it.pegarNome() + (i < salaAtual.pegarItens().size() - 1 ? ", " : ".\n"));
                }
            } else {
                System.out.println("Não há nada de relevante para examinar aqui.");
            }

            // Painel de Notificação (Só aparece se houver uma notificação recente)
            if (!ultimaNotificacao.isEmpty()) {
                System.out.println("\n------------------------------------------------------------------");
                Configuracao.digitar(ultimaNotificacao);
                ultimaNotificacao = ""; // Limpa para a próxima rodada
            }
            System.out.println("\n--------------------------------------------------");
            exibirAguardar();
            String entrada = scanner.nextLine().trim();

            // Comando direto de salvar a qualquer momento
            if (entrada.equalsIgnoreCase("salvar")) {
                GerenciadorSave.salvarJogo(jogador);
                System.out.println("\n[ Pressione ENTER para continuar... ]");
                exibirAguardar();
                continue;
            }
            // Comando direto para abrir a mochila
            if (entrada.equalsIgnoreCase("inventario") || entrada.equalsIgnoreCase("mochila")) {
                Configuracao.limparTela();
                jogador.exibirInventario();
                System.out.println("\n[ Pressione ENTER para continuar... ]");
                exibirAguardar();
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
                    // Normaliza textos para ignorar acentos e maiúsculas/minúsculas
                    String alvoNormal = java.text.Normalizer.normalize(alvo, java.text.Normalizer.Form.NFD)
                            .replaceAll("\\p{M}", "")
                            .toLowerCase();

                    Item itemAlvo = jogador.buscarItemNoInventario(alvoNormal);

                    if (itemAlvo == null) {
                        for (Item item : salaAtual.pegarItens()) {
                            String nomeItemNormal = java.text.Normalizer
                                    .normalize(item.pegarNome(), java.text.Normalizer.Form.NFD)
                                    .replaceAll("\\p{M}", "")
                                    .toLowerCase();

                            if (nomeItemNormal.contains(alvoNormal) || alvoNormal.contains(nomeItemNormal)) {
                                itemAlvo = item;
                                break;
                            }
                        }
                    }

                    if (itemAlvo != null) {
                        StringBuilder resposta = new StringBuilder();
                        resposta.append(itemAlvo.pegarDescricao());

                        if (itemAlvo.estaTrancado()) {
                            resposta.append("\n[!] O objeto está trancado. Preciso da ")
                                    .append(itemAlvo.pegarChaveNecessaria()).append(" para abri-lo.");
                        } else {
                            if (itemAlvo.eTextoLendo()) {
                                resposta.append("\n--- CONTEÚDO DO DOCUMENTO ---\n")
                                        .append(itemAlvo.pegarConteudoTexto())
                                        .append("\n-----------------------------");
                            }

                            if (itemAlvo.temItemEscondido()) {
                                Item encontrado = itemAlvo.pegarItemEscondido();
                                resposta.append("\n[!] Procurando melhor, encontro: ")
                                        .append(encontrado.pegarNome()).append("!");

                                // Adiciona o item escondido na sala para poder ser pego com o comando 'pegar'
                                salaAtual.conjuntoItemPresente(encontrado);
                                itemAlvo.esconderItem(null); // Esvazia o recipiente
                            }
                        }

                        // Guarda a resposta para ser exibida no painel de notificação da próxima tela
                        ultimaNotificacao = resposta.toString();

                    } else {
                        ultimaNotificacao = "Eu não vejo esse objeto aqui.";
                    }
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
