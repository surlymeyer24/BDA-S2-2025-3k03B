import java.util.Scanner;
public class Ejercicio4 {
    /*Productividad
    Escribir un programa en Java que Le pida al usuario:

    Su nombre (texto)
    La cantidad de horas trabajadas en el día (entero)
    La cantidad de tareas completadas (entero) 
    Luego:

    Calcule un índice de productividad usando esta fórmula
    (tareas completadas * 10) - (5 puntos por cada hora faltante si trabajó menos de 8 horas).
    Si trabajó más de 8 horas, agregar 5 puntos extra
    Se deberá mostrar por pantalla un resumen con los siguientes datos:

    Nombre del empleado
    Horas trabajadas
    Tareas completadas
    Índice de productividad */
    public static void main(String[] args) {
        // iniciar scanner
        Scanner miEscaner = new Scanner(System.in); 

        System.out.println("Ingrese su nombre:");
        String nombre = miEscaner.nextLine();

        System.out.println("Horas trabajadas:");
        int horasTrabajadas = miEscaner.nextInt();

        System.out.println("Tareas completadas:");
        int tareasCompletadas = miEscaner.nextInt();

        int indiceProductividad = 0;
        if (horasTrabajadas < 8) {
            indiceProductividad = (tareasCompletadas * 10) - (5 * (8 - horasTrabajadas));
        } else {
            indiceProductividad = (tareasCompletadas * 10) + 5;
        }

        System.out.println("Resumen:");
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Horas trabajadas: " + horasTrabajadas);
        System.out.println("Tareas completadas: " + tareasCompletadas);
        System.out.println("Índice de productividad: " + Integer.toString(indiceProductividad));
        
        

    }
}
