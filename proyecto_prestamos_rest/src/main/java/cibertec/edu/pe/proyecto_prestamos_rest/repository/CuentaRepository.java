package cibertec.edu.pe.proyecto_prestamos_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.edu.pe.proyecto_prestamos_rest.model.Cuenta;


public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

}
