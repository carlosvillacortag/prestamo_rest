package cibertec.edu.pe.proyecto_prestamos_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.edu.pe.proyecto_prestamos_rest.model.Rol;


public interface RolRepository extends JpaRepository<Rol, Integer> {

	Rol findByNombre(String nombre);

}
