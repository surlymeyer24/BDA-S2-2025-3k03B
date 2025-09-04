package ar.edu.utn.frc.backend;

import java.time.LocalDate;
import java.util.Map;

public class Porcino  extends Animal {
	public Porcino(float aPeso, LocalDate aFechaNacimiento, Sexo aSexo, RazaPorcino aRaza) {
		super(aPeso, aFechaNacimiento, aSexo, aRaza.getNombre());
	}

	@Override public Dieta getDieta() {

		ComposicionDieta composicion = getComposicion();
    if (composicion == null) {
        return null; // o una Dieta por defecto
    }

    // Construye el arreglo de Racion usando la composición asignada
    final float consumoTotal = this.getPeso() * 1.5f;
    Map<Alimento, Double> mapa = composicion.getComposicion();

    Racion[] raciones = mapa.entrySet().stream()
        .map(entry -> new Racion(entry.getKey(), (float)(consumoTotal * entry.getValue())))
        .toArray(Racion[]::new);

    return new Dieta(raciones);
	}
}
