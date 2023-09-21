package Fernanda.Sistema_Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Leitor> leitoresCadastrados;
    private ArrayList<Livro> livrosCadastrados;
    private ArrayList<Livro> livrosDisponiveis;
    private ArrayList<Livro> livrosEmprestados;

    public Biblioteca() {
        this.leitoresCadastrados = new ArrayList<>();
        this.livrosCadastrados = new ArrayList<>();
        this.livrosDisponiveis = new ArrayList<>();
        this.livrosEmprestados = new ArrayList<>();
    }

    private void gerarCadastroAutomatico() {
        this.leitoresCadastrados = new ArrayList<>();
        this.livrosCadastrados = new ArrayList<>();
        this.livrosDisponiveis = new ArrayList<>();
        this.livrosEmprestados = new ArrayList<>();

        this.leitoresCadastrados.add(new Leitor("Maria da Silva"));
        this.leitoresCadastrados.add(new Leitor("João Santos"));
        this.leitoresCadastrados.add(new Leitor("Ana Souza"));
        this.leitoresCadastrados.add(new Leitor("Pedro Oliveira"));
        this.leitoresCadastrados.add(new Leitor("Luiza Rodrigues"));

        this.livrosCadastrados.add(new Livro("A Moreninha", "Joaquim Manuel de Macedo"));
        this.livrosCadastrados.add(new Livro("Dom Casmurro", "Machado de Assis"));
        this.livrosCadastrados.add(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis"));
        this.livrosCadastrados.add(new Livro("Cem Anos de Solidão", "Gabriel García Márquez"));
        this.livrosCadastrados.add(new Livro("O Guarani", "José de Alencar"));

        this.livrosDisponiveis.addAll(livrosCadastrados);

        System.out.println("Cadastro automático importado com sucesso!");
    }

    public int coletarINT(String mensagem_de_exibicao, int valorMin, int valorMax) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
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
        } while (true);
    }


    private void emprestarLivro(Livro livro, Leitor leitor, int dias){
        if (livro.isDisponivel()){
            leitor.livrosRetirados.add(livro);
            livro.setLeitor(leitor); // setLeitor altera livro.disponivel automaticamente.
            livro.setDiasDeEmprestimo(dias);
            this.livrosEmprestados.add(livro);
            this.livrosDisponiveis.remove(livro);

            System.out.printf("O livro %s foi emprestado a %s no dia %s e deverá ser entregue no dia %s.\n",
                    livro.getTitulo(), leitor.getNome(), livro.getDataEmprestimoToString(), livro.getDataDevolucaoToString());
        } else {
            System.out.printf("O livro %s não está disponível para empréstimo.\n", livro.getTitulo());
        }
    }

    private void receberLivro(Livro livro, Leitor leitor){
        leitor.livrosRetirados.remove(livro);
        livro.leitor = null;
        livro.setDisponivel(true);
        this.livrosEmprestados.remove(livro);
        this.livrosDisponiveis.add(livro);
        System.out.printf("%s devolveu %s à biblioteca.\n", leitor.getNome(), livro.getTitulo());
    }

    private void exibirLeitoresCadastrados() {
        System.out.println("Usuários cadastrados:\n");
        int posicao = 1;

        for (Leitor leitorCadastrado : leitoresCadastrados) {
            System.out.printf("[%d]", posicao);
            System.out.printf("Nome: %s\n", leitorCadastrado.getNome());

            posicao++;
        }
        System.out.println("------------\n");
    }

    private void exibirLivrosCadastrados() {
        System.out.println("Livros cadastrados:\n");
        int posicao = 1;

        for (Livro livroCadastrado : livrosCadastrados) {
            System.out.printf("[%d]\n", posicao);
            System.out.printf("Título: %s\n", livroCadastrado.getTitulo());
            System.out.printf("Autor: %s\n", livroCadastrado.getAutor());
            System.out.println("------------\n");

            posicao++;
        }
    }


    private void exibirLivrosDisponiveis() {
        System.out.println("Livros disponíveis:\n");
        int posicao = 1;

        for (Livro livroDisponivel : livrosDisponiveis) {
            System.out.printf("[%d]\n", posicao);
            System.out.printf("Título: %s\n", livroDisponivel.getTitulo());
            System.out.printf("Autor: %s\n", livroDisponivel.getAutor());
            System.out.println("------------\n");

            posicao++;
        }
    }

    private void exibirLivrosEmprestados() {
        System.out.println("Livros emprestados:\n");
        int posicao = 1;

        for (Livro livroEmprestado : livrosEmprestados) {
            System.out.printf("[%d]\n", posicao);
            System.out.printf("Título: %s\n", livroEmprestado.getTitulo());
            System.out.printf("Autor: %s\n", livroEmprestado.getAutor());
            System.out.printf("Usuário: %s\n", livroEmprestado.getLeitor().getNome());
            System.out.printf("Data de empréstimo: %s\n", livroEmprestado.getDataEmprestimoToString());
            System.out.printf("Data para devolução: %s\n", livroEmprestado.getDataDevolucaoToString());
            System.out.println("------------\n");

            posicao++;
        }
    }

    private Leitor cadastrarLeitor(String nome){
        return new Leitor(nome);
    }

    private Livro cadastrarLivro(String titulo, String autor){
        return new Livro(titulo, autor);
    }

    private boolean sistema() {
        System.out.println("""
                1. Cadastrar novo usuário.
                2. Cadastrar novo livro.
                3. Emprestar livro.
                4. Receber livro.
                5. Exibir livros disponíveis.
                6. Exibir livros emprestados.
                7. Exibir livros cadastrados.
                8. Exibir usuários cadastrados.
                9. (Gerar cadastro automático.)
                10. Encerrar programa.
                """);

        boolean continuar = true;
        int opcao = coletarINT("Sua opção: ", 1, 10);

        Scanner sc = new Scanner(System.in);
        switch (opcao) {
            case 1 -> {
                System.out.println("Digite o nome: ");
                String nome = sc.nextLine().trim();
                Leitor leitor = this.cadastrarLeitor(nome);
                this.leitoresCadastrados.add(leitor);
                System.out.println("Usuário cadastrado com sucesso!");
            }
            case 2 -> {
                System.out.println("Digite o título da obra: ");
                String titulo = sc.nextLine();
                System.out.println("Digite o nome do autor: ");
                String autor = sc.nextLine();
                Livro livro = this.cadastrarLivro(titulo, autor);
                this.livrosCadastrados.add(livro);
                this.livrosDisponiveis.add(livro);
                System.out.println("Livro cadastrado com sucesso!");
            }
            case 3 -> {
                if (this.livrosDisponiveis.size() > 0 && this.leitoresCadastrados.size() > 0) {
                    this.exibirLeitoresCadastrados();
                    int op1 = coletarINT("Escolha o usuário: ", 1, this.leitoresCadastrados.size()) - 1;
                    this.exibirLivrosDisponiveis();
                    int op2 = coletarINT("Escolha o livro: ", 1, this.livrosDisponiveis.size()) - 1;
                    int op3 = coletarINT("Escolha quantos dias de empréstimo: ", 10, 90);
                    this.emprestarLivro(this.livrosDisponiveis.get(op2), this.leitoresCadastrados.get(op1), op3);
                } else {
                    if (this.livrosCadastrados.size() == 0) {
                        System.out.println("Não há livros cadastrados. Cadastre algum livro primeiro.");
                    } else if (this.livrosDisponiveis.size() == 0) {
                        System.out.println("Todos os livros estão emprestados. Cadastre mais livros ou aguarde a devolução.");
                    } else {
                        System.out.println("Não há usuários cadastrados. Cadastre usuários primeiro.");
                    }
                }
            }
            case 4 -> {
                if (this.livrosEmprestados.size() != 0) {
                    this.exibirLivrosEmprestados();
                    int op1 = coletarINT("Escolha qual livro será devolvido:", 1, this.livrosEmprestados.size()) - 1;
                    this.receberLivro(this.livrosEmprestados.get(op1), this.livrosEmprestados.get(op1).getLeitor());
                } else {
                    System.out.println("No momento não há livros a serem recebidos.");
                }
            }
            case 5 -> this.exibirLivrosDisponiveis();
            case 6 -> this.exibirLivrosEmprestados();
            case 7 -> this.exibirLivrosCadastrados();
            case 8 -> this.exibirLeitoresCadastrados();
            case 9 -> this.gerarCadastroAutomatico();
            case 10 -> continuar = false;
        }
        return continuar;
    }

    public void exibirSistema(){
        boolean continuar;
        System.out.println("Olá! Seja bem-vindo à biblioteca! Para continuar, escolha uma das opções:");
        do {
            continuar = this.sistema();
        } while (continuar);
        System.out.println("Encerrando... Tenha um bom dia!");
    }
}