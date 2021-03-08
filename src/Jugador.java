import processing.core.PApplet;
import processing.core.PImage;

public class Jugador {
	private int xJ;
	private int yJ;
	private int move;
	private PImage jugador1;
	private PImage jugador2;
	//private int aparecer;
	private boolean aparecer;
	private PApplet app;
	
	public Jugador (PApplet app, int xJ, int yJ) {
		app.imageMode(app.CENTER);
		jugador1 = app.loadImage("jugador1.png");
		jugador2 = app.loadImage("jugador1.1.png");
		
		this.xJ= 420;
		this.yJ= 620;
	//	this.aparecer= 1;
		this.aparecer=true;
	}
	
	public void pintarJugador (PApplet app) {
	/*	if (aparecer == 1) {
		app.image(jugador1, xJ, yJ);
		}*/
		
		/*if (aparecer == false) {*/
			app.image(jugador1, xJ, yJ);
		//}
		
		
	}
	public void pintarJugador2 (PApplet app) {
	/* if(aparecer == 0) {
		app.image(jugador2, xJ, yJ);
		 }*/
		if (aparecer == true) {
			app.image(jugador2, xJ+1, yJ);
		}
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
	
	public void setAparecer(boolean aparecer) {
		this.aparecer = aparecer;
	}
	public boolean Aparecer() {
		return aparecer;
	}
	
	

}
