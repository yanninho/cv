package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * Représente un type d'information pour le centre d'information
 * */

@Entity
public class TypeInformation extends Model{

	private static final long serialVersionUID = -6496050147337072574L;

	/**
	 * identifiant unique auto-généré
	 */
	@Id
	public Long id;

	/**
	 * Nom du type (obligatoire)
	 */
	@Constraints.Required
	public String nom;	
	
	/**
	 * prefixe image
	 */
	public String prefixImage;

	/**
	 * ajoute les fonctionnalités CRUD de Ebean (play) 
	 */
	public static Finder<Long, TypeInformation> find = new Finder<Long, TypeInformation>(
			Long.class, TypeInformation.class);


	public TypeInformation(Long id, String nom, String prefixImage) {
		super();
		this.id = id;
		this.nom = nom;
		this.prefixImage = prefixImage;
	}	
	
	
}
