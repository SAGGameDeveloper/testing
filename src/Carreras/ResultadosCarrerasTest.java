package Carreras;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ResultadosCarrerasTest {
	
	private ResultadosCarreras results;
	private Cliente client;
	private Mensaje message;
	
	@Before
	public void init() {
		results = new ResultadosCarreras();
		client = mock(Cliente.class);
		message = mock(Mensaje.class);
	}
	
	@Test
	public void testNoSub() {
		
		results.enviar(message);
		verify(client, never()).recibe(message);
	}
	
	@Test
	public void testReceiveOnce() {
		
		results.nuevaSuscripcion(client);
		results.enviar(message);
		
		verify(client, atLeast(1)).recibe(message);
		verify(client, atMost(1)).recibe(message);
	}
	
	@Test
	public void testMultipleClients() {
		
		Cliente client2 = mock(Cliente.class);
		
		results.nuevaSuscripcion(client);
		results.nuevaSuscripcion(client2);
		results.enviar(message);
		
		verify(client, atLeast(1)).recibe(message);
		verify(client2, atLeast(1)).recibe(message);
	}
	
	@Test
	public void testNoRepeatClient() {
		
		results.nuevaSuscripcion(client);
		results.nuevaSuscripcion(client);
		results.enviar(message);
		
		verify(client, atMost(1)).recibe(message);
	}
	
	@Test
	public void testNoReceiveUnsub() {
		
		results.nuevaSuscripcion(client);
		results.enviar(message);
		results.bajaSuscripcion(client);
		results.enviar(message);
		
		verify(client, atMost(1)).recibe(message);
	}

}
