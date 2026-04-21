import java.util.ArrayList;

public class Usuario {

    private String nome;
    private ArrayList<Playlist> playlists;

    // Construtor padrão
    public Usuario() {
        this("Usuário");
    }

    // Construtor parametrizado
    public Usuario(String nome) {
        setNome(nome);
        this.playlists = new ArrayList<>();
    }

    // Getter / Setter
    public String getNome() {
        return nome;
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