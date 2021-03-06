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
		app.imageMode(app.CENTER);
		jugador1 = app.loadImage("jugador1.png");
		jugador2 = app.loadImage("jugador1.1.png");
		
		this.xJ= 420;
		this.yJ= 620;
	}
	
	public void pintarJugador (PApplet app) {
		app.image(jugador1, xJ, yJ);
	}
	
	
	public void jugadorMove (PApplet app) {
		
		xJ= app.mouseX;
		
		if(xJ<170)  {
			xJ=170;
			
		}
		if(xJ>890) {
			xJ=890;
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
