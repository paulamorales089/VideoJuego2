import java.util.ArrayList;

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
	
	private int coolDown;
	
	
// ARRAY LIST DE LOS RAYOS
	private ArrayList<Rayo> rayos;
	
	public Jugador (PApplet app, int xJ, int yJ) {
		
		jugador1 = app.loadImage("jugador1.png");
		jugador2 = app.loadImage("jugador1.1.png");
		
		this.xJ= 420;
		this.yJ= 620;
	//	this.aparecer= 1;
		this.aparecer=true;
		this.app=app;
		
		rayos = new ArrayList<>();
		coolDown = 0;
	}
	
	public void pintarJugador (PApplet app) {
	/*	if (aparecer == 1) {
		app.image(jugador1, xJ, yJ);
		}*/
		
		/*if (aparecer == false) {*/
		app.imageMode(app.CENTER);
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
// METODOS PARA HACER QUE LOS RAYOS APAREZCAN
	public void generarRayo () {
		if (coolDown == 0) {
	Rayo rayo= new Rayo(app,xJ,yJ);
	rayos.add(rayo);
	
		}
	}
	public void disparar() {
		
		for (int i = 0; i < rayos.size(); i++) {
			rayos.get(i).pintarRayo();
			rayos.get(i).rayoMove();
		}
	}
	public void eliminarRayos () {
		for (int i = 0; i < rayos.size(); i++) {
			if(rayos.get(i).getyR()<0) {
				rayos.remove(i);
			}
		}
	}
	
// GETS Y SETS 
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
	
// GET PARA GENERAR LOS RAYOS
	public ArrayList<Rayo> getRayos() {
		return rayos;
	}
	

}
