package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="Usuario")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {

	private String mail;
	private String username;
	private String password;
	private int id_Restaurant;

}
