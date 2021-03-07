import processing.core.PApplet;

public class Rayo {
		int xR;
		int yR;
		
		
	public Rayo (PApplet app, int x, int y) {
		app.loadImage("rayo.png");
			this.xR=x;
			this.yR=y;
		}
	/*public void pintarBala (PApplet app) {
			app.noStroke();
			app.fill(38,11,18);
			app.ellipse(x, y, 25, 6);
			
		}
	void moverBala (int xArma, int yArma) {
			x-=5;
		}*/
	

}
