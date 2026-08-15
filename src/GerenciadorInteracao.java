import java.util.Scanner;

public class GerenciadorInteracao{
    // Variaveis de estado do mundo(flags)
    private static boolean geradorLigado = false;
    private static boolean geradorComCombustivel = false;
    private static boolean gravadorComPilhas = false;
    

    public static void processarUso(Jogador jogador, String itemUsar, Scanner scanner){
        Configuracao.limparTela();
        Sala salaAtual = jogador.pegarSalaAtual();

        //1. uso de chaves
        if (itemUsar.contains("chave")){
            usarChave(jogador, salaAtual);
        }
        //2. colocar gasolina no gerador
        else if(itemUsar.contains("gasolina")|| itemUsar.contains("galao")){
            usarGasolina(jogador, salaAtual);
        }
        // 3. Ligar o Gerador
        else if (itemUsar.contains("gerador") || itemUsar.contains("interruptor")) {
            usarGerador(salaAtual);
        } 
        // 4. Colocar Pilhas no Gravador
        else if (itemUsar.contains("pilha") || itemUsar.contains("pilhas")) {
            usarPilhas(jogador);
        } 
        // 5. Tocar a Fita Cassete
        else if (itemUsar.contains("fita") || itemUsar.contains("gravador")) {
            usarFita(jogador, itemUsar);
        }
        else {
            Configuracao.digitar("Eu não posso usar isso agora ou desse jeito.");
        }
        System.out.println("\n[ Pressione ENTER para continuar... ]");
        scanner.nextLine();
    }
    // --- MÉTODOS ESPECÍFICOS DE CADA AÇÃO ---

    private static void usarChave(Jogador jogador, Sala salaAtual) {
        // 1. Chave do Porão (Usada na Sala de Jantar / Acesso à Escada do Porão)
    if (jogador.possuiItem("Chave do Porão")) {
        Sala escadaPorao = salaAtual.pegarSaida("leste"); // Conexão da Sala de Jantar com a escada
        if (salaAtual.pegarNome().equalsIgnoreCase("Sala de Jantar") && escadaPorao != null && escadaPorao.estaTrancada()) {
            escadaPorao.destrancarCom("Chave do Porão");
            Configuracao.digitar("Insero a Chave do Porão na fechadura pesada. A porta para o porão se destranca com um estalo!");
            return;
        }
    }

    // 2. Chave do Quarto de Visita / Infantil (Usada no Hall)
    if (jogador.possuiItem("Chave do Quarto de Visita")) {
        Sala quartoInfantil = salaAtual.pegarSaida("nordeste");
        if (salaAtual.pegarNome().equalsIgnoreCase("Hall") && quartoInfantil != null && quartoInfantil.estaTrancada()) {
            quartoInfantil.destrancarCom("Chave do Quarto de Visita");
            Configuracao.digitar("Giro a chave dourada na fechadura do Quarto Infantil. A porta range e se abre!");
            return;
        }
    }

    // 3. Chave do Quarto do Morador (Usada no Hall)
    if (jogador.possuiItem("Chave do Quarto do Morador")) {
        Sala quartoMorador = salaAtual.pegarSaida("leste");
        if (salaAtual.pegarNome().equalsIgnoreCase("Hall") && quartoMorador != null && quartoMorador.estaTrancada()) {
            quartoMorador.destrancarCom("Chave do Quarto do Morador");
            Configuracao.digitar("A chave desgastada entra com facilidade. O Quarto do Morador está destrancado.");
            return;
        }
    }

    // 4. Chave do Escritório (Usada no Hall)
    if (jogador.possuiItem("Chave do Escritorio")) {
        Sala escritorio = salaAtual.pegarSaida("norte");
        if (salaAtual.pegarNome().equalsIgnoreCase("Hall") && escritorio != null && escritorio.estaTrancada()) {
            escritorio.destrancarCom("Chave do Escritorio");
            Configuracao.digitar("Uso a chave ornamentada no Escritório. O mecanismo da tranca cede suavemente.");
            return;
        }
    }

    // 5. Chave do Guarda-Roupa (Usada dentro do Quarto do Morador)
    if (jogador.possuiItem("Chave do Guarda-Roupa") && salaAtual.pegarNome().equalsIgnoreCase("Quarto Morador")) {
        Item guardaRoupa = salaAtual.pegarItemPresente();
        if (guardaRoupa != null && guardaRoupa.pegarNome().equalsIgnoreCase("Guarda-Roupa Grande")) {
            Configuracao.digitar("Destranco o Guarda-Roupa Grande com a chave simples. As portas se abrem devagar...");
            // Se o guarda-roupa tiver um item escondido (como o esqueleto), ele fica acessível
            return;
        }
    }

    // Caso o jogador tente usar uma chave na sala errada ou sem porta trancada por perto
    Configuracao.digitar("Nenhuma das chaves no seu inventário parece servir para a fechadura mais próxima aqui.");
}
    private static void usarGasolina(Jogador jogador, Sala salaAtual) {
        if (salaAtual.pegarNome().equalsIgnoreCase("Porão")) {
            if (jogador.possuiItem("Galão de Gasolina")) {
                geradorComCombustivel = true;
                Configuracao.digitar("Eu despejo todo o combustível do Galão dentro do tanque do Gerador.");
                Configuracao.digitar("O Gerador agora está abastecido e pronto para ser ligado!");
            } else {
                Configuracao.digitar("Eu não tenho o Galão de Gasolina no meu inventário.");
            }
        } else {
            Configuracao.digitar("Não há onde usar gasolina neste local.");
        }
    }
    private static void usarGerador(Sala salaAtual) {
        if (salaAtual.pegarNome().equalsIgnoreCase("Porão")) {
            if (geradorComCombustivel) {
                geradorLigado = true;
                Configuracao.digitar("VRUMMM! O gerador ganha vida rugindo alto e iluminando o painel de energia!");
                Configuracao.digitar("[!] O circuito elétrico da casa foi reestabelecido!");
            } else {
                Configuracao.digitar("O gerador tenta dar partida, mas o tanque está totalmente vazio!");
            }
        } else {
            Configuracao.digitar("Não há nenhum gerador aqui.");
        }
    }
    private static void usarPilhas(Jogador jogador) {
        if (jogador.possuiItem("Gravador de Áudio") && jogador.possuiItem("Pilhas")) {
            gravadorComPilhas = true;
            Configuracao.digitar("Eu encaixo as duas pilhas de 1,5V no compartimento do Gravador de Áudio. A luz vermelha pisca!");
        } else {
            Configuracao.digitar("Eu preciso ter tanto o Gravador de Áudio quanto as Pilhas no meu inventário.");
        }
    }
    
