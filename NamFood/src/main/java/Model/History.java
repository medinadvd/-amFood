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
@Table(name = "historial")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
public class History {
	
	@Id
	@Column(name = "correo")
	private String mail;
	
	@Column(name = "idrestaurante")
	private int id_Restaurant;
	
	@Column(name = "favorito")
	private boolean fav = false;
	
}
