import processing.core.PApplet;
import processing.core.PImage;

public class Enemigo2 {
	private int xE2;
	private int yE2;
	private int aceleracionE2;
	private boolean moveE2;
	private boolean mostrarE2;
	private PImage enemigo2 ,enemigo21;

	public Enemigo2 (PApplet app, int xE2, int yE2) {
		enemigo2= app.loadImage("enemigo2.png");
		enemigo21= app.loadImage("enemigo2.1.png");
		
		this.xE2=xE2;/*230*/
		this.yE2=yE2;/*150*/
		this.aceleracionE2=1;
		this.moveE2 = true;
		this.mostrarE2= true;
	}
	
	public void pintarEnemigo2 (PApplet app) {
		app.image(enemigo2, xE2, yE2);
	}
	public void moveEnemigo2 (PApplet app) {
		if (moveE2 == true) {
			yE2+= aceleracionE2; 
	}
	}
	public void mostrarEnemigo2 () { 
	}
	
	public int getxE2() {
		return xE2;
	}
	
	public int getyE2() {
		return yE2;
 }
}