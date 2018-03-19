//NAME :    Patel Dhaval //
//ID :      N03632807//
//SUBJECT : programming with data structure//
//ASSIGNMENT 5 : PostfixEvaluation

import java.util.*;
public class PostfixEvaluation
{
    public static void main(String[] args)
    {
       evaluate();
    }

public static void evaluate()
{
    System.out.println("Hello! This is a postfix expression calculator");
    Scanner input = new Scanner(System.in);
    Stack <Double> numbers = new Stack<Double>();
    String next;
    char first;
    while(input.hasNext())
    {	
       String expression = input.nextLine();
       Scanner findinLine = new Scanner(expression);	

     while(findinLine.hasNext())
     {
   	   if(findinLine.hasNextDouble())
   	   {
   	   	 numbers.push(findinLine.nextDouble());
   	   }
   	   else
   	   {
   	   	 next = findinLine.next();
   	   	 first = next.charAt(0);
   	   	 evaluateStackTop(numbers,first);
   	   }	
     }
     System.out.println("\nThe value of \"" + expression + "\" is " + numbers.pop());
     
   }
   System.out.println("\nBye-bye!");
   	
}
public static void evaluateStackTop(Stack<Double>numbers,char first)
{
    double operand1 = 0,operand2; 
    operand2 = numbers.pop();
    if(first != '_' && first != '#')
       operand1 = numbers.pop();
    switch(first)
    {
       case '+' :
         numbers.push(operand1 + operand2);
         break;
       case '-' :
         numbers.push(operand1 - operand2);
         break;
       case '*' :
         numbers.push(operand1 * operand2);
         break;
       case '/' :
         numbers.push(operand1 / operand2);
         break;
       case '#' :
         numbers.push(Math.sqrt(operand2));
         break;
       case '_' :
         numbers.push(-operand2);
         break;
       case '^' :
         numbers.push(Math.pow(operand1,operand2));
         break;          
    } 
}
}