    private static void usarFita(Jogador jogador, String entradaAlvo) {
        if (!jogador.possuiItem("Gravador de Áudio")) {
            Configuracao.digitar("Preciso ter um Gravador de Áudio na mochila para tocar uma fita.");
            return;
        }

        if (!gravadorComPilhas) {
            Configuracao.digitar("Tento ligar o gravador, mas ele está sem pilhas.");
            return;
        }

        // Checa qual fita o jogador quer tocar ou qual fita ele possui
        if ((entradaAlvo.contains("1") || entradaAlvo.contains("porque?")|| entradaAlvo.contains("fita")) && jogador.possuiItem("Fita Cassete #01")) {
            tocarAudio("FITA CASSETE #01", 
            "\"até ontem estava tudo bem, parecia perfeito demais, calma, diversão, brincadeiras...\n"+
            "guiando os alunos do acampamento por uma trilha tranquila...\n"+
            "porque ela estava lá (sua voz soava seria)... se eu pudesse mudar alguma coisa (um tom de arrependimento)...\n"+
            " naquele momento. Talvez... ela estivesse viva hoje, minha pequena (sua voz termina melancolica)\""
            );
        } 
        else if ((entradaAlvo.contains("2") || entradaAlvo.contains("acusações")|| entradaAlvo.contains("fita")) && jogador.possuiItem("Fita Cassete #02")) {
            tocarAudio("FITA CASSETE #02",  
            "\" Aconteceu de novo, o mesmo que fizeram com minha filha (sua voz parecia frustada)...\n" +
            "suspeitam de mim, não entendo o porque, essas acusações... me fizeram perder o que me restava\n"+
            "meu trabalho, vida social, meu relacionamento com a minha esposa agora... (suspira ao fundo)\n"+
            "o que preciso fazer para que tudo volte ao que era? preciso descobrir como fazer isso.\n"+
            "Talvez só assim, eu possa me sentir em paz novamente... (desliga) \"");
        } 
        else if ((entradaAlvo.contains("3") || entradaAlvo.contains("pistas") || entradaAlvo.contains("fita")) && jogador.possuiItem("Fita Cassete #03")) {
            tocarAudio("FITA CASSETE #03", 
            "\" Semanas pesquisando (sua voz parecia cansada)... ligando os pontos, os locais que aconteceram.\n" +
            "as possiveis suspeitas, tentando entender sua motivação para continuar matando as pobres crianças\n"+
            "precisava escoder as provas que coloquei no escritorio, onde ninguem além de mim saiba...\n"+
            "até que eu possa ter certeza do verdadeiro assasino. Se passou tanto tempo... cortaram a luz em algum momento\n"+
            "agora eu preciso ficar abastecendo o gerador do porão, para continuar minha investigação. \"");
        }  
        else if ((entradaAlvo.contains("4") || entradaAlvo.contains("decisão") || entradaAlvo.contains("fita")) && jogador.possuiItem("Fita Cassete #04")) {
            tocarAudio("FITA CASSETE #04", 
            "\" Ele sabe que eu sei, por causa disso fica me enviando cartas de ameaça, achando que eu tenho algo a perder,\n" +
            "com essas ameaças cheias de medo, ele já tirou de mim, o que eu tinha de mais precioso na vida...\n"+
            "não dá para traze-la de volta, mas ainda continuo tendo pesadelos daquele dia...se o denuncio à polícia,\n"+
            "ele ira me matar antes de ser preso, se o mato me tornarei o assassino que me acusaram ser.\n"+
            "tenho que ficar preparado para uma invasão iminente, mesmo não tendo pelo que lutar, farei o possível para não perder de propósito... seja o que Deus quiser\"");
        }
        else {
            Configuracao.digitar("Você não possui a fita indicada no seu inventário.");
        }
    }
    private static void tocarAudio(String titulo, String transcricao) {
        Configuracao.digitar("Insere a " + titulo + " e aperto PLAY...\n");
        System.out.println("--------------------------------------------------");
        System.out.println("  ÁUDIO REPRODUZINDO: " + titulo);
        System.out.println("--------------------------------------------------");
        Configuracao.digitar(transcricao);
        System.out.println("\n--------------------------------------------------");
    }

    // Getters caso precise verificar o estado do gerador em outras partes do código
    public static boolean isGeradorLigado() { return geradorLigado; }
}
