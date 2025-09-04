package ar.edu.utn.frc.backend;

import java.time.LocalDate;

public class App 
{
    public static void main( String[] args )
    {
        Porcino porcino = new Porcino(
        285.f,
        LocalDate.now(),
        Sexo.MACHO,
        "Cerdo 1",
        RazaPorcino.KUNEKUNE
        );

        Bovino bovino = new Bovino(
        350.f,
        LocalDate.now(),
        Sexo.HEMBRA,
        "Vaca 1",
        RazaBovino.ANGUS
        );

        System.out.println("Porcino ------");
        System.out.println(porcino);

        System.out.println("\nBovino ------");
        System.out.println(bovino);
    }
}
