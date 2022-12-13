package com.Namfood.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "restaurante")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idrestaurante")
	private int id_Restaurant;

	@Column(name = "tierRestaurante")
	private int tier;

	@Column(name = "Nombre")
	private String name;

	@Column(name = "Localizacion")
	private String gps;

	@Column(name = "Tipo_comida")
	private String type;

	@Column(name = "Puntuacion")
	private int score;

	@Column(name = "Telefono")
	private int movil;

}
