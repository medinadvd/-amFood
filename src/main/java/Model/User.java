package Model;

import java.util.Objects;

public class User {

	private String mail;
	private String username;
	private String password;
	private int id_Restaurant;

	public User(String mail, String username, String password, int id_Restaurant) {
		super();
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.id_Restaurant = id_Restaurant;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_Restaurant() {
		return id_Restaurant;
	}

	public void setId_Restaurant(int id_Restaurant) {
		this.id_Restaurant = id_Restaurant;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_Restaurant, mail, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id_Restaurant == other.id_Restaurant && Objects.equals(mail, other.mail)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

}
