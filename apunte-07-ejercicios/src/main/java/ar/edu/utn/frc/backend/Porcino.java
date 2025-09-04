package ar.edu.utn.frc.backend;

public class Porcino extends Animal {
    private RazaPorcino raza;

    public Porcino(float peso, java.time.LocalDate fechaNacimiento, Sexo sexo, String nombre, RazaPorcino raza) {
        super(peso, fechaNacimiento, sexo, nombre);
        this.raza = raza;
    }

    public float getConsumoTotalKg() {
    return getPeso() * 2.0f; // Los porcinos consumen 2kg por cada kg de peso
    }
    @Override
    public Racion[] getDieta() {
        float cantidadTotal = getConsumoTotalKg();

        return new Racion[] {
            new Racion(Alimento.MAIZ, cantidadTotal * 0.5f),
            new Racion(Alimento.SOJA, cantidadTotal * 0.3f),
            new Racion(Alimento.TRIGO, cantidadTotal * 0.2f)
        };

    }
}
