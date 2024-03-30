package br.com.erudio.mockito;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

//class para fazer uns testes com as funcionalidades/possibilidades do HAMCREST
//
class HamcrestMatchersTest {

	@Test
	void test() {
		//GIVEN

		List<Integer> scores = Arrays.asList(99, 100, 101, 105);
		
		//WHEN & THEN

		//aqui nos estamos pegando a LISTA de nome SCORES e tamos vendo se o TAMANHO dela
		//e 4
		assertThat(scores, hasSize(4));

		//aqui nos vamos verificar se na LISTA SCORES tem alguns itens... o 100 e 101
		assertThat(scores, hasItems(100, 101));

		assertThat(scores, everyItem(greaterThan(98)));

		assertThat(scores, everyItem(lessThan(777)));
		
		assertThat("", is(emptyString()));
	
		assertThat(null, is(emptyOrNullString()));
		
		//Arrays
		Integer[] myArray = {1, 2, 3};

		assertThat(myArray, arrayWithSize(3));

		assertThat(myArray, arrayContaining(1, 2, 3));

		assertThat(myArray, arrayContainingInAnyOrder(3, 2, 1));
		
		
	}
	
}
