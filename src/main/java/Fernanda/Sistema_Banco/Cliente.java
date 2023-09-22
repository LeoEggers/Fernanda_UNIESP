package Fernanda.Sistema_Banco;

class Cliente {
    private final String nome;
    private double saldo;

    Cliente(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    Cliente(String nome){
        this.nome = nome;
        this.saldo = 0;
    }

    String getNome() {
        return nome;
    }

    double getSaldo() {
        return saldo;
    }

    void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    void consultarSaldo(){
        System.out.printf("%s possui R$%.2f em sua conta bancária.\n",
                this.getNome(), this.getSaldo());
    }

    void depositar(double valor_do_deposito){
        this.setSaldo(this.getSaldo() + valor_do_deposito);
        System.out.printf("""
                        Operação realizada com sucesso.
                        R$%.2f depositado na conta de %s.
                        """,
                valor_do_deposito, this.getNome());
        this.consultarSaldo();
    }

    void sacar(double valor_do_saque){
        this.setSaldo(this.getSaldo() - valor_do_saque);
        System.out.printf("""
                        Operação realizada com sucesso.
                        R$%.2f retirado da conta de %s.
                        """,
                valor_do_saque, this.getNome());
        this.consultarSaldo();
    }

    void transferir(Cliente cliente, double valor_da_transferencia){
        this.setSaldo(this.getSaldo() - valor_da_transferencia);
        cliente.setSaldo(cliente.getSaldo() + valor_da_transferencia);
        System.out.printf("""
                        Operação realizada com sucesso.
                        %s transferiu R$%.2f para %s.
                        """,
                this.getNome(), valor_da_transferencia , cliente.getNome());
        this.consultarSaldo();
        cliente.consultarSaldo();
    }

}