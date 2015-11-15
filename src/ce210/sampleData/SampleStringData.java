package ce210.sampleData;

import java.lang.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class SampleStringData { 
  private String[] v ;
  private int size;
  private int usedData;
  private static final int SIZE=50;
  
  public String getNext() {
    if(usedData <= size) {
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
        
  public SampleStringData()  {        
    v = new String[SIZE];
    usedData = 0;
    size = 0;
        
    try {

      URL url = new URL("http://inf-server.inf.uth.gr/~gthanos/small_dict.txt");
      BufferedReader in = new BufferedReader( new InputStreamReader(url.openStream()));

      String inputLine;
      String csvSplitter = ",";
        
      while ((inputLine = in.readLine()) != null) {
        //System.out.println(inputLine);
        v[size++] = new String(inputLine);
      }
       
      in.close();
    } catch(IOException ex) {
      //System.out.println("Unable to open file at location: "+location);
      System.out.println(ex.toString());
      System.out.println("Exiting...");
      System.exit(-1);
    }
  }
    
}
