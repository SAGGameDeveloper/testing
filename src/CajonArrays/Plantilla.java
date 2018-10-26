package CajonArrays;
import java.util.*;



public class Plantilla {


	private ArrayList<Empleado> empleados;
	
	public Plantilla() {
		empleados= new ArrayList<Empleado>();
	}

	public void add(Empleado est)	{
		empleados.add(est);
	}
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}


	public ArrayList<String> getEmpleados1825() {
		return null;
		
	}

	
	public Empleado getEmpleadoPorDNI(String DNI) {
		return null;
		
	}

	
	public String getEmpleadoDepartamento(String DNI) {
		return DNI;
		
	}

	
	public ArrayList<Empleado> getEmpleadosPorEdadSexo(int minEdad,	String sexo) {
		return empleados;
		
	}


}