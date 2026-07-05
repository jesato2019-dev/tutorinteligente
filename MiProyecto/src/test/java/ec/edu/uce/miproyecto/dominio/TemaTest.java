package ec.edu.uce.miproyecto.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemaTest {

    @Test
    void getIdTema() {
        Concepto[] conceptosSimulados = new Concepto[0];
        Ejercicio[] ejerciciosSimulados = new Ejercicio[0];
        // CORREGIDO: Sin el número manual 7 al inicio
        Tema tema = new Tema("Integrales por Sustitución", "Métodos avanzados de integración", conceptosSimulados, ejerciciosSimulados);

        // Verificamos que el contador estático automático asigne un ID válido
        assertTrue(tema.getIdTema() >= 0, "El ID del tema debe ser autogenerado y válido.");
    }

    @Test
    void getNombre() {
        Concepto[] conceptosSimulados = new Concepto[0];
        Ejercicio[] ejerciciosSimulados = new Ejercicio[0];
        // CORREGIDO: Sin ID manual
        Tema tema = new Tema("Límites", "Introducción al cálculo", conceptosSimulados, ejerciciosSimulados);

        assertEquals("Límites", tema.getNombre(), "El nombre del tema obtenido no coincide.");
    }

    @Test
    void setNombre() {
        Tema tema = new Tema();
        tema.setNombre("Derivadas");

        assertEquals("Derivadas", tema.getNombre(), "El nombre no se modificó correctamente con el setter.");
    }

    @Test
    void getDescription() {
        Concepto[] conceptosSimulados = new Concepto[0];
        Ejercicio[] ejerciciosSimulados = new Ejercicio[0];
        // CORREGIDO: Sin ID manual
        Tema tema = new Tema("Álgebra Lineal", "Matrices y vectores", conceptosSimulados, ejerciciosSimulados);

        assertEquals("Matrices y vectores", tema.getDescripcion(), "La descripción obtenida no coincide.");
    }

    @Test
    void setDescripcion() {
        Tema tema = new Tema();
        tema.setDescripcion("Estudio del área bajo la curva");

        assertEquals("Estudio del área bajo la curva", tema.getDescripcion(), "La descripción no se modificó correctamente.");
    }

    @Test
    void getConceptos() {
        Concepto conceptoPrueba = new Concepto("Definición de Integral", "Operación inversa a la derivación");
        Concepto[] conceptosSimulados = new Concepto[]{conceptoPrueba};

        Ejercicio ejercicioPrueba = new Ejercicio("Calcular integral de x", "x^2/2", "Fácil", new Pista[0]);
        Ejercicio[] ejerciciosSimulados = new Ejercicio[]{ejercicioPrueba};

        Tema tema = new Tema("Integrales", "Cálculo", conceptosSimulados, ejerciciosSimulados);

        assertNotNull(tema.getConceptos(), "La lista de conceptos no debería ser nula.");
        assertEquals(1, tema.getConceptos().length, "La cantidad de conceptos no coincide.");
    }

    @Test
    void setConceptos() {
        Tema tema = new Tema();
        Concepto[] nuevosConceptos = new Concepto[2];

        tema.setConceptos(nuevosConceptos);

        assertNotNull(tema.getConceptos(), "El arreglo de conceptos no se asignó correctamente.");
        assertEquals(2, tema.getConceptos().length, "El tamaño del arreglo modificado no coincide.");
    }

    @Test
    void getEjercicios() {
        Concepto[] conceptosSimulados = new Concepto[0];
        // CORREGIDO: Sin ID manual en el ejercicio simulado
        Ejercicio ejercicioPrueba = new Ejercicio("Integral de x^2", "x^3/3", "Fácil", new Pista[0]);
        Ejercicio[] ejerciciosSimulados = new Ejercicio[]{ejercicioPrueba};

        // CORREGIDO: Sin ID manual en el tema
        Tema tema = new Tema("Cálculo Integral", "Prácticas", conceptosSimulados, ejerciciosSimulados);

        assertNotNull(tema.getEjercicios(), "El arreglo de ejercicios no debería ser nulo.");
        assertEquals(1, tema.getEjercicios().length, "La cantidad de ejercicios en el arreglo no coincide.");
        assertEquals("Integral de x^2", tema.getEjercicios()[0].getEnunciado(), "El ejercicio dentro del arreglo no coincide.");
    }

    @Test
    void setEjercicios() {
        Tema tema = new Tema();
        Ejercicio[] nuevosEjercicios = new Ejercicio[4];

        tema.setEjercicios(nuevosEjercicios);

        assertNotNull(tema.getEjercicios(), "El arreglo de ejercicios no se asignó correctamente.");
        assertEquals(4, tema.getEjercicios().length, "El tamaño del arreglo de ejercicios modificado no coincide.");
    }

    @Test
    void testToString() {
        Concepto[] conceptosSimulados = new Concepto[0];
        Ejercicio[] ejerciciosSimulados = new Ejercicio[0];
        // CORREGIDO: Sin ID manual
        Tema tema = new Tema("Geometría Analítica", "Secciones cónicas", conceptosSimulados, ejerciciosSimulados);

        String resultadoToString = tema.toString();

        assertNotNull(resultadoToString, "El método toString() devolvió null.");
        assertTrue(resultadoToString.contains("Geometría Analítica"), "El toString() no incluye el nombre del tema.");
        assertTrue(resultadoToString.contains("Secciones cónicas"), "El toString() no incluye la descripción.");
    }
}