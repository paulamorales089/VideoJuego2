import processing.core.PApplet;
import processing.core.PImage;

public class Enemigo1 {
	private int xE1;
	private int yE1;
	private int aceleracion;
	private boolean moveE1;
	private PImage enemigo1;
	
	public Enemigo1(PApplet app, int xE1, int yE1) {
		enemigo1= app.loadImage("enemigo1.png");
		
		this.xE1=200;
		this.yE1=110;
		this.aceleracion=2;
		this.moveE1 = true;
			
	}
	
	public void pintarEnemigo1 (PApplet app) {
		app.image(enemigo1, xE1, yE1);
	}
	
	public void moveEnemigo1 (PApplet app) {
		if (moveE1 == true) {
			yE1+= aceleracion; 
		}
	
	}
	
	public int getxE1() {
		return xE1;
	}
	public int getyE1() {
		return yE1;
	}
}
