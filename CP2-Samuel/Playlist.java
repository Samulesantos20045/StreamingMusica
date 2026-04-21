import java.util.ArrayList;

public class Playlist {

    private String nome;
    private ArrayList<Musica> musicas = new ArrayList<>();

    public Playlist(String nome) {
        this.nome = nome;
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void removerMusica(int indice) {
        if (indice >= 0 && indice < musicas.size()) {
            musicas.remove(indice);
        } else {
            System.out.println("Índice inválido!");
        }
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

    public int getDuracaoTotal() {
        int total = 0;
        for (Musica m : musicas) {
            total += m.getDuracaoFormatada().length(); // simples (pode melhorar)
        }
        return total;
    }

    public int getQuantidadeMusicas() {
        return musicas.size();
    }

    public String getNome() {
        return nome;
    }
}