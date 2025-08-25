import java.util.Scanner;

public class Ejercicio2 {
    /*El problema del ISBN (International Standard Book Number)
    Necesita realizar un procedimiento para diferenciar cuáles son 
    libros publicados por una editorial fantasma y cuáles corresponden 
    a editoriales reales.

    El formato del ISBN de 10 dígitos para libros fue desarrollado por 
    la ISO (Organización Internacional de Estandarización) y publicado en 1970.

    Este código ISBN consiste de varias partes (grupo, editorial, título más un 
    dígito de comprobación), separadas por guiones (“-”) y se conoce que sus dígitos 
    satisfacen la condición:

    (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0

    Entrada
    La entrada es una cadena de caracteres que corresponde a un número isbn con los guiones incluidos.

    Salida
    La salida es un valor verdadero o falso indicando si el isbn ingresado es válido o no.*/


    public static void main(String[] args) {
        // iniciar scanner
        Scanner miEscaner = new Scanner(System.in);
        
        // banderas

        System.out.println("Ingrese un ISBN de 10 dígitos (con guiones):");
        String isbn = miEscaner.nextLine();
        int valor = 0;
        int cantDigitos = 10;
        for (int i = 0; i < isbn.length(); i++) {
            if (isbn.charAt(i) != '-') {
                char c = isbn.charAt(i);
                int digito = Character.getNumericValue(c);
                int incremento = digito * (cantDigitos);
                valor += incremento;
                cantDigitos--;
            }
        }

        if (valor % 11 == 0) {
            System.out.println("Valido");
        } else {
            System.out.println("Invalido");
        }
        
        miEscaner.close();
    }
}



