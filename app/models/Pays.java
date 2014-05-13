package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Pays extends Model {

	private static final long serialVersionUID = -2080433897917554635L;
	
	@Id
	public Long id;
	private String nom;
	private Integer drapeau = 0;
	
	public Pays(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public static Finder<Long,Pays> find = new Finder<Long,Pays>(Long.class, Pays.class);

	public String getNom() {
	    return nom;
	}

	public void setNom(String nom) {
	    this.nom = nom;
	}

	public Integer getDrapeau() {
	    return drapeau;
	}

	public void setDrapeau(Integer drapeau) {
	    this.drapeau = drapeau;
	} 
	
}
