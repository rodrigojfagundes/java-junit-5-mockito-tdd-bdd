package br.com.erudio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.erudio.service.IPsersonService;
import br.com.erudio.service.PersonService;

//		TDD -> Test Driven Develomepment
//		ou seja PRIMEIRO CRIAMOS OS TESTES, e DPS CRIAMOS a CLASSE q sera
//		TESTADA
//
public class PersonServiceTest {
	
	//test[System Under Test]_[Condition or State Change]_[Expected Result]
	
	@DisplayName("When Create a Person with Success Should Return a Person Object")
	@Test
	void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
		
		//Given / Arrange
		
		IPsersonService service = new PersonService();
		
		//When / Act
		
		//Then / Assert

	}
	
	
}
