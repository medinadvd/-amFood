package com.Namfood.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "preferencias_restaurante")
@Data
public class PreferenceRest {
	@Id
	@Column(name = "id_restaurante")
	private int id_restaurante;

	@Column(name = "vegetariano")
	private boolean vegetariano = false;

	@Column(name = "vegano")
	private boolean vegano = false;

	@Column(name = "halal")
	private boolean halal = false;

	@Column(name = "gluten_free")
	private boolean gluten_free = false;
}
