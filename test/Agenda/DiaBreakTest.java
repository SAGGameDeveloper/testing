package Agenda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;


public class DiaBreakTest {
	private DiaBreak dia;
	
	@Before
	public void setUp() {
		try {
			dia = new DiaBreak(1);
		} catch (DatoException exception) {
		}
	}
	
	@Test
	public void testConstructorLowerThanOne() {
		try {
			dia = new DiaBreak(0);
			fail("Se ha podido crear un día menor que 1");
		} catch (DatoException exception) {
			
		}
	}
	
	@Test
	public void testConstructorGreaterThan365() {
		try {
			dia = new DiaBreak(366);
			fail("Se ha podido crear un día mayor de 365");
		} catch (DatoException exception) {
			
		}
	}
	
	@Test
	public void testConstructorOne() {
		try {
			dia = new DiaBreak(1);
		} catch (DatoException exception) {
			fail("No se ha podido crear el día 1");
		}
	}
	
	@Test
	public void testConstructor365() {
		try {
			dia = new DiaBreak(365);
		} catch (DatoException exception) {
			fail("No se ha podido crear el día 365");
		}
	}
	@Test
	public void testBuscaSlotVacio() {
		assertEquals(9, dia.buscaSlot(1));
	}
	
	@Test
	public void testBuscaSlotLleno() {
		dia.asignarCita(9, new Cita("Rezar a nuestro señor Jesucristo", 8));
		assertEquals(-1, dia.buscaSlot(1));
	}
	
	@Test
	public void testBuscaSlotConCita() {
		dia.asignarCita(9, new Cita("Rezar a nuestro señor Jesucristo", 1));
		assertEquals(10, dia.buscaSlot(1));
	}
	
	@Test
	public void testBuscaSlotConCitaLarga() {
		dia.asignarCita(9, new Cita("Rezar a nuestro señor Allah", 7));
		assertEquals(16, dia.buscaSlot(1));
	}
	@Test
	public void testBuscaSlotVariasCitas() {
		dia.asignarCita(9, new Cita("Rezar a nuestro señor Pipo", 2));
		dia.asignarCita(12, new Cita("Rezar a nuestro señor Miyazaki", 3));
		assertEquals(11, dia.buscaSlot(1));
	}
	
	@Test
	public void testBuscaSlotLargoVariasCitas() {
		dia.asignarCita(9, new Cita("Rezar a nuestro señor Pipo", 1));
		dia.asignarCita(11, new Cita("Rezar a nuestro señor Miyazaki", 2));
		assertEquals(13, dia.buscaSlot(2));
	}
	
	@Test
	public void testBuscaSlotHuecoInsuficiente() {
		dia.asignarCita(9, new Cita("Rezar a nuestro señor Pipo", 3));
		dia.asignarCita(14, new Cita("Rezar a nuestro señor Miyazaki", 1));
		assertEquals(-1, dia.buscaSlot(3));
	}
	
	
}
