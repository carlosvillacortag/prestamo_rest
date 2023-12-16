package cibertec.edu.pe.proyecto_prestamos_rest.service;

import cibertec.edu.pe.proyecto_prestamos_rest.model.Cuenta;

public interface CuentaService {
	
	Cuenta findByNumeroCuenta(String numeroCuenta);

	void guardarCuenta(Cuenta cuenta);

	Cuenta obtenerCuentaPorId(int id);

	void eliminarCuentaPorId(int id);
	
}
