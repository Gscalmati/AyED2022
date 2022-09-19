package tp03.ejercicio2;

public class TestEjs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArbolBinario <Integer> ab = new ArbolBinario <Integer>(1);
		
		ArbolBinario <Integer> hi = new ArbolBinario <Integer>(2);
		ArbolBinario <Integer> hd = new ArbolBinario <Integer>(3);
		
		ArbolBinario <Integer> hid = new ArbolBinario <Integer>(5);
		ArbolBinario <Integer> hdi = new ArbolBinario <Integer>(4);
		
		ab.agregarHijoIzquierdo(hi);
		ab.agregarHijoDerecho(hd);
		
		hi.agregarHijoDerecho(hid);
		hd.agregarHijoIzquierdo(hdi);
		
		Recorridos recorrer = new Recorridos();
		
		recorrer.preOrder(ab);
		
		System.out.println();
		
		ArbolBinario<Integer> arbolEspejo = new ArbolBinario <Integer>();
		
		arbolEspejo = ab.espejo();
		
		recorrer.preOrder(arbolEspejo);
		

	}

}
