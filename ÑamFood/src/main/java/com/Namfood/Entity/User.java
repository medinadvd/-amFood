package com.Namfood.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@Column(name = "correo")
	private String mail;
	
	@Column(name = "nombre")
	private String username;
	
	@Column(name = "contraseña")
	private String password;
	
	@Column(name = "idrestaurante")
	private int id_Restaurant;

}
