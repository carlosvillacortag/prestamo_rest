package cibertec.edu.pe.proyecto_prestamos_rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.proyecto_prestamos_rest.model.Prestamo;
import cibertec.edu.pe.proyecto_prestamos_rest.repository.PrestamoRepository;
import cibertec.edu.pe.proyecto_prestamos_rest.service.PrestamoService;

@Service
public class PrestamoServiceImpl implements PrestamoService {

	@Autowired
	private PrestamoRepository prestamoRepository;

	@Override
	public List<Prestamo> getAllPrestamos() {
		return prestamoRepository.findAll();
	}

	// Método para guardar/actualizar
	@Override
	public Prestamo savePrestamo(Prestamo Prestamo) {
		return prestamoRepository.save(Prestamo);
	}

	@Override
	public Prestamo updatePrestamo(Prestamo Prestamo, int id) {
		Prestamo prestamoFound = prestamoRepository.findById(id).get();

		prestamoFound.setFechaSolicitud(Prestamo.getFechaSolicitud());
		prestamoFound.setMontoPrestamo(Prestamo.getMontoPrestamo());
		prestamoFound.setNroCuotas(Prestamo.getNroCuotas());
		prestamoFound.setTasa(Prestamo.getTasa());
		prestamoFound.setFechaAprobacion(Prestamo.getFechaAprobacion());
		prestamoFound.setEstado(Prestamo.getEstado());

		return prestamoRepository.save(prestamoFound);
	}

	@Override
	public void deletePrestamo(int id) {
		prestamoRepository.deleteById(id);
	}

	@Override
	public Optional<Prestamo> findPrestamoById(int id) {
		return prestamoRepository.findById(id);
	}

}