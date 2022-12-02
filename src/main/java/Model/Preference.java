package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="Preferencias")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Preference {
	private String id;
	private boolean vegan = false;
	private boolean vege = false;
	private boolean halal = false;
	private boolean glutenfree = false;
	
}