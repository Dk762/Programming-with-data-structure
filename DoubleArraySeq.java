//NAME :    Patel Dhaval //
//ID :      N03632807//
//SUBJECT : programming with data structure//
//ASSIGNMENT 3 : DoubleArraySequence


public class DoubleArraySeq implements Cloneable
{
   private double[] data;
   private int manyItems;
   private int currentElement;
   public DoubleArraySeq()
   {
       data = new double[10];
       manyItems = 0;
       currentElement = 0;	
   }

   public DoubleArraySeq(int initialCapacity)
   {
       data = new double[initialCapacity];
       manyItems = currentElement = 0;
   }

   public void addAfter(double element)
   {
       if(manyItems == data.length)
       	 ensureCapacity(2 * data.length);
       if(currentElement == manyItems)
       	 currentElement = manyItems - 1;
       else 
       	 System.arraycopy(data,currentElement + 1,data,currentElement + 2,manyItems - currentElement - 1);
         data[currentElement + 1] = element;
         currentElement++;
         manyItems++;	
   }
   public void addBefore(double element)
   {
        if(manyItems == data.length)
   	   ensureCapacity(2 * data.length);
   	if(currentElement == manyItems)
   	   currentElement = 0;
   	else 
   	   System.arraycopy(data,currentElement,data,currentElement + 1,manyItems - currentElement);
   	   data[currentElement] = element;
   	   manyItems++;  	
   }
   public void addAll(DoubleArraySeq addend)
   {
       if(addend != null)
       if(data.length < manyItems + addend.manyItems)
         ensureCapacity(manyItems + addend.manyItems);
       System.arraycopy(addend.data,0,data,manyItems,addend.manyItems);
       manyItems += addend.manyItems;   
   }
   public void advance()
   {
       if(currentElement == manyItems - 1)
   	 currentElement = manyItems;
       else
   	 currentElement++;	
   }
   public DoubleArraySeq clone()
   {
       DoubleArraySeq answer;
       try
       {
       	 answer = (DoubleArraySeq)super.clone();
       }
       catch(CloneNotSupportedException e)
       {
       	 throw new RuntimeException("this class is not implement clonable");
       }
       answer.data = data.clone();
       return answer;
   }
   public static DoubleArraySeq concatenation (DoubleArraySeq s1,DoubleArraySeq s2)
   {
       DoubleArraySeq answer = new DoubleArraySeq(s1.manyItems + s2.manyItems);
       answer.addAll(s1);
       answer.addAll(s2);
       answer.currentElement = answer.manyItems;
       return answer;
   }
   public void ensureCapacity(int minimumCapacity)
   {
       if(data.length <= minimumCapacity)
   	 {
   	   double[] answer = new double[minimumCapacity];
   	   System.arraycopy(data,0,answer,0,manyItems);
   	   data = answer;
   	 }  	
   }
   public int getCapacity()
   {
       return data.length;
   }
   public double getCurrent()
   {
       if(isCurrent())
         return data[currentElement];
       else
       	 throw new RuntimeException("illeagel state exception");
   }
   public boolean isCurrent()
   {
       return(currentElement != manyItems);
   }
   public void removeCurrent()
   {
       if(currentElement == manyItems - 1)
       	 currentElement = manyItems;
       else
       System.arraycopy(data,currentElement + 1,data,currentElement,manyItems - currentElement);
       manyItems--;	
   }
   public int size()
   {
       return manyItems;
   }
   public void start()
   {
       currentElement = 0; 
   }
   public void trimToSize()
   {
       double[] trim;
       if(data.length != manyItems){
       trim = new double[manyItems];
       System.arraycopy(data,0,trim,0,manyItems);
       data = trim;
       } 
   }
   public void print()
   {
       System.out.println("    capacity = " + getCapacity());
       System.out.println("    length = " + size());
       if(currentElement == manyItems)
         System.out.println("    there is no currentElement");
       else
       	 System.out.println("    current element = " + getCurrent());
       System.out.print("    elements: ");
       for(int i = 0; i<manyItems; i++)
         System.out.printf("%5.1f", data[i]);

       System.out.println("\n");  	
   }
}