package br.com.erudio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


//colocando a ANNOTATION @TESTMETHORDER para fazer testes de FORMA RANDOMICA
// pois assim não tem como um DEV fazer um TEST EM Q UM METODO DEPENDA UM DO OUTRO...
//
//colocando a ANNOTATION @ORDER(1) para dizer q na hora q EXEC TEST em massa (exec todos TESTS
//do mesmo PACOTE) esse o METHODORDERRANDONLYTEST seja o PRIMEIRO a ser EXEC
//
@Order(1)
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
