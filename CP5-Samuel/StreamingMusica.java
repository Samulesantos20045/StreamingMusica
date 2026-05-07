
// CLASSE PRINCIPAL


import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {

    static ArrayList<Musica> musicas = new ArrayList<>();

    static ArrayList<Usuario> usuarios = new ArrayList<>();

    static Usuario usuarioLogado = null;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        carregarDados();

        menuInicial();
    }

    public static void carregarDados() {

        musicas.add(new Musica(
                "Blinding Lights",
                "The Weeknd",
                200,
                "Pop"));

        musicas.add(new Musica(
                "Numb",
                "Linkin Park",
                180,
                "Rock"));

        musicas.add(new Musica(
                "Billie Jean",
                "Michael Jackson",
                240,
                "Pop"));

        usuarios.add(new UsuarioFree(
                "Ana",
                "ana@email.com"));

        usuarios.add(new UsuarioPremium(
                "Carlos",
                "carlos@email.com",
                "Anual"));
    }

    public static void menuInicial() {

        int opcao;

        do {

            System.out.println("\n=== SISTEMA DE STREAMING ===");

            System.out.println("1. Criar usuário");
            System.out.println("2. Login");
            System.out.println("3. Listar usuários");
            System.out.println("0. Sair");

            System.out.print("Escolha: ");

            opcao = lerIntSeguro();

            switch (opcao) {

                case 1:
                    criarUsuario();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    listarUsuarios();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    public static void menuUsuario() {

        int opcao;

        do {

            System.out.println("\n=== MENU USUÁRIO ===");

            System.out.println("1. Reproduzir música");
            System.out.println("2. Histórico");
            System.out.println("3. Criar playlist");
            System.out.println("4. Gerenciar playlists");
            System.out.println("5. Playlist automática");
            System.out.println("6. Estatísticas");
            System.out.println("0. Logout");

            opcao = lerIntSeguro();

            switch (opcao) {

                case 1:
                    reproduzirMusica();
                    break;

                case 2:
                    usuarioLogado.exibirHistorico();
                    break;

                case 3:
                    criarPlaylist();
                    break;

                case 4:
                    gerenciarPlaylists();
                    break;

                case 5:
                    playlistAutomatica();
                    break;

                case 6:
                    exibirEstatisticas();
                    break;

                case 0:
                    usuarioLogado = null;
                    System.out.println("Logout realizado!");
                    break;
            }

        } while (opcao != 0);
    }

    public static void criarUsuario() {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.println("1. Free");
        System.out.println("2. Premium");

        int tipo = lerIntSeguro();

        if (tipo == 1) {

            usuarios.add(new UsuarioFree(nome, email));

        } else {

            System.out.print("Plano: ");
            String plano = scanner.nextLine();

            usuarios.add(new UsuarioPremium(
                    nome,
                    email,
                    plano));
        }

        System.out.println(" Usuário criado!");
    }

    public static void listarUsuarios() {

        for (int i = 0; i < usuarios.size(); i++) {

            System.out.println((i + 1)
                    + ". "
                    + usuarios.get(i));
        }
    }

    public static void login() {

        listarUsuarios();

        System.out.print("Escolha: ");

        int escolha = lerIntSeguro() - 1;

        if (escolha < 0 || escolha >= usuarios.size()) {

            System.out.println("Usuário inválido!");
            return;
        }

        usuarioLogado = usuarios.get(escolha);

        System.out.println(" Login realizado: "
                + usuarioLogado);

        menuUsuario();
    }

    public static void listarMusicas() {

        for (int i = 0; i < musicas.size(); i++) {

            System.out.println((i + 1) + " - ");

            musicas.get(i).exibir();
        }
    }

    public static void reproduzirMusica() {

        listarMusicas();

        System.out.print("Escolha a música: ");

        int index = lerIntSeguro() - 1;

        if (index < 0 || index >= musicas.size()) {

            System.out.println("Música inválida!");
            return;
        }

        usuarioLogado.reproduzirMusica(
                musicas.get(index));
    }

    public static void criarPlaylist() {

        System.out.print("Nome da playlist: ");

        String nome = scanner.nextLine();

        usuarioLogado.criarPlaylist(nome);
    }

    public static void gerenciarPlaylists() {

        int opcao;

        do {

            System.out.println("\n=== PLAYLISTS ===");

            System.out.println("1. Listar");
            System.out.println("2. Adicionar música");
            System.out.println("3. Remover música");
            System.out.println("0. Voltar");

            opcao = lerIntSeguro();

            switch (opcao) {

                case 1:
                    usuarioLogado.listarPlaylists();
                    break;

                case 2:
                    adicionarMusicaPlaylist();
                    break;

                case 3:
                    removerMusicaPlaylist();
                    break;
            }

        } while (opcao != 0);
    }

    public static void adicionarMusicaPlaylist() {

        usuarioLogado.listarPlaylists();

        System.out.print("Playlist: ");

        int p = lerIntSeguro() - 1;

        Playlist playlist = usuarioLogado.getPlaylist(p);

        if (playlist == null) {

            System.out.println("Playlist inválida!");
            return;
        }

        listarMusicas();

        System.out.print("Música: ");

        int m = lerIntSeguro() - 1;

        if (m < 0 || m >= musicas.size()) {

            System.out.println("Música inválida!");
            return;
        }

        playlist.adicionarMusica(musicas.get(m));

        System.out.println(" Música adicionada!");
    }

    public static void removerMusicaPlaylist() {

        usuarioLogado.listarPlaylists();

        System.out.print("Playlist: ");

        int p = lerIntSeguro() - 1;

        Playlist playlist = usuarioLogado.getPlaylist(p);

        if (playlist == null) {

            System.out.println("Playlist inválida!");
            return;
        }

        playlist.listarMusicas();

        System.out.print("Música: ");

        int m = lerIntSeguro() - 1;

        playlist.removerMusica(m);
    }

    public static void playlistAutomatica() {

        System.out.println("\n=== PLAYLIST AUTOMÁTICA ===");

        System.out.println("1. Top 10");
        System.out.println("2. Recomendadas");
        System.out.println("3. Recentes");

        int op = lerIntSeguro();

        PlaylistAutomatica p = null;

        switch (op) {

            case 1:
                p = new PlaylistAutomatica(
                        "Top 10",
                        "Top");
                break;

            case 2:
                p = new PlaylistAutomatica(
                        "Recomendadas",
                        "Recomendadas");
                break;

            case 3:
                p = new PlaylistAutomatica(
                        "Recentes",
                        "Recentes");
                break;

            default:
                System.out.println("Inválido!");
                return;
        }

        p.atualizar(musicas);

        p.reproduzir();
    }

    public static void exibirEstatisticas() {

        int free = 0;
        int premium = 0;

        int repFree = 0;
        int repPremium = 0;

        for (Usuario u : usuarios) {

            if (u instanceof UsuarioFree) {

                free++;
                repFree += u.getReproducoes();

            } else if (u instanceof UsuarioPremium) {

                premium++;
                repPremium += u.getReproducoes();
            }
        }

        int total = repFree + repPremium;

        System.out.println("\n=== ESTATÍSTICAS ===");

        System.out.println("Usuários: "
                + usuarios.size());

        System.out.println("Free: " + free);

        System.out.println("Premium: " + premium);

        System.out.println("\nReproduções totais: "
                + total);

        System.out.println("Free: " + repFree);

        System.out.println("Premium: " + repPremium);

        System.out.println("\nAnúncios exibidos: "
                + UsuarioFree.getAnunciosExibidos());
    }

    public static int lerIntSeguro() {

        while (true) {

            try {

                return Integer.parseInt(
                        scanner.nextLine());

            } catch (Exception e) {

                System.out.print("Digite número válido: ");
            }
        }
    }
}