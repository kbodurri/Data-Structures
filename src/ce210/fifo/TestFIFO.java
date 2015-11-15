import ce210.fifo.*;
import ce210.sampleData.*;

class TestFIFO {
  public static void main(String args[]) {
    SampleDistData data = new SampleDistData();
    //SinglyNodeListFIFO<VolosDist> fifo = new SinglyNodeListFIFO<>();
    FiFo<VolosDist> fifo = new FiFo<>();

    for(int i=0; i<3; i++) {
      fifo.enqueue( data.getNext() );
    }

    System.out.println("\nPrinting FiFo (size:"+fifo.size()+")");
    System.out.println(fifo.toString());

    fifo.enqueue( data.getNext() );
    System.out.println("Printing FiFo (size:"+fifo.size()+")");
    System.out.println(fifo.toString());

    System.out.println("Printing Dequeued Element");
    System.out.println(fifo.dequeue().toString());

    System.out.println("Printing Dequeued Element");
    System.out.println(fifo.dequeue().toString());

    System.out.println("\nPrinting FiFo (size:"+fifo.size()+")\n");
    System.out.println(fifo.toString());

  }

}
