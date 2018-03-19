//NAME :    Patel Dhaval //
//ID :      N03632807//
//SUBJECT : programming with data structure//
//ASSIGNMENT 4 : DoubleLinkedSequence


public class DoubleLinkedSeq implements Cloneable
{
	private DoubleNode head,tail;
	private DoubleNode CurrentNode;
	private int manyNodes;
	public DoubleLinkedSeq()
	{
	     head = tail =  null;
	     CurrentNode = null;
	     manyNodes = 0;	
	}
	public void addAfter(double element)
	{
       if(manyNodes == 0)
       {
       	 head = new DoubleNode(element,null);
       	 CurrentNode = tail = head;
       }
       else if(CurrentNode == null)
       {
       	 tail.addNodeAfter(element);
       	 tail = tail.getLink();
       	 CurrentNode = tail;
       }
       else
       {
       	 CurrentNode.addNodeAfter(element);
       	 CurrentNode = CurrentNode.getLink();
       }
       manyNodes++;
	}
	public void addBefore(double element)
	{
       if(manyNodes == 0)
       {
       	 head = new DoubleNode(element, null);
       	 CurrentNode = tail = head;
       }
       else if(CurrentNode == null || CurrentNode == head)
       {
       	 head = new DoubleNode(element,head);
       	 CurrentNode = head;
       }
       else
       {
         DoubleNode cursor;
         for(cursor = head;cursor.getLink() != CurrentNode;cursor = cursor.getLink()){
         }
           cursor.addNodeAfter(element);
           CurrentNode = cursor.getLink();		
       }
       manyNodes++;	
	}
	public void addAll(DoubleLinkedSeq addend)
	{
       DoubleNode[] addendcopy = DoubleNode.listCopyWithTail(addend.head);
       tail.setLink(addendcopy[0]);
       tail = addendcopy[1];
       manyNodes += addend.manyNodes; 
	}
	public void advance()
	{
       if(isCurrent()){
       if(CurrentNode == null)
       	 throw new IllegalStateException("there is no current element");
       else
       	 CurrentNode = CurrentNode.getLink();
       }
	}
	public DoubleLinkedSeq clone()
	{
	     DoubleLinkedSeq answer = new DoubleLinkedSeq();
       DoubleNode[] copy = DoubleNode.listCopyWithTail(head);
       answer.head = copy[0];
       answer.tail = copy[1];
       answer.manyNodes = manyNodes;
       if(!isCurrent())
         answer.CurrentNode = null;
       else
       {
         int i = 1;
         for(DoubleNode cursor = head; cursor != CurrentNode; cursor = cursor.getLink())
         {
          i++;
         }
       answer.CurrentNode = CurrentNode.listPosition(answer.head, i);     
       }
       return answer;
	}
	public static DoubleLinkedSeq catenation(DoubleLinkedSeq s1 , DoubleLinkedSeq s2)
	{
       DoubleLinkedSeq answer = s1.clone();
       answer.addAll(s2);
       answer.CurrentNode = null;
       return answer; 
	}
	public double getCurrent()
	{
       if(isCurrent())
         return CurrentNode.getData();
       else
         throw new IllegalStateException("there is no current element");      
	}
	public boolean isCurrent()
	{
       return(CurrentNode != null);   
	}
	public void removeCurrent()
	{
       if(CurrentNode == head)
       {
         head = tail = CurrentNode = null;
       }
       else
       { 
         DoubleNode cursor;
         for(cursor = head;cursor.getLink() != CurrentNode;cursor = cursor.getLink()){
         }
     	   cursor.removeNodeAfter();
         CurrentNode = CurrentNode.getLink();
       }  
         manyNodes--;
	}
	public int size()
	{
       return manyNodes;
	}
	public void start()
	{
       CurrentNode = head;
	}
	public void print()
	{
	     System.out.println("    Length = " + size());
       if(CurrentNode == null)
       	 System.out.println("    there is no current element");
       else
         System.out.println("    Current element = " + getCurrent());
       System.out.print("    Elements: ");
       for(DoubleNode cursor = head;cursor != null;cursor = cursor.getLink())
         System.out.printf("%5.1f" ,cursor.getData());
       System.out.println("\n");    	
	}
}