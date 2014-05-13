package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

import play.data.validation.Constraints;
import play.db.ebean.Model.Finder;

@Entity
public class User {

    @Id
    public Long id;

    @Constraints.Required
    public String login;

    @Constraints.Required
    public String password;

    public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

    public static Object authenticate(String username, String password) {	
	if (StringUtils.equals(username, "ouistiti") && StringUtils.equals(password, "ouistiti")) {
	    return "ok";
	}
	return null;
    }

}
