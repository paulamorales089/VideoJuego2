import processing.core.PApplet;
import processing.core.PImage;

public class Enemigo3 {
	private int xE3;
	private int yE3;
	private int aceleracion3;
	private boolean moveE3;
	private PImage enemigo3;
	
	public Enemigo3(PApplet app, int xE1, int yE1) {
		enemigo3= app.loadImage("enemigo3.png");
		
		this.xE3=230;
		this.yE3=150;
		this.aceleracion3=1;
		this.moveE3 = true;
	}
	
	public void pintarEnemigo3 (PApplet app) {
		app.image(enemigo3, xE3, yE3);
		app.image(enemigo3, xE3+150, yE3);
		app.image(enemigo3, xE3+300, yE3);
		app.image(enemigo3, xE3+450, yE3);
		app.image(enemigo3, xE3+600, yE3);
	}
	
	public void moveEnemigo3 (PApplet app) {
		if (moveE3 == true) {
			yE3+= aceleracion3; 
		}
	}
	/*public void arriba()
	{
		yE3 -= 3;
	}*/
	
	public void abajo()
	{
		yE3 += 3;
	}
	
	public void derecha()
	{
		xE3 += 2;
	}
	
	public void izquierda()
	{
		xE3 -= 2;
	}
	
	
	
	public int getxE3() {
		return xE3;
	}
	public int getyE3() {
		return yE3;
	}
}


