package Model;

import java.util.Objects;

public class Restaurant {
	private int id_Restaurant;
	private Preference pref;
	private int tier;
	private String type;
	private String name;
	private String gps;
	private int score;
	private int movil;
	
	public Restaurant(int id_Restaurant, Preference pref, int tier, String type, String name, String gps, int score,
			int movil) {
		super();
		this.id_Restaurant = id_Restaurant;
		this.pref = pref;
		this.tier = tier;
		this.type = type;
		this.name = name;
		this.gps = gps;
		this.score = score;
		this.movil = movil;
	}
	
	public int getId_Restaurant() {
		return id_Restaurant;
	}
	public Preference getPref() {
		return pref;
	}
	public int getTier() {
		return tier;
	}
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public String getGps() {
		return gps;
	}
	public int getScore() {
		return score;
	}
	public int getMovil() {
		return movil;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gps, id_Restaurant, movil, name, pref, score, tier, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(gps, other.gps) && id_Restaurant == other.id_Restaurant && movil == other.movil
				&& Objects.equals(name, other.name) && Objects.equals(pref, other.pref) && score == other.score
				&& tier == other.tier && Objects.equals(type, other.type);
	}
	
}
