package Fernanda.Sistema_Universidade;

public class Aluno extends Pessoa{

    private double nota1;
    private double nota2;
    private int matricula;

    public Aluno(String nome, int idade, int matricula, double nota1, double nota2) {
        super(nome, idade);
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double tirarMedia(){
        return (getNota1() + getNota2())/2;
    }
}
