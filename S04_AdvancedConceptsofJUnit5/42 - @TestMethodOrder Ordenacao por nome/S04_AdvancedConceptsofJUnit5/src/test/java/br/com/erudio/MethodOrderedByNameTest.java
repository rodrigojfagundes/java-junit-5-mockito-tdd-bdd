package br.com.erudio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


//colocando a ANNOTATION @TESTMETHORDER e nela chamando o METHODNAME do METHODORDER
//para podermos ordernar os testes em ORDEM ALFABETICA
//
@TestMethodOrder(MethodOrderer.MethodName.class)
class MethodOrderedByNameTest {

	@Test
	void testA() {
		System.out.println("Running Test A");
	}
		
	@Test
	void testB() {
		System.out.println("Running Test B");
	}	

	@Test
	void testC() {
		System.out.println("Running Test C");
	}
	

	@Test
	void testD() {
		System.out.println("Running Test D");
	}	
	
	
}
