package br.com.erudio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


//colocando a ANNOTATION @TESTMETHORDER para fazer testes de FORMA RANDOMICA
//
@TestMethodOrder(MethodOrderer.Random.class)
class MethodOrderedRandonlyTest {


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
