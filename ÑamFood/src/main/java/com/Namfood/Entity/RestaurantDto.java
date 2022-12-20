package com.Namfood.Entity;

import lombok.Data;


@Data
public class RestaurantDto {

	private int id_restaurante;
	private int tier_restaurante;
	private String nombre;
	private String localizacion;
	private String tipo_comida;
	private int puntuacion;
	private int telefono;
	private String imagen;
	
	public RestaurantDto(Restaurant entity) {
		super();
		this.id_restaurante = entity.getId_restaurante();
		this.tier_restaurante = entity.getTier_restaurante();
		this.nombre = entity.getNombre();
		this.localizacion = entity.getLocalizacion();
		this.tipo_comida = entity.getTipo_comida();
		this.puntuacion = entity.getPuntuacion();
		this.telefono = entity.getTelefono();
		this.imagen = entity.getImagen();
	}

}
