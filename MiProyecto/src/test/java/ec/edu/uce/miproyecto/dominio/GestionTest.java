package ec.edu.uce.miproyecto.dominio;

import ec.edu.uce.miproyecto.enums.Genero;
import ec.edu.uce.miproyecto.enums.EstadoEjercicio;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class GestionTest {

    @Test
    void registrarUsuario() {
        Gestion gestion = new Gestion();
        Estudiante estudiante = new Estudiante("Jeremy", "jeremy@uce.edu.ec", "1234", new Date(), Genero.M, "Principiante", new Progreso());

        gestion.registrarUsuario(estudiante);

        assertEquals(1, gestion.getNumUsuarios(), "El contador de usuarios no se incrementó.");
        assertEquals(estudiante, gestion.getListaUsuarios()[0], "El usuario guardado en la posición 0 no coincide.");
    }

    @Test
    void buscarUsuarioPorCorreo() {
        Gestion gestion = new Gestion();
        Docente docente = new Docente("Ing. Lara", "lara@uce.edu.ec", "abcd", new Date(), Genero.M, "Cálculo");
        gestion.registrarUsuario(docente);

        Usuario encontradoPorEmail = gestion.buscarUsuarioPorCorreo("lara@uce.edu.ec");
        assertNotNull(encontradoPorEmail, "No se pudo encontrar al usuario por su correo exacto.");
        assertEquals("Ing. Lara", encontradoPorEmail.getNombre(), "El usuario encontrado no es el correcto.");

        Usuario encontradoPorNombreMayus = gestion.buscarUsuarioPorCorreo("ING. LARA");
        assertNotNull(encontradoPorNombreMayus, "La búsqueda falló al usar mayúsculas.");

        Usuario noExiste = gestion.buscarUsuarioPorCorreo("falso@uce.edu.ec");
        assertNull(noExiste, "El método debería retornar null si el usuario no existe.");
    }

    @Test
    void agregarEjercicio() {
        Gestion gestion = new Gestion();
        Ejercicio ejercicio = new Ejercicio("Integral de 2x", "x^2", "Fácil", new Pista[0]);

        gestion.agregarEjercicio(ejercicio);

        assertEquals(1, gestion.getNumItemE(), "El ejercicio no se incrementó en el contador.");

        // Accedemos directamente a la posición usando el atributo que hereda el test o la simulación
        // Como no tienes implementado getListaItemE(), comprobamos a través del contador
        assertTrue(gestion.getNumItemE() > 0);
    }

    @Test
    void getListaUsuarios() {
        Gestion gestion = new Gestion();

        assertNotNull(gestion.getListaUsuarios(), "La lista de usuarios debería estar inicializada.");
        assertEquals(0, gestion.getNumUsuarios(), "Debería haber 0 usuarios registrados al inicializar.");
    }

    @Test
    void setListaUsuarios() {
        Gestion gestion = new Gestion();
        Usuario[] nuevaLista = new Usuario[100];
        nuevaLista[0] = new Estudiante("Jeremy", "j@uce.edu.ec", "1", new Date(), Genero.M, "P", new Progreso());

        gestion.setListaUsuarios(nuevaLista);
        assertNotNull(gestion.getListaUsuarios());
    }

    @Test
    void testToString() {
        Gestion gestion = new Gestion();
        gestion.registrarUsuario(new Estudiante("Jeremy", "j@uce.edu.ec", "1", new Date(), Genero.M, "P", new Progreso()));

        String resultadoToString = gestion.toString();
        assertNotNull(resultadoToString, "El método toString() devolvió null.");
    }
}