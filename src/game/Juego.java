package game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/* Juego.java
Nombre y Apellidos: Guillermo Rubio Bolger
Fecha: 05/05/2021 */

public class Juego{

	/*ATRIBUTOS*/
	private Stack<Carta> mazo;
	private List<Stack<Carta>> bases;

	/*CONSTRUCTORES*/
	public Juego (){
		Baraja baraja = new Baraja();
		mazo = new Stack<Carta>();
		bases = new ArrayList<Stack<Carta>>(4);
		for (int i = Carta.OROS; i <= Carta.BASTOS; i+=1) 
			bases.add(i, new Stack<Carta>());
		baraja.barajar();
		mazo = carga(baraja);
	} // de Juego (constructor)

	/**
   POST: Crea un prototipo de juego de cartas con la baraja española. 
	 */
	public Juego (Baraja baraja){
		mazo = new Stack<Carta>();
		bases = new ArrayList<Stack<Carta>>(4);
		for (int i = Carta.OROS; i <= Carta.BASTOS; i+=1) 
			bases.add(i, new Stack<Carta>());
		baraja.barajar();
		mazo = carga(baraja);
	} // de Juego (Constructor)

	/*FUNCIONES Y PROCEDIMIENTOS*/
	/**
   POST: Carga una pila de cartas a partir de una baraja. 
	 */
	private Stack<Carta> carga (Baraja baraja){
		Stack<Carta> res = new Stack<Carta>();
		for (int i=baraja.NUMERO_DE_CARTAS-1 ; i >= 0; i--) {
			if(baraja.get(i)!=null)
				res.push(baraja.get(i));
		} // de for
		return res;
	}  // de carga

	/**
   POST: Simulación de un juego (ver enunciado). 
	 */
	public void jugar (){
		while (!mazo.isEmpty()) {
			if (mazo.peek().ordinalPalo()==Carta.OROS) {
				bases.get(Carta.OROS).push(mazo.peek());
				mazo.pop();
			} else if (mazo.peek().ordinalPalo()==Carta.COPAS) {
				bases.get(Carta.COPAS).push(mazo.peek());
				mazo.pop();
			} else if (mazo.peek().ordinalPalo()==Carta.ESPADAS) {
				bases.get(Carta.ESPADAS).push(mazo.peek());
				mazo.pop();
			} else {
				bases.get(Carta.BASTOS).push(mazo.peek());
				mazo.pop();
			} // de if else if else if else
		} // de while
	} // de jugar

	/**
   POST: Simulación de otro juego (ver enunciado). 
	 */
	public void jugar2 (){
		for (int numeroCartasExtraer = (int)(Math.random()*40); numeroCartasExtraer>=0;numeroCartasExtraer--) {
			if(mazo.peek().ordinalPalo()==Carta.OROS) {
				bases.get(Carta.OROS).push(mazo.peek());
				mazo.pop();
			} else if (mazo.peek().ordinalPalo()==Carta.COPAS) {
				bases.get(Carta.COPAS).push(mazo.peek());
				mazo.pop();
			} else if (mazo.peek().ordinalPalo()==Carta.ESPADAS) {
				bases.get(Carta.ESPADAS).push(mazo.peek());
				mazo.pop();
			} else {
				bases.get(Carta.BASTOS).push(mazo.peek());
				mazo.pop();  
			} // de if else if else if else
		} // de for
	} // de jugar2

	/**
   Determina si las cuatro bases de cartas están ordenadas 
   según el criterio explicado en el enunciado.
	 */
	public boolean basesOrdenadas (){
		boolean res = true;
		for (int i=Carta.OROS; i<=Carta.BASTOS; i++) {
			res = res && baseOrdenada(bases.get(i));
		} // de for
		return res;
	}  // de res

	/**
   Pasa las cartas de una pila a una lista, insertándolas 
   por el principio.
	 */
	public List<Carta> pasarALista (Stack<Carta> pila){
		List<Carta> res = new LinkedList<Carta>();
		while (!pila.isEmpty()) {
			res.add(0, pila.peek());
			pila.pop();
		} // de while
		return res;
	} // de pasarALista

	/**
   Determina si una lista de cartas está ordenada.
	 */
	public boolean estaOrdenada (List<Carta> lista){
		boolean res = true;
		for (int i=0; res && i<lista.size()-1; i++) {
			if (lista.get(i).ordinalValor()>lista.get(i+1).ordinalValor())
				res=false;
		} // de for
		return res;
	}  // de estaOrdenada


	/**
   Determina si una base de cartas está ordenada según
   el criterio explicado en el enunciado.
	 */
	public boolean baseOrdenada (Stack<Carta> base){
		return estaOrdenada(pasarALista(base));
	} // de baseOrdenada 

	/**
   Determina si el juego ha terminado con éxito (ver enunciado).
	 */
	public boolean jugadoConExito (){
		return basesOrdenadas();
	} // de basesOrdenadas

	/**
   POST: Convierte la baraja a String.
	 */
	public String toString (){
		String s = new String();
		s += "mazo = " + mazo.toString() + "\n";
		for (int i = Carta.OROS; i <= Carta.BASTOS; i+=1) s += " base" + i + " = " + bases.get(i).toString() + "\n";
		s += "]";
		return s;
	} // de toString
	
	/*FUNCIONES Y PROCEDIMIENTOS AUXILIARES PARA JuegoApp*/
	public Stack<Carta> mazo() {
		return mazo;
	} // de mazo
	
	public List<Stack<Carta>> bases(){
		return bases;
	} // de bases

} // de clase Juego
  