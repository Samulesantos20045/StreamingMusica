import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {

    static ArrayList<Musica> musicas = new ArrayList<>();
    static Usuario usuario = new Usuario("Usuário");
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;
        do {
            exibirMenu();
            opcao = lerIntSeguro();
            processarOpcao(opcao);
        } while (opcao != 0);
    }

    public static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE STREAMING ===");
        System.out.println("1. Cadastrar música");
        System.out.println("2. Listar músicas");
        System.out.println("3. Buscar música");
        System.out.println("4. Criar playlist");
        System.out.println("5. Gerenciar playlists");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
    }

    public static int lerIntSeguro() {
        while (true) {
            try {
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (Exception e) {
                System.out.print("Digite um número válido: ");
            }
        }
    }

   

    public static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarMusica();
            case 2 -> listarMusicas();
            case 3 -> buscarMusica();
            case 4 -> criarPlaylist();
            case 5 -> gerenciarPlaylists();
            case 0 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida!");
        }
    }

   public static void cadastrarMusica() {

    String titulo;
    String artista;
    int duracao;
    String genero;

    // ===== TÍTULO =====
    while (true) {
        try {
            titulo = lerStringObrigatoria("Título: ");
            new Musica(titulo, "teste", 60, "pop"); // testa validação
            break;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ===== ARTISTA =====
    while (true) {
        try {
            artista = lerStringObrigatoria("Artista: ");
            new Musica("teste", artista, 60, "pop");
            break;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ===== DURAÇÃO =====
    while (true) {
        try {
            System.out.print("Duração (segundos): ");
            duracao = lerIntSeguro();
            new Musica("teste", "teste", duracao, "pop");
            break;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ===== GÊNERO =====
    while (true) {
        try {
            genero = lerStringObrigatoria("Gênero: ");
            new Musica("teste", "teste", 60, genero);
            break;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Agora sim cria a música
    musicas.add(new Musica(titulo, artista, duracao, genero));
    System.out.println("Música cadastrada!");
}

    public static void listarMusicas() {
        if (musicas.isEmpty()) {
            System.out.println("Nenhuma música cadastrada.");
            return;
        }

        for (int i = 0; i < musicas.size(); i++) {
            System.out.println((i + 1) + " - ");
            musicas.get(i).exibir();
        }
    }

    public static void buscarMusica() {
        String busca = lerStringObrigatoria("Digite busca: ");

        boolean encontrou = false;

        for (Musica m : musicas) {
            if (m.contemTitulo(busca) || m.contemArtista(busca)) {
                m.exibir();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma música encontrada!");
        }
    }

    public static void criarPlaylist() {
        String nome = lerStringObrigatoria("Nome da playlist: ");
        usuario.criarPlaylist(nome);
    }

    public static void gerenciarPlaylists() {

        int opcao;

        do {
            System.out.println("\n--- GERENCIAR PLAYLISTS ---");
            System.out.println("1. Listar minhas playlists");
            System.out.println("2. Adicionar música");
            System.out.println("3. Remover música");
            System.out.println("4. Exibir detalhes");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            opcao = lerIntSeguro();

            switch (opcao) {
                case 1 -> usuario.listarPlaylists();
                case 2 -> adicionarMusicaNaPlaylist();
                case 3 -> removerMusicaDaPlaylist();
                case 4 -> exibirDetalhesPlaylist();
            }

        } while (opcao != 0);
    }

    public static void adicionarMusicaNaPlaylist() {

        usuario.listarPlaylists();
        System.out.print("Escolha a playlist: ");
        int pIndex = lerIntSeguro() - 1;

        Playlist p = usuario.getPlaylist(pIndex);

        if (p == null) {
            System.out.println("Playlist inválida!");
            return;
        }

        listarMusicas();
        System.out.print("Escolha a música: ");
        int mIndex = lerIntSeguro() - 1;

        if (mIndex < 0 || mIndex >= musicas.size()) {
            System.out.println("Música inválida!");
            return;
        }

        p.adicionarMusica(musicas.get(mIndex));
        System.out.println("Música adicionada!");
    }

    public static void removerMusicaDaPlaylist() {

        usuario.listarPlaylists();
        System.out.print("Escolha a playlist: ");
        int pIndex = lerIntSeguro() - 1;

        Playlist p = usuario.getPlaylist(pIndex);

        if (p == null) {
            System.out.println("Playlist inválida!");
            return;
        }

        p.listarMusicas();
        System.out.print("Escolha a música: ");
        int mIndex = lerIntSeguro() - 1;

        p.removerMusica(mIndex);
    }

    public static void exibirDetalhesPlaylist() {

        usuario.listarPlaylists();
        System.out.print("Escolha a playlist: ");
        int pIndex = lerIntSeguro() - 1;

        Playlist p = usuario.getPlaylist(pIndex);

        if (p == null) {
            System.out.println("Playlist inválida!");
            return;
        }

        System.out.println("\nPlaylist: " + p.getNome());
        p.listarMusicas();
        System.out.println("Quantidade: " + p.getQuantidadeMusicas());
    }
    // metodo validador
     public static String lerStringObrigatoria(String msg) {
        while (true) {
            
            System.out.print(msg);
            String texto = scanner.nextLine();

            if (texto != null && !texto.trim().isEmpty()) {
                return texto;
            }

            System.out.println("Entrada inválida!");
        }
    }
}