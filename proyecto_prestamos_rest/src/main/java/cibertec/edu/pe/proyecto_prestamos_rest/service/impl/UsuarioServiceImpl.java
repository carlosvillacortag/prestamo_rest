package cibertec.edu.pe.proyecto_prestamos_rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.proyecto_prestamos_rest.model.Usuario;
import cibertec.edu.pe.proyecto_prestamos_rest.repository.UsuarioRepository;
import cibertec.edu.pe.proyecto_prestamos_rest.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	// Método para guardar/actualizar
	@Override
	public Usuario saveUsuario(Usuario Usuario) {
		return usuarioRepository.save(Usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario Usuario, int id) {
		Usuario usuarioFound = usuarioRepository.findById(id).get();

		usuarioFound.setNombres(Usuario.getNombres());
		usuarioFound.setApellidos(Usuario.getApellidos());
		usuarioFound.setDni(Usuario.getDni());
		usuarioFound.setPassword(Usuario.getPassword());
		usuarioFound.setRegistro(Usuario.getRegistro());
		usuarioFound.setDireccion(Usuario.getDireccion());
		usuarioFound.setMail(Usuario.getMail());
		// usuarioFound.setGrupos(Usuario.getGrupos());

		return usuarioRepository.save(usuarioFound);
	}

	@Override
	public void deleteUsuario(int id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public Optional<Usuario> findUsuarioById(int id) {
		return usuarioRepository.findById(id);
	}

}