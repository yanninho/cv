package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import com.avaje.ebean.Page;

@Entity
public class Joueur extends Model {

	private static final long serialVersionUID = -3535467997822849277L;

	@Id
	public Long id;
	
	@Constraints.Required
	public String nom;
	
	@Constraints.Required
	public String prenom;
	
	@ManyToOne
	public Club club;
	
	public Joueur(Long id, String nom, String prenom, Club club) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.club = club;
	}
	
    public static Finder<Long,Joueur> find = new Finder<Long,Joueur>(
            Long.class, Joueur.class
        );

    public static Page<Joueur> page(int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
                .ilike("nom", "%" + filter + "%")
                .orderBy(sortBy + " " + order)
                .findPagingList(pageSize)
                .getPage(page);
    }
}
