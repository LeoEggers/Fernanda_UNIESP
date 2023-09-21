package Fernanda.Sistema_Banco;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static Bibliotecas.Coletar.*;

public class Sistema {
    ArrayList<Cliente> listaclientes;

    public Sistema() {
        // Inicializa a lista de clientes.
        this.listaclientes = new ArrayList<>();
    }

    private void cadastrarCliente(String nome, double saldo){
        // Cria e cadastra um novo cliente com nome e saldo especificados.
        Cliente cliente = new Cliente(nome, saldo);
        this.listaclientes.add(cliente);
    }

    private void cadastrarCliente(){
        // Permite que o usuário cadastre um novo cliente com entrada via console.
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine().trim();
        Cliente cliente = new Cliente(nome);
        this.listaclientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    private void gerarCadastroAutomatico() {
        // Gera automaticamente clientes com nomes predefinidos e saldos aleatórios.
        String[] nomes = {"Alice", "Heitor", "Carol", "João", "Marcos"};

        for (String nome : nomes) {
            Random rd = new Random();
            double saldoInicial = rd.nextDouble() * rd.nextInt(100, 10000);
            saldoInicial = Math.round(saldoInicial * 100.0) / 100.0; // Arredonda para 2 casas decimais
            this.cadastrarCliente(nome, saldoInicial);
        }
    }

    private void exibirClientes() {
        // Exibe os clientes cadastrados.
        System.out.println("Clientes:\n");
        int posicao = 1;

        for (Cliente cliente : listaclientes) {
            System.out.printf("[%d]\n", posicao);
            System.out.printf("Nome: %s\n", cliente.getNome());
            System.out.println("------------\n");

            posicao++;
        }
    }

    private ArrayList<Cliente> exibirClientes_Transferencia(Cliente user) {
        // Exibe os clientes disponíveis para transferência (sem o nome de quem vai transferir).
        ArrayList<Cliente> outrosClientes = new ArrayList<>();

        System.out.println("Clientes:\n");
        int posicao = 1;

        for (Cliente cliente : listaclientes) {
            if (!cliente.equals(user)) {
                System.out.printf("[%d]\n", posicao);
                System.out.printf("Nome: %s\n", cliente.getNome());
                System.out.println("------------\n");

                outrosClientes.add(cliente);
                posicao++;
            }
        }

        return outrosClientes;
    }

    public void exibirSistema(){
        // switchcase principal.
        this.gerarCadastroAutomatico();
        System.out.println("Bem vindo ao Banco da Confiança.");

        boolean continuar = true;

        do {
            int opcao1 = coletarInt("""
                    1. Entrar.
                    2. Cadastrar novo usuário.
                    3. Encerrar.
                    Escolha uma opção:\s
                    """, 1, 3);

            switch (opcao1){
                case 1 -> {
                    this.exibirClientes();
                    int opcao2 = coletarInt("Escolha o usuário:", 1, this.listaclientes.size());
                    // abre o próximo switch case.
                    this.SistemaCliente(this.listaclientes.get(opcao2 - 1));
                }
                case 2 -> this.cadastrarCliente();
                case 3 -> continuar = false;
            }
        } while (continuar);
        fecharScanner();
        System.out.println("Encerrando... Volte sempre!");
    }

    private void SistemaCliente(Cliente cliente) {
        // switchcase para cada cliente.

        System.out.printf("Olá, %s! Seja bem vindo ao banco!\n", cliente.getNome());
        boolean continuar = true;

        do {
            int opcao = coletarInt("""
                    1. Consultar saldo.
                    2. Depositar.
                    3. Sacar.
                    4. Transferir.
                    5. Encerrar.
                    Escolha a opção:\s
                    """, 1, 5);

            switch (opcao) {
                case 1 -> cliente.consultarSaldo();
                case 2 -> {
                    double valor = coletarDouble("Digite o valor do depósito:", 0);
                    cliente.depositar(valor);
                }
                case 3 -> {
                    if (cliente.getSaldo() <= 0){
                        System.out.println("Saldo insuficiente.");
                        cliente.consultarSaldo();
                    } else {
                        cliente.consultarSaldo();
                        double valor = coletarDouble("Digite o valor do saque:", 0);
                        if (valor > cliente.getSaldo()) {
                            System.out.println("Saldo insuficiente.");
                            cliente.consultarSaldo();
                        } else {
                            cliente.sacar(valor);
                        }
                    }
                }

                case 4 -> {
                    if (cliente.getSaldo() <= 0){
                        System.out.println("Saldo insuficiente.");
                        cliente.consultarSaldo();
                    } else {
                        cliente.consultarSaldo();
                        double valor = coletarDouble("Digite o valor da transferência: ", 0);
                        if (valor > cliente.getSaldo()) {
                            System.out.println("Saldo insuficiente.");
                            cliente.consultarSaldo();
                        } else {
                            ArrayList<Cliente> outrosClientes = this.exibirClientes_Transferencia(cliente);
                            int receptor = coletarInt("Escolha para quem será feita a transferência: ", 1,
                                    outrosClientes.size()) - 1;
                            cliente.transferir(outrosClientes.get(receptor), valor);
                        }
                    }
                }

                case 5 -> continuar = false;
            }
        } while (continuar);
        System.out.println("Retornando...");
    }
}