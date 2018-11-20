package Agenda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SemanaBreakTest {
	private SemanaBreak semana;

	@Before
	public void setUp() {
		try {
			semana = new SemanaBreak(1);
		} catch (DatoException exception) {
		}
	}
	
	@Test
	public void testConstructorLowerThanOne() {
		try {
			semana = new SemanaBreak(0);
			fail("Se ha podido crear una semana menor que 1");
		} catch (DatoException exception) {
			
		}
	}

	@Test
	public void testConstructorGreaterThan53() {
		try {
			semana = new SemanaBreak(53);
			fail("Se ha podido crear una semana mayor de 53");
		} catch (DatoException exception) {
			
		}
	}
	
	@Test
	public void testConstructorOne() {
		try {
			semana = new SemanaBreak(1);
		} catch (DatoException exception) {
			fail("No se ha podido crear la semana 1");
		}
	}
	
	@Test
	public void testConstructor52() {
		try {
			semana = new SemanaBreak(52);
		} catch (DatoException exception) {
			fail("No se ha podido crear el semana 52");
		}
	}
	
	@Test
	public void testGetNumeroSemana() {
		assertEquals(1, semana.getNumeroSemana());
	}
	
	@Test
	public void testGetNumeroSemanaGrande() {
		try {
			semana = new SemanaBreak(11);
		}
		catch (DatoException exception){}
		assertEquals(11, semana.getNumeroSemana());
	}
	
	@Test
	public void testDiaSemanaLunes() {
		assertEquals("Lunes", semana.diaSemana(1));
	}
	
	@Test
	public void testDiaSemanaViernes() {
		assertEquals("Viernes", semana.diaSemana(5));
	}
	
	@Test
	public void testGetDiaUno() {
		assertEquals(1, semana.getDia(1).getDiaNumero());
	}
	
	@Test
	public void testGetDiaCinco() {
		assertEquals(5, semana.getDia(5).getDiaNumero());
	}
	
	@Test
	public void testGetDiaTreinta() {
		try {
			semana = new SemanaBreak(5);
		}
		catch (DatoException exception){}
		assertEquals(30, semana.getDia(2).getDiaNumero());
	}
	
	@Test
	public void testGetDiaNull() {
		assertEquals(null, semana.getDia(6));
	}
	
	@Test
	public void testGetDiaNullZero() {
		assertEquals(null, semana.getDia(0));
	}
	
	@Test
	public void testPrimerHuecoLunes() {
		assertEquals("Lunes 9:00", semana.primerHueco(1));
	}
	
	@Test
	public void testPrimerHuecoMartes() {
		Cita cita = new Cita("Neurólogo", 9);
		semana.getDia(1).asignarCita(9, cita);
		assertEquals("Martes 9:00", semana.primerHueco(1));
	}
	
	@Test
	public void testPrimerHuecoLunes10() {
		Cita cita = new Cita("Neurólogo", 1);
		semana.getDia(1).asignarCita(9, cita);
		assertEquals("Lunes 10:00", semana.primerHueco(1));
	}
	
	@Test
	public void testPrimerHuecoMartesLargo() {
		Cita cita = new Cita("Neurólogo", 9);
		semana.getDia(1).asignarCita(10, cita);
		assertEquals("Martes 9:00", semana.primerHueco(2));
	}
	
	@Test
	public void testPrimerHuecoLleno() {
		Cita cita = new Cita("Neurólogo", 9);
		for(int i = 1; i < SemanaBreak.DIAS_RESERVABLES; i++)
			semana.getDia(i).asignarCita(9, cita);
		assertEquals("No hay disponibilidad", semana.primerHueco(1));
	}
}
