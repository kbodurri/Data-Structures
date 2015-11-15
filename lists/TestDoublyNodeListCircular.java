import ce210.lists.*;
import ce210.sampleData.*;

class TestDoublyNodeListCircular {
  public static void main(String args[]) {
    DoublyNodeListCircular<String> list1 = new DoublyNodeListCircular<String>();
    SampleStringData data = new SampleStringData();
    
    for(int i=0; i<3; i++) {
      list1.insertFirst( data.getNext() );
    }
    
    System.out.println("----Printing List 1---");
    list1.printList();

    list1.insertAfter(list1.last(), data.getNext() );    
    System.out.println("----Printing List 1---");
    list1.printList();

    list1.insertAfter(list1.last().getPrev(), data.getNext() );
    System.out.println("----Printing List 1---");
    list1.printList();
    
    list1.insertAfter(list1.first(), data.getNext() );
    System.out.println("----Printing List 1---");
    list1.printList();
    
    list1.insertBefore(list1.first().getNext(), data.getNext() );
    System.out.println("----Printing List 1---");
    list1.printList();
    
    while(list1.size() > 3) {
      String node = list1.delete( 0 );
      System.out.println("----Printing List 1---");
      list1.printList();
      if( node.isEmpty() ) break;
    }    
    
    list1.delete( list1.first() );
    System.out.println("----Printing List 1---");
    list1.printList();

    DoublyNodeListCircular<String> list2 = new DoublyNodeListCircular<String>();
    for(int i=0; i<5; i++) {
      list2.insertLast( data.getNext() );
    }

    System.out.println("Printing List 2");
    list2.printList();
    
    list1.catenate(list2);
    
    System.out.println("---------------");
    System.out.println("Printing catenated lists 1+2\n");
    list1.printList();
    
    System.out.println("Printing List 2");
    list2.printList();
    
 	}
}
