package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

/**
 * Représente une connaissance pour le centre d'information
 * */

@Entity
public class Connaissance extends Model {

	private static final long serialVersionUID = 5276646601058227492L;

	/**
	 * identifiant unique auto-généré
	 */
	@Id
	public Long id;
	
	public String nom;
	
	public Integer level;
	
	public Integer importance;


	/**
	 * ajoute les fonctionnalités CRUD de Ebean (play)
	 */
	public static Finder<Long, Connaissance> find = new Finder<Long, Connaissance>(
			Long.class, Connaissance.class);

	public Connaissance(Long id, String nom, Integer level, Integer importance) {
		super();
		this.id = id;
		this.nom = nom;
		this.level = level;
		this.importance = importance;
	}

}
