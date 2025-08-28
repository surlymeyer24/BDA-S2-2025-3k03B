package ar.edu.utnfc.backend.modelo;

public class Mascota {
    // Atributos
    private String nombre;
    private int energia;
    private int humor;

    // Constructor
    public Mascota(String nom, int energia, int humor) {
        nombre = nom;
        energia = energia;
        humor = humor;
    }

    public boolean ingesta(String tipo) {
        if (tipo.equals("comer")) {
            energia *= 0.10;
            humor += 1;
            return true;
        } else  if (tipo.equals("beber")){
            energia *= 0.05;
            humor += 1;
            return true;
        } else {
            String mensaje;
            mensaje = "Tipo de ingesta no valido";
            return false;
        }
    }
}
