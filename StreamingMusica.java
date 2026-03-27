import java.util.ArrayList;
import java.util.Scanner;

class Musica {

    String titulo;
    String artista;
    int duracao;
    String genero;

    public Musica(String titulo, String artista, int duracao, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
    }

    public void mostrar() {
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Artista: " + this.artista);
        System.out.println("Duração: " + formatarDuracao(this.duracao));
        System.out.println("Gênero: " + this.genero);
        System.out.println("_____________________________________");
    }

    public String formatarDuracao(int segundos) {
        int min = segundos / 60;
        int seg = segundos % 60;
        return String.format("%d:%02d", min, seg);
    }
}

public class StreamingMusica {

    static ArrayList<Musica> listaMusicas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static String[] generosCadastrados = {
            "Pop", "Rock", "Jazz", "Eletrônica", "Hip-Hop", "Clássica"
    };

    public static void main(String[] args) {

        adicionarMusicasTeste();

        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("Até logo!");
    }

    public static void exibirMenu() {

        System.out.println("\n=== SISTEMA DE STREAMING ===");
        System.out.println("1 - Cadastrar música");
        System.out.println("2 - Listar músicas");
        System.out.println("3 - Buscar por título");
        System.out.println("4 - Buscar por artista");
        System.out.println("5 - Buscar por gênero");
        System.out.println("6 - Estatísticas");
        System.out.println("0 - Sair");

        System.out.print("Escolha: ");
    }

    public static int lerOpcao() {

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public static void processarOpcao(int opcao) {

        switch (opcao) {

            case 1:
                cadastrarMusica();
                break;

            case 2:
                listarMusicas();
                break;

            case 3:
                buscarPorTitulo();
                break;

            case 4:
                buscarPorArtista();
                break;

            case 5:
                buscarPorGenero();
                break;

            case 6:
                estatisticas();
                break;

            case 0:
                break;

            default:
                System.out.println("Opção inválida");
        }
    }

    public static void cadastrarMusica() {

        System.out.println("\n--- CADASTRAR MÚSICA ---");

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();

        System.out.print("Artista: ");
        String artista = scanner.nextLine();

        String genero;

        while (true) {

            System.out.print("Genero: ");
            genero = scanner.nextLine();

            boolean valido = false;

            for (String g : generosCadastrados) {

                if (g.equalsIgnoreCase(genero)) {
                    valido = true;
                    break;
                }
            }

            if (valido) break;

            System.out.println("Genero inválido!");
        }

        System.out.print("Duração em segundos: ");
        int duracao = Integer.parseInt(scanner.nextLine());

        Musica musica = new Musica(titulo, artista, duracao, genero);
        listaMusicas.add(musica);

        System.out.println("Música cadastrada com sucesso!");
    }

    public static void listarMusicas() {

        System.out.println("\n--- LISTA DE MÚSICAS ---");

        if (listaMusicas.isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }

        for (Musica m : listaMusicas) {
            m.mostrar();
        }
    }

    public static void buscarPorTitulo() {

        System.out.print("Digite o titulo: ");
        String busca = scanner.nextLine();

        for (Musica m : listaMusicas) {

            if (m.titulo.equalsIgnoreCase(busca)) {
                m.mostrar();
                return;
            }
        }

        System.out.println("Música não encontrada");
    }

    public static void buscarPorArtista() {

        System.out.print("Digite o artista: ");
        String busca = scanner.nextLine();

        boolean encontrou = false;

        for (Musica m : listaMusicas) {

            if (m.artista.equalsIgnoreCase(busca)) {
                m.mostrar();
                encontrou = true;
            }
        }

        if (!encontrou)
            System.out.println("Artista não encontrado");
    }

    public static void buscarPorGenero() {

        System.out.print("Digite o genero: ");
        String busca = scanner.nextLine();

        boolean encontrou = false;

        for (Musica m : listaMusicas) {

            if (m.genero.equalsIgnoreCase(busca)) {
                m.mostrar();
                encontrou = true;
            }
        }

        if (!encontrou)
            System.out.println("Gênero não encontrado");
    }

    public static void estatisticas() {

        System.out.println("\n--- ESTATÍSTICAS ---");

        totalMusicas();
        duracaoTotal();
        duracaoMedia();
        generoMaisCadastrado();
    }

    public static void totalMusicas() {

        System.out.println("Total de músicas: " + listaMusicas.size());
    }

    public static void duracaoTotal() {

        int total = 0;

        for (Musica m : listaMusicas) {
            total += m.duracao;
        }

        System.out.println("Duração total: " + formatarDuracao(total));
    }

    public static void duracaoMedia() {

        int total = 0;

        for (Musica m : listaMusicas) {
            total += m.duracao;
        }

        System.out.println("Duração média: " +
                formatarDuracao(total / listaMusicas.size()));
    }

    public static void generoMaisCadastrado() {

        int pop = 0, rock = 0, jazz = 0, eletronica = 0, hiphop = 0, classica = 0;

        for (Musica m : listaMusicas) {

            if (m.genero.equalsIgnoreCase("Pop")) pop++;
            if (m.genero.equalsIgnoreCase("Rock")) rock++;
            if (m.genero.equalsIgnoreCase("Jazz")) jazz++;
            if (m.genero.equalsIgnoreCase("Eletrônica")) eletronica++;
            if (m.genero.equalsIgnoreCase("Hip-Hop")) hiphop++;
            if (m.genero.equalsIgnoreCase("Clássica")) classica++;
        }

        System.out.println("Pop: " + pop);
        System.out.println("Rock: " + rock);
        System.out.println("Jazz: " + jazz);
        System.out.println("Eletrônica: " + eletronica);
        System.out.println("Hip-Hop: " + hiphop);
        System.out.println("Clássica: " + classica);
    }

    public static String formatarDuracao(int segundos) {

        int min = segundos / 60;
        int seg = segundos % 60;

        return String.format("%d:%02d", min, seg);
    }

    public static void adicionarMusicasTeste() {

        listaMusicas.add(new Musica("Bohemian Rhapsody", "Queen", 354, "Rock"));
        listaMusicas.add(new Musica("Billie Jean", "Michael Jackson", 293, "Pop"));
    }
}