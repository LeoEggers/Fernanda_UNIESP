package Fernanda.Sistema_Banco;

public class Cliente {
    String nome;
    double saldo;

    public Cliente(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public Cliente(String nome){
        this.nome = nome;
        this.saldo = 0;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void consultarSaldo(){
        System.out.printf("%s possui R$%.2f em sua conta bancária.\n",
                this.getNome(), this.getSaldo());
    }

    public void depositar(double valor_do_deposito){
        this.setSaldo(this.getSaldo() + valor_do_deposito);
        System.out.printf("""
                        Operação realizada com sucesso.
                        R$%.2f depositado na conta de %s.
                        """,
                valor_do_deposito, this.getNome());
        this.consultarSaldo();
    }

    public void sacar(double valor_do_saque){
        this.setSaldo(this.getSaldo() - valor_do_saque);
        System.out.printf("""
                        Operação realizada com sucesso.
                        R$%.2f retirado da conta de %s.
                        """,
                valor_do_saque, this.getNome());
        this.consultarSaldo();
    }

    public void transferir(Cliente cliente, double valor_da_transferencia){
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