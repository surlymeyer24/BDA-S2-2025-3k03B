package ar.edu.utn.frc.backend;

import java.time.LocalDate;

public class App {
	public static void main(String[] args) {

		final Bovino bovino = new Bovino(300f, LocalDate.now(), Sexo.HEMBRA, RazaBovino.HEREFORD);

		final ServicioDieta servicioDieta = new ServicioDieta();
		final ComposicionDieta composicionDieta = new ComposicionDieta();

		composicionDieta.agregarAlimento(Alimento.MAIZ, 0.4);
		composicionDieta.agregarAlimento(Alimento.SOJA, 0.2);
		composicionDieta.agregarAlimento(Alimento.TRIGO, 0.4);
		servicioDieta.asignarDieta(bovino, composicionDieta);

		final Porcino porcino = new Porcino(100f, LocalDate.now(), Sexo.MACHO, RazaPorcino.DUROC);
		composicionDieta.agregarAlimento(Alimento.MAIZ, 0.4);
		composicionDieta.agregarAlimento(Alimento.SOJA, 0.2);
		composicionDieta.agregarAlimento(Alimento.TRIGO, 0.4);
		servicioDieta.asignarDieta(porcino, composicionDieta);
		System.out.println(bovino);
		System.out.println(porcino);
	}
}
