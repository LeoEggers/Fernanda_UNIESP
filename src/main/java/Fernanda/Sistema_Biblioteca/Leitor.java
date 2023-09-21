package Fernanda.Sistema_Biblioteca;

import java.util.Random;
import java.util.ArrayList;

public class Leitor {
    protected String nome;
    protected int Idd;
    protected ArrayList<Livro> livrosRetirados;

    protected Leitor(String nome) {
        this.nome = nome;
        Random rd = new Random();
        this.Idd = rd.nextInt(10000, 99999);
        this.livrosRetirados = new ArrayList<>();
    }

    protected String getNome() {
        return nome;
    }
}