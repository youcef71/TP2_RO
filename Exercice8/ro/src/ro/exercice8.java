/*
Exercice 8
Medjahed Youcef
Groupe 05
 */
package ro;

import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class exercice8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		optimizer();
	}
	public static void optimizer() {
		//Le nombre des noeus/pilotes
		int n= 8;
		//Cij
		double [][]c=new double[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++) {
				
				c[i][j]= 0;
				
			}
		}
		//[i,j] doit appartenir à E
		c[0][1]= 30;
	    c[1][2]= 27;
	    c[0][4]= 25;
	    c[0][3]= 24;
	    c[1][3]= 28;
	    c[1][5]= 27;
	    c[2][5]= 26;
	    c[2][6]= 30;
	    c[3][4]= 29;
	    c[3][5]= 21;
	    c[4][5]= 30;
	    c[5][6]= 28;
	    c[4][7]= 30;
	    c[5][7]= 36;
	    c[6][7]= 25;
	/* Puisque, ce problème est modélisé par [i,j] qui appartient à E.
	Alors nous allons prendre tous i et j qui ont une arrête entre eux. Si par exemple :
	i=1 et j=2, et ils ont une arrête entre eux, cela veut dire que [i,j] appartient à E,
	dans ce cas, si nous inversons les valeurs tel que : i=2 et j=1, nous auront aussi
	l'arrête entre ces deux noeuds. Alors, [i,j] appartient à E si nous inversons les valeurs,
	et puisque, la fonction objectif et la contrainte 2 vont prendre i et j tel que :
	[i,j] appartient à E. Alors, nous allons inclure le cas où les valeurs se sont inversés */
	   
	    c[1][0]= 30;
	    c[2][1]= 27;
	    c[4][0]= 25;
	    c[3][0]= 24;
	    c[3][1]= 28;
	    c[5][1]= 27;
	    c[5][2]= 26;
	    c[6][2]= 30;
	    c[4][3]= 29;
	    c[5][3]= 21;
	    c[5][4]= 30;
	    c[6][5]= 28;
	    c[7][4]= 30;
	    c[7][5]= 36;
	    c[7][6]= 25;
	   
	 
		try {
			//Xij en respectant la contrainte 3
        	IloCplex cplex = new IloCplex();
        	IloNumVar[][] x = new IloNumVar[n][n];
        	for(int i=0;i<n;i++) {
        		for(int j =0;j<n;j++) {
        			//[i,j] doit appartenir à E
        			if(c[i][j]== 0) {
        			x[i][j]= cplex.numVar(0,0);}
        			else {
        			x[i][j]= cplex.numVar(0,1);}
        		}
        	}
        	//La fonction objectif
        	IloLinearNumExpr objective = cplex.linearNumExpr();
        	for (int i=0; i<n; i++) {
        		for (int j=0; j<n; j++) {
        			objective.addTerm(c[i][j],x[i][j]);
        		}
        	}
        	cplex.addMaximize(objective);
        	
        	//Les contraintes
        	
        	/* Si nous substituons cette expression avec les valeurs de i et j, nous allons 
        	 obtenir plusieurs inégalités/contraintes */
        	 
        	IloLinearNumExpr contrainte_1 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_2 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_3 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_4 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_5 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_6 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_7 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_8 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_9 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_10 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_11 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_12 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_13 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_14 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_15 = cplex.linearNumExpr();
        	IloLinearNumExpr contrainte_16 = cplex.linearNumExpr();


//
        	//La somme de Xij avec i=k est <= 1
         	int i=0;
     		for (int j=0; j<n; j++) {
     			contrainte_1.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_1, 1);

 //
          	 i=1;
     		for (int j=0; j<n; j++) {
     			contrainte_2.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_2, 1);

 //
          	 i=2;
     		for (int j=0; j<n; j++) {
     			contrainte_3.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_3, 1);

 //
          	 i=3;
     		for (int j=0; j<n; j++) {
     			contrainte_4.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_4, 1);

 //
          	 i=4;
     		for (int j=0; j<n; j++) {
     			contrainte_5.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_5, 1);

 //
          	 i=5;
     		for (int j=0; j<n; j++) {
     			contrainte_6.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_6, 1);

 //
          	 i=6;
     		for (int j=0; j<n; j++) {
     			contrainte_7.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_7, 1);

 //
          	 i=7;
     		for (int j=0; j<n; j++) {
     			contrainte_8.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_8, 1);

 //
         	 
         	//La somme de Xij avec j=k j est <= 1
         	int j=0;
     		for ( i=0; i<n; i++) {
     			contrainte_9.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_9, 1);

 //
          	 j=1;
     		for ( i=0; i<n; i++) {
     			contrainte_10.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_10, 1);

 //
          	 j=2;
     		for ( i=0; i<n; i++) {
     			contrainte_11.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_11, 1);

 //
          	 j=3;
     		for ( i=0; i<n; i++) {
     			contrainte_12.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_12, 1);

 //
          	 j=4;
     		for ( i=0; i<n; i++) {
     			contrainte_13.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_13, 1);

 //
          	 j=5;
     		for ( i=0; i<n; i++) {
     			contrainte_14.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_14, 1);

 //
          	 j=6;
     		for ( i=0; i<n; i++) {
     			contrainte_15.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_15, 1);

 //
          	 j=7;
     		for ( i=0; i<n; i++) {
     			contrainte_16.addTerm(1,x[i][j]);
     		}
         	 cplex.addLe(contrainte_16, 1);

        	//Resolution
        	if (cplex.solve()) {
        		System.out.println("\nLa solution optimale est "+cplex.getObjValue());
        	}
        	else {
        		System.out.println("\nPas de solution optimale");
        	}
        	//Affichage
        	System.out.println("\nPour : \n");
        	for (i=0;i<n;i++) {
        		for ( j=0; j<n; j++) {
        			//Afficher que les poids choisis pour ce problème 
        			if (c[i][j] != 0) {
        		 System.out.println( "X"+(i+1)+ ""+(j+1)+"= "+ cplex.getValue(x[i][j]));}
        	}
        	}
        		
        	cplex.end();
        	

        	
		}
		//Exeption
		catch(IloException exc){
			System.out.print("\nException " + exc);;
		}
	}
}
