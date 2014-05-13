package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * Représente un type d'information pour le centre d'information
 * */

@Entity
public class TypeConnaissance extends Model{

	private static final long serialVersionUID = 8713161154565791532L;

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
	
	@OneToMany(cascade=CascadeType.ALL)
	public List<Connaissance> connaissances;
	
	/**
	 * ajoute les fonctionnalités CRUD de Ebean (play) 
	 */
	public static Finder<Long, TypeConnaissance> find = new Finder<Long, TypeConnaissance>(
			Long.class, TypeConnaissance.class);


	public TypeConnaissance(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}	
		
}
