
package interfaz;

import java.awt.*;
import javax.swing.*;


public class MainRespuestas extends JFrame{
	
	public MainRespuestas(){
		super("Estadisticas por Pregunta");
		setSize(1010,650);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		InterImagenes prueba= new InterImagenes();
		//InterComentario prueba= new InterComentario();
	//	InterLikeIt prueba= new InterLikeIt();
	//	InterGrid prueba= new InterGrid();
		new MainRespuestas().add(prueba);
	}

}
