package Model;

import java.util.Objects;

public class History {
	
	private String mail;
	private int id_Restaurant;
	private boolean fav = false;
	
	public History(String mail, int id_Restaurant, boolean fav) {
		this.mail = mail;
		this.id_Restaurant = id_Restaurant;
		this.fav = fav;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getId_Restaurant() {
		return id_Restaurant;
	}

	public void setId_Restaurant(int id_Restaurant) {
		this.id_Restaurant = id_Restaurant;
	}

	public boolean isFav() {
		return fav;
	}

	public void setFav(boolean fav) {
		this.fav = fav;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fav, id_Restaurant, mail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		History other = (History) obj;
		return fav == other.fav && id_Restaurant == other.id_Restaurant && Objects.equals(mail, other.mail);
	}
	
}
