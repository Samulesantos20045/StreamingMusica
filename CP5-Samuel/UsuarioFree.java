// ==========================
// CLASSE USUARIO FREE
// ==========================

public class UsuarioFree extends Usuario {

    private static final int MAX_PLAYLISTS = 3;

    private int contadorReproducoes;
    private static int anunciosExibidos;

    public UsuarioFree(String nome, String email) {

        super(nome, email);
    }

    @Override
    public void reproduzirMusica(Musica musica) {

        contadorReproducoes++;
        reproducoes++;

        if (contadorReproducoes % 3 == 0) {
            exibirAnuncio();
            anunciosExibidos++;
        }

        System.out.println("🎵 Reproduzindo: "
                + musica.getTitulo());

        historicoReproducao.add(musica);
    }

    @Override
    public void criarPlaylist(String nome) {

        if (playlists.size() >= MAX_PLAYLISTS) {

            System.out.println("❌ Limite de playlists atingido!");
            return;
        }

        playlists.add(new Playlist(nome));

        System.out.println("✅ Playlist criada!");
    }

    private void exibirAnuncio() {

        System.out.println("\n📢 ANÚNCIO:");
        System.out.println("Assine Premium!");
    }

    public static int getAnunciosExibidos() {
        return anunciosExibidos;
    }

    @Override
    public String toString() {
        return getNome() + " (Free)";
    }
}