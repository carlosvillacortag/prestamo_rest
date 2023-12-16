package cibertec.edu.pe.proyecto_prestamos_rest.service;

import java.util.List;
import java.util.Optional;

import cibertec.edu.pe.proyecto_prestamos_rest.model.Usuario;

public interface UsuarioService {
	
	 //Guardar nuevo Usuario
    Usuario saveUsuario(Usuario usuario);

    //Obtener el listado de todos los Usuarios
    List<Usuario> getAllUsuarios();

    //Actualizar Usuario
    Usuario updateUsuario(Usuario usuario, int id);

    //Eliminar Usuario
    void deleteUsuario(int id);

    //Busqueda de Usuario por Id
    Optional<Usuario> findUsuarioById(int id);
	
}