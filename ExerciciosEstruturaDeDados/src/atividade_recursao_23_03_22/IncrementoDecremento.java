package atividade_recursao_23_03_22;

public class IncrementoDecremento {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Decremento Com For:");
        decrementar(4);
        
        System.out.println("Decremento Com recursividade:");
        decrementarRecursivo(4);
        
        System.out.println("Incremento Com recursividade:");
        incrementoRecursivo(0,3);
    }
    
    private static void decrementar(int numero) {
        for (; numero > 0; numero--) {
            System.out.println(numero);
        }
    }
    
    private static void decrementarRecursivo(int numero) {
        if (numero > 0) {
            System.out.println(numero);
            decrementarRecursivo(--numero);
        }
    }
    
    private static void incrementoRecursivo(int numero, int contarAte) {
        if (numero <= contarAte) {
            System.out.println(numero);
            incrementoRecursivo(++numero, contarAte);
        }
    }
}
