package gui;

import java.awt.EventQueue;

public class NoFuncionLaConsola {

	//Unai: Cuando lo ejecuto desde VentanaJuegoPrueba, da error la ejecucion, corre una version anterior
	// al menos así consigo ver lo que hago en ejecucion
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuegoPrueba window = new VentanaJuegoPrueba();
//					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
