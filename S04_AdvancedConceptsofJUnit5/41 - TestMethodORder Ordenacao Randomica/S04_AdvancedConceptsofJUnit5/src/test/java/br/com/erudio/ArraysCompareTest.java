package br.com.erudio;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;



//classe ARRAYSCOMPARETEST para executar ASSERTIONS com ARRAYS... Ou seja COMPARAR ARRAYS
//tipo, se o q nos ESPERAMOS foi o q foi RETORNADO, pelo metodo
//
class ArraysCompareTest {

	@Test
	void test() {
		int[] numbers = {25, 8, 21, 32, 3};
		int [] expectedArray = {3, 8, 21, 25, 32};

		Arrays.sort(numbers);
		
		assertArrayEquals(numbers, expectedArray);
		
	}
	
	
	//aqui nos vamos fazer um TEST de PERFORMANCE... Tipo vai testar se o RETORNO de um METODO
	//aconteceu em uma quantidade X de SEGUNDOS...
	//
	@Test
    //@Timeout(1)
	@Timeout(value = 15, unit = TimeUnit.MILLISECONDS)
	void testSortPerfomance() {

		int[] numbers = {25, 8, 21, 32, 3};
		for (int i = 0; i<10; i++) {

			numbers[0] = i;
			Arrays.sort(numbers);
			
		}

	}
	
}
