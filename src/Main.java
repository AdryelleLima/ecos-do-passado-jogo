import java.util.Scanner;

public class Main{
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Sala> mapaSalas = new HashMap<>();
    private static Map<String, Item> mapaItens = new HashMap<>();

    public static void main(String[] args){
        inicializarMundo(); // Cria as salas e itens do jogo
        boolean noMenu = true;

        while(noMenu){
            exibirMenuPrincipal();
            System.out.print("Escolha uma opção > ");
            String opcao = scanner.nextLine().trim();

            switch (opcao){
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
    private static void exibirMenuPrincipal(){
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
    private static void inicializarMundo(){
        // Criando Itens --- criar e adicionar mais itens
        Item chavePorao = new Item("Chave do Porão","Uma chave antiga e enferrujada.", true);

        mapaItens.put("chave porão", chavePorao);
        
        // Criando Salas
        Sala sacada = new Sala("Sacada","");
        Sala salaEstar = new Sala("Sala de Estar","");
        Sala cozinha = new Sala("Cozinha","");
        Sala banheiro = new Sala("Banheiro","");
        Sala salaJantar = new Sala("Sala de Jantar","");
        
        Sala escada1 = new Sala("Escada 1° andar", "");
        Sala escada0 = new Sala("Escada do Porão","");
        
        Sala porao = new Sala("Porão","");

        Sala hall = new Sala("hall","");
        Sala quartoMorador = new Sala("Quarto Morador", "");
        Sala quartoInfantil = new Sala("Quarto Infantil","");
        Sala escritorio = new Sala("Escritorio","");
        Sala salaSecreta = new Sala("Sala Secreta", "");

        // Conexões
        sacada.definirSala("norte", salaEstar);
        
        salaEstar.definirSala("norte", cozinha);
        salaEstar.definirSala("leste", salaJantar);
        salaEstar.definirSala("nordeste", banheiro);

        salaJantar.definirSala("norte", banheiro);
        salaJantar.definirSala("sudeste", escada1);
        salaJantar.definirSala("leste",escada0);
        salaJantar.definirSala("oeste",salaEstar);

        cozinha.definirSala("sul", salaEstar);
        
        banheiro.definirSala("sul", salaJantar);

        escada1.definirSala("norte", hall);

        escada0.definirSala("sul",porao);

        hall.definirSala("leste", quartoMorador);
        hall.definirSala("nordeste", quartoInfantil);
        hall.definirSala("norte",escritorio);

        quartoMorador.definirSala("sul", hall);

        quartoInfantil.definirSala("sul", hall);
        
        escritorio.definirSala("sul",hall);

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
        mapaSalas.put("Quarto Infantil",quartoInfantil);
        mapaSalas.put("Escritorio",escritorio);
        mapaSalas.put("Sala Secreta", salaSecreta);
        
        // Colocando itens nas Salas --- atualizarei ainda
        cozinha.conjuntoItemPresente(chavePorao);
    }
    private static void exibirSobre() {
        System.out.println("\n--- SOBRE O JOGO ---");
        System.out.println("Um suspense interativo baseado em texto.");
        System.out.println("Explore a cabana abandonada e descubra a verdade sobre os acontecimentos de 1984.");
        System.out.println("Desenvolvido em Java (MVP).");
        System.out.println("\nPressione ENTER para voltar ao menu...");
        scanner.nextLine();
    }
    private static void iniciarNovoJogo(){
        Configuracao.digitar("\nIniciando novo jogo...");
        System.out.println("\n--------------------------------------------------");
        System.out.print("Digite o seu nome para começar > ");
        String nomeDigitado = scanner.nextLine().trim();

        if(nomeDigitado.isEmpty()){
            nomeDigitado = "Investigador"; 
            // Nome padrão caso o jogador aprete ENTER sem digitar
        }
        Configuracao.digitar("\nBem-vindo, " + nomeDigitado + ". Sua investigação começa agora...");

        // Criar o jogador com o nome digitado na sala inicial (sacada)
        Jogador jogador = new Jogador(nomeDigitado, mapaSalas.get("Sacada da Casa"));
        rodarLoopJogo(jogador);
    }
    private static void continuarJogo(){
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
        if (salaCarregada == null){
            salaCarregada = mapaSalas.get("Sacada da Casa");
        }
        // Recria o jogador com nome gravado no save
        Jogador jogador = new Jogador(nomeJogadorSalvo, salaCarregada);
        
        //Restaura os itens da mochila
        if (!itensSalvos.isEmpty()){
            String[] nomesItens = itensSalvos.split(",");
            for(String nomeItem : nomesItens ){
                Item item = mapaItens.get(nomeItem.trim().toLowerCase());
                if(item != null){
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
        }
    }
    // Durante o jogo ou introdução da cena: Configuracao.digitar("A porta principal bateu com força atrás de você e a tranca emperrou!");
}
