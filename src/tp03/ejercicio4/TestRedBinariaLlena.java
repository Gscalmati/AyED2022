package tp03.ejercicio4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp03.ejercicio2.ArbolBinario;
import tp04.ejercicio2.RecorridosGeneral;

public class TestRedBinariaLlena {

		public static void main(String[] args) {
			
			ArbolBinario <Integer> ab = new ArbolBinario <Integer>(10);
			
			ArbolBinario <Integer> hi = new ArbolBinario <Integer>(5);
			ArbolBinario <Integer> hd = new ArbolBinario <Integer>(20);
			
			ArbolBinario <Integer> hid = new ArbolBinario <Integer>(8);
			ArbolBinario <Integer> hdi = new ArbolBinario <Integer>(18);
			
			ab.agregarHijoIzquierdo(hi);
			ab.agregarHijoDerecho(hd);
			
			hi.agregarHijoDerecho(hid);
			hd.agregarHijoIzquierdo(hdi);
			
			
			System.out.println("-------------------------------------------");
			
			
			RedBinariaLlena redB = new RedBinariaLlena ();
			
			redB.setAb(ab);
			
			System.out.println(redB.retardoReenvio());
			
		}

}
