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
            opcao = scanner.nextInt();
            scanner.nextLine();
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

    public static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarMusica();
                break;
            case 2:
                listarMusicas();
                break;
            case 3:
                buscarMusica();
                break;
            case 4:
                criarPlaylist();
                break;
            case 5:
                gerenciarPlaylists(); // 🔥 ADICIONADO
                break;
        }
    }

    public static void cadastrarMusica() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Artista: ");
        String artista = scanner.nextLine();

        System.out.print("Duração (segundos): ");
        int duracao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Gênero: ");
        String genero = scanner.nextLine();

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
        System.out.print("Digite busca: ");
        String busca = scanner.nextLine();

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
        System.out.print("Nome da playlist: ");
        String nome = scanner.nextLine();
        usuario.criarPlaylist(nome);
    }

    // ===========================
    // 🔥 MENU 5 - GERENCIAMENTO
    // ===========================

    public static void gerenciarPlaylists() {

        int opcao;

        do {
            System.out.println("\n--- GERENCIAR PLAYLISTS ---");
            System.out.println("1. Listar minhas playlists");
            System.out.println("2. Adicionar música a uma playlist");
            System.out.println("3. Remover música de uma playlist");
            System.out.println("4. Exibir detalhes de uma playlist");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    usuario.listarPlaylists();
                    break;
                case 2:
                    adicionarMusicaNaPlaylist();
                    break;
                case 3:
                    removerMusicaDaPlaylist();
                    break;
                case 4:
                    exibirDetalhesPlaylist();
                    break;
            }

        } while (opcao != 0);
    }

    public static void adicionarMusicaNaPlaylist() {

        usuario.listarPlaylists();
        System.out.print("Escolha a playlist numero: ");
        int pIndex = scanner.nextInt() - 1;

        Playlist p = usuario.getPlaylist(pIndex);

        if (p == null) {
            System.out.println("Playlist inválida!");
            return;
        }

        listarMusicas();
        System.out.print("Escolha a música: ");
        int mIndex = scanner.nextInt() - 1;

        if (mIndex < 0 || mIndex >= musicas.size()) {
            System.out.println("Música inválida!");
            return;
        }

        p.adicionarMusica(musicas.get(mIndex));
        System.out.println("Música adicionada à playlist!");
    }

    public static void removerMusicaDaPlaylist() {

        usuario.listarPlaylists();
        System.out.print("Escolha a playlist: ");
        int pIndex = scanner.nextInt() - 1;

        Playlist p = usuario.getPlaylist(pIndex);

        if (p == null) {
            System.out.println("Playlist inválida!");
            return;
        }

        p.listarMusicas();
        System.out.print("Escolha a música para remover: ");
        int mIndex = scanner.nextInt() - 1;

        p.removerMusica(mIndex);
    }

    public static void exibirDetalhesPlaylist() {

        usuario.listarPlaylists();
        System.out.print("Escolha a playlist: ");
        int pIndex = scanner.nextInt() - 1;

        Playlist p = usuario.getPlaylist(pIndex);

        if (p == null) {
            System.out.println("Playlist inválida!");
            return;
        }

        System.out.println("\nPlaylist: " + p.getNome());
        p.listarMusicas();
        System.out.println("Quantidade: " + p.getQuantidadeMusicas());
    }
}