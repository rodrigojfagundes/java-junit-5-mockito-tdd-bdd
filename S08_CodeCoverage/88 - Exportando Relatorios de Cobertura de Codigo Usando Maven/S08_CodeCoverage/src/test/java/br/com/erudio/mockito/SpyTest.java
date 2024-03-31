package br.com.erudio.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//conhecendo o MOKITO SPY, ele serve como um MOCK PARCIAL, tipo ele PERMITE altera o RETORNO
//de um METODO, ah quero q o METODO RETORNE o valor 7 OBRIGATORIAMENTE dai e possivel fazer
//com o SPY... com o MOCK APENAS NAO... Geralmente utilizado para codigos legado e nao sabe
//exatamente como funciona alguma dependencia e tals...
//
public class SpyTest {
	
	@DisplayName("Display Name")
	@Test
	void testV1() {
		//Given / Arrange
	
		//criando um ARRAYLIST do tipo STRING de nome MOCKARRAYLIST, e informamos
		//para o MOCKITO SPY qual sera a CLASSE A SER MOCKADA/SIMULADA... No caso a ARRAYLIST
		List<String> mockArrayList = spy(ArrayList.class);
		
		
		//When / Act & Then / Assert
		
		//modificando o ASSERTION
		//dessa forma nos estamos disendo q QUANDO FOR CHAMADO O MOCKARRAYLIST.SIZE em vez de
		//retornar 0 (pois nao tem nada na LISTA) (THENRETURN) ele deve RETORNAR 5
		//
		when(mockArrayList.size()).thenReturn(5);

		mockArrayList.add("Foo-Bar");
		
		//mesmo TENDO SIDO ADD a palavra FOO-BAR dps de DIZER Q TEM Q RETORNAR 5...
		//o MOCKARRAYLIST vai CONTINUAR COM O VALOR 5 e NAO 6
		assertEquals(5, mockArrayList.size());
		
		
	}
	
	@DisplayName("Display Name")
	@Test
	void testV2() {
		//Given / Arrange

		List<String> spyArrayList = spy(ArrayList.class);
				
		//When / Act & Then / Assert
		
		assertEquals(0, spyArrayList.size());
		spyArrayList.add("Foo-Bar");
		assertEquals(1, spyArrayList.size());

		spyArrayList.remove("Foo-Bar");
		assertEquals(0, spyArrayList.size());
		
		
	}
	
	
	@Test
	void testV3() {
		//Given / Arrange
		List<String> spyArrayList = spy(ArrayList.class);
		
		
		//When / Act & Then / Assert		
		assertEquals(0, spyArrayList.size());
		when(spyArrayList.size()).thenReturn(5);
		assertEquals(5, spyArrayList.size());
		
	}
	
	
	@Test
	void testV4() {
	//Given / Arrange
		List<String> spyArrayList = spy(ArrayList.class);
		
		
		//When / Act & Then / Assert
		spyArrayList.add("Foo-Bar");
		verify(spyArrayList).add("Foo-Bar");
		verify(spyArrayList, never()).remove("Foo-Bar");

		verify(spyArrayList, never()).clear();
		
	}
	
	
	
}
