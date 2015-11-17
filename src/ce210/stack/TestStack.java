import ce210.stack.*;
import ce210.sampleData.*;

class TestStack {
  public static void main(String args[]) {
    ArrayStack<VolosDist> stack = new ArrayStack<VolosDist>();    
    SampleDistData data = new SampleDistData();

    for(int i=0; i<3; i++) {
      stack.push( data.getNext() );
    }

    System.out.println("\nPrinting Stack (size:"+stack.size()+")");
    System.out.println(stack.toString());

    stack.push( data.getNext() );
    System.out.println("Printing Stack (size:"+stack.size()+")");
    System.out.println(stack.toString());

    System.out.println("Printing Poped Element");
    System.out.println(stack.pop().toString());

    System.out.println("Printing Poped Element");
    System.out.println(stack.pop().toString());

    System.out.println("\nPrinting Stack (size:"+stack.size()+")\n");
    System.out.println(stack.toString());

  }

}
