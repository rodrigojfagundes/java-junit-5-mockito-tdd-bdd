package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


//Given -> Contexto/cenario inicial das classes, onde e setado as 
//configurações, inicializar as var, etc...
//When -> onde dispara o gatilho e inicia a execução do cenario
//Then -> avaliação se o resultado corresponde ao esperado


//classe q ira testar os METODOS da CLASSE SIMPLEMATHTEST

@DisplayName("Test Math Operations in Simple Math Class")
class SimpleMathTestS4 {

	SimpleMath math;
	
	
	@BeforeEach
	void beforeEachMethod() {
		math = new SimpleMath();
	}
	
	
	//criando o METODO TESTVALUESOURCE para criacao de TESTS PARAMETIZADOS
	//usando a ANNOTATION @PARAMETERIZEDTEST para dizer q e um TEST parametizado
	//e no ANNOTATION @VALUESOURCE nos vamos passar um ARRAY de STRING
	@ParameterizedTest
	@ValueSource(strings = {"Pelé", "Senna", "Keith Moon"})
	void testValueSource(String firsName) {
		System.out.println(firsName);
		assertNotNull(firsName);
		
	}
	
	
	
	//metodo para TESTAR o metodo DIVISION q ta na classe SIMPLEMATH
	//
	@DisplayName("Test double sbtraction [firstNumber, secondNumber, expected]")
	@ParameterizedTest
	//@MethodSource("testDivisionInputParameters")
	//@MethodSource()
	/**
	@CsvSource({
		"6.2, 2, 3.1",
		"71, 14, 5.07",
		"18.3, 3.1, 5.90", 
	})
	@CsvSource({
	"Pele, Football",
	"Senna, F1",
	"Keith moon, ''"
	})
	*/
	
	//usando a ANNOTATION @CSVFILESOURCE pois com ela e possivel ABRIR um ARQUIVO CSV
	//e pegar o valor q ta nas LINHAS e usar esses valores como parametro...
	//
	@CsvFileSource(resources = "/testDivision.csv")
	void testDivision(double firstNumber, double secondNumber, double expected) {
		
		System.out.println("Test " + firstNumber + "/" + 
		secondNumber + " = " + expected + "!");
		Double actual = math.division(firstNumber, secondNumber);
		
		assertEquals(expected, actual, 2D,
				() -> firstNumber + "/" + secondNumber +"   not produce " + expected);
	}
	
	

	//public static Stream<Arguments> testDivisionInputParameters() {
	//
	/**
	public static Stream<Arguments> testDivision() {
		//dentro do STREAM vai ter ARGUMENTS com os valores 
		//FIRSTNUMBER = 6.2D, SECONDNUMBER = 2D, EXPECTED = 3.1D... 
		//e assim sucessivamente...
		return Stream.of(
				Arguments.of(6.2D, 2D, 3.1D),
				Arguments.of(71D, 14D, 5.07D),
				Arguments.of(18.3D, 3.1D, 5.90D)
				);
		
	}
	*/
}
