package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

import org.junit.Before;
import org.junit.Test;

import play.test.WithApplication;

public class PaysTest extends WithApplication {
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void creerRetourner() {
		new Pays(new Long(100), "PaysTest").save();
		Pays pays = Pays.find.where().eq("nom", "PaysTest").findUnique();
		assertNotNull(pays);
		assertEquals("PaysTest", pays.getNom());

	}

}
