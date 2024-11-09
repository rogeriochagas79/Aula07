import Entidade.Conta;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Conta conta = new Conta(123, 150, "1111");

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("===== Menu Principal =====");
            System.out.println("1 - Ver Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Sair");
            System.out.print("Digite a opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite sua senha: ");
                        String senha = sc.nextLine();
                        if (conta.autenticar(senha)) {
                            conta.exibirSaldo();
                        } else {
                            System.out.println("Senha incorreta. Acesso negado.");
                        }
                        break;
                    case 2:
                        boolean depositoValido = false;
                        while (!depositoValido) {
                            System.out.print("Digite o valor do depósito: ");
                            try {
                                double valorDeposito = sc.nextDouble();
                                sc.nextLine();
                                conta.depositar(valorDeposito);
                                depositoValido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Valor inválido! Digite um número.");
                                sc.nextLine();
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Digite sua senha: ");
                        senha = sc.nextLine();
                        if (conta.autenticar(senha)) {
                            System.out.print("Digite o valor do saque: ");
                            try {
                                double valorSaque = sc.nextDouble();
                                sc.nextLine();
                                conta.sacar(valorSaque);
                            } catch (InputMismatchException e) {
                                System.out.println("Valor inválido! Digite um número.");
                                sc.nextLine();
                            }
                        } else {
                            System.out.println("Senha incorreta. Acesso negado.");
                        }
                        break;
                    case 4:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Digite um número.");
                sc.nextLine();
            }

            System.out.println();
        }

        sc.close();
    }
}
