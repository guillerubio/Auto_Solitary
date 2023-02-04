package game;
import java.awt.Font;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import stdlib.StdDraw;

/* JuegoApp.java
   Nombre y Apellidos: Guillermo Rubio Bolger
   Fecha: 05/05/2021 */

public class JuegoApp {
	
	Juego ju;
	List<Carta> mazo;
	List<List<Carta>> bases;
	boolean jugadoConExito;
	
	private int ultimaYOros = 100;
	private int ultimaYCopas = 100;
	private int ultimaYEspadas = 100;
	private int ultimaYBastos = 100;

	public  void inicioGrafico(){
		final int XMAX = 150;
	    final int YMAX = 250;
	    StdDraw.setCanvasSize(6*XMAX+50, 2*YMAX);
	    StdDraw.setScale(0, XMAX);
	    StdDraw.setPenRadius(0.005);
	    fondoInicio();
	} // de inicioGrafico

	public void fondoInicio() {
		StdDraw.setPenColor(53,101,77);
		StdDraw.filledRectangle(0, 0, 150, 250);
		StdDraw.setPenColor(StdDraw.WHITE);
		Font font = new Font("Times New Roman", Font.PLAIN, 20);
		StdDraw.setFont(font);
		StdDraw.text(130, 142, "Mazo");
		StdDraw.rectangle(130, 73, 10, 65);
		StdDraw.text(14, 137, "Oros");
		StdDraw.rectangle(14, 73, 10, 55);
		StdDraw.text(40, 137, "Copas");
		StdDraw.rectangle(40, 73, 10, 55);
		StdDraw.text(66, 137, "Espadas");
		StdDraw.rectangle(66, 73, 10, 55);
		StdDraw.text(92, 137, "Bastos");
		StdDraw.rectangle(92, 73, 10, 55);
	} // de fondo
	
	public void fondoIt() {
		StdDraw.setPenColor(53,101,77);
		StdDraw.filledRectangle(0, 0, 150, 250);
		StdDraw.setPenColor(StdDraw.WHITE);
		Font font = new Font("Times New Roman", Font.PLAIN, 20);
		StdDraw.setFont(font);
		StdDraw.text(130, 142, "Mazo");
		StdDraw.rectangle(130, 73, 10, 65);
		StdDraw.text(14, 137, "Oros");
		StdDraw.rectangle(14, 73, 10, 55);
		StdDraw.text(40, 137, "Copas");
		StdDraw.rectangle(40, 73, 10, 55);
		StdDraw.text(66, 137, "Espadas");
		StdDraw.rectangle(66, 73, 10, 55);
		StdDraw.text(92, 137, "Bastos");
		StdDraw.rectangle(92, 73, 10, 55);
		for (int i = 0; i<mazo.size(); i++) {
			mazo.get(i).pintar(mazo.get(i).x,mazo.get(i).y);
		} // de for
		for (int i = Carta.OROS; i<=Carta.BASTOS; i++) {
			for(int b=0; b<bases.get(i).size();b++) {
				bases.get(i).get(b).pintar(bases.get(i).get(b).x, bases.get(i).get(b).y);
			} // de for
		} // de for
	} // de fondo
	
	public void inicioMazo() {
		ju = new Juego();
		mazo = pasarALista(ju.mazo());
		iniciarBases();
		int x = 130;
		int y = 112;	
		for (int i = 0; i<=mazo.size()-1; i++) {
			mazo.get(i).x=x;
			mazo.get(i).y=y;
			mazo.get(i).pintar(x,y);
			y=y-2;
			esperar(30);
		} // de for
		ju.jugar();
		jugadoConExito=ju.jugadoConExito();
	} // de inicioMazo
	
	public void iniciarBases() {
		bases= new LinkedList<List<Carta>>();
		for(int i = Carta.OROS; i<=Carta.BASTOS; i++) {
			bases.add(i, new LinkedList<Carta>());
		} // de for
	} // de iniciarBases
	
