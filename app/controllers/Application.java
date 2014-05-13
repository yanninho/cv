package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.Collections;

import models.Actualites;
import models.Emploi;
import models.Experience;
import models.Formation;
import models.Information;
import models.InformationsGenerales;
import models.TypeConnaissance;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {


    public static Result getInformationsGenerales() {
	return ok(Json.toJson(new InformationsGenerales()));
    }

    public static Result getConnaissances() {
	List<TypeConnaissance> connaissances = TypeConnaissance.find.all();
	return ok(Json.toJson(connaissances));
    }

    public static Result getExperiences() {
	List<Experience> experiences = Experience.find.where().orderBy().desc("ordre").findList();
	return ok(Json.toJson(experiences));
    }

    public static Result getEmplois() {
	List<Emploi> emplois = Emploi.find.orderBy("ordre desc").findList();
	return ok(Json.toJson(emplois));
    }

    public static Result getFormations() {
	List<Formation> formations = Formation.find.where().orderBy().desc("ordre").findList();
	return ok(Json.toJson(formations));
    }

    public static Result informations(String type, int element) {
	ObjectNode result = Json.newObject();
	Map<String, JsonNode> map = new HashMap<>();
	map.put("nombre", Json.toJson(String.valueOf(Information.nbByTypeInformation(type))));
	map.put("information", Json.toJson(Information.getInformation(type, element)));
	return ok(result.putAll(map));
    }

    public static Result getActualites() {
	List<Actualites> actualites = Actualites.find.where().orderBy().desc("creation").findList();
	return ok(Json.toJson(actualites));
    }

}