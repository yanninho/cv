package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import play.db.ebean.Model;

@Entity
public class Image extends Model {

	private static final long serialVersionUID = 8404168219276920256L;

	@Id
	public Integer id;

	public String type;

	@Lob
	@Column(length=100000)
	private byte[] contenu;

	public static Finder<Integer,Image> find = new Finder<Integer,Image>(Integer.class, Image.class);

	public byte[] getContenu() {
	    return contenu;
	}

	public void setContenu(byte[] contenu) {
	    this.contenu = contenu;
	} 
	
}
