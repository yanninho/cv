package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import com.avaje.ebean.Page;

@Entity
public class Club extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String nom;

    @ManyToOne
    public Championnat championnat;

    public Integer logo = 0;
    
    public String premiereSaison;
    
    public Integer nombreTitres;
    
    public String nomComplet;
    
    public String surnoms;
    
    public String fondation;
    
    public String couleurs;
    
    public String siege;
    
    public String site;

    public Club(Long id, String nom, Championnat championnat) {
	this.id = id;
	this.nom = nom;
	this.championnat = championnat;
    }

    public static Finder<Long, Club> find = new Finder<Long, Club>(Long.class, Club.class);

    public static Page<Club> page(int page, int pageSize, String sortBy, String order, String filter, Long championnat) {
	return find.where().ilike("nom", "%" + filter + "%").ieq("championnat_id", "" + championnat).orderBy(sortBy + " " + order).findPagingList(pageSize).getPage(page);
    }

    /**
     * Retourne le nombre total de championnat
     */
    public static int getNombreClub(String filter, Long championnat) {
	return find.where().ilike("nom", "%" + filter + "%").ieq("championnat_id", "" + championnat).findRowCount();
    }
}
