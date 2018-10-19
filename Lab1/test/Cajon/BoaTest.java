package Cajon;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoaTest {

	@Test
	void esSanaTest() {
		Boa boa = new Boa("gods_devourer", 15, "granola");
		
		assertTrue("Should be healthy.", boa.esSana());
	}
	
	@Test
	void noEsSanaTest() {
		Boa boa = new Boa("gods_devourer", 15, "hierba");
		
		assertFalse("Should be unhealthy.", boa.esSana());
	}
	
	@Test
	void cabeEnCesta() {
		Boa boa = new Boa("gods_devourer", 15, "hierba");
		
		assertTrue("Should fit in the basket.", boa.cabeEnCesta(20));
	}

	@Test
	void noCabeEnCesta() {
		Boa boa = new Boa("gods_devourer", 15, "hierba");
		
		assertFalse("Shouldn't fit in the basket.", boa.cabeEnCesta(15));
	}
	
	@Test
	void logitudEnPulgadasTest() {
		Boa boa = new Boa("gods_devourer", 15, "hierba");
		
		assertEquals((int)180, boa.longEnPulgadas());
	}
	
}
