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

import cibertec.edu.pe.proyecto_prestamos_rest.model.Prestamo;
import cibertec.edu.pe.proyecto_prestamos_rest.service.PrestamoService;


@RestController
public class PrestamoController {
	
    @Autowired
    private PrestamoService prestamoService;

    //Guardar nuevo Prestamo
    @PostMapping("/prestamo")
    public ResponseEntity<Prestamo> savePrestamo(@RequestBody Prestamo Prestamo){
        //return PrestamoService.savePrestamo(Prestamo);
        try{
            prestamoService.savePrestamo(Prestamo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Listar todos los Prestamos
    @GetMapping("/prestamo")
    public List<Prestamo> getAllPrestamos(){
        return prestamoService.getAllPrestamos();
    }

    //Actualizar un Prestamo
    @PutMapping("/prestamo/{id}")
    public Prestamo updatePrestamo(@RequestBody Prestamo Prestamo,
                                   @PathVariable("id") int id){
        return prestamoService.updatePrestamo(Prestamo, id);
    }

    //Eliminar Prestamo
    @DeleteMapping("/prestamo/{id}")
    public String deletePrestamo(@PathVariable("id") int id){
        prestamoService.deletePrestamo(id);
        return "Prestamo eliminado correctamente";
    }

    //Buscar Prestamo por Id
    @GetMapping("/prestamo/{id}")
    public ResponseEntity<Prestamo> findPrestamoById(@PathVariable("id") int id){
        //return PrestamoService.findPrestamoById(id);
        if (prestamoService.findPrestamoById(id).isPresent()) {
            return new ResponseEntity<>(prestamoService.findPrestamoById(id).get(),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}