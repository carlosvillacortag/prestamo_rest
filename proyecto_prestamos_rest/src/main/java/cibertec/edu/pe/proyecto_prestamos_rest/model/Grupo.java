package cibertec.edu.pe.proyecto_prestamos_rest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "grupos")
@NoArgsConstructor
public class Grupo {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		@Column(nullable = false, unique = true)
		private String nombre;
		
		public Grupo(String nombre) {
			this.nombre = nombre;
		}

}
