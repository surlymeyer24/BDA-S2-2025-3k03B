package ar.edu.utnfc.backend.modelo;

public class Mascota {
    // Atributos
    private String nombre;
    private float energia;
    private int humor;

    // Constructor
    public Mascota(String nom, int energia, int humor) {
        nombre = nom;
        energia = energia;
        humor = humor;
    }

    public boolean comer() {
        energia += energia * 0.10;
        humor += 1;
        return true;
    }

    public boolean beber() {
        energia += energia * 0.05;
        humor += 1;
        return true;
    }

    public boolean correr() {
        energia *=  0.35;
        humor -= 2;
        return true;
    }

    public boolean saltar() {
        energia *= 0.15;
        humor -= 2;
        return true;
    }
}
