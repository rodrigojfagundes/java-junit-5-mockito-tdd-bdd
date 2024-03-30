package br.com.erudio.business;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

import java.util.List;




import javax.management.RuntimeErrorException;

import org.junit.jupiter.api.Test;



//								MOCKS USANDO O CONCEITO DE BDD
//								BEHAVIOR DRIVEN DEVELOPMENT
//

public class ListWithBDDTest {
	
	
	//mockando o tamanho de uma lista

	//test[System Under Test]_[Condition or State Change]_[Expected Result]
	@Test
	void testMockigList_When_SizeIsCalled_ShouldReturn10() {
		
		//Given / Arrange

		//criando uma VAR de nome LIST q ira receber um MOCK de LIST.CLASS... Dai dessa
		//forma e possivel manipular o q tem dentro dessa LISTA
		var list = mock(List.class);
		
		//quando LIST.SIZE for chamado entao vai retornar o valor 10, dessa forma
		//nos MOCKEMOS/SIMULEMOS O RETORNO da LISTA de nome LIST
		given(list.size()).willReturn(10);
		
		//When / Act & Then / Assert

		//usando o ASSERTTHAT para TESTAR SE o valor q a LIST retorna(tamanho da lista) e
		//o VALOR q nos esperamos receber
		assertThat(list.size(), is(10));
		
	}
	
	@Test
	void testMockigList_When_SizeIsCalled_ShouldReturnMultipleValues() {
		
		//Given / Arrange
		List<?> list = mock(List.class);
		given(list.size()).willReturn(10).willReturn(20);
		
		//When / Act & Then / Assert
		assertThat(list.size(), is(10));
		assertThat(list.size(), is(20));
	}
	
	
	@Test
	void testMockigList_When_GetIsCalled_ShouldReturnErudio() {
		
		//Given / Arrange
		var list = mock(List.class);
		given(list.get(0)).willReturn("Erudio");
		
		//When / Act & Then / Assert
		assertThat(list.get(0), is("Erudio"));
		assertNull(list.get(1));
	}
	
	@Test
	void testMockigList_When_GetIsCalledWithArgumentMatcher_ShouldReturnErudio() {
		
		//Given / Arrange
		var list = mock(List.class);
		given(list.get(anyInt())).willReturn("Erudio");
		
		//When / Act & Then / Assert

		assertThat(list.get(anyInt()), is("Erudio"));
		assertThat(list.get(anyInt()), is("Erudio"));
		assertThat(list.get(anyInt()), is("Erudio"));
	}
	
	@Test
	void testMockigList_When_ThrowsAndException() {
		
		//Given / Arrange

		var list = mock(List.class);
		given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar!"));
		
		//When / Act & Then / Assert

		assertThrows(RuntimeException.class, 
				() ->
				//When / Act
					{list.get(anyInt());
				}, () -> "Should have throw an RuntimeException");
	}
}
