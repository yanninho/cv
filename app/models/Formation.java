package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Formation extends Model {

	private static final long serialVersionUID = -488240886253897216L;

	@Id
	public Long id;
	
	public String titre;
	
	public String description;
	
	public String enseignement;
	
	public String etablissement;
	
	public Integer ordre;
	
	public String idMap;
	
	public double latitude;
	
	public double longitude;

	public static Finder<Long, Formation> find = new Finder<Long, Formation>(
			Long.class, Formation.class);

}
