import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PlayList playlist = new PlayList();

        Video v1 = new Video();
        v1.setTitulo("A Morte");
        v1.setDuracao(60);
        v1.setUrl("videos/teste");
        playlist.adicionarVideo(v1);

        Video v2 = new Video();
        v2.setTitulo("A Pobreza");
        v2.setDuracao(90);
        v2.setUrl("videos/teste");
        playlist.adicionarVideo(v2);
        boolean sair = false;
        while (!sair) {
            System.out.println("\t\t\t================= MENU =================");
            System.out.println("\t\t\t|   1 - Adicionar Vídeo                |");
            System.out.println("\t\t\t|   2 - Consultar Vídeo                |");
            System.out.println("\t\t\t|   3 - Editar Vídeo                   |");
            System.out.println("\t\t\t|   4 - Remover Vídeo                  |");
            System.out.println("\t\t\t|   5 - Mostrar Lista de Reprodução    |");
            System.out.println("\t\t\t|   0 - Sair                           |");
            System.out.println("\t\t\t========================================");
            int opcao = 0;
            System.out.print("\nEscolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\n================================\n");
                    System.out.print("Título: ");
                    String titulo = scan.nextLine();
                    System.out.print("Duração: ");
                    int duracao = scan.nextInt();
                    scan.nextLine();
                    System.out.print("URL: ");
                    String url = scan.nextLine();
                    System.out.print("\n================================\n");
                    Video video = new Video(titulo, url, duracao);
                    playlist.adicionarVideo(video);
                    System.out.println("\nVídeo adicionado com sucesso...\n");
                    break;
                case 2:
                    System.out.print("\n================================\n");
                    System.out.print("Digite o título: ");
                    String tituloConsulta = scan.nextLine();
                    playlist.consultarVideo(tituloConsulta);
                    break;
                case 3:
                    System.out.print("Digite o título do vídeo a ser editado: ");
                    String tituloEditar = scan.nextLine();
                    System.out.print("\n================================\n");
                    System.out.print("Novo Título: ");
                    String novoTitulo = scan.nextLine();
                    System.out.print("Duração: ");
                    int novaDuracao = scan.nextInt();
                    scan.nextLine();
                    System.out.print("URL: ");
                    String novaUrl = scan.nextLine();
                    System.out.print("================================\n");
                    playlist.editarVideo(tituloEditar, novoTitulo, novaDuracao, novaUrl);
                    break;
                case 4:
                    System.out.print("Digite o título: ");
                    String tituloRemover = scan.nextLine();
                    System.out.print("\n================================\n");
                    playlist.removerVideo(tituloRemover);
                    break;
                case 5:
                    playlist.mostrarLista();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}