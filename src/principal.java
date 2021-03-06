import processing.core.PApplet;
import processing.core.PImage;

public class principal extends PApplet {

	public static void main(String[] args) {

		PApplet.main("principal");
	}

	@Override
	public void settings() {

		size(1100, 700);
	}

//PANTALLAS
	PImage inicio;
	PImage juego;

//CAMBIO DE PANTALLAS
	int estado;
	
//PINTAR JUGADOR 
	Jugador jugador1, jugador2;

	@Override

	public void setup() {
		
		inicio = loadImage("pInicio.png");
		juego = loadImage("pJuego.png");
		
//PINTAR JUGADOR 
		jugador1 = new Jugador(this);
		jugador2 = new Jugador(this);

		estado = 0;

	}

	@Override
	public void draw() {

		System.out.println(mouseX + "," + mouseY);
		background(255);
		
//PANTALLA 1
		if (estado == 0) {
			image(inicio, 0, 0);
			
		}
//PANTALLA 2
		if (estado == 1) {
			image(juego,0,0);
			jugador1.pintarJugador(this);
			}
	
		
		}

	@Override
	public void mousePressed() {
//CAMBIO A PANTALLA 2
		if (mouseX > 452 && mouseX < 647 && mouseY > 483 && mouseY < 540) {
			estado = 1;
		}
	
	}
}
