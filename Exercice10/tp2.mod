/*********************************************
 * OPL 12.6.0.0 Model
 * Author: ahmed
 * Creation Date: 6 avr. 2022 at 16:57:44
 *********************************************/
 int nville=...;
 int nhubs=...;
 
 int p=...;
 range I=1..nville;
range J=1..nville;
 int Q[I][J]=...;
 range K=1..nhubs;
 range M=1..nhubs;
 int D[K][M]=...;
 float C[i in 1..6][j in 1..6][k in 1..6][m in 1..6]=D[i][k]+0.8*D[k][m]+D[m][j];
 dvar boolean hub[K];
dvar boolean flow[I][J][K][M];

dexpr float cbj =sum(i in I)sum(j in J)sum(k in K)sum(m in M)Q[i,j]*C[i,j,k,m]*flow[i,j,k,m];
minimize cbj;
 
  subject to{
//1

	sum(k in K)hub[k]==p;    
//2	
	forall(i in I)
	  forall(j in J)
	    sum(k in K)sum(m in M)flow[i,j,k,m]==1;
//3
	  forall(i in I)
	    forall(j in J)
	      forall(k in K)
	        forall(m in M)
	          flow[i,j,k,m]<=hub[k];
//4	    
	forall(i in I)
	    forall(j in J)
	      forall(k in K)
	        forall(m in M)
	          flow[i,j,k,m]<=hub[m];        
//5
	    forall(k in K)
	      hub[k]<=1;
//6
forall(i in I)
	    forall(j in J)
	      forall(k in K)
	        forall(m in M)
	          flow[i,j,k,m]<=1;
  }

