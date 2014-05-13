package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

import org.junit.Before;
import org.junit.Test;

import play.test.WithApplication;

public class InformationTest extends WithApplication {
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void creerRetourner() {
		new Information(new Long(1000), 1,"typeInfosTest").save();
		Information typeInfos = Information.find.where()
				.eq("texte", "typeInfosTest").findUnique();
		assertNotNull(typeInfos);
		assertEquals("typeInfosTest", typeInfos.texte);

		typeInfos = Information.find.byId(new Long(1000));
		assertNotNull(typeInfos);
		assertEquals("typeInfosTest", typeInfos.texte);
	}

}
