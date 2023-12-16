package cibertec.edu.pe.proyecto_prestamos_rest.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "usuarios")
@NoArgsConstructor
public class Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String nombres;

	@Column(nullable = false)
	private String apellidos;

	@Column(nullable = false, unique = true)
	private String dni;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime registro = LocalDateTime.now();

	@Column(nullable = false)
	private String direccion;

	@Column(nullable = false, unique = true)
	private String mail;
		
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "grupos_id", referencedColumnName = "id")
    private Grupo grupos;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
	private Rol roles;
	
	public Usuario(String nombres, String apellidos, String dni, String password, LocalDateTime registro,String direccion,
			 String mail, Grupo grupos, Rol roles) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.password = password;
		this.registro= registro;
		this.direccion = direccion;
		this.mail = mail;
		this.grupos = grupos;
		this.roles = roles;
			
	}
}
