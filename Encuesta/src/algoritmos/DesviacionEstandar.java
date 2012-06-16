/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;
public class DesviacionEstandar {
	
        private double [] promedio= new double [19];
	private double [] desviacion= new double[19];    
public double [][] Calcula(int [][]encuestas){									
	int [][] answers;
	answers=encuestas;
	int num_encuestas=answers.length;
	double prom_maxmin=0;
	double [][] resultados= new double[3][1];					//Arreglo donde se almanenan los arreglos con los resultados finales
	double [] sumas= new double [19];
	double [] diferencias_cuad= new double [19];
	double [] promedios= new double[4];
	double [] maximos= new double[4];
	double [] minimos= new double[4];
	double [] general= new double[4];

	for (int h=0;h<19;h++){
		for (int i=0;i<answers.length;i++){
			sumas[h]+=answers[i][h];
		}
		System.out.println("Suma pregunta "+h+":"+sumas[h]);
	}
	for (int j=0;j<19;j++){
		promedio[j]=sumas[j]/num_encuestas;
		System.out.println("Promedio pregunta "+j+":" +promedio[j]);
	}
	for (int h=0;h<19;h++){
		for (int i=0;i<answers.length;i++){
			diferencias_cuad[h]+=Math.pow((answers[i][h]-promedio[h]),2);
		}
	}
	for (int m=0;m<19;m++){
		desviacion[m]=Math.sqrt(diferencias_cuad[m]/(num_encuestas-1));
		System.out.println("Desviación Estandar "+m+":" +desviacion[m]);
	}
	for (int i=0;i<8;i++){														//Estos for's los utilizo para la separacion de los 4 aspectos del cuestionario
		promedios[0]+=promedio[i]/8;											//(Uso del Sistema)
		prom_maxmin+=desviacion[i]/8;
		maximos[0]=promedios[0]+prom_maxmin;
		minimos[0]=promedios[0]-prom_maxmin;
	}
	prom_maxmin=0;
	for (int i=8;i<15;i++){														//(Calidad de la información)
		promedios[1]+=promedio[i]/7;
		prom_maxmin+=desviacion[i]/7;
		maximos[1]=promedios[1]+prom_maxmin;
		minimos[1]=promedios[1]-prom_maxmin;
	}
	prom_maxmin=0;
	for (int i=15;i<18;i++){													//(Calidad de la interfaz)
		promedios[2]+=promedio[i]/3;
		prom_maxmin+=desviacion[i]/3;
		maximos[2]=promedios[2]+prom_maxmin;
		minimos[2]=promedios[2]-prom_maxmin;
	}
	promedios[3]=promedio[18];													//(General)
	maximos[3]=promedios[3]+desviacion[18];
	minimos[3]=promedios[3]-desviacion[18];
	
	for (int i=0;i<4;i++){
		System.out.println("Promedio "+i+": "+promedios[i]);						//Imprimo solo para verificar que los datos son correctos
		System.out.println("Maxi "+i+": "+maximos[i]);
		System.out.println("Mini "+i+": "+minimos[i]);
	}
	resultados[0]=maximos;
	resultados[1]=minimos;
	resultados[2]=promedios;
	
	for (int h=0;h<3;h++){															//Imprimo solo para verificar que los datos son correctos
		for (int i=0;i<4;i++){
		//System.out.println("Resultado ["+h+"]["+i+"]:"+resultados[h][i]);
		}
	}
return resultados;
}
public double[] getPromedios(){
return promedio;
}
public double[] getVars(){
return desviacion;
}

 public static void main (String[] args) {
 	int [] en1={4,5,3,3,4,5,7,4,1,3,2,3,5,3,3,3,4,2,4};			//Cada arreglo es una encuesta con los valores de las 19 preguntas
	int [] en2={7,6,7,6,5,7,7,5,5,4,4,4,5,4,6,6,6,7,7};			//Probe con los datos de ejemplo de Franciso y concuerdan con los resultados obtenidos
	int [] en3={6,7,7,5,6,7,6,4,5,5,3,4,6,4,5,6,5,6,7};
	int [] en4={6,6,7,6,3,7,3,3,5,5,7,5,7,7,6,6,6,5,4};
	int [] en5={3,7,4,3,3,4,7,6,4,5,4,6,7,7,5,6,5,7,3};
	int [] en6={5,6,4,7,5,5,6,5,6,4,7,6,7,6,7,6,4,6,6};
	int [][]ans={en1,en2,en3,en4,en5,en6};						//Es el arreglo de las encuestas (el que recibiria la función)
   new DesviacionEstandar().Calcula(ans);						//Llamamos al metodo Calcula que recibe como parametro el arreglo de entrevistas
}   
}