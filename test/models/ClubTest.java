package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

import org.junit.Before;
import org.junit.Test;

import play.test.WithApplication;

public class ClubTest extends WithApplication {
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void creerRetourner() {
		new Club(new Long(1000), "ClubTest", null).save();
		Club club = Club.find.where()
				.eq("nom", "ClubTest").findUnique();
		assertNotNull(club);
		assertEquals("ClubTest", club.nom);
	}

}
