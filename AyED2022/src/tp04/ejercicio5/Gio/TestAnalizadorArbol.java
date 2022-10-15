package tp04.ejercicio5.Gio;

import tp04.ejercicio1.ArbolGeneral;

public class TestAnalizadorArbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AreaEmpresa area = new AreaEmpresa(30, "A");
		AreaEmpresa area2 = new AreaEmpresa(25, "A");
		AreaEmpresa area3 = new AreaEmpresa(10, "A");
		AreaEmpresa area4 = new AreaEmpresa(15, "A");
		AreaEmpresa area5 = new AreaEmpresa(50, "A");
		
		ArbolGeneral<AreaEmpresa> ag = new ArbolGeneral<AreaEmpresa> (area3);
		ArbolGeneral<AreaEmpresa> hag1 = new ArbolGeneral<AreaEmpresa> (area);
		ArbolGeneral<AreaEmpresa> hag2 = new ArbolGeneral<AreaEmpresa> (area);
		ArbolGeneral<AreaEmpresa> hag3 = new ArbolGeneral<AreaEmpresa> (area);
		
		ag.agregarHijo(hag1);
		ag.agregarHijo(hag2);
		ag.agregarHijo(hag3);
		
		ArbolGeneral<AreaEmpresa> hhag1 = new ArbolGeneral<AreaEmpresa> (area2);
		
		hag3.agregarHijo(hhag1);
		
		ArbolGeneral<AreaEmpresa> hhhag1 = new ArbolGeneral<AreaEmpresa> (area5);
		ArbolGeneral<AreaEmpresa> hhhag2 = new ArbolGeneral<AreaEmpresa> (area5);
		ArbolGeneral<AreaEmpresa> hhhag3 = new ArbolGeneral<AreaEmpresa> (area5);
		ArbolGeneral<AreaEmpresa> hhhag4 = new ArbolGeneral<AreaEmpresa> (area5);
		ArbolGeneral<AreaEmpresa> hhhag5 = new ArbolGeneral<AreaEmpresa> (area3);
		
		hhag1.agregarHijo(hhhag1);
		hhag1.agregarHijo(hhhag2);
		hhag1.agregarHijo(hhhag3);
		hhag1.agregarHijo(hhhag4);
		hhag1.agregarHijo(hhhag5);
		
		AnalizadorArbol analizador = new AnalizadorArbol();
		
		System.out.println("--------------------------------------------------");
		System.out.println(analizador.devolverMaximoPromedio(ag));
	}

}
