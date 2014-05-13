package controllers;

import java.util.HashMap;
import java.util.Map;

import models.Club;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security.Authenticated;

public class ClubController  extends Controller {

    @Authenticated(Secured.class)
    public static Result listClub(int page, String sortBy, String order, String filtreNom, Long championnat) {
	ObjectNode result = Json.newObject();
	Map<String, JsonNode> map = new HashMap<>();
	map.put("nombre", Json.toJson(String.valueOf(Club.getNombreClub(filtreNom, championnat))));
	map.put("clubs", Json.toJson(Club.page(page, 10, sortBy, order, filtreNom, championnat).getList()));
	return ok(result.putAll(map));
    }
    
    @Authenticated(Secured.class)
    public static Result nouveauClub() {
//	JsonNode json = request().body().asJson();
//	Map<String, String> map = new HashMap<String, String>();
	return status(Http.Status.OK);
    }

    @Authenticated(Secured.class)
    public static Result supprimerClub(Long clubId) {
//	JsonNode json = request().body().asJson();
	return status(Http.Status.OK);
    }

}
