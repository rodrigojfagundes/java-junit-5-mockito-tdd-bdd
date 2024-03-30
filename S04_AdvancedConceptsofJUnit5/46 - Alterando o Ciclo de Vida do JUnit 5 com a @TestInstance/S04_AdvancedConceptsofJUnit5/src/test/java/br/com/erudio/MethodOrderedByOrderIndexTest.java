package br.com.erudio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;


//colocando a ANNOTATION @TESTMETHORDER e nela chamando o ORDER do METHODORDER
//e dps nos chamamos a ANNOTATION @ORDER nos metodos q farao os testes, dai dessa forma
//nos poderemos ORDERNAR por INDICE
//@Order(3)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MethodOrderedByOrderIndexTest {
	
	StringBuilder actualValue = new StringBuilder("");
	
	
	//ANNOTATION @AFTEREACH ser exec apos CADA METODO de TEST ser exec
	@AfterEach
	void afterEach() {
		System.out.println("the actual value is: " + actualValue);
	}
	
	@Test
	@Order(1)
	void testC() {
		System.out.println("Running Test C");
		actualValue.append("1");
	}
	
	@Test
	@Order(2)
	void testD() {
		System.out.println("Running Test D");
		actualValue.append("2");
	}	
	
	@Test
	@Order(3)
	void testA() {
		System.out.println("Running Test A");
		actualValue.append("3");
	}
		

	@Test
	@Order(4)
	void testB() {
		System.out.println("Running Test B");
		//ADD o VALOR 3 ao ACTUALVALUE
		actualValue.append("4");
	}	
	
	
}
