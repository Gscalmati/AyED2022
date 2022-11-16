package tp06.clase911;

import tp06.ejercicio3.*;

public class TestRecorridos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafo <Integer> grafo = new GrafoImplListAdy<Integer> ();
		
		Vertice <Integer> v1 = new VerticeImplListAdy<Integer>(1);
		Vertice <Integer> v2 = new VerticeImplListAdy<Integer>(2);
		Vertice <Integer> v3 = new VerticeImplListAdy<Integer>(3);
		Vertice <Integer> v4 = new VerticeImplListAdy<Integer>(4);
		Vertice <Integer> v5 = new VerticeImplListAdy<Integer>(5);
		Vertice <Integer> v6 = new VerticeImplListAdy<Integer>(6);
		
		grafo.agregarVertice(v1);
		grafo.agregarVertice(v2);
		grafo.agregarVertice(v3);
		grafo.agregarVertice(v4);
		grafo.agregarVertice(v5);
		grafo.agregarVertice(v6);
		
		grafo.conectar(v1, v2);
		grafo.conectar(v1, v3);
		
		grafo.conectar(v2, v1);
		grafo.conectar(v2, v3);
		grafo.conectar(v2, v4);
		
		grafo.conectar(v3, v1);
		grafo.conectar(v3, v2);
		grafo.conectar(v3, v4);
		
		grafo.conectar(v4, v2);
		grafo.conectar(v4, v3);
		grafo.conectar(v4, v5);
		
		grafo.conectar(v5, v4);
		
		Recorridos rec = new Recorridos ();
		
		rec.dfs(grafo, 5);
		//rec.bfs(grafo, 5);
	}

}
