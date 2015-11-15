import ce210.dequeue.*;
import ce210.sampleData.*;

class TestDequeue {
  public static void main(String args[]) {
    //Dequeue<VolosDist> dequeue = new Dequeue<>();
    DoublyNodeListDequeue<VolosDist> dequeue = new DoublyNodeListDequeue<>();
    SampleDistData data = new SampleDistData();
    
    System.out.println("Printing Dequeue\n");
    System.out.println(dequeue.toString());
    
    System.out.println("Pushing 3 elements\n");

    for(int i=0; i<3; i++) {
      dequeue.push( data.getNext() );
    }

    System.out.println("Printing Dequeue\n");
    System.out.println(dequeue.toString());
    
    System.out.println("Injecting 3 elements\n");

    for(int i=0; i<3; i++) {
      dequeue.inject( data.getNext() );
    }
    System.out.println("Printing Dequeue\n");
    System.out.println(dequeue.toString());

    System.out.println("Ejecting one element\n");
    System.out.println(dequeue.eject().toString());
    System.out.println("Printing Dequeue\n");
    System.out.println(dequeue.toString());
    
    System.out.println("Poping two elements\n");
    System.out.println(dequeue.pop().toString());
    System.out.println(dequeue.pop().toString());
    System.out.println("Printing Dequeue\n");
    System.out.println(dequeue.toString());

  }
}
