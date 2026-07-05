package ec.edu.uce.miproyecto.dominio;

import ec.edu.uce.miproyecto.enums.Genero;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void iniciarSesion() {
        Date fechaPrueba = new Date();
        Usuario usuario = new Estudiante("Jeremy", "jeremy@uce.edu.ec", "1234", fechaPrueba, Genero.M, "Principiante", new Progreso());

        assertTrue(usuario.iniciarSesion("jeremy@uce.edu.ec", "1234"), "El inicio de sesión debería ser exitoso con las credenciales correctas.");

        assertFalse(usuario.iniciarSesion("jeremy@uce.edu.ec", "clave_erronea"), "El inicio de sesión debería fallar con una contraseña incorrecta.");
    }

    @Test
    void cerrarSesion() {
        Date fechaPrueba = new Date();
        Usuario usuario = new Estudiante("Jeremy", "jeremy@uce.edu.ec", "1234", fechaPrueba, Genero.M, "Principiante", new Progreso());

        assertDoesNotThrow(() -> usuario.cerrarSesion(), "El método cerrarSesion() no debería lanzar ninguna excepción.");
    }

    @Test
    void verProgreso() {
        Date fechaPrueba = new Date();
        Usuario estudiante = new Estudiante("Jeremy", "jeremy@uce.edu.ec", "1234", fechaPrueba, Genero.M, "Principiante", new Progreso());
// Agregamos Genero.M antes del último String
        Usuario docente = new Docente("Ing. Lara", "lara@uce.edu.ec", "abcd", fechaPrueba, Genero.M, "Sistemas");
        assertDoesNotThrow(() -> estudiante.verProgreso(), "El verProgreso de Estudiante no debe lanzar excepciones.");
        assertDoesNotThrow(() -> docente.verProgreso(), "El verProgreso de Docente no debe lanzar excepciones.");
    }

    @Test
    void testEquals() {
        Date fecha = new Date();
        // Al quitar los IDs manuales, cada instancia tendrá un ID secuencial propio y único
        Usuario usuario1 = new Estudiante("Jeremy", "jeremy@uce.edu.ec", "1234", fecha, Genero.M, "Principiante", new Progreso());
        Usuario usuario2 = new Estudiante("Pedro", "pedro@uce.edu.ec", "pass", fecha, Genero.M, "Principiante", new Progreso());

        assertNotEquals(usuario1, usuario2, "No deberían ser iguales porque tienen diferentes idUsuario generados por el contador.");
    }

    @Test
    void getIdUsuario() {
        Date fechaPrueba = new Date();
        Usuario usuario = new Estudiante("Pedro", "pedro@uce.edu.ec", "pass", fechaPrueba, Genero.M, "Principiante", new Progreso());

        // Verificamos que el ID automático sea válido
        assertTrue(usuario.getIdUsuario() >= 0, "El ID de usuario obtenido debe ser autogenerado y válido.");
    }

    @Test
    void getNombre() {
        Date fechaPrueba = new Date();
        Usuario usuario = new Estudiante("Ing. Lara", "lara@uce.edu.ec", "abcd", fechaPrueba, Genero.M, "Avanzado", new Progreso());
        assertEquals("Ing. Lara", usuario.getNombre(), "El nombre obtenido no coincide.");
    }

    @Test
    void setNombre() {
        Usuario usuario = new Estudiante();
        usuario.setNombre("Carlos");
        assertEquals("Carlos", usuario.getNombre(), "El nombre no se modificó correctamente con el setter.");
    }

    @Test
    void getEmail() {
        Date fechaPrueba = new Date();
        Usuario usuario = new Estudiante("Jeremy", "jeremy@uce.edu.ec", "1234", fechaPrueba, Genero.M, "Principiante", new Progreso());
        assertEquals("jeremy@uce.edu.ec", usuario.getEmail(), "El correo obtenido no coincide.");
    }

    @Test
    void setEmail() {
        Usuario usuario = new Estudiante();
        usuario.setEmail("nuevo@uce.edu.ec");
        assertEquals("nuevo@uce.edu.ec", usuario.getEmail(), "El correo no se modificó correctamente.");
    }

    @Test
    void getContrasena() {
        Date fechaPrueba = new Date();
        Usuario usuario = new Estudiante("Jeremy", "jeremy@uce.edu.ec", "1234", fechaPrueba, Genero.M, "Principiante", new Progreso());
        assertEquals("1234", usuario.getContrasena(), "La contraseña obtenida no coincide.");
    }

    @Test
    void setContrasena() {
        Usuario usuario = new Estudiante();
        usuario.setContrasena("secure99");
        assertEquals("secure99", usuario.getContrasena(), "La contraseña no se modificó correctamente.");
    }

    @Test
    void getFechaRegistro() {
        Date fechaPrueba = new Date();
        Usuario usuario = new Estudiante("Jeremy", "jeremy@uce.edu.ec", "1234", fechaPrueba, Genero.M, "Principiante", new Progreso());
        assertNotNull(usuario.getFechaRegistro(), "La fecha de registro no debería ser nula.");
        assertEquals(fechaPrueba, usuario.getFechaRegistro(), "La fecha de registro obtenida no coincide.");
    }

    @Test
    void setFechaRegistro() {
        Usuario usuario = new Estudiante();
        Date nuevaFecha = new Date();
        usuario.setFechaRegistro(nuevaFecha);
        assertEquals(nuevaFecha, usuario.getFechaRegistro(), "La fecha de registro no se modificó correctamente.");
    }

    @Test
    void testToString() {
        Date fechaPrueba = new Date();
        Usuario usuario = new Estudiante("Jeremy", "jeremy@uce.edu.ec", "1234", fechaPrueba, Genero.M, "Principiante", new Progreso());

        String resultadoToString = usuario.toString();

        assertNotNull(resultadoToString, "El método toString() devolvió null.");
        assertTrue(resultadoToString.contains("Jeremy"), "El toString() no incluye el nombre del usuario.");
        assertTrue(resultadoToString.contains("jeremy@uce.edu.ec"), "El toString() no incluye el email del usuario.");
    }
}