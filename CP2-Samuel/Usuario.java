import java.util.ArrayList;

public class Usuario {

    private String nome;
    private ArrayList<Playlist> playlists = new ArrayList<>();

    public Usuario(String nome) {
        this.nome = nome;
    }

    public void criarPlaylist(String nome) {
        playlists.add(new Playlist(nome));
        System.out.println("Playlist criada!");
    }

    public Playlist getPlaylist(int indice) {
        if (indice >= 0 && indice < playlists.size()) {
            return playlists.get(indice);
        }
        return null;
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