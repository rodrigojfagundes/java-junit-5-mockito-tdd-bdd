package br.com.erudio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.erudio.model.Person;
import br.com.erudio.service.IPsersonService;
import br.com.erudio.service.PersonService;

//		TDD -> Test Driven Develomepment
//		ou seja PRIMEIRO CRIAMOS OS TESTES, e DPS CRIAMOS a CLASSE q sera
//		TESTADA
public class PersonServiceTest {
	
	Person person;
	
	//Metodo Setup com Annotation @BeforeEach, então antes de cada metodo de teste será
	//chamado o metodo Setup por causa do @BeforeEach
	@BeforeEach
	void setup() {
		person = new Person(
				"Keith",
				"Moon",
				"kmoon@erudio.com.br",
				"Wembley - UK",
				"Male"
				);
	}
	
		
	//test[System Under Test]_[Condition or State Change]_[Expected Result]

	
	//Testando se quando e criado um Person é retornado o Person criado
	@DisplayName("When Create a Person with Success Should Return a Person Object")
	@Test
	void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
		
		//Given / Arrange
		IPsersonService service = new PersonService();
		
		//When / Act
		Person actual = service.createPerson(person);
		
		
		//Then / Assert
		assertNotNull(actual, () -> "The createPerson() should not have retorned null");
		
		
	}
	
	
	//para testar SE o FIRSTNAME do PERSON esta PREENCHIDO
	@DisplayName("When Create a Person with Success Should Contains FirstName in Returned Person Object")
	@Test
	void testCreatePerson_WhenSuccess_ShoulContainsFirstNameInReturnedPersonObject() {
		
		//Given / Arrange
		IPsersonService service = new PersonService();

		
		
		//When / Act
		Person actual = service.createPerson(person);
		
		
		//Then / Assert
		assertEquals(person.getFirstName(), actual.getFirstName(),() -> "The firtName is Different!");
		
	}
	
}
