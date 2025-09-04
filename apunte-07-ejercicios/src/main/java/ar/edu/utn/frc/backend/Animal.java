package ar.edu.utn.frc.backend;

import java.time.LocalDate;

public abstract class Animal {
	protected float peso;
	private final LocalDate fechaNacimiento;
	private final Sexo sexo;
	private final String raza;

	public Animal(float aPeso, LocalDate aFechaNacimiento, Sexo aSexo, String aRaza) {
		peso = aPeso;
		fechaNacimiento = aFechaNacimiento;
		sexo = aSexo;
		raza = aRaza;
	}

	public float getPeso() {
		return peso;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public String getRaza() {
		return raza;
	}

	public Racion[] getDieta(){
		return new Racion[0];
	}

	public abstract float getConsumoTotalKg();

	public float getValorEnergeticoTotalMcal() {
        float total = 0f;
        for (Racion r : getDieta()) {
            total += r.getAlimento().getEnergiaMcalKg() * r.getCantidadKilogramos(); // o r.getEnergiaMcal()
        }
        return total;
    }


	public float getDensidadEnergeticaMcalKg() {
        float kgTotales = getConsumoTotalKg();
		float valorEnergetico = getValorEnergeticoTotalMcal();
        return kgTotales == 0 ? 0 : (valorEnergetico / kgTotales);
    }


	@Override
	public String toString() {

		String resultado = "[ Raza " + raza + ", Peso" + peso + "kg, Sexo " + sexo + " ]\n" +
			"[ Dieta ]";
		for (Racion racion : getDieta()) {
			resultado += "\n" + racion;
		}
		return resultado;
	}
}
