package cibertec.edu.pe.proyecto_prestamos_rest.service;

import java.util.List;
import java.util.Optional;

import cibertec.edu.pe.proyecto_prestamos_rest.model.Prestamo;

public interface PrestamoService {

	 //Guardar nuevo Prestamo
    Prestamo savePrestamo(Prestamo prestamo);

    //Obtener el listado de todos los Prestamos
    List<Prestamo> getAllPrestamos();

    //Actualizar Prestamo
    Prestamo updatePrestamo(Prestamo prestamo, int id);

    //Eliminar Prestamo
    void deletePrestamo(int id);

    //Busqueda de Prestamo por Id
    Optional<Prestamo> findPrestamoById(int id);
}
