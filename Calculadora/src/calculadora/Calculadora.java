package calculadora;

public class Calculadora {
	
	 private double result;
	    private int operation;

	    public Calculadora(int operation) {
	        this.operation = operation;
	        calculate();
	    }

	    private void calculate() {
	        switch (operation) {
	            case 1:
	                result = new Soma(SolicitaValor.getvalue1(), SolicitaValor.getvalue2()).calculate();
	                break;
	            case 2:
	                result = new Subtracao(SolicitaValor.getvalue1(), SolicitaValor.getvalue2()).calculate();
	                break;
	            case 3:
	                result = new Multiplicacao(SolicitaValor.getvalue1(), SolicitaValor.getvalue2()).calculate();
	                break;
	            case 4:
	                result = new Divisao(SolicitaValor.getvalue1(), SolicitaValor.getvalue2()).calculate();
	                break;
	        }
	    }

	    public double getResult() {
	        return result;
	    }
	    
}
