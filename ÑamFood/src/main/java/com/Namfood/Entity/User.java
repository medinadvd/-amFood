package com.Namfood.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

	@Id
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "password")
	private String password;

}
