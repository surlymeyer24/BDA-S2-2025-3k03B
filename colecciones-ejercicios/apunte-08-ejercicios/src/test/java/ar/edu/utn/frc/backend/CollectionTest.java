package ar.edu.utn.frc.backend;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ar.edu.utn.frc.backend.modelo.Auto;

public class CollectionTest {

	private List<Auto> cargarListaDeAuto() throws FileNotFoundException {
		List<Auto> autos = new LinkedList<>();
		Path csv = Path.of("src/test/resources/autos.csv");

		try (Scanner sc = new Scanner(Files.newBufferedReader(csv))) {
			while (sc.hasNextLine()) {
				String[] columnas = sc.nextLine().split(",");

				int anio = Integer.parseInt(columnas[0]);
				String marca = columnas[1];
				String modelo = columnas[2];
				String tipos[] = columnas[3].split("\\|");
				List<String> listaTipos = Arrays.asList(tipos);
				
				Auto auto = new Auto(anio, marca, modelo, listaTipos);
				autos.add(auto);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return autos;
	}

	// throws FileNotFoundException verifica que el archivo exista
	@Test
	public void testCargarListaDeAuto() throws FileNotFoundException {
		List<Auto> autos = cargarListaDeAuto();

		// Verifica que no este vacia
		assertFalse(autos.isEmpty(), "La lista de autos no debería estar vacía");

		// Verifica que haya al menos un auto en el archivo
		assertTrue(autos.size() > 0, "La lista deberia tener al menos un auto");

		//Verificar que el primer auto tenga los datos cargados
		Auto primerAuto = autos.get(0);
		assertNotNull(primerAuto.getAnio(), "No deberia ser nulo");
		assertNotNull(primerAuto.getMarca(), "No deberia ser nulo");
		assertNotNull(primerAuto.getModelo(), "No deberia ser nulo");
		assertNotNull(primerAuto.getTipos(), "No deberia ser nulo");

		System.out.println("Se cargaron " + autos.size() + " autos exitosamente");
		System.out.println("------------------------------------------------");

		// Opcional: Mostrar algunos autos para verificar
    for (int i = 0; i < Math.min(3, autos.size()); i++) {
        Auto auto = autos.get(i);
        System.out.println("Auto " + (i+1) + ": " + auto.getAnio() + " " + 
        auto.getMarca() + " " + auto.getModelo() + 
        " - Tipos: " + auto.getTipos());
    }

	}


	@Test
	public void devuelveLaCantidadCorrecta() throws FileNotFoundException {

		List<Auto> autos = cargarListaDeAuto();

		int resultado = Collection.obtenerCantidadPorMarcaYAnio(autos, "Audi", 2020);

		assertEquals(7, resultado);
	}

	@Test
	public void devuelveLaCantidadCorrecta2() throws FileNotFoundException {

		List<Auto> autos = cargarListaDeAuto();

		int resultado = Collection.obtenerCantidadPorMarcaYAnio(autos, "BMW", 2021);

		assertEquals(17, resultado);
	}

	@Test
	public void devuelveLaCantidadDeConvertibles() throws FileNotFoundException {

		List<Auto> autos = cargarListaDeAuto();

		int resultado = Collection.obtenerCantidadDeConvertibles(autos);

		assertEquals(14, resultado);
	}

	@Test
	public void devuelveLaCantidadMarcasQueVendanSedanes() throws FileNotFoundException {

		List<Auto> autos = cargarListaDeAuto();

		Set<String> resultado = Collection.obtenerLasMarcasQueVendanSedanes(autos);

		assertArrayEquals(new String[] { "Acura", "Audi", "Alfa Romeo", "BMW", "Bentley" }, resultado.toArray());
	}

	@Test
	public void devuelveLaCantidadCorrectaDeAudi() throws FileNotFoundException {

		List<Auto> autos = cargarListaDeAuto();

		Map<String, Integer> resultado = Collection.obtenerCantidadDeAutosPorMarca(autos);

		assertEquals(31, resultado.get("Audi"));
	}

	@Test
	public void devuelveLaCantidadCorrectaDeFerrari() throws FileNotFoundException {

		List<Auto> autos = cargarListaDeAuto();

		Map<String, Integer> resultado = Collection.obtenerCantidadDeAutosPorMarca(autos);

		assertEquals(3, resultado.get("Ferrari"));
	}

	@Test
	public void devuelveLaCantidadCorrectaDeAutosPorAnio() throws FileNotFoundException {

		List<Auto> autos = cargarListaDeAuto();

		Map<Integer, Integer> resultado = Collection.obtenerCantidadDeAutosPorAnio(autos);

		assertEquals(20, resultado.get(2019));
	}

	
}
