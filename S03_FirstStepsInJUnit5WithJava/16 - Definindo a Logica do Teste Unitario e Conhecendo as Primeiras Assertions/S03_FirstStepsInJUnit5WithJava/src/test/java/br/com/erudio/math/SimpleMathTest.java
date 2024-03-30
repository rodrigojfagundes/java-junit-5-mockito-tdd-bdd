package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleMathTest {

	//vamos testar o METODO SUM da classe SIMPLEMATH
	//
	@Test
	void testSum() {

		SimpleMath math = new SimpleMath();
		Double actual = math.sum(6.2D, 2D);
		Double expected = 8.2D;

		assertEquals(expected, actual);
	}

}
