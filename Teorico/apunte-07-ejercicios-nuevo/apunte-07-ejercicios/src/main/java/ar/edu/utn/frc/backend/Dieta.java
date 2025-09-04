package ar.edu.utn.frc.backend;

import java.util.Arrays;
import java.util.List;

public class Dieta {

	private String nombre;
	private String descripcion;
	private List<ComposicionDieta> composiciones;

	private final Racion[] raciones;

	public Dieta(Racion[] raciones) {
		this.raciones = raciones;
	}

	public Racion[] getRaciones() {
		return raciones;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}

	@Override public String toString() {
		return "Dieta{" +
			"raciones=" + Arrays.toString(raciones) +
			'}';
	}
}
