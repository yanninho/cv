package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import com.avaje.ebean.Page;

/**
 * Représente un championnat pou l'exemple de gestion de base de données pour
 * l'application cv
 * 
 * @author Yannick Saint Martino
 * 
 */
@Entity
public class Championnat extends Model {

	private static final long serialVersionUID = -8752863343634366049L;

	/**
	 * identifiant unique auto-généré
	 */
	@Id
	public Long id;

	/**
	 * Nom du championnat (obligatoire)
	 */
	@Constraints.Required
	public String nom;

	/**
	 * identifiant dans la table image
	 */
	public Integer logo = 0;
	
	
	/**
	 * date de creation du championnat
	 */
	public String creation;

	/**
	 * site internet
	 */
	public String site;
	
	/**
	 * clé étrangère vers le pays du championnat
	 */
	@ManyToOne
	private Pays pays;

	/**
	 * Constructeur
	 * @param id unique du championnat
	 * @param nom du championnat
	 * @param pays du championnat
	 */
	public Championnat(Long id, String nom, Pays pays) {
		super();
		this.id = id;
		this.nom = nom;
		this.pays = pays;
	}

	/**
	 * ajoute les fonctionnalités CRUD de Ebean (play) 
	 */
	public static Finder<Long, Championnat> find = new Finder<Long, Championnat>(
			Long.class, Championnat.class);

	public static Page<Championnat> page(int page, int pageSize, String sortBy,
			String order, String filtreNom, String filtrePays) {
		return find.where()
				.ilike("nom", "%" + filtreNom + "%")
				.ilike("pays.nom", "%" + filtrePays + "%")
				.orderBy(sortBy + " " + order).findPagingList(pageSize)
				.getPage(page);
	}

	/**
	 * Recherche un championnat par son identifiant
	 * @param id a rechercher
	 * @return le championnat trouvé
	 */
	public static Championnat byId(Long id) {
		return find.byId(id);
	}
	
	
	/**
	 * Retourne le nombre total de championnat
	 */
	public static int getNombreChampionnat(String filtreNom, String filtrePays) {
	    return find.where()
		    .ilike("nom", "%" + filtreNom + "%")
		    .ilike("pays.nom", "%" + filtrePays + "%")
		    .findRowCount();
	}

	public Pays getPays() {
	    return pays;
	}

	public void setPays(Pays pays) {
	    this.pays = pays;
	}

	public static Championnat getChampionnat(Long id) {
	    return find.byId(id);
        }

	
	
}
