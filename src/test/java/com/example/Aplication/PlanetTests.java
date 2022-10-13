package com.example.Aplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlanetTests {

	private final Planet planet = new Planet("Json");

	@Test
	void compareToTest() {
		Assertions.assertEquals(0, planet.compareTo(new Planet("Json")));
		Assertions.assertEquals(0, planet.compareTo(new Planet("json")));

		Assertions.assertEquals(-1, planet.compareTo(new Planet("Kkk")));
		Assertions.assertEquals(1, planet.compareTo(new Planet("Aaa")));
	}

	@Test
	void gettersTest(){
		Assertions.assertEquals(0, planet.getId());
		Assertions.assertEquals("Json", planet.getName());
	}

}
