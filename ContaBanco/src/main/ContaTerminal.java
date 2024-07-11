package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo a criação da conta bancária!");

        try {
            System.out.print("\nDigite seu nome: ");
            String nome = scanner.nextLine();

            System.out.print("\nDigite o numero: ");
            int numero = scanner.nextInt();

            scanner.nextLine();

            System.out.print("\nDigite o numero da agência: ");
            String agencia = scanner.nextLine();

            System.out.print("\nDigite seu saldo inicial: ");
            double saldo = scanner.nextDouble();

            Conta conta = new Conta(numero, agencia, nome, saldo);
            System.out.println("\nOlá " + conta.getNome() + ", obrigado por criar uma conta em nosso banco, " +
                    "sua agência é " + conta.getAgencia() + ", conta " + conta.getNumero() +
                    " e seu saldo " + conta.getSaldo() + " já está disponível para saque!");
        } catch (InputMismatchException e) {
            System.out.println("Digite valores válidos para os campos!");
        }

        scanner.close();
    }
}
