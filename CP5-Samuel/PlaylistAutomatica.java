// ==========================
// CLASSE PLAYLIST AUTOMATICA
// ==========================

import java.util.ArrayList;

public class PlaylistAutomatica extends Playlist {

    private String criterio;

    public PlaylistAutomatica(String nome, String criterio) {

        super(nome);
        this.criterio = criterio;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    @Override
    public void reproduzir() {

        System.out.println("🤖 Playlist Automática");
        System.out.println("Critério: " + criterio);

        super.reproduzir();
    }

    public void atualizar(ArrayList<Musica> musicas) {

        getMusicas().clear();

        for (Musica m : musicas) {
            getMusicas().add(m);
        }
    }
}