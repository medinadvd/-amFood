package com.Namfood.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "preferencias_user")
@Data
public class PreferenceUser {
	@Id
	@Column(name = "correo")
	private String correo;

	@Column(name = "vegetariano")
	private int vegetariano = 0;

	@Column(name = "vegano")
	private int vegano = 0;

	@Column(name = "halal")
	private int halal = 0;

	@Column(name = "gluten_free")
	private int gluten_free = 0;

}
