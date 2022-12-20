package com.Namfood.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "historial")
@Data
public class History {
	
	@Id
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "id_restaurante")
	private int id_restaurante;
	
	@Column(name = "favorito")
	private boolean favorito = false;
	
}
