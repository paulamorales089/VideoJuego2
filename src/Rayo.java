import java.awt.PageAttributes;

import processing.core.PApplet;
import processing.core.PImage;

public class Rayo {
	private	int xR;
	private int yR;
	private int velocidad;
	private boolean visible;
	private PImage rayo;
		
		
	public Rayo (PApplet app, int x, int y) {
		rayo=app.loadImage("bala.png");
		this.xR=450;
		this.yR=510;
		velocidad = 5;
		visible = true;
		}
	public void pintarRayo (PApplet app) {
		rayo.resize(0, 80);
		app.image(rayo,xR,yR);
			
		}
	public void rayoMove (PApplet app) {
		xR= app.mouseX;
		yR-=velocidad;
		if(xR<170)  {
			xR=170;
			
		}
		if(xR>890) {
			xR=890;
		}
	
		
	}
	void generarRayo (int xArma, int yArma) {
			yR=velocidad;
		}
	

}
