package cibertec.edu.pe.proyecto_prestamos_rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.proyecto_prestamos_rest.model.Grupo;
import cibertec.edu.pe.proyecto_prestamos_rest.repository.GrupoRepository;
import cibertec.edu.pe.proyecto_prestamos_rest.service.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService {

	@Autowired
	GrupoRepository grupoRepository;
	
	@Override
	public List<Grupo> getAllGrupos() {
		return grupoRepository.findAll();
	}
}
