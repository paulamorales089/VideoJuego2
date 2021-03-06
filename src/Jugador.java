import processing.core.PApplet;
import processing.core.PImage;

public class Jugador {
	private int xJ;
	private int yJ;
	private int move;
	private PImage jugador1;
	private PImage jugador2;
	private PApplet app;
	
	public Jugador (PApplet app) {
		jugador1 = app.loadImage("jugador1.png");
		jugador2 = app.loadImage("jugador1.1.png");
		
		this.xJ= xJ;
		this.yJ= yJ;
	}
	
	public void pintarJugador (PApplet app) {
		app.image(jugador1, 450, 500);
	
}
	
	public void pintarJugador2 (PApplet app) {
		app.image(jugador2, xJ, yJ);
	}
	
	public void movimiento (int x, int y) {
		
	}
	
	public PImage getJugador1() {
		return jugador1;
	}
	public int getxJ() {
		return xJ;
	}
	public int getyJ() {
		return yJ;
	}

}
