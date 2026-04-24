import java.util.ArrayList;

public class Playlist {

    private String nome;
    private ArrayList<Musica> musicas;

    // Construtor padrão
    public Playlist() {
        this("Playlist");
    }

    // Construtor parametrizado
    public Playlist(String nome) {
        setNome(nome);
        this.musicas = new ArrayList<>();
    }

    // Getter / Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da playlist inválido!");
        }
        this.nome = nome.trim();
    }

    // ======================
    // MÉTODOS
    // ======================

    public void adicionarMusica(Musica musica) {
        if (musica == null) {
            throw new IllegalArgumentException("Música não pode ser null!");
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
}