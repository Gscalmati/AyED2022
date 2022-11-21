package tp06.ejercicio6;

import tp02.ejercicio2.*;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class TestVisitaOslo {

	public static void main(String[] args) {
		
		
		Vertice<String> v1 = new VerticeImplListAdy<String>("Holmenkollen");
		Vertice<String> v2 = new VerticeImplListAdy<String>("Parque Vigeland");
		Vertice<String> v3 = new VerticeImplListAdy<String>("FolkMuseum");
		Vertice<String> v4 = new VerticeImplListAdy<String>("Museo Fram");
		Vertice<String> v5 = new VerticeImplListAdy<String>("Galeria Nacional");
		Vertice<String> v6 = new VerticeImplListAdy<String>("Palacio Real");
		Vertice<String> v7 = new VerticeImplListAdy<String>("Akker Brigge");
		Vertice<String> v8 = new VerticeImplListAdy<String>("Parque Botanico");
		Vertice<String> v9 = new VerticeImplListAdy<String>("Ayuntamiento");
		Vertice<String> v10 = new VerticeImplListAdy<String>("Museo Munch");
		Vertice<String> v11 = new VerticeImplListAdy<String>("El Tigre");
		Vertice<String> v12 = new VerticeImplListAdy<String>("La Opera");
		Vertice<String> v13 = new VerticeImplListAdy<String>("Fortaleza Akershus");
		Vertice<String> v14 = new VerticeImplListAdy<String>("Museo del Barco Polar");
		Vertice<String> v15 = new VerticeImplListAdy<String>("Museo Vikingo");
		
		Grafo<String> lugares = new GrafoImplListAdy<String>();
		
		lugares.agregarVertice(v1);
		lugares.agregarVertice(v2);
		lugares.agregarVertice(v3);
		lugares.agregarVertice(v4);
		lugares.agregarVertice(v5);
		lugares.agregarVertice(v6);
		lugares.agregarVertice(v7);
		lugares.agregarVertice(v8);
		lugares.agregarVertice(v9);
		lugares.agregarVertice(v10);
		lugares.agregarVertice(v11);
		lugares.agregarVertice(v12);
		lugares.agregarVertice(v13);
		lugares.agregarVertice(v14);
		lugares.agregarVertice(v15);
		
		lugares.conectar(v1, v2, 30);
		lugares.conectar(v2, v1, 30);
		lugares.conectar(v2, v3, 20);
		lugares.conectar(v3, v2, 20);
		lugares.conectar(v2, v5, 10);
		lugares.conectar(v5, v2, 10);
		lugares.conectar(v3, v4, 5);
		lugares.conectar(v4, v3, 5);
		lugares.conectar(v4, v14, 5);
		lugares.conectar(v14, v4, 5);
		lugares.conectar(v14, v15, 5);
		lugares.conectar(v15, v14, 5);
		lugares.conectar(v3, v6, 5);
		lugares.conectar(v6, v3, 5);
		lugares.conectar(v3, v7, 30);
		lugares.conectar(v7, v3, 30);
		lugares.conectar(v7, v15, 30);
		lugares.conectar(v15, v7, 30);
		lugares.conectar(v5, v8, 15);
		lugares.conectar(v8, v5, 15);
		lugares.conectar(v8, v10,1);
		lugares.conectar(v10, v8,1);
		lugares.conectar(v10, v11,15);
		lugares.conectar(v11, v10,15);
		lugares.conectar(v11, v12,5);
		lugares.conectar(v12, v11,5);
		lugares.conectar(v12, v13,10);
		lugares.conectar(v13, v12,10);
		
		lugares.conectar(v9, v6,5);
		lugares.conectar(v6, v9,5);
		
		lugares.conectar(v9, v7,20);
		lugares.conectar(v7, v9,20);
		
		lugares.conectar(v9, v8,10);
		lugares.conectar(v8, v9, 10);
		
		lugares.conectar(v9, v11,15);
		lugares.conectar(v11, v9,15);
		
		VisitaOslo visita = new VisitaOslo();
		
		ListaGenerica<String> lugaresRestringidos = new ListaEnlazadaGenerica<String>();
		lugaresRestringidos.agregarFinal("Akker Brigge");
		lugaresRestringidos.agregarFinal("Palacio Real");
		
		ListaGenerica<String> camino = visita.paseoEnBici(lugares, "Museo Vikingo", 120, lugaresRestringidos);
		camino.comenzar();
		while (!camino.fin()) {
			System.out.println(camino.proximo());
		}
	}

}
