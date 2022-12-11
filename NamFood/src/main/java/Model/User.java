package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@Column(name = "correo")
	private String mail;
	
	@Column(name = "nombre")
	private String username;
	
	@Column(name = "contraseña")
	private String password;
	
	@Column(name = "idrestaurante")
	private int id_Restaurant;

}
