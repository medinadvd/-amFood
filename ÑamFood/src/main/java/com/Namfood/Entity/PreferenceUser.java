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
@Table(name = "preferencias_user")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
public class PreferenceUser {
	@Id
	@Column(name = "correo")
	private String mail;

	@Column(name = "vegetariano")
	private boolean vege = false;

	@Column(name = "vegano")
	private boolean vegan = false;

	@Column(name = "halal")
	private boolean halal = false;

	@Column(name = "gluten_free")
	private boolean glutenfree = false;

}
