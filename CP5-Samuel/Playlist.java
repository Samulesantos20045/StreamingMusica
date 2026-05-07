// ==========================
// CLASSE PLAYLIST
// ==========================

import java.util.ArrayList;

public class Playlist {

    private String nome;
    private ArrayList<Musica> musicas;

    public Playlist() {
        this("Playlist");
    }

    public Playlist(String nome) {

        setNome(nome);
        musicas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setNome(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido!");
        }

        this.nome = nome;
    }

    public void adicionarMusica(Musica musica) {

        if (musica == null) {
            return;
        }

        musicas.add(musica);
    }

    public void removerMusica(int indice) {

        if (indice < 0 || indice >= musicas.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        musicas.remove(indice);
    }

    public void listarMusicas() {

        if (musicas.isEmpty()) {

            System.out.println("Playlist vazia!");
            return;
        }

        for (int i = 0; i < musicas.size(); i++) {

            System.out.println((i + 1) + " - ");
            musicas.get(i).exibir();
        }
    }

    public int getQuantidadeMusicas() {
        return musicas.size();
    }

    public void reproduzir() {

        System.out.println("🎵 Reproduzindo playlist: " + nome);

        for (Musica m : musicas) {
            System.out.println("▶ " + m.getTitulo());
        }
    }
}