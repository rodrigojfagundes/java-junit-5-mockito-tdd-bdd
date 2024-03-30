package br.com.erudio.business;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.junit.jupiter.api.Test;

public class ListTest {
		
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
		when(list.size()).thenReturn(10);
		
		//When / Act & Then / Assert
		
		//testando SE o VALOR retornado pelo a LISTA q foi MOCKADA e o MESMO VALOR
		//q ESPERAMOS RECEBER
		assertEquals(10, list.size());
		
	}
		
	@Test
	void testMockigList_When_SizeIsCalled_ShouldReturnMultipleValues() {
		
		//Given / Arrange
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20);
		
		//When / Act & Then / Assert
		assertEquals(10, list.size());
		assertEquals(20, list.size());
	}
	
	@Test
	void testMockigList_When_GetIsCalled_ShouldReturnErudio() {
		
		//Given / Arrange
		var list = mock(List.class);
		when(list.get(0)).thenReturn("Erudio");
		
		//When / Act & Then / Assert
		assertEquals("Erudio", list.get(0));
		assertNull(list.get(1));
	}
	
	@Test
	void testMockigList_When_GetIsCalledWithArgumentMatcher_ShouldReturnErudio() {
		
		//Given / Arrange
		var list = mock(List.class);
		when(list.get(anyInt())).thenReturn("Erudio");		
		assertEquals("Erudio", list.get(anyInt()));
		assertEquals("Erudio", list.get(anyInt()));
		assertEquals("Erudio", list.get(anyInt()));
	}
	
	@Test
	void testMockigList_When_ThrowsAndException() {
		
		//Given / Arrange
		var list = mock(List.class);
		when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar!"));
		
		//When / Act & Then / Assert
		assertThrows(RuntimeException.class, 
				() ->
				//When / Act
					{list.get(anyInt());
				}, () -> "Should have throw an RuntimeException");
	}
}
