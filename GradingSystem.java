
//NAME :    patel Dhaval //
//ID :      N03632807//
//SUBJECT : programming with data structure//


import java.util.*;
public class GradingSystem
         {



   
public static void main(String []args) {
    Scanner input = new Scanner(System.in);
    int grades=0;
    int counter=0;
    int counterA=0,counterB=0,counterC=0,counterD=0,counterF=-1;
    
 
     while(grades >= 0){
     if(grades <= 100) {	
       
	               if(grades >= 90 && grades <= 100)
			      {         
					
					counterA++;
					
			      }
			else if(grades >= 80 && grades <= 89)
			      {
					
					counterB++;
			      }
                        else if(grades >= 70 && grades <= 79)
			      {
					
					counterC++;
			      }
                        else if(grades >= 60 && grades <= 69)
			      {
					
					counterD++;
			      }
                        else if(grades >= 0 && grades <= 59)
			      {
					
					counterF++;
			      }
	}
	else{
		System.out.println("invalid input");
	    } 

        
	counter = counterA+counterB+counterC+counterD+counterF;
	grades = input.nextInt();
      }
       
	    System.out.println("Total number of grades = " + counter);          
        System.out.println("Total number of A's = " + counterA);
        System.out.println("Total number of B's = " + counterB);
        System.out.println("Total number of C's = " + counterC);
        System.out.println("Total number of D's = " + counterD);
        System.out.println("Total number of F's = " + counterF);
        
	
}
}