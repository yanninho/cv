package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import play.db.ebean.Model;

@Entity
public class Emploi extends Model {

    private static final long serialVersionUID = -6623725997995779145L;

    @Id
    public Long id;

    public String nom;

    public String logo;

    public String debut;

    public String fin;

    @OneToMany(cascade=CascadeType.ALL)
    @OrderBy("ordre DESC")
    public List<Experience> experiences;
	
    public static Finder<Long, Emploi> find = new Finder<Long, Emploi>(Long.class, Emploi.class);

}
