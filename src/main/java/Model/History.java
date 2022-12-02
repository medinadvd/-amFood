package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="Historial")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class History {
	
	private String mail;
	private int id_Restaurant;
	private boolean fav = false;

	
}
