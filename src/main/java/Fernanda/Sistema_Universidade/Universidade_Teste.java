package Fernanda.Sistema_Universidade;

import java.util.ArrayList;
import java.util.Scanner;

public class Universidade_Teste {
    public static int coletarINT(String mensagem_de_exibicao, int valorMin, int valorMax) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        while (true) {
            System.out.println(mensagem_de_exibicao);
            if (sc.hasNextInt()) {
                opcao = sc.nextInt(); sc.nextLine();
                if (opcao >= valorMin && opcao <= valorMax) {
                    return opcao;
                } else {
                    System.out.println("Erro! O valor deve estar entre " + valorMin + " e " + valorMax + ". Tente novamente.");
                }
            } else {
                System.out.println("Erro! Entrada inválida. Digite um número inteiro.");
                sc.nextLine();
            }
        }
    }
    public static double coletarNota(String mensagem_de_exibicao) {
        Scanner sc = new Scanner(System.in);
        double valor;

        while (true) {
            System.out.println(mensagem_de_exibicao);
            String input = sc.nextLine().replace(",", ".");

            try {
                valor = Double.parseDouble(input);
                if (valor >= 0 && valor <= 10) {
                    return valor;
                } else {
                    System.out.println("Erro! O valor deve estar entre 0 e 10. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro! Entrada inválida. Digite um número double entre 0 e 10.");
            }
        }
    }
    public static double coletarSalario(String mensagem_de_exibicao) {
        Scanner sc = new Scanner(System.in);
        double valor;

        while (true) {
            System.out.println(mensagem_de_exibicao);
            String input = sc.nextLine().replace(",", ".");

            try {
                valor = Double.parseDouble(input);
                if (valor >= 0) {
                    return valor;
                } else {
                    System.out.println("Erro! O valor deve ser positivo. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro! Entrada inválida. Digite um número double positivo.");
            }
        }
    }
    public static String coletarString(String mensagem_de_exibicao){
        Scanner sc = new Scanner(System.in);
        String nome;

        while (true) {
            System.out.println(mensagem_de_exibicao);
            nome = sc.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("Tente novamente. A entrada não pode ser vazia.");
            } else {
                return nome;
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Professor> listaProfessores = new ArrayList<>();
        ArrayList<Aluno> listaAlunos = new ArrayList<>();

        boolean encerrar = false;
        System.out.println("Seja bem vindo!");
        do {
            int opcao = coletarINT("""
                    Escolha a sua opção:
                    1. Cadastrar Professor:
                    2. Cadastrar Aluno:
                    3. Exibir Tudo:
                    4. Encerrar:
                    """, 1, 4);
            switch (opcao){
                case 1 -> {
                    String nomeProfessor = coletarString("Digite o nome: ");
                    int idadeProfessor = coletarINT("Digite a idade:", 1, 999);
                    String especializacaoProfessor = coletarString("Digite a especialização: ");
                    double professorSalario = coletarSalario("Digite o salário: ");
                    listaProfessores.add(new Professor(nomeProfessor, idadeProfessor, especializacaoProfessor, professorSalario));
                }
                case 2 -> {
                    String nomeAluno = coletarString("Digite o nome: ");
                    int idadeAluno = coletarINT("Digite a idade: ", 1, 999);
                    int matriculaAluno = coletarINT("Digite a matrícula: ", 1, 100000);
                    double nota1Aluno = coletarNota("Digite a nota 1: ");
                    double nota2Aluno = coletarNota("Digite a nota 2: ");
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
        System.out.println("Encerrando... Volte Sempre!");
    }
}