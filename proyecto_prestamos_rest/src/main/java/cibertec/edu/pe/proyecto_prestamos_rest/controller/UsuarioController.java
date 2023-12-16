package cibertec.edu.pe.proyecto_prestamos_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cibertec.edu.pe.proyecto_prestamos_rest.model.Usuario;
import cibertec.edu.pe.proyecto_prestamos_rest.service.UsuarioService;


@RestController
public class UsuarioController {
	
    @Autowired
    private UsuarioService usuarioService;

    //Guardar nuevo Usuario
    @PostMapping("/usuario")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario Usuario){
        //return UsuarioService.saveUsuario(Usuario);
        try{
            usuarioService.saveUsuario(Usuario);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Listar todos los Usuarios
    @GetMapping("/usuario")
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    //Actualizar un Usuario
    @PutMapping("/usuario/{id}")
    public Usuario updateUsuario(@RequestBody Usuario Usuario,
                                   @PathVariable("id") int id){
        return usuarioService.updateUsuario(Usuario, id);
    }

    //Eliminar Usuario
    @DeleteMapping("/usuario/{id}")
    public String deleteUsuario(@PathVariable("id") int id){
        usuarioService.deleteUsuario(id);
        return "Usuario eliminado correctamente";
    }

    //Buscar Usuario por Id
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> findUsuarioById(@PathVariable("id") int id){
        //return UsuarioService.findUsuarioById(id);
        if (usuarioService.findUsuarioById(id).isPresent()) {
            return new ResponseEntity<>(usuarioService.findUsuarioById(id).get(),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}