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
	PImage instrucciones;
	PImage juego;
	PImage resumen;

//CAMBIO DE PANTALLAS
	int estado;
//VARIABLES DEL TIMER
	int s;
	int m;
	int h;
//SCORE PUNTAJE JAJAJA
	int score;

//PINTAR JUGADOR 
	Jugador jugador1, jugador2;

// PINTAR RAYO ASESINAO
	Rayo rayo;

//PINTAR ENEMIGO 1
	private ArrayList<Enemigo1> listaEnemigos1;
	private ArrayList<Enemigo2> listaEnemigos2;

	// Enemigo1 enemigo1;
	// Enemigo2 enemigo2;
//CAMBIO DIRECCION ENEMIGO 3
	float cambioDireccion;

	@Override

	public void setup() {
//PANTALLAS	
		inicio = loadImage("pInicio.png");
		instrucciones = loadImage("pInstrucciones.png");
		juego = loadImage("pJuego.png");
		resumen = loadImage("pResumen.png");

//PINTAR JUGADOR 
		jugador1 = new Jugador(this, 420, 500);
		// jugador2 = new Jugador(this, 420,500);

//PINTAR RAYO
		// rayo = new Rayo(this, 420, 400);

//LISTA ENEMIGO 1 - MURCIELAGO
		listaEnemigos1 = new ArrayList<Enemigo1>();
		// enemigo1 = new Enemigo1(this, 255, 150);
//LISTA ENEMIGO 2 - SEÑOR OJOTES
		listaEnemigos2 = new ArrayList<Enemigo2>();

//SCORE PUNTAJE JAJA
		score = 0;
//VARIABLES TIMER		
		s = 0;
		m = 0;
		h = 0;
//ESTADO PANTALLAS
		estado = 0;
	}

	@Override
	public void draw() {

		System.out.println(mouseX + "," + mouseY);
		background(255);

//PANTALLA 1 INICIO
		if (estado == 0) {
			image(inicio, 0, 0);
		} else

//PANTALLA 2 INSTRUCCIONES
		if (estado == 1) {
			image(instrucciones, 0, 0);
		} else
//PANTALLA 3 JUEGO
		if (estado == 2) {

			image(juego, 550, 350);
			jugador1.pintarJugador(this);
			jugador1.jugadorMove(this);
			jugador1.disparar();
			// ENEMIGO 1
			iniciarEnemigo1();
			pintarListaEnemeigo1();

			// ENEMIGO 2
			//iniciarEnemigo2();
			pintarListaEnemeigo2();

			// PERDER SI TOCA EN BORDE ABAJO
			limiteBordeInferior();
			//limiteBordeInferior2(); 

//SCORE PINTAR	
			fill(255, 255, 255);
			textSize(35);
			text(score, 1020, 615);
//TIMER DISPAROS BALAS YEI
			textSize(25);
			if (s <= 59) {
				s = s + 1;
				text(h + " : " + m, 140, 88);
			} else {
				m = m + 1;
				s = 0;
			}
			if (m <= 59) {

			} else {
				h = h + 1;
				m = 0;
			}

		} else

//PANTALLA RESUMEN		
		if (estado == 3) {
			image(resumen, 550, 350);
			textSize(35);
			text(score, 435, 392);
			text(h + " : " + m, 620, 392);
		}
	}

	@Override
	public void mousePressed() {

// CAMBIO A PANTALLA 2 - INSTRUCCIONES
		if (mouseX > 452 && mouseX < 647 && mouseY > 483 && mouseY < 540 && estado == 0) {
			estado = 1;
		} else

// CAMBIO A PANTALLA 3 - JUEGO
		if (mouseX > 935 && mouseX < 1025 && mouseY > 605 && mouseY < 665) {
			estado = 2;
		}

		if (estado == 2) {
			// alDispararJugador();
			jugador1.generarRayo();
			jugador1.disparar();
			desaparecerEnemigos1();
			desaparecerEnemigos2();
		}
	}

