package cibertec.edu.pe.proyecto_prestamos_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.edu.pe.proyecto_prestamos_rest.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByMail(String mail);
}
