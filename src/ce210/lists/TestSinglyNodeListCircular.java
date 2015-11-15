import ce210.lists.*;
import ce210.sampleData.*;

class TestSinglyNodeListCircular {
  public static void main(String args[]) {
    
    SinglyNodeListCircular<String> list1 = new SinglyNodeListCircular<String>();
    SampleStringData data = new SampleStringData();

    for(int i=0; i<7; i++) {
      list1.insertFirst( data.getNext() );
    }
    
    System.out.println("Printing List 1\n");
    list1.printList();
    System.out.println("---------------");

    list1.insertAfter(list1.first().getNext(), data.getNext() );
    System.out.println("Printing List 1\n");
    list1.printList();
    System.out.println("---------------");
    
    list1.insertLast(data.getNext() );
    System.out.println("Printing List 1\n");
    list1.printList();
    System.out.println("---------------");
    
    list1.insertLast(data.getNext() );
    System.out.println("Printing List 1\n");
    list1.printList();
    System.out.println("---------------");
    
    System.out.println("Deleting after first element: "+list1.deleteAfter(list1.first()) );
    System.out.println("Printing List 1\n");
    list1.printList();
    System.out.println("---------------");
    while(list1.size() > 2 ) {
      System.out.println("Deleting first: "+list1.deleteFirst());
      System.out.println("Deleting last: "+list1.deleteLast());
    }

    System.out.println("Printing List 1\n");
    list1.printList();
    System.out.println("---------------");

    SinglyNodeListCircular<String> list2= new SinglyNodeListCircular<String>();
    for(int i=0; i<2; i++) {
      list2.insertFirst( data.getNext() );
    }
    for(int i=0; i<2; i++) {
      list2.insertLast( data.getNext() );
    }

    System.out.println("Printing List 2\n");
    list2.printList();
    System.out.println("---------------");

    list2.catenate(list1);

    System.out.println("Printing catenated lists 2,1\n");
    list2.printList();
    System.out.println("---------------");
    
    System.out.println("Printing List 1\n");
    list1.printList();
    
    
  }

}
