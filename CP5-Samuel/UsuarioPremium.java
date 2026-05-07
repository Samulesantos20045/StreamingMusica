// ==========================
// CLASSE USUARIO PREMIUM
// ==========================

import java.util.ArrayList;

public class UsuarioPremium extends Usuario {

    private String plano;

    private ArrayList<Musica> musicasBaixadas;

    public UsuarioPremium(String nome,
                           String email,
                           String plano) {

        super(nome, email);

        this.plano = plano;

        musicasBaixadas = new ArrayList<>();
    }

    @Override
    public void reproduzirMusica(Musica musica) {

        reproducoes++;

        System.out.println("🎧 Alta Qualidade: "
                + musica.getTitulo());

        historicoReproducao.add(musica);
    }

    public void baixarMusica(Musica musica) {

        if (!musicasBaixadas.contains(musica)) {

            musicasBaixadas.add(musica);

            System.out.println("⬇ Música baixada!");
        }
    }

    public void listarMusicasBaixadas() {

        if (musicasBaixadas.isEmpty()) {

            System.out.println("Nenhuma música baixada.");
            return;
        }

        for (Musica m : musicasBaixadas) {
            m.exibir();
        }
    }

    public String getPlano() {
        return plano;
    }

    @Override
    public String toString() {
        return getNome() + " (Premium)";
    }
}