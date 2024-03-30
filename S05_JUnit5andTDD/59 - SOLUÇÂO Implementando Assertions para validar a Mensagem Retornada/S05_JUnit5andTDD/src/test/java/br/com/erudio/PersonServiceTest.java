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
//
//criando uma classe de TESTS...
public class PersonServiceTest {
	
	IPsersonService service;
	
	Person person;
	
	//Metodo Setup com Annotation @BeforeEach, então antes de cada metodo de teste será
	//chamado o metodo Setup por causa do @BeforeEach
	@BeforeEach
	void setup() {
		service = new PersonService();
		person = new Person(
				"Keith",
				"Moon",
				"kmoon@erudio.com.br",
				"Wembley - UK",
				"Male"
				);
	}
	
	//test[System Under Test]_[Condition or State Change]_[Expected Result]
	
	//Metodo de test para testar se apos criar um PERSON, e retornado o PERSON criado
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
	
	//Metodo para testar SE o FIRSTNAME do PERSON esta PREENCHIDO
	@DisplayName("When Create a Person with Success Should Contains Valid Fields in Returned Person Object")
	@Test
	void testCreatePerson_WhenSuccess_ShoulContainsValidFieldsInReturnedPersonObject() {
		
		//Given / Arrange
		IPsersonService service = new PersonService();

		//When / Act
		Person actual = service.createPerson(person);
		
		//Then / Assert
		assertNotNull(person.getId(), ()-> 	"Person ID is Missing");
		
		assertEquals(
				person.getFirstName(), 
				actual.getFirstName(), 
				() -> "The firtName is Incorrect!");
				
		//Then / Assert
		assertEquals(
				person.getLastName(), 
				actual.getLastName(), 
				() -> "The LastName is Incorrect!");
			
			//Then / Assert
		assertEquals(
			person.getAddress(), 
			actual.getAddress(), 
			() -> "The Address is Incorrect!");
	
		//Then / Assert
		assertEquals(
				person.getGender(), 
				actual.getGender(), 
				() -> "The Gender is Incorrect!");
			
		//Then / Assert
		assertEquals(
				person.getEmail(), 
				actual.getEmail(), 
				() -> "The Email is Incorrect!");
		
	}
	
	
	//teste para validar o lancamento de uma exception
	@DisplayName("When Create a Person with Null e-mail Should throw Exception")
	@Test
	void testCreatePerson_WhithNullEmail_ShouldThrowIllegalArgumentException() {

	//Given / Arrange
	person.setEmail(null);
	
	var expectedMessage = "The Person e-Mail is null or empty!";
		
	// When / Act & Then / Assert
	IllegalArgumentException exception =  assertThrows(
			IllegalArgumentException.class, 
			() -> service.createPerson(person),
			() -> "Empty e-Mail should have cause an IllgalArgumentException!");
		
	//Then / Assert
	assertEquals(expectedMessage,
			exception.getMessage(),
			() -> "Exception error message is incorrect!");
	
	
	}
}