import java.util.Scanner;

public class Main{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
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
                    configuracaoJogo();
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
    private static void exibirSobre() {
        System.out.println("\n--- SOBRE O JOGO ---");
        System.out.println("Um suspense interativo baseado em texto.");
        System.out.println("Explore a cabana abandonada e descubra a verdade sobre os acontecimentos de 1984.");
        System.out.println("Desenvolvido em Java (MVP).");
        System.out.println("\nPressione ENTER para voltar ao menu...");
        scanner.nextLine();
    }
}
