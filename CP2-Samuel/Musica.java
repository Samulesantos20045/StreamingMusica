public class Musica {

    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private String genero;

    public Musica(String titulo, String artista, int duracaoSegundos, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
        this.genero = genero;
    }

    public void exibir() {
        System.out.println("Título: " + titulo);
        System.out.println("Artista: " + artista);
        System.out.println("Duração: " + getDuracaoFormatada());
        System.out.println("Gênero: " + genero);
        System.out.println("----------------------------");
    }

    public String getDuracaoFormatada() {
        int min = duracaoSegundos / 60;
        int seg = duracaoSegundos % 60;
        return String.format("%d:%02d", min, seg);
    }

    public boolean contemTitulo(String busca) {
        return titulo.toLowerCase().contains(busca.toLowerCase());
    }

    public boolean contemArtista(String busca) {
        return artista.toLowerCase().contains(busca.toLowerCase());
    }

    public String getTitulo() {
        return titulo;
    }
}