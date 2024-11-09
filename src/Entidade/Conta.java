package Entidade;

public class Conta {
    private int conta;
    private double saldo;
    private  String senha;

    public Conta(int conta, double saldo, String senha) {
        this.conta = conta;
        this.saldo = saldo;
        this.senha = senha;
    }

    public boolean autenticar (String senhaDigitada) {
        return senha.equals(senhaDigitada);
    }

    public void exibirSaldo() {
        System.out.println("Seu saldo atual e: R$" + saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso! Seu novo saldo é: R$ " + saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso! Seu novo saldo é: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }
}
