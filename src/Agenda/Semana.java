package Agenda;



public class Semana {

	    // Representa una semana de lunes a viernes.
	
	    public static final int DIAS_RESERVABLES = 5;
	    
	    // Numero de la semana en el a�o (1-52).
	    
	    private final int numeroSemana;
	    private final Dia[] dias;

	    /**
	      * @param numeroSemana (1-52).
	     */
	    public Semana(int numeroSemana) throws DatoException
	    {
	    	
	    	if (numeroSemana <= 0 || numeroSemana > 52) {
				
				throw new DatoException("La semana debe tomar valor entre 1 y 52");
			}
	        this.numeroSemana = numeroSemana;
	        dias = new Dia[DIAS_RESERVABLES];
	        int diaDelAnio = (numeroSemana - 1) * 7 + 1; //testGetDiaUno
	        for(int dia = 0; dia < DIAS_RESERVABLES; dia++) {
	            dias[dia] = new Dia(diaDelAnio);
	            diaDelAnio++;
	        }
	    }

	    /**
	     * @param hora de la cita
	     * @param dia de la cita(1-5)
	     * @return Cita de un dia a una hora .
	     */
	    public String mostrarCita(int hora, int diaSemana)
	    {   	    	
	        return getDia(diaSemana).muestraCita(hora);
	    }

	    /**
	     * @param dia de la semana (1..DIAS_RESERVABLES).
	     * @return El Dia asociado, o null si dia de la semana
	     *         esta fuera de rango.
	     */
	    public Dia getDia(int diaSemana)
	    {
	        if(diaSemana >= 1 && diaSemana <= DIAS_RESERVABLES) {
	            return dias[diaSemana - 1]; //testGetDiaUno
	        }
	        else {
	            return null; 
	        }
	    }

	    /**
	     * @return Numero de semana (1-52).
	     */
	    public int getNumeroSemana()
	    {
	        return numeroSemana;
	    }
	    
	   	    
	    public String primerHueco(int duracion) {
	    	
	    	String disponible;
	    	for(int dia = 1; dia < DIAS_RESERVABLES; dia++) {
	    		int hueco=dias[dia - 1].buscaSlot(duracion);
	    		if (hueco!=-1)
	             { disponible= diaSemana(dia) + " " + hueco + ":00";
	    			return disponible;
	             }
	    	}
	             
	    	return "No hay disponibilidad";
	    }
	    
	    /**
	     * @return Nombre Dia de la semana
	     */
	    public String diaSemana(int dia) {
	    
	    	String diaNombre;
	    	//testDiaSemanaLunes
	    	switch(dia) {
	    	 case 1: 
	    		 diaNombre="Lunes";
	    	     break;
	    	 case 2: 
	    		 diaNombre="Martes";
	    	     break;
	    	 case 3: 
	    		 diaNombre="Miercoles";
	    	     break;
	    	 case 4: 
	    		 diaNombre="Jueves";
	    	     break;
	    	 case 5: 
	    		 diaNombre="Viernes";
	    		 break; //testDiaSemanaViernes
	    	 default: 
	    		 diaNombre="No citable";
	    	     break;
	    	 }
		    
		    return diaNombre;
	    }
	    
	    
	}
