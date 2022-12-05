package calculadora;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        int operation = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Menu");
            System.out.println("===============");
            System.out.println("1. Adição");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("0. Encerrar");
            System.out.println("===============");
            System.out.print("Escolha: ");

            operation = scanner.nextInt();

            System.out.println();

            if(new Validacao().isOptionValid(operation)){
                SolicitaValor.requestDoubles(scanner);
                Calculadora calculadora = new Calculadora(operation);
                System.out.println("\nO resultado é: " + calculadora.getResult());
                System.out.println();
                SolicitaValor.cleanValues();
            }

        } while (operation != 0);

        scanner.close();

    }

}
