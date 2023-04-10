
package com.mycompany.dllists_stacks_queues;

/**
 *
 * @author MoaathAlrajab
 */
class Node {
    public int data;
    public Node next;
    public Node previous;

    public Node(int initialData) {
      data = initialData;
      next = null;
      previous = null;
   }
}

public class DoublyLinkedList {
   private Node head;
   private Node tail;
   private int listSize = 0;
    
   public DoublyLinkedList() {
      head = null;
      tail = null;
   }
    
   public void append(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         tail.next = newNode;
         newNode.previous = tail;
         tail = newNode;
      }
      
      listSize++;
   }
   
   public void prepend(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         newNode.next = head;
         head.previous = newNode;
         head = newNode;
      }
      
      listSize++;
   }
   
   public void printList() {
      Node node = head;
      while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
      }
      System.out.println();
   }
   
   public void printReverseList(){
       Node node = tail;
       while(node != null){
           System.out.print(node.data + " ");
           node = node.previous;
       }
       System.out.println();
   }
   
   public int findmax(){
       
           
       Node node = head;
       int max = node.data;
       while(node != null){
           if(node.data > max){
               max = node.data;
               
           }
           
           node = node.next;
       }
       return max;
   }
   
   public int findmin(){
       Node node = head;
       int min = node.data;
       while(node != null){
           if(node.data < min){
               min = node.data;
               
           }
           
           node = node.next;
       }
       return min;
   }
   public void insertAfter(Node currentNode, Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else if (currentNode == tail) {
         tail.next = newNode;
         newNode.previous = tail;
         tail = newNode;
      }
      else {
         Node successor = currentNode.next;
         newNode.next = successor;
         newNode.previous = currentNode;
         currentNode.next = newNode;
         successor.previous = newNode;
      }
      
      listSize++;
   }
   
   public void remove(Node currentNode) {
       
       if(head == null){
           return;
       }
      Node successor = currentNode.next;
      Node predecessor = currentNode.previous;
      
      if (successor != null)
         successor.previous = predecessor;
         
      if (predecessor != null)
         predecessor.next = successor;
         
      if (currentNode == head)
         head = successor;
         
      if (currentNode == tail)
         tail = predecessor;
      
      listSize--;
   }
   
  public int size(){
      return listSize;
  }
  
  
public int[] toArray(){
     Node nd = head;
     int[] arr = new int[listSize];
     int count = 0;
     while(nd != null){
         
         arr[count] = nd.data;
         count++;
         nd = nd.next;
     }
     
     return arr;
  }



 public int indexOf(int n){
      Node nd = head;
      int count  = 0;
      while(nd != null){
          if(n == nd.data){
              
              return count;
              
          }
          count++;
          nd = nd.next;
      }
      
      return -1;
  }
 
 public int sumOfLastElements(int m){
     Node nd = tail;
     int sum = 0;
     int count = 1;
     while(nd.previous != null){
         if(count <= m){
            sum += nd.data;
         }
         count++;
         nd = nd.previous;
     }
     
     return sum;
     
 }
 
 public int sumOfLastElements2(int m){
     Node nd = head;
     int sum2 = 0;
     int count = 1;
     int start = listSize - m;
     while(nd != null){
         if(count > start && count <= listSize){
             sum2 += nd.data;
         }
         count ++;
         nd = nd.next;
         
     }
     return sum2;
 }

}

