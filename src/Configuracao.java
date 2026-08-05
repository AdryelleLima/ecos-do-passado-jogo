import java.util.Scanner;

public class Configuracao{
    // velocidade em milissegundos por caractere (padrão: 30ms)
    private static int velocidadeDigitacao = 30;
    
    public static int pegarVelocidadeDigitacao(){
        return velocidadeDigitacao;
    }
    public static void conjuntoVelocidadeDigitacao(int novaVelocidade){
        velocidadeDigitacao = novaVelocidade;
    }
    // Método responsavel por imprimir texto letra por letra
    public static void digitar(String texto){
        for(char letra : texto.toCharArray()){
            System.out.print(letra);
            System.out.flush();// garante a impressão imediata no terminal
            try{
                if(velocidadeDigitacao > 0){
                    Thread.sleep(velocidadeDigitacao);
                }
            } catch(InterruptedException e){
                    Thread.currentThread().interrupt();
            }
        }
        System.out.println();// pula linha ao final do texto
    }

    // Submenu para alterar as configurações
    public static void menuConfiguracoes(Scanner scanner){
        boolean noMenuConfig = true;

        while(noMenuConfig){
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

            switch(opcao){
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
    private static String descreverVelocidade(){
        switch(velocidadeDigitacao){
            case 0: return "Instantânea";
            case 10: return "Rápida";
            case 30: return "Normal";
            case 60: return "Lenta";
            default: return velocidadeDigitacao + " ms";
        }
    }
}