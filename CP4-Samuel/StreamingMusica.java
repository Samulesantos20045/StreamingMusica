import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class StreamingMusica {

    static ArrayList<Musica> musicas = new ArrayList<>();
    static Usuario usuario = new Usuario("Samuel","Samuel@gmail.com");
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("entrou no mein");
        int opcao;
        exibirLogin();
        do {
            
            escolhaConta();
            opcao = lerIntSeguro();
            processarOpcao(opcao);
        } while (opcao != 0);
    }

    public static void escolhaConta(){
        System.out.println(" === ESCOLHA O TIPO DE CONTA ===");
        int escolha;
        System.out.println("1. Free (Gratuito)");
        System.out.println("2. Premium (Pago)");
        escolha = scanner.nextInt();
        

        switch (escolha) {
            case 1:
                planoFree();
                  break;
            case 2:
                planoPremium();
                  break;
            case 0:
                System.out.println("Logof...");
                break;
        
            default:
                System.out.println("Informe uma opção valida!!!");
                break;
        }
    }

      public static void pacoteMusicas(){
                Musica m1 = new Musica("Love", "Jack", 100, "rock");
                Musica m2 = new Musica("life", "Jack", 100, "rock");
                Musica m3 = new Musica("pain", "Jack", 100, "rock");
                Musica m4 = new Musica("sorry", "Jack", 100, "rock");
                musicas.add(m1);
                musicas.add(m2);
                musicas.add(m3);
                musicas.add(m4);
    }
    public static void planoFree(){
                UsuarioFree uFree = new UsuarioFree("Samuel", "Samuel@gmail.com");
                pacoteMusicas();
                int opcaof;
                opcaof = scanner.nextInt();
                do{
                
                System.out.println("1. Reproduzir música");
                 System.out.println("2. Ver histórico");
                 System.out.println("3. Criar playlist (máx. 3)");
                 System.out.println("4. 💎 Fazer upgrade para Premium");
                 System.out.println("0. Sair");
                 int escolhaDF1;
                 escolhaDF1 = scanner.nextInt();
                 switch (escolhaDF1) {
                    case 1:
                        uFree.reproduzirMusica(musicas.get(0));
                        break;
                    case 2:
                        uFree.exibirHistorico();
                        break;
                    case 3:
                        uFree.criarPlaylist("As Melhores free");
                        break;
                    case 4:
                        planoPremium();
                        break;
                    case 0 :
                        opcaof = 0;
                        break;
                 
                    default:
                        break;
                 }
                }while (opcaof!=0);
                    
                
            }
    public static void planoPremium(){

        UsuarioPremium uPremium = new UsuarioPremium("Samuel", "Sam@gmail.com", null);
                pacoteMusicas();
                System.out.println("Escolha o plano Premium:\r\n" + //
                                    "1. Mensal (R$ 19,90)\r\n" + //
                                    "2. Anual (R$ 199,00)\r\n" + //
                                    "3. Familiar (R$ 29,90)");        
                int opcao;

                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        uPremium.setPlano("Mensal");
                    case 2:
                         uPremium.setPlano("Anual");
                        break;
                    case 3:
                          uPremium.setPlano("Familiar");
                        break;
                
                    default:
                        System.out.println("Informe um plano valido!!!");
                        break;
                }
               
                 int escolhaDP1;
                 do{
                
                System.out.println("1. Reproduzir música (Alta Qualidade)\r\n" + //
                                   "2. Ver histórico\r\n" + //
                                   "3. Criar playlist (ilimitado)\r\n" + //
                                   "4. Baixar música\r\n" + //
                                   "5. Ver músicas baixadas\r\n" + //
                                   "0. Sair");
                
                 escolhaDP1 = scanner.nextInt();
                 switch (escolhaDP1) {
                    case 1:
                        uPremium.reproduzirMusica(musicas.get(1));
                        break;
                    case 2:
                        uPremium.exibirHistorico();
                        break;
                    case 3:
                        uPremium.criarPlaylist("Melhores Premium");
                        break;
                    case 4:
                        uPremium.baixarMusica(musicas.get(2));
                        break;
                     case 5:
                        uPremium.listarMusicasBaixadas();
                        break;
                    case 0 :
                        System.out.println("saindo...");
                        escolhaDP1 = 0;
                        break;
                 
                    default:
                          System.out.println("informe uma Opção valida!!!");
                        break;
                 }
                
                }while (escolhaDP1!=0); 
                


            

    }

    public static void exibirLogin(){
        System.out.println("=== BEM VINDO AO STREAMING DE MÚSICA ===");
        
        boolean opcao1 = false;
        do {
            
        System.out.println("informe o seu Nome: ");
        String nomeU = scanner.nextLine();

        System.out.println("informe o seu Email: ");
        String emailU = scanner.nextLine();
        if(usuario.getNome().equals(nomeU) && usuario.getEmail().equals(emailU)){
        System.out.println("Login realizado com Sucesso!!!");
        opcao1 = true;
        } else {
            System.out.println("Informe o Usuario Válido!!!");
}
            
        } while (opcao1 == false);


    }

    public static void exibirMenu() {
         System.out.println("entrou no mein");
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