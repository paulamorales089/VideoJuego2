import java.awt.PageAttributes;

import processing.core.PApplet;
import processing.core.PImage;

public class Rayo {
	private	int xR;
	private int yR;
	private int velocidad;
	private boolean visible;
	private boolean mover;
	private PImage rayo;
	private PApplet app;
	
	public Rayo (PApplet app, int xR, int yR) {
		rayo=app.loadImage("./data/bala.png");
		this.xR=xR;
		this.yR=yR;
		velocidad = 25;
		visible = true;
		this.app=app;
		this.mover=true;
		}
	public void pintarRayo () {
		if ( visible == true) {
		rayo.resize(0, 80);
		app.image(rayo,xR,yR);
		}
	}
	public void rayoMove () {
		xR= app.mouseX;
		if(mover==true) {
		yR-=velocidad;
		}
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
	
// GETS Y SETS 
	public int getxR() {
		return xR;
	}
	
	public int getyR() {
		return yR;
	}
	
	

}