// METODO PARA HACER APARECER LA SEGUNDA IMAGEN DEL JUGADOR
	public void alDispararJugador() {
		/*
		 * if (jugador1.getAparecer()==1) { jugador1.setAparecer(0); }
		 */

		if (jugador1.Aparecer() == true) {
			jugador1.pintarJugador2(this);
		}
	}

// PINTA LISTA MURCIELAGOS - ENEMIGO 1
	public void pintarListaEnemeigo1() {

		for (int i = 0; i < listaEnemigos1.size(); i++) {
			listaEnemigos1.get(i).pintarEnemigo1(this);
			// listaEnemigos1.get(i).moveEnemigo1(this);

		}
	}

// MURCIELAGO ENEMIGO 1
	public void iniciarEnemigo1() {
		if (estado == 2) {
			frameRate = (100);
			if (frameCount == 100 && m <= 20) {

				int posX = (int) random(200, 900);
				listaEnemigos1.add(new Enemigo1(this, posX, 150));
				frameCount = 0;
			}
			if (m >= 20 && frameCount==100) {
				//int posX = (int) random(100, 100);
				listaEnemigos2.add(new Enemigo2(this, 230, 100));
				listaEnemigos2.add(new Enemigo2(this, 380, 100));
				listaEnemigos2.add(new Enemigo2(this, 530, 100));
				listaEnemigos2.add(new Enemigo2(this, 680, 100));
				listaEnemigos2.add(new Enemigo2(this, 830, 100));
				frameCount = 0;
			}
		}
		
	}

// PINTA LISTA SEÑOR OJOTES - ENEMIGO 2
	public void pintarListaEnemeigo2() {
		for (int i = 0; i < listaEnemigos2.size(); i++) {
			listaEnemigos2.get(i).pintarEnemigo2(this);
			listaEnemigos2.get(i).moveEnemigo2(this);
		}
	}

//SEÑOR OJOS RAROS ENEMIGO 2
	/*public void iniciarEnemigo2() {
		//frameRate = (110);
		if (frameCount == 110) {
			if (m >= 20) {
				int posX = (int) random(100, 100);
				listaEnemigos2.add(new Enemigo2(this, 230, 100));
				listaEnemigos2.add(new Enemigo2(this, 380, 100));
				listaEnemigos2.add(new Enemigo2(this, 530, 100));
				listaEnemigos2.add(new Enemigo2(this, 680, 100));
				listaEnemigos2.add(new Enemigo2(this, 830, 100));
				frameCount = 0;
			}
		}
	}*/

// QUITAR ENEMIGO 1 MURCIELAGO	
	public void desaparecerEnemigos1() {

		for (int i = 0; i < listaEnemigos1.size(); i++) {
			if (dist(mouseX, mouseY, listaEnemigos1.get(i).getxE1() + 10, listaEnemigos1.get(i).getyE1() + 40) < 60) {
				System.out.println("yas this time :D");
				listaEnemigos1.remove(i);
				score += 5;
			}
		}
	}

// QUITAR ENEMIGO 2 SEÑOR OJOS RAROS
	public void desaparecerEnemigos2() {

		for (int i = 0; i < listaEnemigos2.size(); i++) {
			if (dist(mouseX, mouseY, listaEnemigos2.get(i).getxE2() + 20, listaEnemigos2.get(i).getyE2() + 40) < 60) {
				System.out.println("yas this time :D");
				listaEnemigos2.remove(i);
				score += 15;
			}
		}
	}

//PERDER CUANDO LLEGUE AL BORDE INFERIOR 
	public void limiteBordeInferior() {
		for (int i = 0; i < listaEnemigos1.size(); i++)	{
			if (listaEnemigos1.get(i).getyE1() > 600)	{
				estado = 3;
			}
			
		}
		for (int i = 0; i <listaEnemigos2.size(); i++) {
			if(listaEnemigos2.get(i).getyE2()>600) {
				estado = 3; 
			}
			
		}
	}

	
}


