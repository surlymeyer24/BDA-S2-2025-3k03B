package ar.edu.utn.frc.backend;

import java.util.ArrayList;
import java.util.List;

public enum RazaBovino{
	HOLSTEIN("Holstein"),
	HEREFORD("Hereford"),
	ANGUS("Angus");

	private final String nombre;

	RazaBovino(final String aNombre) {
		nombre = aNombre;
	}

	private List<Dieta> dietas = new ArrayList<>();

	public List<Dieta> getDietas() {
		return dietas;
	}

	public void agregarDieta(Dieta dieta) {
		this.dietas.add(dieta);
	}

	public String getNombre() {
		return nombre;
	}
}
