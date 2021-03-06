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
	private ArrayList<Enemigo2> listaEnemigos2;
	//Enemigo1 enemigo1;
	//Enemigo2 enemigo2;

	@Override

	public void setup() {
//PANTALLAS	
		inicio = loadImage("pInicio.png");
		juego = loadImage("pJuego.png");
		
//PINTAR JUGADOR 
		jugador1 = new Jugador(this, 420,500);
		jugador2 = new Jugador(this, 420,500);

		estado = 3;

//LISTA ENEMIGO 1 - MURCIELAGO
		listaEnemigos1 = new ArrayList<Enemigo1>();
		//enemigo1 = new Enemigo1(this, 255, 150);
		
//LISTA ENEMIGO 2 - SEÑOR OJOTES
		listaEnemigos2 = new ArrayList<Enemigo2>();
		
	}

	@Override
	public void draw() {

		System.out.println(mouseX + "," + mouseY);
		background(255);
		
//PANTALLA 1
		if (estado == 0) {
			image(inicio, 550, 350);
		}
		
//PANTALLA 2 INSTRUCCIONES
		if(estado == 1) {
			
		}
//PANTALLA 3
		if (estado == 2) {
			image(juego,550, 350);
			jugador1.pintarJugador(this);
			jugador1.jugadorMove(this);
			//enemigo1.pintarEnemigo1(this);
			iniciarEnemigo1();
			pintarListaEnemeigo1 ();
			}
		
		if (estado == 3) {
			image(juego,550, 350);
			jugador2.pintarJugador(this);
			jugador2.jugadorMove(this);
			//enemigo2.pintarEnemigo2(this);
			iniciarEnemigo2();
			pintarListaEnemeigo2();
			}
		}


	@Override
	public void mousePressed() {
//CAMBIO A PANTALLA 3
		if (mouseX > 452 && mouseX < 647 && mouseY > 483 && mouseY < 540) {
			estado = 2;
		}
	}
// PINTA LISTA MURCIELAGOS - ENEMIGO 1
	public void pintarListaEnemeigo1 () {
		for (int i = 0; i < listaEnemigos1.size(); i++) {
			listaEnemigos1.get(i).pintarEnemigo1(this);
			listaEnemigos1.get(i).moveEnemigo1(this);
		}
	}
// MURCIELAGO
	public void iniciarEnemigo1 () {
		frameRate = (100);
		if (frameCount == 100) {
			
			int posX=150;
			listaEnemigos1.add(new Enemigo1(this, posX,180));
			frameCount = 0;
		}
	}
	
// PINTA LISTA SEÑOR OJOTES - ENEMIGO 2
	public void pintarListaEnemeigo2 () {
		for (int i = 0; i < listaEnemigos2.size(); i++) {
			listaEnemigos2.get(i).pintarEnemigo2(this);
			listaEnemigos2.get(i).moveEnemigo2(this);
		}
	}
	public void iniciarEnemigo2 () {
		frameRate = (100);
		if (frameCount == 100) {
			
			int posX=150;
			listaEnemigos2.add(new Enemigo2(this, posX,430));
			frameCount = 0;
		}
	}
	
}
