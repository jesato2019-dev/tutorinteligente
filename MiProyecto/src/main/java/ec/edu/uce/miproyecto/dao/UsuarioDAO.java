package ec.edu.uce.miproyecto.dao;

import ec.edu.uce.miproyecto.dominio.Usuario;

public interface UsuarioDAO {
    boolean registrar(Usuario usuario);
    void registrar(Usuario[] nuevosUsuarios); 
    boolean editar(int pos, String nombre, String email, String contrasena);
    Usuario buscarPorCorreo(String credencial);
    String consultarTodos();
    boolean validarDuplicado(Object o);
}