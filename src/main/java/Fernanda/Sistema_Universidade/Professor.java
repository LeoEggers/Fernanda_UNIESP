package Fernanda.Sistema_Universidade;

public class Professor extends Pessoa{
    String especializacao;
    double salario;

    public Professor(String nome, int idade, String especializacao, double salario) {
        super(nome, idade);
        this.especializacao = especializacao;
        this.salario = salario;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}