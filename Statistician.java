
//NAME :    patel Dhaval //
//ID :      N03632807//
//SUBJECT : programming with data structure//
//ASSIGNMENT 2 : Statistician


public class Statistician
{    
   private double sum;
   private double minimum;
   private double maximum;
   private int length;
   private double mean;

   public Statistician()
   {
      sum = 0.0;
      mean = 0.0;
      length = 0;
   }

   public void addAll(Statistician addend)
   {
      length = length + addend.length;
      sum = sum + addend.sum;
      mean = sum/length;
      if(addend.minimum < minimum)
       	minimum = addend.minimum;
      if(addend.maximum > maximum)
        maximum = addend.maximum;
   }

   public void next(double number)
   {
      if(length == 0)
        minimum = maximum = number;
      length ++;
      sum = sum + number;
      mean = sum/length;
      if(number > maximum)
      	maximum = number;
      if(number < minimum)
      	minimum = number;
   }

   public int length()
   {
      return length;     
   }

   public double sum()
   {
      return sum;
   }

   public double mean()
   {
      if(length == 0)
        mean = Double.NaN;
     
      return mean;
   }
   public double maximum()
   {   	    
      if(length == 0)
        maximum = Double.NaN;
       
      return maximum; 
   }
   public double minimum()
   {
      if(length == 0)
        minimum = Double.NaN;
             
      return minimum;	
   }
   public void clear()
   {
      length = 0;
      sum = 0; 
   }
   public static Statistician union(Statistician s1,Statistician s2)
   {        
   	  Statistician s3 = new Statistician();
   	  s3.addAll(s1);
   	  s3.addAll(s2);
   	  return s3;
   }
   public boolean equals(Statistician stat) 
   {
      return(stat.length == length && stat.sum == sum && stat.mean == mean && stat.minimum == minimum && stat.maximum == maximum);	
   }
                                 
}