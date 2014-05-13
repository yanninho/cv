package controllers;

import java.util.HashMap;
import java.util.Map;

import models.Championnat;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security.Authenticated;

public class ChampionnatController  extends Controller {

    @Authenticated(Secured.class)
    public static Result listChampionnat(int page, String sortBy, String order, String filtreNom, String filtrePays) {
	ObjectNode result = Json.newObject();
	Map<String, JsonNode> map = new HashMap<>();
	map.put("nombre", Json.toJson(Championnat.getNombreChampionnat(filtreNom, filtrePays)));
	map.put("championnats", Json.toJson(Championnat.page(page, 10, sortBy, order, filtreNom, filtrePays).getList()));
	return ok(result.putAll(map));
    }

    @Authenticated(Secured.class)
    public static Result getChampionnat(Long id) {
	ObjectNode result = Json.newObject();
	Map<String, JsonNode> map = new HashMap<>();
	map.put("championnat", Json.toJson(Championnat.getChampionnat(id)));
	return ok(result.putAll(map));
    }

    @Authenticated(Secured.class)
    public static Result nouveauChampionnat() {
//	JsonNode json = request().body().asJson();
	return status(Http.Status.OK);
    }

    @Authenticated(Secured.class)
    public static Result supprimerChampionnat(Long championnatId) {
//	JsonNode json = request().body().asJson();
//	Map<String, String> map = new HashMap<String, String>();
	return status(Http.Status.OK);
    }

}
