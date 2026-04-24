

public class Musica {

    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private String genero;

    // Construtor padrão
    public Musica() {
        this("Desconhecido", "Desconhecido", 60, "Pop");
    }

    // Construtor parametrizado
    public Musica(String titulo, String artista, int duracaoSegundos, String genero) {
        setTitulo(titulo);
        setArtista(artista);
        setDuracaoSegundos(duracaoSegundos);
        setGenero(genero);
    }

    // ======================
    // GETTERS E SETTERS
    // ======================

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título inválido!");
        }
        this.titulo = titulo.trim();
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        if (artista == null || artista.trim().isEmpty()) {
            throw new IllegalArgumentException("Artista inválido!");
        }
        this.artista = artista.trim();
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos <= 0 || duracaoSegundos >= 3600) {
            throw new IllegalArgumentException("Duração inválida!");
        }
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero == null) {
            throw new IllegalArgumentException("Gênero inválido!");
        }

        String g = genero.trim().toLowerCase();

        switch (g) {
            case "pop":
            case "rock":
            case "jazz":
            case "eletrônica":
            case "hip-hop":
            case "clássica":
                this.genero = capitalize(g);
                break;
            default:
                throw new IllegalArgumentException("Gênero inválido!");
        }
    }

    private String capitalize(String texto) {
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }

    // ======================
    // MÉTODOS
    // ======================

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
}