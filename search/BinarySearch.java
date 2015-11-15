package ce210.search;

import ce210.sampleData.*;
import java.util.Arrays;

public class BinarySearch <T extends Comparable> {

  public int binarySearch( T a[], T o ) {
    int left = 0;
    int right = a.length -1;

    while(right >= left) {
      int middle = (left+right)/2;
      if(o.compareTo(a[middle])==0)
        return middle;
      if( o.compareTo(a[middle]) < 0 )
        right = middle-1;
      else 
        left = middle+1;
    }
    return -1;
  }
  
  public int binarySearchRecursive( T a[], T o ) {
    int left = 0;
    int right = a.length -1;

    if(right < left) 
      return -1;
    
    int middle = (left+right)/2;
    if(o.compareTo(a[middle])==0)
      return middle;
    if( o.compareTo(a[middle]) < 0 )
      return binarySearchRecursive( Arrays.copyOfRange(a, left, middle), o);
    else {
      int pos = binarySearchRecursive( Arrays.copyOfRange(a, middle+1, right+1), o);
      if( pos < 0 ) 
        return pos; 
      return (middle + 1 + pos);
    }
  }

}
