package Model;

import java.util.Objects;

public class Preference {
	private String id;
	private boolean vegan = false;
	private boolean vege = false;
	private boolean halal = false;
	private boolean glutenfree = false;
	
	public Preference(String id) {
		this.id = id;
	}

	public Preference(String id, boolean vegan, boolean vege, boolean halal, boolean glutenfree) {
		super();
		this.id = id;
		this.vegan = vegan;
		this.vege = vege;
		this.halal = halal;
		this.glutenfree = glutenfree;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	public boolean isVege() {
		return vege;
	}

	public void setVege(boolean vege) {
		this.vege = vege;
	}

	public boolean isHalal() {
		return halal;
	}

	public void setHalal(boolean halal) {
		this.halal = halal;
	}

	public boolean isGlutenfree() {
		return glutenfree;
	}

	public void setGlutenfree(boolean glutenfree) {
		this.glutenfree = glutenfree;
	}

	@Override
	public int hashCode() {
		return Objects.hash(glutenfree, halal, id, vegan, vege);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Preference other = (Preference) obj;
		return glutenfree == other.glutenfree && halal == other.halal && Objects.equals(id, other.id)
				&& vegan == other.vegan && vege == other.vege;
	}
	
}
