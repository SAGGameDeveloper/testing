package Cajon;

public class Boa {
	
	private String nombre;
	private int longitud; // en pies
	private String comidaFavorita;
	
	public Boa (String nombre, int longitud, String comidaFavorita){
		this.nombre = nombre;
		this.longitud = longitud;
		this.comidaFavorita = comidaFavorita;
	}
	
	public boolean esSana(){
		return this.comidaFavorita.equals("granola");
	}
	
	public boolean cabeEnCesta(int longitud_cesta) {
		return this.longitud < longitud_cesta;
	}
	
	public int longEnPulgadas(){  
		return longitud * 12;
	} 
	
}