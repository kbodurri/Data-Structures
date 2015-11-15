package ce210.sampleData;

import java.lang.*;
import java.util.*;

public class SampleIntegerRandomData { 
  private Integer[] v ;
  private int size;
  private int usedData;
  private static final int SIZE=1000;
  
  public Integer getNext() {
    if(usedData < size) {
      return v[usedData++];
    }
    return null;
  }   

  public int getSize() {
    return size;
  }
    
  public int getUsedData() {
    return usedData;
  }
        
  public SampleIntegerRandomData()  {        
    v = new Integer[SIZE];
    usedData = 0;
    size = 0;
        
    Random rand = new Random( 15127598 );
    while(size < SIZE) {
      v[size++] = new Integer(rand.nextInt(10000));
    }
  }
    
}
