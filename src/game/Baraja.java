package game;
import java.util.ArrayList;
import java.util.List;
import stdlib.*;


/* JuegoApp.java
Nombre y Apellidos: Guillermo Rubio Bolger
Fecha: 02/05/2021 */

public class Baraja{
	
	/*ATRIBUTOS*/
	public final int NUMERO_DE_CARTAS = 40;
	private List<Carta> baraja;
	
	/*CONSTRUCTORES*/
	/**
   POST: Crea una baraja espa�ola. 
	 */
	public Baraja (){
		baraja = new ArrayList<Carta>(NUMERO_DE_CARTAS);
		String[] valores = {"As", "Dos", "Tres", "Cuatro", "Cinco", 
				"Seis", "Siete", "Sota", "Caballo", "Rey"};
		String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
		for (int palo=Carta.OROS; palo<=Carta.BASTOS; palo+=1)
			for (int valor=0; valor<=9; valor+=1)
				baraja.add(palo*10+valor, new Carta(valores[valor], palos[palo]));   
	} // de Baraja (Constructor)

	/*FUNCIONES Y PROCEDIMIENTOS*/
	/**
   POST: Convierte la baraja a String.
	 */
	public String toString (){
		return baraja.toString();
	} // de toString

	/**
   Pinta la baraja.
	 */
	public void pintar (){
		iniciarGraficos();
		for (int i=0; i<NUMERO_DE_CARTAS; i++)
			baraja.get(i).pintar(i*4+20, 100);    
	} // de pintar

	private void permutar (int i, int j) { 
		Carta t = baraja.get(i);
		baraja.set(i, baraja.get(j));
		baraja.set(j, t);
	} // de permutar

	/*
	 * POST: Genera un n�mero aleatorio en el rango [0, |n-1|] 
	 */       
	public int aleatorio (int n)  { 
		return (int)(Math.random() * Math.abs(n));
	} // de aleatorio

	/**
   Baraja las cartas de la <baraja>. 
	 */
	public void barajar (){
		for(int i=0; i<=10; i++) {
			for(int b=0; b<baraja.size();b++)
				permutar (aleatorio(40),aleatorio(40));
		} // de for
	} // de barajar

	/**
   Devuelve la carta que est� en la posici�n i en la baraja. 
	 */
	Carta get (int i){
		return baraja.get(i);
	} // de get

	/*
   Establece el contexto gr�fico.
	 */
	public static void iniciarGraficos () {  
		final int XMAX = 200;
		final int YMAX = 200;
		StdDraw.setCanvasSize(6*XMAX+50, 2*YMAX);
		StdDraw.setScale(0, XMAX);
		StdDraw.setPenRadius(5);
		StdDraw.setPenColor(StdDraw.BLACK);
	} // de iniciar graficos 

} // de clase Baraja
