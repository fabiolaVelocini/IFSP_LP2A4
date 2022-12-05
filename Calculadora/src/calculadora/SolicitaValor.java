package calculadora;

import java.util.Scanner;

public class SolicitaValor {

    private static double value1, value2;

    public static double getvalue1() {
        return value1;
    }

    public static double getvalue2() {
        return value2;
    }
    
    public static void requestDoubles(Scanner scanner) {
        System.out.print("Insira o primeiro valor: ");
        value1 = scanner.nextDouble();
        System.out.print("Insira o segundo valor: ");
        value2 = scanner.nextDouble();
    }

    public static void cleanValues() {
        value1 = 0;
        value2 = 0;
    }

}
