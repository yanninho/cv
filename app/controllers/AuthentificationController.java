package controllers;

import java.util.Map;

import models.User;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

public class AuthentificationController extends Controller {

    public static Result connexion() {
	try {
	    Map<String, String[]> queryParameters = request().queryString();
	    String username = queryParameters.get("username")[0];
	    String password = queryParameters.get("password")[0];	    
	    
	    if (User.authenticate(username, password) != null) {
	        session().clear();
	        session("username", username);
	        ObjectNode result = Json.newObject();
		result.put("username", username);
		return ok(result);
	    } else {
	        return status(Http.Status.UNAUTHORIZED, "Erreur! Mauvaises informations de connexion");
	    }
        } catch (Exception e) {
            return status(Http.Status.UNAUTHORIZED, "Erreur! Mauvaises informations de connexion");
        }
    }

    public static Result deconnexion() {
	session().clear();
	return status(Http.Status.OK); 
    }
    
    public static Result getConnexion() {
	String username = session().get("username");
	if (StringUtils.isNotBlank(username)) {
	    ObjectNode result = Json.newObject();
	    result.put("username", username);
	    return ok(result);
	}
	else {
	    return status(Http.Status.UNAUTHORIZED);
	}	
    }
}