package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="Restaurante")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Restaurant {
	private int id_Restaurant;
	private Preference pref;
	private int tier;
	private String type;
	private String name;
	private String gps;
	private int score;
	private int movil;
	
}
