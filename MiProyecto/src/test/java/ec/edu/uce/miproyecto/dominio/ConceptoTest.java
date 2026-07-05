package ec.edu.uce.miproyecto.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConceptoTest {

    @Test
    void getIdConcepto() {
        Concepto concepto = new Concepto("Límites", "Estudio de la tendencia de una función");

        assertTrue(concepto.getIdConcepto() >= 0, "El ID autogenerado debería ser válido y mayor o igual a 0.");
    }

    @Test
    void getNombre() {
        Concepto concepto = new Concepto("Derivadas", "Razón de cambio instantánea");
        assertEquals("Derivadas", concepto.getNombre(), "El nombre obtenido no coincide con el asignado.");
    }

    @Test
    void setNombre() {
        Concepto concepto = new Concepto();
        concepto.setNombre("Integrales");
        assertEquals("Integrales", concepto.getNombre(), "El nombre no se modificó correctamente con el setter.");
    }

    @Test
    void getDescripcion() {
        Concepto concepto = new Concepto("Sustitución", "Método de cambio de variable");
        assertEquals("Método de cambio de variable", concepto.getDescripcion(), "La descripción obtenida no coincide.");
    }

    @Test
    void setDescripcion() {
        Concepto concepto = new Concepto();
        concepto.setDescripcion("Área bajo la curva");
        assertEquals("Área bajo la curva", concepto.getDescripcion(), "La descripción no se modificó correctamente.");
    }

    @Test
    void testToString() {
        Concepto concepto = new Concepto("Prueba", "Definición corta");
        String resultadoToString = concepto.toString();

        assertNotNull(resultadoToString, "El método toString() devolvió null.");
        assertTrue(resultadoToString.contains("Prueba"), "El toString() no incluye el nombre del concepto.");
        assertTrue(resultadoToString.contains("Definición corta"), "El toString() no incluye la descripción.");
    }
}