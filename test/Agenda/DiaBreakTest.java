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
			fail("No se ha podido crear el día número 1");
		}
	}
	
	// Constructor
	
	@Test
	public void testConstructorLowerThanOne() {
		try {
			dia = new DiaBreak(0);
			fail("Se ha podido crear un d�a menor que 1");
		} catch (DatoException exception) {
			
		}
	}
	
	@Test
	public void testConstructorGreaterThan365() {
		try {
			dia = new DiaBreak(366);
			fail("Se ha podido crear un d�a mayor de 365");
		} catch (DatoException exception) {
			
		}
	}
	
	@Test
	public void testConstructorOne() {
		try {
			dia = new DiaBreak(1);
		} catch (DatoException exception) {
			fail("No se ha podido crear el d�a 1");
		}
	}
	
	@Test
	public void testConstructor365() {
		try {
			dia = new DiaBreak(365);
		} catch (DatoException exception) {
			fail("No se ha podido crear el d�a 365");
		}
	}
	
	// buscaSlot
	
	@Test
	public void testBuscaSlotVacio() {
		assertEquals(9, dia.buscaSlot(1));
	}
	
	@Test
	public void testBuscaSlotLleno() {
		dia.asignarCita(dia.PRIMERA_CITA, new Cita("Cita9", dia.MAX_CITAS_POR_DIA));
		assertEquals(-1, dia.buscaSlot(1));
	}
	
	@Test
	public void testBuscaSlotConCita() {
		dia.asignarCita(9, new Cita("Cita9", 1));
		assertEquals(10, dia.buscaSlot(1));
	}
	
	@Test
	public void testBuscaSlotConCitaLarga() {
		dia.asignarCita(9, new Cita("Cita9", 7));
		assertEquals(16, dia.buscaSlot(1));
	}
	@Test
	public void testBuscaSlotVariasCitas() {
		dia.asignarCita(9, new Cita("Cita9", 2));
		dia.asignarCita(12, new Cita("Cita12", 3));
		assertEquals(11, dia.buscaSlot(1));
	}
	
	@Test
	public void testBuscaSlotLargoVariasCitas() {
		dia.asignarCita(9, new Cita("Cita9", 1));
		dia.asignarCita(11, new Cita("Cita11", 2));
		assertEquals(13, dia.buscaSlot(2));
	}
	
	@Test
	public void testBuscaSlotHuecoInsuficiente() {
		dia.asignarCita(9, new Cita("Cita9", 3));
		dia.asignarCita(14, new Cita("Cita14", 2));
		assertEquals(-1, dia.buscaSlot(3));
	}
	
	// validaHora
	
	@Test
	public void testValidaHoraLimiteInferior() {
		assertEquals(true, dia.validaHora(dia.PRIMERA_CITA));
		assertEquals(false, dia.validaHora(dia.PRIMERA_CITA - 1));
	}
	
	@Test
	public void testValidaHoraLimiteSuperior() {
		assertEquals(true, dia.validaHora(dia.ULTIMA_CITA));
		assertEquals(false, dia.validaHora(dia.ULTIMA_CITA + 1));
	}
	
	@Test
	public void testValidaHoraEntreLimites() {
		assertEquals(true, dia.validaHora(dia.PRIMERA_CITA + 1));
		assertEquals(true, dia.validaHora(dia.ULTIMA_CITA - 1));
	}
	
	// asignarCita
	
	@Test
	public void testAsignarCitaPrimeraHora() {
		assertEquals(true, dia.asignarCita(dia.PRIMERA_CITA, new Cita("Primera cita", 1)));		
	}
	
	@Test
	public void testAsignarCitaUltimaHora() {
		assertEquals(true, dia.asignarCita(dia.ULTIMA_CITA, new Cita("Ultima cita", 1)));		
	}
	
	@Test
	public void testAsignarCitaHuecoOcupado() {
		dia.asignarCita(dia.PRIMERA_CITA, new Cita("Cita", 5));
		assertEquals(false, dia.asignarCita(dia.PRIMERA_CITA, new Cita("Esta cita no cabe", 2)));		
	}
	
	@Test
	public void testAsignarCitasConsecutivas() {
		assertEquals(true, dia.asignarCita(dia.PRIMERA_CITA, new Cita("Primera cita", 2)));
		assertEquals(true, dia.asignarCita(dia.PRIMERA_CITA + 2, new Cita("Segunda cita", 4)));		
	}
	
	@Test
	public void testAsignarCitaSolapada() {
		dia.asignarCita(dia.PRIMERA_CITA + 2, new Cita("Primera cita", 3));
		
		assertEquals(false, dia.asignarCita(dia.PRIMERA_CITA, new Cita("Cita solapada por debajo", 3)));		
		assertEquals(false, dia.asignarCita(dia.PRIMERA_CITA + 4 , new Cita("Cita solapada por arriba", 1)));
	}
	
	// huecoLibre
	
	@Test
	public void testHuecoLibrePrimeraHora() {
		assertEquals(true, dia.huecoLibre(dia.PRIMERA_CITA, 1));	
	}
	
	@Test
	public void testHuecoLibreUltimaHora() {
		assertEquals(true, dia.huecoLibre(dia.ULTIMA_CITA, 1));	
	}
	
	@Test
	public void testHuecoLibreDemasiadoGrande() {
		assertEquals(false, dia.huecoLibre(dia.PRIMERA_CITA, 20));
	}
	
	@Test
	public void testHuecoLibreOcupado() {
		dia.asignarCita(dia.PRIMERA_CITA, new Cita("Primera cita", 3));
		
		assertEquals(false, dia.huecoLibre(dia.PRIMERA_CITA+1, 2));
	}
	
	@Test
	public void testHuecoLibreSolapado() {
		dia.asignarCita(dia.PRIMERA_CITA + 2, new Cita("Cita", 3));
		
		assertEquals(false, dia.huecoLibre(dia.PRIMERA_CITA, 3));
		assertEquals(false, dia.huecoLibre(dia.PRIMERA_CITA + 4, 2));
	}
	
	// getCita
	
	@Test
	public void testGetCitaPrimeraHora() {
		Cita cita = new Cita("Primera cita", 1);
		
		dia.asignarCita(dia.PRIMERA_CITA, cita);
		
		assertEquals(cita, dia.getCita(dia.PRIMERA_CITA));
	}
	
	@Test
	public void testGetCitaUltimaHora() {
		Cita cita = new Cita("Ultima cita", 1);
		
		dia.asignarCita(dia.ULTIMA_CITA, cita);
		
		assertEquals(cita, dia.getCita(dia.ULTIMA_CITA));
	}
	
	@Test
	public void testGetCitaFueraLimites() {	
		assertEquals(null, dia.getCita(dia.PRIMERA_CITA - 1));
		assertEquals(null, dia.getCita(dia.ULTIMA_CITA + 1));
	}
	
	@Test
	public void testGetCitaVacia() {	
		assertEquals(null, dia.getCita(dia.PRIMERA_CITA + 2));
	}
	
	@Test
	public void testGetCitaLarga() {	
		Cita cita = new Cita("Ultima cita", 5);
		
		dia.asignarCita(dia.PRIMERA_CITA, cita);
		
		assertEquals(cita, dia.getCita(dia.PRIMERA_CITA + 4));
	}
	
	// muestraCita
	
	@Test
	public void testMuestraCitaDescripcionVacia() {		
		Cita cita = new Cita("", 1);
		
		dia.asignarCita(dia.PRIMERA_CITA, cita);
		
		assertEquals(dia.PRIMERA_CITA+":00 ", dia.muestraCita(dia.PRIMERA_CITA));
	}
	
	@Test
	public void testMuestraCitaLarga() {
		String descripcion = "Descripción";
		Cita cita = new Cita(descripcion, 4);
		
		dia.asignarCita(dia.PRIMERA_CITA, cita);
		
		assertEquals((dia.PRIMERA_CITA+3) + ":00 " + descripcion, dia.muestraCita(dia.PRIMERA_CITA + 3));
	}
	
	@Test
	public void testMuestraCitaInexistente() {		
		assertEquals("No existe", dia.muestraCita(dia.PRIMERA_CITA + 2));
	}
	
	@Test
	public void testMuestraCitaHoraNoValida() {		
		assertEquals("Hora no valida", dia.muestraCita(dia.PRIMERA_CITA - 2));
	}
	
}
