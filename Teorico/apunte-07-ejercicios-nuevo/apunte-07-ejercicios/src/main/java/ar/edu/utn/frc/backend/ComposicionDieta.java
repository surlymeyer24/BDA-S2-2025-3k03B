package ar.edu.utn.frc.backend;

import java.util.HashMap;
import java.util.Map;

public class ComposicionDieta {
    private Map<Alimento, Double> composicion;

    public ComposicionDieta() {
        this.composicion = new HashMap<>();
    }

    // 3. Métodos
    public void agregarAlimento(Alimento alimento, double porcentaje) {
        composicion.put(alimento, porcentaje);
    }

    public Map<Alimento, Double> getComposicion() {
        return composicion;
    }
}
