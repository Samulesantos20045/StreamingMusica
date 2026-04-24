import java.util.ArrayList;

public class Usuario {

    private String nome;
    private String email;
    private ArrayList<Playlist> playlists;
    

    public ArrayList<Playlist> getPlaylists() {
    return playlists;
}

    protected ArrayList<Musica> historicoReproducao;


    // Construtor parametrizado
    public Usuario(String nome, String email) {
    setNome(nome);
    setEmail(email);
    this.playlists = new ArrayList<>();
    this.historicoReproducao = new ArrayList<>();
}

    // Getter / Setter
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email inválido!");
        }
        this.email = email.trim();
    }


    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        this.nome = nome.trim();
    }

    // ======================
    // MÉTODOS
    // ======================
    public void reproduzirMusica(Musica musica) {
        System.out.println("🎵 Reproduzindo: " + musica.getTitulo());
        historicoReproducao.add(musica);
    }

    public void exibirHistorico() {
        System.out.println("\n--- HISTÓRICO DE REPRODUÇÃO ---");
        for (Musica m : historicoReproducao) {
            m.exibir();
        }}
    
    
    public void criarPlaylist(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome inválido!");
            return;
        }

        playlists.add(new Playlist(nome));
        System.out.println("Playlist criada!");
    }

    public void adicionarPlaylist(Playlist playlist) {
        if (playlist == null) {
            throw new IllegalArgumentException("Playlist não pode ser null!");
        }
        playlists.add(playlist);
    }

    public Playlist getPlaylist(int indice) {
        if (indice < 0 || indice >= playlists.size()) {
            return null;
        }
        return playlists.get(indice);
    }

    public void listarPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("Nenhuma playlist criada.");
            return;
        }

        for (int i = 0; i < playlists.size(); i++) {
            System.out.println((i + 1) + " - " + playlists.get(i).getNome());
        }
    }
}