import java.util.Scanner;

public class Ejercicio3 {

    /*Divisores y Multiplos
    Escribir un programa en Java que:
    Solicite al usuario un número entero positivo n.
    Muestre por pantalla todos los números entre 1 y n que sean múltiplos de 3 o múltiplos de 5, 
    pero no de ambos.
    Si el usuario ingresa un valor no válido (≤ 0), mostrar un mensaje de error y volver a pedir el número. */

    public static void main(String[] args) {
        // iniciar scanner
        Scanner miEscaner = new Scanner(System.in);

        System.out.println("Ingrese un número entero positivo:");
        int n = miEscaner.nextInt();
        while (n <= 0) {
            System.out.println("Número no válido. Ingrese un número entero positivo:");
            n = miEscaner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 ^ i % 5 == 0) {
                System.out.println(i);
            }
        }
    
    }
}
