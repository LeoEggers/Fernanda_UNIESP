package Fernanda.Sistema_Biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Livro {

    private final String titulo;
    private final String autor;
    private boolean disponivel;
    protected Leitor leitor;
    protected LocalDate dataEmprestimo;
    protected int diasDeEmprestimo;
    protected LocalDate dataDevolucao;
    protected String dataEmprestimoToString;
    protected String dataDevolucaoToString;

    protected Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    protected String getTitulo() {
        return titulo;
    }

    protected String getAutor() {
        return autor;
    }

    protected boolean isDisponivel() {
        return disponivel;
    }

    protected void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    protected Leitor getLeitor() {
        return leitor;
    }

    protected void setLeitor(Leitor leitor) {
        this.leitor = leitor;
        this.setDisponivel(false);
    }

    protected LocalDate getDataEmprestimo() {
        return LocalDate.now();
    }

    protected int getDiasDeEmprestimo() {
        return diasDeEmprestimo;
    }

    protected void setDiasDeEmprestimo(int diasDeEmprestimo) {
        this.diasDeEmprestimo = diasDeEmprestimo;
    }

    protected LocalDate getDataDevolucao() {
        this.dataEmprestimo = getDataEmprestimo();
        this.dataDevolucao = this.dataEmprestimo.plusDays(this.getDiasDeEmprestimo());
        return dataDevolucao;
    }

    protected String getDataEmprestimoToString() {
        this.dataEmprestimo = getDataEmprestimo();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataEmprestimoToString = dataEmprestimo.format(formato);
        return dataEmprestimoToString;
    }

    protected String getDataDevolucaoToString(){
        this.dataDevolucao = getDataDevolucao();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataDevolucaoToString = dataDevolucao.format(formato);
        return dataDevolucaoToString;
    }
}