	public void jugarMoviendo (){
		while (mazo.size() != 0) {
			if (mazo.get(mazo.size()-1).ordinalPalo()==Carta.OROS) {
				bases.get(Carta.OROS).add(bases.get(Carta.OROS).size(), mazo.get(mazo.size()-1));
				moverCarta (mazo.get(mazo.size()-1),14, ultimaYOros);
				ultimaYOros=ultimaYOros-2;
				mazo.remove(mazo.size()-1);
			} else if (mazo.get(mazo.size()-1).ordinalPalo()==Carta.COPAS) {
				bases.get(Carta.COPAS).add(bases.get(Carta.COPAS).size(), mazo.get(mazo.size()-1));
				moverCarta(mazo.get(mazo.size()-1), 40, ultimaYCopas);
				ultimaYCopas=ultimaYCopas-2;
				mazo.remove(mazo.size()-1);
			} else if (mazo.get(mazo.size()-1).ordinalPalo()==Carta.ESPADAS) {
				bases.get(Carta.ESPADAS).add(bases.get(Carta.ESPADAS).size(), mazo.get(mazo.size()-1));
				moverCarta(mazo.get(mazo.size()-1),66, ultimaYEspadas);
				ultimaYEspadas=ultimaYEspadas-2;
				mazo.remove(mazo.size()-1);
			} else {
				bases.get(Carta.BASTOS).add(bases.get(Carta.BASTOS).size(), mazo.get(mazo.size()-1));
				moverCarta(mazo.get(mazo.size()-1), 92, ultimaYBastos);
				ultimaYBastos=ultimaYBastos-2;
				mazo.remove(mazo.size()-1);
			} // de if else if else if else
		} // de while
	} // de jugar

	private  List<Carta> pasarALista (Stack<Carta> pila){
		List<Carta> res = new LinkedList<Carta>();
		while (!pila.isEmpty()) {
			res.add(0, pila.peek());
			pila.pop();
		} // de while
		return res;
	} // de pasarALista
	
	/*private Stack<Carta> copiarStack (Stack<Carta>pila){
		Stack<Carta> res = new Stack<Carta>();
		Stack<Carta> aux = new Stack<Carta>();
		while(!pila.isEmpty()) {
			res.push(pila.peek());
			aux.push(pila.peek());
			pila.pop();
		} // de while
		while(!aux.isEmpty()) {
			pila.push(aux.peek());
			aux.pop();
		} // de while
		return res;
	} // de copiarStack*/
	
	public void esperar (int ms) {
		try{
			Thread.sleep(ms);
		}catch(InterruptedException ex){}
	} // de esperar
	
	public void moverCarta(Carta carta, double x, double y) {
		double vectorX=x-carta.x;
		double vectorY=y-carta.y;
		System.out.println(carta.toString() + "de (" + carta.x + ", " + carta.y + ") a (" + x + ", " + y +")");
		StdDraw.enableDoubleBuffering();
		while(carta.x!=x) {
			StdDraw.clear();
			carta.x=carta.x+vectorX/Math.abs(vectorX);
			carta.y=carta.y+vectorY/Math.abs(vectorX);
			pintarCarta(carta);
			StdDraw.show();
			esperar(10);
			}  // de while
		fondoIt();
		esperar(20);
		} // de mover
	
	public void pintarCarta(Carta carta) {
		StdDraw.enableDoubleBuffering();
		fondoIt();
		StdDraw.picture(carta.x, carta.y, Carta.DIRECTORIO +carta.toString()+".jpg");
		StdDraw.show();
	    esperar(10);
	  //  StdDraw.disableDoubleBuffering();
	} // de pintarCarta
	
	public void jugar () {
		System.out.println("Has Ganado = " +jugadoConExito);
		inicioGrafico();
		inicioMazo();
		jugarMoviendo();
	} // de jugar
	
	public static void main (String[]args) {
		ClassLoader loader = JuegoApp.class.getClassLoader();
        String aux = (loader.getResource("game").toString());
        String directorio = (aux.substring(5, aux.length()-8) + "src/data/images");
        System.out.println(directorio);
        

		JuegoApp j = new JuegoApp();
		j.jugar();		
	} // de main
	
} // de clase JuegoApp
