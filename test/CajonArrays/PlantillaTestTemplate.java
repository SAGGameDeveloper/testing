package CajonArrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PlantillaTestTemplate
{

	private Plantilla mat;
	private Departamentos dept;

	@Before
	public void setUp() {
		
		dept = new Departamentos();
		mat = new Plantilla();
		
		mat.add(new Empleado("s0189034","Pedro","pedro@mate",17,"Hombre"));
		mat.add(new Empleado("s0289125","Miguel","miguel@geo",21,"Hombre"));
		mat.add(new Empleado("s0378435","Elena","elena@fisic",28, "Mujer"));
		mat.add(new Empleado("s0412375","Maria","maria@inf",18,"Mujer"));
		mat.add(new Empleado("s0456782","Juan","juan@inf",22, "Hombre"));
		mat.add(new Empleado("s0355689","Diana","diana@leng",33, "Mujer"));
		mat.add(new Empleado("s0768633","Luis","luis@quim",36, "Hombre"));
   
	}
	
	@Test
	public void testGetEmpleado1825() {
		
	}
	
	@Test
	public void testGetEmpleadoDepartamentoNulo() {
		
	}
	
	@Test
	public void testGetEmpleadoDepartamentoValorNulo() {
		
	}
	
	@Test
	@Parameters(method = "????")
	public void testGetEmpleadoDepartamentoNoNulo(String DNI, String dept) {
	
	}

	@Test
	public void testGetEmpleadoPorDNINulo() {

	}
	
	@Test
	public void testGetEmpleadoPorDNIValorNulo() {

	}
	
	@Test
	@Parameters(method = "????")
	public void testGetEmpleadoPorDNINoNulo(String DNI) {

	}
	
	public void testGetEmpleadosPorEdadSexo() {

		
	}


}