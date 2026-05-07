// ==========================
// CLASSE USUARIO (ABSTRATA)
// ==========================

import java.util.ArrayList;

public abstract class Usuario {

    private String nome;
    private String email;

    protected int reproducoes;

    protected ArrayList<Playlist> playlists;
    protected ArrayList<Musica> historicoReproducao;

    public Usuario(String nome, String email) {

        setNome(nome);
        setEmail(email);

        playlists = new ArrayList<>();
        historicoReproducao = new ArrayList<>();
    }

    public abstract void reproduzirMusica(Musica musica);

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getReproducoes() {
        return reproducoes;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setNome(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido!");
        }

        this.nome = nome;
    }

    public void setEmail(String email) {

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido!");
        }

        this.email = email;
    }

    public void criarPlaylist(String nome) {

        playlists.add(new Playlist(nome));

        System.out.println("✅ Playlist criada!");
    }

    public void listarPlaylists() {

        if (playlists.isEmpty()) {

            System.out.println("Nenhuma playlist.");
            return;
        }

        for (int i = 0; i < playlists.size(); i++) {

            System.out.println((i + 1)
                    + " - "
                    + playlists.get(i).getNome());
        }
    }

    public Playlist getPlaylist(int indice) {

        if (indice < 0 || indice >= playlists.size()) {
            return null;
        }

        return playlists.get(indice);
    }

    public void exibirHistorico() {

        if (historicoReproducao.isEmpty()) {

            System.out.println("Histórico vazio!");
            return;
        }

        for (Musica m : historicoReproducao) {
            m.exibir();
        }
    }
}