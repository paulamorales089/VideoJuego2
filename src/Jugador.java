import processing.core.PApplet;
import processing.core.PImage;

public class Jugador {
	private int xJ;
	private int yJ;
	private int move;
	private PImage jugador1;
	private PImage jugador2;
	private PApplet app;
	
	public Jugador (PApplet app, int xJ, int yJ) {
		jugador1 = app.loadImage("jugador1.png");
		jugador2 = app.loadImage("jugador1.1.png");
		
		this.xJ= 420;
		this.yJ= 500;
	}
	
	public void pintarJugador (PApplet app) {
		app.image(jugador1, xJ, yJ);
	}
	
	
	public void jugadorMove (PApplet app) {
		
		xJ= app.mouseX;
		
		if(xJ<100)  {
			xJ=100;
			
		}
		if(xJ>780) {
			xJ=780;
		}
		
		
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
