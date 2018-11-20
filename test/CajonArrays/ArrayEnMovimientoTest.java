package CajonArrays;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class ArrayEnMovimientoTest {
	private ArrayEnMovimiento arrayMov;
	private int[] array, arrayResult;
	
	@Before
	public void	setUp() {
		arrayMov = new ArrayEnMovimiento();
		array = new int[20];
		
		for (int i = 0; i < array.length-1; i++) {
			array[i] = (int) (Math.random() * Integer.MAX_VALUE);
		}
	}
	
	@Test
	public void testMoverUnoFirstElement() {
		arrayResult = arrayMov.moverUno(array);
		
		assertEquals(-1, arrayResult[0]);
	}
	
	@Test
	public void testMoverUno() {		
		arrayResult = arrayMov.moverUno(array);
		
		assertEquals(array[0], arrayResult[1]);
	}

}
