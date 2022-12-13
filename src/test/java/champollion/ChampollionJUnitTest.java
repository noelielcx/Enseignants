package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}

	@Test
	public void testHeuresPrevues(){
		untel.ajouteEnseignement(java, 1, 2, 3);
		untel.ajouteEnseignement(uml, 1, 2, 3);
		assertEquals(6, untel.heuresPrevues(), "6h prévues");
	}

	@Test
	public void testSousService(){
		untel.ajouteEnseignement(uml, 10, 20, 30);{
			assertEquals(true, untel.enSousService(), "L'enseignant est en sous service");
			untel.ajouteEnseignement(uml, 150, 150, 100);
			assertEquals(false, untel.enSousService(), "L'enseignement n'est pas en sous-service");
		}
	}

	@Test
	public void testHeuresPrevuesPourUe(){
		untel.ajouteEnseignement(uml, 1, 2, 2);
		untel.ajouteEnseignement(java, 3, 1, 2);
		assertEquals(7, untel.heuresPrevuesPourUE(uml), "7h prévues");
		assertEquals(7, untel.heuresPrevuesPourUE(java), "7h prévues");
	}
}
