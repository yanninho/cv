package controllers;

import java.util.List;
import java.util.Comparator;
import java.util.Collections;

import models.Experience;
import models.Emploi;
import models.TypeConnaissance;
import models.Connaissance;
import models.Formation;
import models.TacheExperience;
import play.mvc.Result;
import play.mvc.Controller;

public class CvController  extends Controller {
   
    public static Result getLatexCv() {
	response().setContentType("text/plain");
	StringBuilder latexcv = new StringBuilder();	
	latexcv.append("\\documentclass[11pt,a4paper,sans]{moderncv}\n");
	latexcv.append("\\moderncvstyle{banking}\n");
	latexcv.append("\\moderncvcolor{blue}\n");
	latexcv.append("\\setlength{\\hintscolumnwidth}{3cm}\n");
	latexcv.append("\\usepackage[scale=0.8]{geometry}\n");
	latexcv.append("\\usepackage{helvet}\n");
	latexcv.append("\\usepackage[french]{babel}\n");
	latexcv.append("\\name{Yannick}{Saint Martino}\n");
	latexcv.append("\\address{12, impasse des zinnias}{31\\,200 Toulouse}{France}\n");
	latexcv.append("\\phone[mobile]{06~10~50~45~62}\n");
	latexcv.append("\\email{yannick.saintmartino@gmail.com}\n");
	latexcv.append("\\homepage{www.yannick-saintmartino.com}\n");
	latexcv.append("\\begin{document}\n");
	latexcv.append("\\makecvtitle\n");
	latexcv.append("\\section{Compétences}\n");
	addCompetences(latexcv);
	latexcv.append("\\section{Expériences Professionnelles}\n");
	addExperiences(latexcv);
	//latexcv.append("\\section{Réalisations Personnelles}\n");
	//addReaPersos(latexcv);
	latexcv.append("\\section{Formation}\n");
	addFormations(latexcv);
	latexcv.append("\\section{Langues}\n");
	latexcv.append("\\cvitemwithcomment{Anglais}{Scolaire, technique}{}\n");
	latexcv.append("\\cvitemwithcomment{Espagnol}{Lu, parlé}{}\n");
	latexcv.append("\\end{document}\n");	
	return ok(latexcv.toString(), "utf-8");
    }

    private static void addReaPersos(StringBuilder latexcv) {
    	latexcv.append("\\cvitem{CV en ligne}{www.yannick-saintmartino.com}\n");
    	latexcv.append("{%\n");
	    latexcv.append("\\begin{itemize}%\n");
	    latexcv.append("\\item Présentation de mes compétences et mon parcours professionnel sur un site internet moderne.\n");
   		latexcv.append("\\end{itemize}}\n");

    	latexcv.append("\\cvitem{Quiprendlestickets}{www.quiprendlestickets.com}\n");
    	latexcv.append("{%\n");
	    latexcv.append("\\begin{itemize}%\n");
	    latexcv.append("\\item Site communautaire qui permet d'échanger sur la prise des titres restaurant par les magasins de la grande distribution en France.\n");
   		latexcv.append("\\end{itemize}}\n");
    }

	private static void addCompetences(StringBuilder latexcv) {
		List<TypeConnaissance> typeConnaissances = TypeConnaissance.find.all();
		String nom = "";
		StringBuilder description = new StringBuilder();
		for (TypeConnaissance typeConnaissance : typeConnaissances) {
			description.setLength(0);
			nom = typeConnaissance.nom;
			int cptConnaissance = 0;
			for (Connaissance connaissance : typeConnaissance.connaissances) {				
				description.append(connaissance.nom);
				cptConnaissance++;
				if (cptConnaissance < typeConnaissance.connaissances.size()) {
					description.append(", ");
				}
			}
			latexcv.append("\\cvitem{"+ nom +"}{"+description+"}\n");
		}
	}

    private static void addExperiences(StringBuilder latexcv) {

			List<Emploi> emplois = Emploi.find.orderBy("ordre desc").findList();			
			String debut = "";
			String fin = "";
			String poste = "";
			String contexte = "";
			String client = "";
			String envTechnique = "";
		for (Emploi emploi : emplois) {
			List<Experience> experiences = emploi.experiences;
			Collections.sort(experiences, new Comparator<Experience>(){
			    @Override
			    public int compare(Experience exp1, Experience exp2) {
			    	int result = 0;
			    	if (exp1.ordre > exp2.ordre) {
			    		result = -1;
			    	}
			    	else {
			    		result = 1;
			    	}
			        return result;
			    }
			});

			for (Experience experience : emploi.experiences) {
				    debut = experience.debut;
				    fin = experience.fin;
				    poste = experience.poste;
				    contexte = experience.contexte;
				    client = experience.client;
				    envTechnique = experience.envtechnique;
				    latexcv.append("\\cventry{"+debut+" - "+fin+"}{"+ poste +"}{"+client+" ("+ emploi.nom +")}{}{}%\n");
				    latexcv.append("{%\n");
				    latexcv.append("\\begin{itemize}%\n");
				    latexcv.append("\\item "+ contexte +"\n");
				    latexcv.append("\\begin{itemize}%\n");
				    for (TacheExperience tache : experience.taches) {
						latexcv.append("\\item "+tache.description+"\n");
			        }
				    latexcv.append("\\end{itemize}\n");
				    latexcv.append("\\item \\textit{Environnement technique : "+ envTechnique +".}\n");
			        latexcv.append("\\end{itemize}}\n");
		    }
		}
    }

    private static void addFormations(StringBuilder latexcv) {
	List<Formation> formations = Formation.find.orderBy("ordre desc").findList();
	String titre = "";
	String description = "";
	String etablissement = "";
	for (Formation formation : formations) {
	    titre =  formation.titre;
	    description = formation.description;
	    etablissement = formation.etablissement;
	    latexcv.append("\\cventry{"+titre+"}{"+description+"}{"+etablissement+"}{}{}{}\n");
        }	
    }
}
