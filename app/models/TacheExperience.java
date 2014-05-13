package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class TacheExperience extends Model {

	private static final long serialVersionUID = 5690213619330893975L;

	@Id
	public Long id;
	
	public String description;
	
}
