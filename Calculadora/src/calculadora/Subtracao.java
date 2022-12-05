package calculadora;

public class Subtracao implements Operacao {

    private double result, value1, value2;

    public Subtracao(double value1, double value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public double calculate() {
        result = value1 - value2;
        return result;
    }

}
