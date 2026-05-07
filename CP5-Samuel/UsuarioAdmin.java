// ==========================
// CLASSE USUARIO ADMIN
// ==========================

public final class UsuarioAdmin extends Usuario {

    public UsuarioAdmin(String nome, String email) {

        super(nome, email);
    }

    @Override
    public void reproduzirMusica(Musica musica) {

        reproducoes++;

        System.out.println("ADMIN reproduzindo: "
                + musica.getTitulo());

        historicoReproducao.add(musica);
    }
}