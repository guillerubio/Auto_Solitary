package game;
import stdlib.*;

/* Carta.java
Nombre y Apellidos: Guillermo Rubio Bolger
Fecha: 04/05/2021 */

public class Carta{
// Relative reference from classpath
	static ClassLoader loader = JuegoApp.class.getClassLoader();
    static String aux = (loader.getResource("game").toString());
	public final static String DIRECTORIO = (aux.substring(5, aux.length()-8) + "src/data/images/");
	private String valor;  //valor de la carta
	private String palo;  //palo de la carta
	public static final int OROS = 0, COPAS = 1, ESPADAS = 2, BASTOS = 3;

	public Carta (String valor, String palo){
		this.valor = valor;
		this.palo = palo; 
	} // de Carta
	
	public String palo (){
		return palo;
	} // de palo
	
	public String valor (){
		return valor; // valor corregido
	} // de valor
	
	public String toString (){
		return valor + "De" + palo; // espacios corregidos
	}  // de toString
	
	/**
    Pinta esta <carta> en las coordenadas (<x>, <y>) de la ventana.
    Hay que llamar previamente a iniciarGraficos().
	 */
	public void pintar (double x, double y) {
		StdDraw.picture(x, y, DIRECTORIO +toString()+".jpg");
	} // de pintar
	
	/**
   POST: resultado es el ordinal del palo de la carta.
	 */
	int ordinalPalo (){
		if (palo.equals("Oros"))
			return OROS;
		else if (palo.equals("Copas"))
			return COPAS;
		else if (palo.equals("Espadas"))
			return ESPADAS;
		else 
			return BASTOS;
	}  // de ordinalPalo
	
	/**
   POST: 
     resultado es el valor numérico de la carta.
	 */
	int ordinalValor (){
		if (valor.equals("As"))
			return 1;
		else if (valor.equals("Dos"))
			return 2;
		else if (valor.equals("Tres"))
			return 3;
		else if (valor.equals("Cuatro"))
			return 4;
		else if (valor.equals("Cinco"))
			return 5;
		else if (valor.equals("Seis"))
			return 6;
		else if (valor.equals("Siete"))
			return 7;
		else if (valor.equals("Sota"))
			return 10;
		else if (valor.equals("Caballo"))
			return 11;
		else 
			return 12;
	}  // de ordinalValor
	
	/*ATRIBUTOS AUXILIARES JuegoApp*/
	public double x;
	public double y;
	
	/*CONSTRUCTOR AUXILIAR JuegoApp*/
	public Carta (String valor, String palo, double x, double y){
		this.valor = valor;
		this.palo = palo; 
		this.x=x;
		this.y=y;
	} // de constructor auxiliar

} // de clase Carta
