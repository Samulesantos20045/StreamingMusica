package com.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.Util.Menus;
import com.Util.M;


public class Main {
    
    static Scanner scanner = new Scanner(System.in);

    static String[] generosCadastrados = {
            "Pop", "Rock", "Jazz", "Eletrônica", "Hip-Hop", "Clássica"
    };

    public static void main(String[] args) {
        Menus mn = new Menus();

        boolean continua = true;
        
        while (continua) {
            mn.Tela1();
            int opcao = lerOpcao();
            processarOpcao(opcao);
           continua =  verificar();

        }
        
        
        

        System.out.println("Até logo!");
        scanner.close();
    }
    public static boolean verificar() {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("DESEJA SAIR? S/N: ");
    String resp = sc.next();

    if (resp.equalsIgnoreCase("S")) {
        return false;
    } else {
        return true;
    }
}
    


    public static int lerOpcao() {

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public static void processarOpcao(int opcao) {

        switch (opcao) {

            case 1:
                M.adicionarMusica();
                break;

            case 2:
                M.listarMusicas();
                break;

            case 3:
                M.buscarPorTitulo();
                break;

            case 4:
                
                M.buscarPorArtista();
                break;

            case 5:
                M.buscarPorGenero();
                break;

            case 6:
                M.estatisticas();
                break;

            case 0:
                
                break;

            default:
                System.out.println("Opção inválida");
        }
    }

    
}
