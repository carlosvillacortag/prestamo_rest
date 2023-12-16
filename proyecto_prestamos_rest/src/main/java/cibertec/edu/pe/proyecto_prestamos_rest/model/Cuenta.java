package cibertec.edu.pe.proyecto_prestamos_rest.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cuentas")
@NoArgsConstructor
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	private String numeroCuenta;

	@Column(nullable = false, unique = true)
	private String banco;

	@Column(nullable = false, unique = true)
	private String codigoBanco;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarios_id", referencedColumnName="id")
	private Usuario usuario;

	public Cuenta(String numeroCuenta, String banco, String codigoBanco) {
		this.numeroCuenta = numeroCuenta;
		this.banco = banco;
		this.codigoBanco = codigoBanco;
	}
}
