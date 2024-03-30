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
//
public class PersonServiceTest {
	
	//test[System Under Test]_[Condition or State Change]_[Expected Result]
	
	//Metodo de test para testar se apos criar um PERSON, e retornado o PERSON criado
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
	
	
	//criando o METODO DE TEST para testar SE o FIRSTNAME do PERSON esta PREENCHIDO
	@DisplayName("When Create a Person with Success Should Contains FirstName in Returned Person Object")
	@Test
	void testCreatePerson_WhenSuccess_ShoulContainsFirstNameInReturnedPersonObject() {
		
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
		assertEquals(person.getFirstName(), actual.getFirstName(),() -> "The firtName is Different!");
		
	}
}
