package calculadora;

public class Validacao {

    public boolean isOptionValid(int operation) {
    	
        if(operation == 0) {
            System.out.println("Programa encerrado");
            return false;
        } else if (operation < 0 || operation > 4) {
            System.out.println("Opção inválida. Por favor, tente novamente.");
            return false;
        }
        return true;
    }

}
