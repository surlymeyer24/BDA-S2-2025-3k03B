
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5 {
    /*Estadísticas con Input
    Crear un programa en Java que lea desde teclado una lista de notas numéricas 
    (enteros entre 0 y 10, una por una) y calcule:

    La nota máxima
    La nota mínima
    El promedio (con decimales)
    La cantidad de aprobados (nota ≥ 6)
    La cantidad de desaprobados (nota < 6)
    El ingreso finaliza cuando el usuario ingresa -1.


    Si se ingresan valores fuera de rango (por ejemplo, 20 o -5), deben ignorarse 
    mostrando un mensaje de advertencia por consola. */

    public static void main(String[] args) {
        Scanner miScanner = new Scanner(System.in);
        List<Integer> notas = new ArrayList<>();
        int n = 0;
        while (n != -1) {
            System.out.println("Ingrese una nota entre 0 y 10 (-1 para finalizar):");
            
        }
    }
}
