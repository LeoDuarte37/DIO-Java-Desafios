package main;

import main.exceptions.ParametrosInvalidosException;
import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("\nDigite o primeiro valor: ");
            int num1 = scanner.nextInt();

            System.out.print("\nDigite o segundo valor: ");
            int num2 = scanner.nextInt();

            contar(num1, num2);

        } catch (ParametrosInvalidosException e) {
            System.out.println("\nO segundo valor deve ser maior que o primeiro!");
        }
    }

    public static void contar(int num1, int num2) throws ParametrosInvalidosException {
        if (num1 > num2) {
            throw new ParametrosInvalidosException();
        }

        for (int i = 0; i < (num2 - num1); i++) {
            System.out.print(i + " ");
        }
    }
}
