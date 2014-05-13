package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.ebean.Model;

@Entity
public class Actualites extends Model {

    private static final long serialVersionUID = 8770721832453543637L;

    @Id
    public Long id;

    @Temporal(TemporalType.TIMESTAMP)
    public Date creation;

    public String texteCourt;

    public String texteLong;

    public static Finder<Long, Actualites> find = new Finder<Long, Actualites>(Long.class, Actualites.class);

}
