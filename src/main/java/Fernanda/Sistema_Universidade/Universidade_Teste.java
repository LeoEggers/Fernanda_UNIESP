package Fernanda.Sistema_Universidade;

import java.util.ArrayList;
import static Bibliotecas.Coletar.*;

public class Universidade_Teste {

    public static void main(String[] args) {

        ArrayList<Professor> listaProfessores = new ArrayList<>();
        ArrayList<Aluno> listaAlunos = new ArrayList<>();

        boolean encerrar = false;
        System.out.println("Seja bem vindo!");
        do {
            int opcao = coletarInt("""
                    Escolha a sua opção:
                    1. Cadastrar Professor:
                    2. Cadastrar Aluno:
                    3. Exibir Tudo:
                    4. Encerrar:
                    """, 1, 4);
            switch (opcao){
                case 1 -> {
                    String nomeProfessor = coletarString("Digite o nome: ");
                    int idadeProfessor = coletarInt("Digite a idade:", 1);
                    String especializacaoProfessor = coletarString("Digite a especialização: ");
                    double professorSalario = coletarDouble("Digite o salário: ", 0);
                    listaProfessores.add(new Professor(nomeProfessor, idadeProfessor, especializacaoProfessor, professorSalario));
                }
                case 2 -> {
                    String nomeAluno = coletarString("Digite o nome: ");
                    int idadeAluno = coletarInt("Digite a idade: ", 1);
                    int matriculaAluno = coletarInt("Digite a matrícula: ", 1, 100000);
                    double nota1Aluno = coletarDouble("Digite a nota 1: ", 0, 10);
                    double nota2Aluno = coletarDouble("Digite a nota 2: ", 0, 10);
                    listaAlunos.add(new Aluno(nomeAluno, idadeAluno, matriculaAluno, nota1Aluno, nota2Aluno));
                }
                case 3 -> {
                    System.out.println("PROFESSORES: ");
                    for (Professor professor : listaProfessores){
                        System.out.println("Nome: " + professor.getNome());
                        System.out.println("Idade: " + professor.getIdade());
                        System.out.println("Especialização: " + professor.getEspecializacao());
                        System.out.printf("Salário: R$%.2f", professor.getSalario());
                        System.out.println("\n");
                    }

                    System.out.println("ALUNOS:");
                    for (Aluno aluno : listaAlunos){
                        System.out.println("Nome: " + aluno.getNome());
                        System.out.println("Matrícula: " + aluno.getMatricula());
                        System.out.println("Idade: " + aluno.getIdade());
                        System.out.println("Nota1: " + aluno.getNota1());
                        System.out.println("Nota2: " + aluno.getNota2());
                        System.out.println("Média: " + aluno.tirarMedia());
                        System.out.println();
                    }
                }
                case 4 -> encerrar = true;
            }
        } while (!encerrar);
        fecharScanner();
        System.out.println("Encerrando... Volte Sempre!");
    }
}