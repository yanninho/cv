package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

import org.junit.Before;
import org.junit.Test;

import play.test.WithApplication;

public class JoueurTest extends WithApplication {
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void creerRetourner() {
		new Joueur(new Long(100), "nomTest", "prenomTest", null).save();
		Joueur joueur = Joueur.find.where()
				.eq("nom", "nomTest").findUnique();
		assertNotNull(joueur);
		assertEquals("nomTest", joueur.nom);

	}

}
