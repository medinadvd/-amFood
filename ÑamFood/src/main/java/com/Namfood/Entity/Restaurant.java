package com.Namfood.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "restaurante")
@Data
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idrestaurante")
	private int idrestaurante;

	@Column(name = "tier_restaurante")
	private int tier_restaurante;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "localizacion")
	private String localizacion;

	@Column(name = "tipo_comida")
	private String tipo_comida;

	@Column(name = "puntuacion")
	private int puntuacion;

	@Column(name = "telefono")
	private int telefono;

}
