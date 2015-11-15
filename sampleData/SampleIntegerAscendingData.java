package ce210.sampleData;

import java.lang.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class SampleIntegerAscendingData { 
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
        
  public SampleIntegerAscendingData()  {        
    v = new Integer[SIZE];
    usedData = 0;
    size = 0;
        
    while(size < SIZE) {
      v[size++] = new Integer(size);
    }
  }
    
}
