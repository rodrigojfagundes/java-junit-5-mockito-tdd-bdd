package br.com.erudio;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

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

}
