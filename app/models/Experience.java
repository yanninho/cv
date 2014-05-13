package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class Experience extends Model {

	private static final long serialVersionUID = 8857687562082486570L;

	@Id
	public Long id;

	public Integer ordre;

	public String logo;

	public String contexte;

	public String poste;

	public String duree;

	public String envtechnique;
	
	public String encreId;
	
	public String client;
	
	public String debut;
	
	public String fin;

	@OneToMany(cascade=CascadeType.ALL)
	public List<TacheExperience> taches;

	public static Finder<Long, Experience> find = new Finder<Long, Experience>(
			Long.class, Experience.class);

}
