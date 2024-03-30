package br.com.erudio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.erudio.model.Person;
import br.com.erudio.service.IPsersonService;
import br.com.erudio.service.PersonService;

//		TDD -> Test Driven Develomepment
//		ou seja PRIMEIRO CRIAMOS OS TESTES, e DPS CRIAMOS a CLASSE q sera
//		TESTADA

public class PersonServiceTest {
	

	@DisplayName("When Create a Person with Success Should Return a Person Object")
	@Test
	void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
		
		//Given / Arrange
		IPsersonService service = new PersonService();

		Person person = new Person(
				"Keith",
				"Moon",
				"kmoon@erudio.com.br",
				"Wembley - UK",
				"Male"
				);
		
		
		//When / Act
		Person actual = service.createPerson(person);
		
		//Then / Assert
		assertNotNull(actual, () -> "The createPerson() should not have retorned null");
		
		
	}
	
	
}
