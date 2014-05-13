package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

import org.junit.Before;
import org.junit.Test;

import play.test.WithApplication;

public class ChampionnatTest extends WithApplication {
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void creerRetourner() {
		new Championnat(new Long(1000), "championnatTest", null).save();
		Championnat championnat = Championnat.find.where()
				.eq("nom", "championnatTest").findUnique();
		assertNotNull(championnat);
		assertEquals("championnatTest", championnat.nom);

		championnat = Championnat.byId(new Long(1000));
		assertNotNull(championnat);
		assertEquals("championnatTest", championnat.nom);
	}

}
