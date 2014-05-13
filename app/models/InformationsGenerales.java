package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InformationsGenerales {

	public final String ADRESSE = "12, impasse des zinnias 31200 Toulouse"; 
	
	public final String TELEPHONE = "06.10.50.45.62";
	
	public final String COURRIEL = "yannick.saintmartino@gmail.com";
	
	private final String DATE_NAISSANCE = "26-08-1980";
	
	private final String DATE_DEBUT_TRAVAIL = "01-01-2007";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
	
	public final String age() {
		
		try {
			GregorianCalendar calendarDateNaissance = new java.util.GregorianCalendar(); 
			Date dateNaissance = sdf.parse(DATE_NAISSANCE);			
			calendarDateNaissance.setTime(dateNaissance);
			
			GregorianCalendar calendarDateCourante = new java.util.GregorianCalendar(); 
			calendarDateCourante.setTime(new Date());
			
			calendarDateCourante.add(Calendar.YEAR, - calendarDateNaissance.get(Calendar.YEAR));
			
			return String.valueOf(calendarDateCourante.get(Calendar.YEAR));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public final String anneesExperience() {
		
		
		try {
			GregorianCalendar calendarDateTravail = new java.util.GregorianCalendar(); 
			Date dateDebutTravail = sdf.parse(DATE_DEBUT_TRAVAIL);			
			calendarDateTravail.setTime(dateDebutTravail);
			
			GregorianCalendar calendarDateCourante = new java.util.GregorianCalendar(); 
			calendarDateCourante.setTime(new Date());
			
			calendarDateCourante.add(Calendar.YEAR, - calendarDateTravail.get(Calendar.YEAR));
			
			return String.valueOf(calendarDateCourante.get(Calendar.YEAR));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "";		
	}
	
	public final String age = age();
	
	public final String anneesExperience = anneesExperience();
}
