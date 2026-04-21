package com.Util;
import java.util.Scanner;
import java.util.ArrayList;


public class M {
    public static Scanner sc = new Scanner(System.in);
    static ArrayList<M> listaMusicas = new ArrayList<>();

    private String titulo;
    private String artista;
    private int duracao;
    private String genero;
    //get
    public String getTitulo(){
        return titulo;
    }
    public String getArtista(){
        return artista;
    }
    public int getDuracao(){
        return duracao;
    }
    public String getGenero(){
        return genero;
    }

    //set
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setArtista(String artista){
        this.artista = artista;
    }
    public void setDuracao(int duracao){
        this.duracao = duracao;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }

    public static void adicionarMusicasTeste() {

        listaMusicas.add(new M("Bohemian Rhapsody", "Queen", 354, "Rock"));
        listaMusicas.add(new M("Billie Jean", "Michael Jackson", 293, "Pop"));
    }


    public M(String titulo, String artista, int duracao, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
    }

    public static void adicionarMusica(){
        
        System.out.println("============ ADICIONAR MÚSICA ============");
        System.out.println("INFORME O NOME: ");
        String titulo = sc.next();

        System.out.println("INFORME O ARTISTA: ");
       String artista = sc.next();

        System.out.println("INFORME A DURAÇÃO: ");
        int duracao = sc.nextInt();

        System.out.println("INFORME O GENERO: ");
        String genero = sc.next();

        listaMusicas.add(new M(titulo, artista, duracao, genero));

        System.out.println("==========================================");

        
    }

    public static void buscarPorGenero() {
        
        System.out.print("Digite o genero: ");
        String busca = sc.nextLine();

        boolean encontrou = false;

        for (M m : listaMusicas) {

            if (m.genero.equalsIgnoreCase(busca)) {
                m.mostrar();
                encontrou = true;
            }
        }

        if (!encontrou)
            System.out.println("Gênero não encontrado");
       
    }

     public static void buscarPorTitulo() {
        
        System.out.print("Digite o titulo: ");
        String busca = sc.nextLine();


        for (M m : listaMusicas) {

            if (m.titulo.equalsIgnoreCase(busca)) {
                m.mostrar();
                return;
            }
        }

        System.out.println("Música não encontrada");

        sc.close();
    }


    public static void buscarPorArtista() {
        String busca;
        
        System.out.print("Digite o artista: ");
        busca = sc.nextLine();

        boolean encontrou = false;

        for (M m : listaMusicas) {

            if (m.artista.equalsIgnoreCase(busca)) {
                m.mostrar();
                encontrou = true;
            }
        }

        if (!encontrou)
            System.out.println("Artista não encontrado");
        
    }

    public static void estatisticas() {

        System.out.println("\n--- ESTATÍSTICAS ---");

        totalMusicas();
        duracaoTotal();
        duracaoMedia();
        generoMaisCadastrado();
    }

    public static void totalMusicas() {

        System.out.println("Total de músicas: " + listaMusicas.size());
    }
    

     public static void duracaoTotal() {

        int total = 0;

        for (M m : listaMusicas) {
            total += m.duracao;
        }

        System.out.println("Duração total: " + formatarDuracao(total));
    }

    public static void duracaoMedia() {

        int total = 0;

        for (M m : listaMusicas) {
            total += m.duracao;
        }

        System.out.println("Duração média: " +
                formatarDuracao(total / listaMusicas.size()));
    }

    public static void listarMusicas() {
        System.out.println("=================LISTA DE MÚSICAS==================");
        System.out.println();

        
        for (M m : listaMusicas) {
            System.out.println("Titulo: " + m.titulo);
            System.out.println("Artista: " + m.artista);
            System.out.println("Duração: " + formatarDuracao(m.duracao));
            System.out.println("Gênero: " + m.genero);
            System.out.println("_____________________________________");
            
        }

        
        
    }

    public static void generoMaisCadastrado() {

        int pop = 0, rock = 0, jazz = 0, eletronica = 0, hiphop = 0, classica = 0;

        for (M m : listaMusicas) {

            if (m.genero.equalsIgnoreCase("Pop")) pop++;
            if (m.genero.equalsIgnoreCase("Rock")) rock++;
            if (m.genero.equalsIgnoreCase("Jazz")) jazz++;
            if (m.genero.equalsIgnoreCase("Eletrônica")) eletronica++;
            if (m.genero.equalsIgnoreCase("Hip-Hop")) hiphop++;
            if (m.genero.equalsIgnoreCase("Clássica")) classica++;
        }

        System.out.println("Pop: " + pop);
        System.out.println("Rock: " + rock);
        System.out.println("Jazz: " + jazz);
        System.out.println("Eletrônica: " + eletronica);
        System.out.println("Hip-Hop: " + hiphop);
        System.out.println("Clássica: " + classica);
    }

    public static String formatarDuracao(int segundos) {

        int min = segundos / 60;
        int seg = segundos % 60;

        return String.format("%d:%02d", min, seg);
    }

    public void mostrar() {
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Artista: " + this.artista);
        System.out.println("Duração: " + formatarDuracao(this.duracao));
        System.out.println("Gênero: " + this.genero);
        System.out.println("_____________________________________");
    }

}

