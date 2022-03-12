package cat.dbuenov.app.bean;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Empleat {

	private @Id @GeneratedValue Long id;
	private String nom;
	private String feina;
	private float sou;
	
	
	public Empleat(){
		
	}	
	
	public Empleat(String nom, String feina) {
		this.nom= nom;
		this.feina= feina;
		setSou();		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getFeina() {
		return feina;
	}

	public void setFeina(String feina) {
		this.feina = feina;		
	}
	
	public float getSou() {
		return sou;
	}

	// depen de la feina rep un sou
	
	public void setSou() {
		
		if (this.feina.equalsIgnoreCase("tecnic")) {
			this.sou = 1600F;
		}else if(this.feina.equalsIgnoreCase("comercial")) {
			this.sou = 1800F;
		}else if(this.feina.equalsIgnoreCase("gerent")) {
			this.sou = 2000F;
		}else {
			this.sou = 1000F;
		}
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(feina, id, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleat other = (Empleat) obj;
		return Objects.equals(feina, other.feina) && Objects.equals(id, other.id) && Objects.equals(nom, other.nom);
	}

	@Override
	public String toString() {
		return "Empleat [id=" + id + ", nom=" + nom + ", feina=" + feina + "]";
	}
	
	
	
}
