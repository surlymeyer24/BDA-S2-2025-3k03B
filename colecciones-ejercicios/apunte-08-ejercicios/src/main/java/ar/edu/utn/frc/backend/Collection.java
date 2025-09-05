package ar.edu.utn.frc.backend;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.utn.frc.backend.modelo.Auto;

public class Collection {



	/*
	 * Devuelve la cantidad de autos de una marca y un año determinado
	 *
	 * @param autos array de autos
	 * @param marca marca a buscar
	 * @param anio año a buscar
	 * @return cantidad de autos de una marca y un año determinado
	 */
	public static int obtenerCantidadPorMarcaYAnio(List<Auto> autos, String marca, int anio) {
		int contador = 0;
		for (Auto auto : autos) {
			if (auto.getMarca().equals(marca) && auto.getAnio() == anio) {
				contador++;
			}
		}
		return contador;
	}

	/*
	 * Devuelve la cantidad de autos convertibles
	 *
	 * @param autos array de autos
	 * @return cantidad de autos convertibles
	 */
	public static int obtenerCantidadDeConvertibles(List<Auto> autos) {
		int contador = 0;
		for (Auto auto : autos) {
			if (auto.getTipos().contains("Convertible")) {
				contador++;
			}
		}
		return contador;
	}

	/*
	 * Devuelve un array con las marcas que vendan sedanes
	 *
	 * @param autos array de autos
	 * @return array de marcas
	 */
	public static Set<String> obtenerLasMarcasQueVendanSedanes(List<Auto> autos) {
		Set<String> marcasSedan = new TreeSet<>();

		for (Auto auto : autos) {
			if (auto.getTipos().contains("Sedan")) {
				marcasSedan.add(auto.getMarca());
			}
		}
		return marcasSedan;
	}

	/*
	 * Devuelve un map con la cantidad de autos por marca
	 *
	 * @param autos array de autos
	 * @return map con la cantidad de autos por marca
	 */
	public static Map<String, Integer> obtenerCantidadDeAutosPorMarca(List<Auto> autos) {
		Map<String, Integer> contadorPorMarca = new HashMap<>();

		for (Auto auto : autos) {
			String marca = auto.getMarca();
			contadorPorMarca.put(marca, contadorPorMarca.getOrDefault(marca, 0) + 1);

		}
		return contadorPorMarca;
	}

	/*
	 * Devuelve un map con la cantidad de autos por año
	 *
	 * @param autos array de autos
	 * @return map con la cantidad de autos por año
	 */
	public static Map<Integer, Integer> obtenerCantidadDeAutosPorAnio(List<Auto> autos) {
		Map<Integer, Integer> contadorPorAnio = new HashMap<>();

		for (Auto auto : autos) {
			int anio = auto.getAnio();
			contadorPorAnio.put(anio, contadorPorAnio.getOrDefault(anio, 0) + 1);
		}
		return contadorPorAnio;
	}
}
