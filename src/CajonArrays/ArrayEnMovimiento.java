package CajonArrays;

public class ArrayEnMovimiento {
	
	public int[] moverUno(int[] inArray) {
		int[] tmp = new int[inArray.length];
		
		for(int i = inArray.length-1; i != 0; i--) {
			tmp[i] = inArray[i - 1];
		}
		tmp[0] = -1;
		
		return tmp;
	}
}
