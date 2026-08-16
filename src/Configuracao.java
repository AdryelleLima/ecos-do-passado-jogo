import java.util.Scanner;

public class Configuracao {
    // velocidade em milissegundos por caractere (padrão: 30ms)
    private static int velocidadeDigitacao = 0;

    public static int pegarVelocidadeDigitacao() {
        return velocidadeDigitacao;
    }

    public static void conjuntoVelocidadeDigitacao(int novaVelocidade) {
        velocidadeDigitacao = novaVelocidade;
    }

    // Método responsavel por imprimir texto letra por letra
    public static void digitar(String texto) {
        AtomicBoolean pular = new AtomicBoolean(false);

        // Thread para monitorar se o jogador pressionou ENTER
        Thread escutador = new Thread(() -> {
            try {
                if (System.in.available() > 0 || System.in.read() != -1) {
                    pular.set(true);
                }
            } catch (Exception e) {
                // Ignora exceções de leitura de stream
            }
        });

        escutador.setDaemon(true); // Encerra se a aplicação principal fechar
        escutador.start();

        for (char letra : texto.toCharArray()) {
            System.out.print(letra);
            System.out.flush();

            if (!pular.get() && velocidadeDigitacao > 0) {
                try {
                    Thread.sleep(velocidadeDigitacao);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        System.out.println();// pula linha ao final do texto

    }

    // Submenu para alterar as configurações
    public static void menuConfiguracoes(Scanner scanner) {
        boolean noMenuConfig = true;

        while (noMenuConfig) {
            limparTela();
            System.out.println("\n==================================================");
            System.out.println("            CONFIGURAÇÕES DE TEXTO               ");
            System.out.println("==================================================");
            System.out.println("Velocidade atual: " + descreverVelocidade());
            System.out.println("1. Rápida (10 ms)");
            System.out.println("2. Normal (30 ms)");
            System.out.println("3. Lenta  (60 ms)");
            System.out.println("4. Instantânea (0 ms - sem efeito)");
            System.out.println("5. Testar Velocidade Atual");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.println("==================================================");
            System.out.print("Escolha uma opção > ");

            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    velocidadeDigitacao = 10;
                    digitar("Velocidade alterada para Rápida!");
                    break;
                case "2":
                    velocidadeDigitacao = 30;
                    digitar("Velocidade alterada para Normal!");
                    break;
                case "3":
                    velocidadeDigitacao = 60;
                    digitar("Velocidade alterada para Lenta!");
                    break;
                case "4":
                    velocidadeDigitacao = 0;
                    System.out.println("Efeito de digitação desativado!");
                    break;
                case "5":
                    digitar("Esta é uma demosntração de como as cartas e descrições das salas serão exibidas durante o jogo...");
                    break;
                case "6":
                    noMenuConfig = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static String descreverVelocidade() {
        switch (velocidadeDigitacao) {
            case 0:
                return "Instantânea";
            case 10:
                return "Rápida";
            case 30:
                return "Normal";
            case 60:
                return "Lenta";
            default:
                return velocidadeDigitacao + " ms";
        }
    }

    public static void limparTela() {
        try {
            // Limpa o terminal no windows (cmd)
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Limpa o terminal no linux e macOS
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Fallback: imprimi linhas em branco caso o comando falhe em algum terminal
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    public static void exibirCabecalho(String subtitulo) {
        System.out.println("==================================================");
        System.out.println("  ECOS DO PASSADO  |  " + subtitulo.toUpperCase()   );
        System.out.println("==================================================\n");
    }

    public static void exibirCabecalho() {
        System.out.println("==================================================");
        System.out.println("   ECOS DO PASSADO: O SEGREDO DA CASA ABANDONADA  ");
        System.out.println("==================================================\n");
    }
}
