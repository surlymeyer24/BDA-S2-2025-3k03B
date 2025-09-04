package ar.edu.utn.frc.backend;

import java.time.LocalDate;
public class Bovino extends Animal {
    private RazaBovino raza;

    public Bovino(float peso, LocalDate fechaNacimiento, Sexo sexo, String nombre, RazaBovino raza) {
        super(peso, fechaNacimiento, sexo, nombre);
        this.raza = raza;
    }

    public float getConsumoTotalKg() {
    return getPeso() * 1.5f; // Los bovinos consumen 1.5kg por cada kg de peso
    }
    @Override
    public Racion[] getDieta() {
        float cantidadTotal = getConsumoTotalKg();

        return new Racion[] {
            new Racion(Alimento.MAIZ, cantidadTotal * 0.4f),
            new Racion(Alimento.SOJA, cantidadTotal * 0.3f),
            new Racion(Alimento.FORRAJE, cantidadTotal * 0.3f)
        };

}
}

    