package cibertec.edu.pe.proyecto_prestamos_rest.service;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.proyecto_prestamos_rest.model.Usuario;
import cibertec.edu.pe.proyecto_prestamos_rest.repository.UsuarioRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByMail(username);

		if (usuario != null) {
			return new org.springframework.security.core.userdetails
					.User(usuario.getMail(),usuario.getPassword(), getGrantedAuthority(usuario));
		} else {
			throw new UsernameNotFoundException("Usuario Invalido");
		}
	}
	
	private Collection<GrantedAuthority> getGrantedAuthority(Usuario usuario){
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
		//asignando autoridad segun los roles a los usuarios
		if (usuario.getRoles().getNombre().equalsIgnoreCase("admin")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		} if (usuario.getRoles().getNombre().equalsIgnoreCase("jefe_prestamista")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_JEFE"));
			} if (usuario.getRoles().getNombre().equalsIgnoreCase("prestamista")) {
				authorities.add(new SimpleGrantedAuthority("ROLE_PRESTAMISTA"));
				}  
		authorities.add(new SimpleGrantedAuthority("ROLE_USUARIO"));
		return authorities;
	}
	

}