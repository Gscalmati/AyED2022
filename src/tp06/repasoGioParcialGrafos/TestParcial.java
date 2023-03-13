package tp06.repasoGioParcialGrafos;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class TestParcial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Grafo <String> grafo = new GrafoImplListAdy<String> ();
		
		Vertice <String> v1 = new VerticeImplListAdy<String>("La Plata");
		Vertice <String> v2 = new VerticeImplListAdy<String>("Berisso");
		Vertice <String> v3 = new VerticeImplListAdy<String>("Ensenada");
		Vertice <String> v4 = new VerticeImplListAdy<String>("City Bell");
		Vertice <String> v5 = new VerticeImplListAdy<String>("Villa Elisa");
		Vertice <String> v6 = new VerticeImplListAdy<String>("Los Hornos");
		Vertice <String> v7 = new VerticeImplListAdy<String>("San Carlos");
		Vertice <String> v8 = new VerticeImplListAdy<String>("Tolosa");
		
		grafo.agregarVertice(v1);
		grafo.agregarVertice(v2);
		grafo.agregarVertice(v3);
		grafo.agregarVertice(v4);
		grafo.agregarVertice(v5);
		grafo.agregarVertice(v6);
		grafo.agregarVertice(v7);
		grafo.agregarVertice(v8);
		
		grafo.conectar(v1, v2, 50);
		grafo.conectar(v1, v3, 70);
		grafo.conectar(v1, v6, 30);
		grafo.conectar(v1, v7, 30);
		grafo.conectar(v1, v8, 20);
		
		grafo.conectar(v2, v1, 50);
		grafo.conectar(v2, v3, 40);
		
		grafo.conectar(v3, v1, 70);
		grafo.conectar(v3, v2, 40);
		
		grafo.conectar(v4, v5, 40);
		grafo.conectar(v4, v7, 60);
		grafo.conectar(v4, v8, 50);
		
		grafo.conectar(v5, v4, 40);
		
		grafo.conectar(v6, v1, 30);
		grafo.conectar(v6, v7, 10);
		
		grafo.conectar(v7, v1, 30);
		grafo.conectar(v7, v4, 60);
		grafo.conectar(v7, v6, 10);
		
		grafo.conectar(v8, v1, 20);
		grafo.conectar(v8, v4, 50);
		
		Parcial parcial = new Parcial();
		
		ListaGenerica<String> camino = parcial.encontrarCaminoMenosDistancia(grafo, "Ensenada", "Villa Elisa", null);
		
		System.out.println("------------------------------------");
		camino.comenzar();
		while(!camino.fin()) {
			System.out.println(camino.proximo());
		}

	}

}
