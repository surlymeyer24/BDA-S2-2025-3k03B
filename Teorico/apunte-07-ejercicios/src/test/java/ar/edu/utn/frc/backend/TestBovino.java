package ar.edu.utn.frc.backend;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class TestBovino {
    @Test
    public void testConsumoTotalKg() {
        Bovino bovino = new Bovino(100.0f, LocalDate.now(), Sexo.MACHO, "Vaca", RazaBovino.ANGUS);
        float consumo = bovino.getConsumoTotalKg();
        assertEquals(150f, consumo, 0.0001f); // esperado: 100 * 1.5
    }
}
