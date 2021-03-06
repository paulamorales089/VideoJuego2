import java.util.ArrayList;

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
	
//PINTAR ENEMIGO 1
	private ArrayList<Enemigo1> listaEnemigos1;
	Enemigo1 enemigo1;

	@Override

	public void setup() {
//PANTALLAS	
		inicio = loadImage("pInicio.png");
		juego = loadImage("pJuego.png");
		
//PINTAR JUGADOR 
		jugador1 = new Jugador(this, 420,500);
		jugador2 = new Jugador(this, 420,500);

		estado = 2;

//LISTA ENEMIGO 1 - MURCIELAGO
		listaEnemigos1 = new ArrayList<Enemigo1>();
		enemigo1 = new Enemigo1(this, 255, 150);
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
		if (estado == 2) {
			image(juego,0,0);
			jugador1.pintarJugador(this);
			jugador1.jugadorMove(this);
			enemigo1.pintarEnemigo1(this);
			//iniciarEnemigo1();
			}
		

		}


	@Override
	public void mousePressed() {
//CAMBIO A PANTALLA 2
		if (mouseX > 452 && mouseX < 647 && mouseY > 483 && mouseY < 540) {
			estado = 2;
		}
	
	}
	
	/*private void iniciarEnemigo1 () {
		if (frameCount == 15) {
			frameCount = 50;
			int posX=150;
			listaEnemigos1.add(new Enemigo1(this, posX+10, ));
			
		}*/
	//}
}
