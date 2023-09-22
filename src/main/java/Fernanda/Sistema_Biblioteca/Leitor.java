package Fernanda.Sistema_Biblioteca;

import java.util.Random;
import java.util.ArrayList;

class Leitor {
    private final String nome;
    private ArrayList<Livro> livrosRetirados;

    Leitor(String nome) {
        this.nome = nome;
        Random rd = new Random();
        int idd = rd.nextInt(10000, 99999);
        this.livrosRetirados = new ArrayList<>();
    }

    public ArrayList<Livro> getLivrosRetirados() {
        return livrosRetirados;
    }

    String getNome() {
        return nome;
    }
}