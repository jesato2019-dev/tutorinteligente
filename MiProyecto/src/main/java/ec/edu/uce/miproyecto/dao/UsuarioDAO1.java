package ec.edu.uce.miproyecto.dao;

import ec.edu.uce.miproyecto.dominio.*;
import ec.edu.uce.miproyecto.enums.EstadoEjercicio;
import ec.edu.uce.miproyecto.enums.Genero;
import java.util.Date;

public class UsuarioDAO1 implements UsuarioDAO {

    private static UsuarioDAO1 instancia;

    private Usuario[] listaUsuarios;
    private Tema[] listaTemas;
    private ItemEjercicio[] listaItemE;
    private int numUsuarios;
    private int numTemas;
    private int numItemE;

    private UsuarioDAO1() {
        this.listaUsuarios = new Usuario[100];
        this.listaTemas = new Tema[100];
        this.listaItemE = new ItemEjercicio[100];
        this.numUsuarios = 0;
        this.numTemas = 0;
        this.numItemE = 0;
        inicializar();
    }

    public static synchronized UsuarioDAO1 getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDAO1();
        }
        return instancia;
    }

    private void inicializar() {
        Progreso p1 = new Progreso();
        Estudiante e1 = new Estudiante("Jeremy", "jeremy@uce.edu.ec", "1234", new Date(), Genero.M, "Principiante", p1);
        Docente d1 = new Docente("Ing. Lara", "lara@uce.edu.ec", "abcd", new Date(), Genero.F, "Cálculo");
        Pista pista1 = new Pista("Usa la regla de la potencia", 1);
        Ejercicio ej1 = new Ejercicio("Integral de 2x", "x^2", "Fácil", new Pista[]{pista1});
        Concepto c1 = new Concepto("Sustitución", "Cambio de variable");

        registrar(e1);
        registrar(d1);
        agregarEjercicio(ej1);

        if (numTemas < listaTemas.length) {
            listaTemas[numTemas] = new Tema("Integrales", "Cálculo Integral", new Concepto[]{c1}, new Ejercicio[]{ej1});
            numTemas++;
        }
    }

    @Override
    public boolean validarDuplicado(Object o) {
        if (o == null || !(o instanceof Usuario)) return false;
        Usuario nuevoUsuario = (Usuario) o;
        for (int i = 0; i < numUsuarios; i++) {
            if (listaUsuarios[i] != null && listaUsuarios[i].equals(nuevoUsuario)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean registrar(Usuario usuario) {
        if (usuario == null) return false;
        if (validarDuplicado(usuario)) {
            System.out.println(" Error: El usuario con ese correo ya existe.");
            return false;
        }
        if (numUsuarios >= listaUsuarios.length) {
            Usuario[] aux = new Usuario[listaUsuarios.length * 2];
            System.arraycopy(listaUsuarios, 0, aux, 0, listaUsuarios.length);
            this.listaUsuarios = aux;
        }
        listaUsuarios[numUsuarios] = usuario;
        numUsuarios++;
        return true;
    }

    @Override
    public void registrar(Usuario[] nuevosUsuarios) {
        if (nuevosUsuarios == null) return;
        for (Usuario u : nuevosUsuarios) {
            if (u != null) registrar(u);
        }
    }

    @Override
    public boolean editar(int pos, String nombre, String email, String contrasena) {
        if (pos >= 0 && pos < numUsuarios && listaUsuarios[pos] != null) {
            listaUsuarios[pos].setNombre(nombre);
            listaUsuarios[pos].setEmail(email);
            listaUsuarios[pos].setContrasena(contrasena);
            return true;
        }
        return false;
    }

    @Override
    public Usuario buscarPorCorreo(String credencial) {
        for (int i = 0; i < numUsuarios; i++) {
            Usuario u = listaUsuarios[i];
            if (u != null && (u.getEmail().equalsIgnoreCase(credencial) || u.getNombre().equalsIgnoreCase(credencial))) {
                return u;
            }
        }
        return null;
    }

    @Override
    public String consultarTodos() {
        StringBuilder texto = new StringBuilder("== LISTA DE USUARIOS REGISTRADOS ==\n");
        for (int i = 0; i < numUsuarios; i++) {
            if (listaUsuarios[i] != null) {
                texto.append(listaUsuarios[i].toString()).append("\n");
            }
        }
        if (numUsuarios == 0) texto.append("No hay usuarios registrados.\n");
        return texto.toString();
    }

    public void agregarEjercicio(Ejercicio ejercicio) {
        if (ejercicio != null && numItemE < listaItemE.length) {
            listaItemE[numItemE] = new ItemEjercicio(ejercicio, EstadoEjercicio.Pendiente);
            numItemE++;
        }
    }

    public String buscarPistaRecursiva(Pista[] pistas, int indice, int ordenBuscado) {
        if (pistas == null || indice >= pistas.length) return "No se encontró la pista.";
        if (pistas[indice] != null && pistas[indice].getOrden() == ordenBuscado) {
            return pistas[indice].getDescripcion();
        }
        return buscarPistaRecursiva(pistas, indice + 1, ordenBuscado);
    }

    public Usuario[] getListaUsuarios() { return listaUsuarios; }
    public int getNumUsuarios() { return numUsuarios; }
}