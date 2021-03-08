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

//CAMBIO DE PANTALLAS
	int estado;
	
//PINTAR JUGADOR 
	Jugador jugador1, jugador2;
	
// PINTAR RAYO ASESINAO
	Rayo rayo;
	
//PINTAR ENEMIGO 1
	private ArrayList<Enemigo1> listaEnemigos1;
	private ArrayList<Enemigo2> listaEnemigos2;
	//Enemigo1 enemigo1;
	//Enemigo2 enemigo2;

	@Override

	public void setup() {
//PANTALLAS	
		inicio = loadImage("pInicio.png");
		instrucciones = loadImage("pInstrucciones.png");
		juego = loadImage("pJuego.png");
		
//PINTAR JUGADOR 
		jugador1 = new Jugador(this, 420,500);
		//jugador2 = new Jugador(this, 420,500);

// PINTAR RAYO
		//rayo = new Rayo(this, 420, 400);

//LISTA ENEMIGO 1 - MURCIELAGO
		listaEnemigos1 = new ArrayList<Enemigo1>();
		//enemigo1 = new Enemigo1(this, 255, 150);
		
//LISTA ENEMIGO 2 - SE�OR OJOTES
		listaEnemigos2 = new ArrayList<Enemigo2>();
		
		

		estado = 2;
	}

	@Override
	public void draw() {

		System.out.println(mouseX + "," + mouseY);
		background(255);
		
		
//PANTALLA 1
		if (estado == 0) {
			image(inicio, 0, 0);
		}
		
//PANTALLA 2 INSTRUCCIONES
		if(estado == 1) {
			image(instrucciones, 0, 0);
		}
//PANTALLA 3
		if (estado == 2) {
			image(juego,550, 350);
		//	rayo.pintarRayo(this);
			//rayo.rayoMove(this);
			jugador1.pintarJugador(this);
			jugador1.jugadorMove(this);
			jugador1.disparar();
			
			
			//enemigo1.pintarEnemigo1(this);
			iniciarEnemigo1();
			pintarListaEnemeigo1 ();
		//	desaparecerEnemigos();
			
			
			
			
			//TIMER DISPAROS BALAS YEI
			int s=second();
			fill(255,255,255);
			textSize(34);
			text(s,140,92);
			}
		
		if (estado == 3) {
			image(juego,550, 350);
			jugador1.pintarJugador(this);
			jugador1.jugadorMove(this);
			//enemigo2.pintarEnemigo2(this);
			iniciarEnemigo2();
			pintarListaEnemeigo2();
			}
		
		
		}

	@Override
	public void mousePressed() {
		if (estado == 2||estado == 3) {
			//alDispararJugador();
			jugador1.generarRayo();
			jugador1.disparar();
			desaparecerEnemigos();
		}
// CAMBIO A PANTALLA 2 - INSTRUCCIONES
		if (mouseX > 452 && mouseX < 647 && mouseY > 483 && mouseY < 540) {
			estado = 1;
			
		}
		
// CAMBIO A PANTALLA 3 - JUEGO
		if (mouseX > 935 && mouseX < 1025 && mouseY > 605 && mouseY < 665) {
					estado = 2;
					
				}
	}
	
// METODO PARA HACER APARECER LA SEGUNDA IMAGEN DEL JUGADOR
	public void alDispararJugador() {
		/*if (jugador1.getAparecer()==1) {
			jugador1.setAparecer(0);
		}*/
		
		if(jugador1.Aparecer()==true) {
			jugador1.pintarJugador2(this);
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
	
// PINTA LISTA SE�OR OJOTES - ENEMIGO 2
	public void pintarListaEnemeigo2 () {
		for (int i = 0; i < listaEnemigos2.size(); i++) {
			listaEnemigos2.get(i).pintarEnemigo2(this);
			listaEnemigos2.get(i).moveEnemigo2(this);
		}
	}
	public void iniciarEnemigo2 () {
		frameRate = (110);
		if (frameCount == 110) {
			 
			int posX=150;
			listaEnemigos2.add(new Enemigo2(this, posX,430));
			frameCount = 0;
		}
	}
	
	public void desaparecerEnemigos() {
				
		for (int i = 0; i < listaEnemigos1.size(); i++) { 	
			if (dist(mouseX, mouseY, listaEnemigos1.get(i).getxE1() + 70,
				listaEnemigos1.get(i).getyE1() + 40) < 40) { 		
				System.out.println("yas this time :D"); 			
				listaEnemigos1.remove(i);  		
				}  		
			} 
		}
		
	}
	/*@Override
	public void keyPressed() {
	switch (key) {
	case ' ':
	//	jugador1.generarRayo();
		jugador1.disparar();
		
		break;

	
	}
	
}*/
