package br.com.erudio;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


//colocando a ANNOTATION @TESTMETHORDER e nela chamando o ORDER do METHODORDER
//e dps nos chamamos a ANNOTATION @ORDER nos metodos q farao os testes, dai dessa forma
//nos poderemos ORDERNAR por INDICE
//
//geralmente utilizado para se trabalhar com TESTE DE INTEGRACAO... EM q tipo o RESULTADO
//do TEST 2 por depender do TEST 1... E e tipo o Test 7 pode depender do Test 1... etc...
//
//colocando a ANNOTATION @ORDER(3) pois quando EXEC todas as CLASSES DE TEST do PACOTE
//BR.COM.ERUDIO essa classe aqui METHODORDERBYORDER seja a TERCEIRA a ser EXEC
//
@Order(3)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MethodOrderedByOrder {
	
	@Test
	@Order(1)
	void testC() {
		System.out.println("Running Test C");
	}

	@Test
	@Order(2)
	void testD() {
		System.out.println("Running Test D");
	}	
	

	@Test
	@Order(3)
	void testA() {
		System.out.println("Running Test A");
	}
		

	@Test
	@Order(4)
	void testB() {
		System.out.println("Running Test B");
	}	
	
	
}
