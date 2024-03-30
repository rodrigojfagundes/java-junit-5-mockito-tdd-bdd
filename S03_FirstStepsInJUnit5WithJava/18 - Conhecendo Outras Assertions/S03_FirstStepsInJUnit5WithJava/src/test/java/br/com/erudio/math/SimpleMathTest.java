package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


//classe q ira testar o CLASSE SIMPLEMATHTEST
class SimpleMathTest {

//testando o metodo SUM do SimpleMath
	@Test
	void testSum() {
		SimpleMath math = new SimpleMath();
		Double actual = math.sum(6.2D, 2D);
		Double expected = 8.2D;
		assertEquals(expected, actual, "6.2 + 2 did not produce 8.2!");
		assertNotEquals(9.2, actual);

		assertNotNull(actual);
	}

}
