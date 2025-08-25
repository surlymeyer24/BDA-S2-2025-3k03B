public class Ejercicio1 {
    /*Ejercicio 1 - Ciclo For
    Desarrollar un programa para cada punto o los cuatro puntos en un 
    programa no tiene importancia.

    El objetivo es lograr imprimir por pantalla las siguientes figuras 
    pero solo pudiendo imprimir a la vez uno y solo un asterisco o uno y 
    solo un espacio, es decir solo podemos imprimir una variable de tipo 
    char que tenga como valor '*' o ' '. */

    public static void main(String[] args) { 
        System.out.println("Figura 1:");
        int i;
        for (i = 0; i <= 26; i++) {
            if (i != 6 && i != 13 && i != 20){
            System.out.print("* ");
            } else {
            System.out.println("");
            }
        }

        System.out.println("\n--------------------");
        System.out.println("Figura 2:");
        for (i = 0; i <= 26; i++) {
            if (i != 6 && i != 13 && i != 20){
            System.out.print("* ");
            } else if (i % 2 == 0) {
            System.out.print("\n\s");
            }
            else {
            System.out.print(" \n");
            }
        }
        System.out.println("\n--------------------");
        System.out.println("Figura 3:");


        String car = "* ";
        String resultado;
        for (i = 0; i <= 4; i++) {
            if (i == 0) {
                resultado = car.repeat(i+1);
                System.out.println(resultado);
            } else if ( i <= 4) {
                resultado = car.repeat(i+1);
                System.out.println(resultado);
            }
        }

        System.out.println("\n--------------------");
        System.out.println("Figura 4:");

        for (i = 1; i <= 9; i++) {
            int vueltas;
            if (i <= 5) {
                vueltas = i;
            } else {
                vueltas = 10 - i;
            }
            resultado = car.repeat(vueltas);
            System.out.println(resultado);
        }
    }
}
