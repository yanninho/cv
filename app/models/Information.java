package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * Représente une information pour le centre d'information
 * */

@Entity
public class Information extends Model {

	private static final long serialVersionUID = 7460778306269388082L;

	/**
	 * identifiant unique auto-généré
	 */
	@Id
	public Long id;

	@Constraints.Required
	public Integer ordre;

	public String texte = "";

	@ManyToOne
	public TypeInformation type;

	/**
	 * ajoute les fonctionnalités CRUD de Ebean (play)
	 */
	public static Finder<Long, Information> find = new Finder<Long, Information>(
			Long.class, Information.class);

	public Information(Long id, Integer ordre, String texte) {
		super();
		this.id = id;
		this.ordre = ordre;
		this.texte = texte;
	}

	public static Integer nbByTypeInformation(String type) {
	    return find.where()
		    .ieq("type.prefixImage", type)
		    .findRowCount();
	}

	public static Information getInformation(String type, int ordre) {

		Information info = find.where().ieq("ordre", "" + ordre)
				   .ieq("type.prefixImage", type).findUnique();
		return info;
	}

}
