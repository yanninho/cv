package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

import org.junit.Before;
import org.junit.Test;

import play.test.WithApplication;

public class TypeInformationTest extends WithApplication {
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void creerRetourner() {
		new TypeInformation(new Long(1000), "typeInfosTest", "prefix").save();
		TypeInformation typeInfos = TypeInformation.find.where()
				.eq("nom", "typeInfosTest").findUnique();
		assertNotNull(typeInfos);
		assertEquals("typeInfosTest", typeInfos.nom);

		typeInfos = TypeInformation.find.byId(new Long(1000));
		assertNotNull(typeInfos);
		assertEquals("typeInfosTest", typeInfos.nom);
	}

}
