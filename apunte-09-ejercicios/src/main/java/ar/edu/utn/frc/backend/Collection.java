package ar.edu.utn.frc.backend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.edu.utn.frc.backend.modelo.Auto;

public class Collection {

	public static List<Auto> cargarListaDeAuto() {
    List<Auto> autos = new ArrayList<>();
    Path csv = Path.of("src/test/resources/autos.csv");
    
    try (Stream<String> lines = Files.lines(csv)) {
        return lines
            .map(linea -> linea.split(","))
            .map(columnas -> new Auto(
                Integer.parseInt(columnas[0]),
                columnas[1],
                columnas[2],
                Arrays.asList(columnas[3].split("\\|"))
            ))
            .collect(Collectors.toList());
    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
        return autos; 
    }
}
	/*
	 * Devuelve la cantidad de autos de una marca y un año determinado
	 *
	 * @param autos array de autos
	 * @param marca marca a buscar
	 * @param anio año a buscar
	 * @return cantidad de autos de una marca y un año determinado
	 */
	public static long obtenerCantidadPorMarcaYAnio(List<Auto> autos, String marca, int anio) {
		return autos.stream()
			.filter(auto -> auto.getMarca().equals(marca) && auto.getAnio() == anio)
			.count();
	}

	/*
	 * Devuelve la cantidad de autos convertibles
	 *
	 * @param autos array de autos
	 * @return cantidad de autos convertibles
	 */
	public static long obtenerCantidadDeConvertibles(List<Auto> autos) {
		return autos.stream()
			.filter(auto -> auto.getTipos().contains("Convertible"))
			.count();
	}

	/*
	 * Devuelve un array con las marcas que vendan sedanes
	 *
	 * @param autos array de autos
	 * @return array de marcas
	 */
	public static Set<String> obtenerLasMarcasQueVendanSedanes(List<Auto> autos) {
		
		return autos.stream()
			.filter(auto -> auto.getTipos().contains("Sedan"))
			.map(auto -> auto.getMarca())
			.collect(Collectors.toSet());
	}

	/*
	 * Devuelve un map con la cantidad de autos por marca
	 *
	 * @param autos array de autos
	 * @return map con la cantidad de autos por marca
	 */
	public static Map<String, Long> obtenerCantidadDeAutosPorMarca(List<Auto> autos) {
		return autos.stream()
			.collect(Collectors.groupingBy(
				Auto::getMarca,
				Collectors.counting()
			));
	}

	/*
	 * Devuelve un map con la cantidad de autos por año
	 *
	 * @param autos array de autos
	 * @return map con la cantidad de autos por año
	 */
	public static Map<Integer, Long> obtenerCantidadDeAutosPorAnio(List<Auto> autos) {
		return autos.stream()
			.collect(Collectors.groupingBy(
				Auto::getAnio,
				Collectors.counting()
			));

	}

	/*
	 * Devuelve los autos filtrados
	 * @param autos array de autos
	 * @param filtro filtro a aplicar
	 * @return autos filtrados
	 */
	public static List<Auto> filtrarAutos(List<Auto> autos, Predicate<Auto> filtro) {
		return autos.stream()
			.filter(filtro)
			.collect(Collectors.toList());
	}

	/**
	 * Devuelve una lista de autos que no sean del tipo especificado
	 *
	 * @param autos array de autos
	 * @param tipo  tipo a filtrar
	 * @return lista de autos que no sean del tipo especificado
	 */
	public static List<Auto> obtenerTodosLosAutosQueNoSeanDelTipo(List<Auto> autos, String tipo) {
		return autos.stream()
			.filter(auto -> !auto.getTipos().contains(tipo))
			.collect(Collectors.toList());
	}

	/*
	 * Obtener las marcas que tengan modelos con números en el nombre
	 * @param autos array de autos
	 * @return marcas que tengan modelos con números en el nombre
	 */
	public static Set<String> obtenerLasMarcasQueTenganModelosConNumeros(List<Auto> autos) {
		return autos.stream()
			.filter(auto -> auto.getModelo().matches(".*\\d.*"))
			.map(Auto::getMarca)
			.collect(Collectors.toSet());
	}

}
