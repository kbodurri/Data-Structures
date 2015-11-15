package ce210.sort;

import ce210.lists.*;

public class DistributionSort {
  
  public static void binSort( char[] s, int left, int right, Alphabet a) {
    int radix = a.getRadix();
    int[] binBucket = new int[radix+10];
    char[] aux = new char[s.length];
    
    for(int i=left; i<=right; i++) 
      binBucket[a.getDigit(s[i])+1]++;

    for(int i=1; i<radix; i++) 
      binBucket[i] += binBucket[i-1];
      
    for(int i=left; i<=right; i++)
      aux[binBucket[a.getDigit(s[i])]++] = s[i];

    for(int i=left; i<=right; i++)
      s[i] = aux[i-left];
  }
  
  public static void bucketSort(SinglyNodeList<Character> list, Alphabet a) {
    if(list.isEmpty())
      return;
    int radix = a.getRadix();
    SinglyNodeList[] bucket = new SinglyNodeList[radix];
    
    for(int i=0; i<radix; i++) 
      bucket[i] = new SinglyNodeList();
    
    while(!list.isEmpty()) {
      Character temp = (Character)list.deleteFirst();
      bucket[a.getDigit(temp.charValue())].insertLast(temp);
    }
    
    for(int i=0; i<radix; i++) {
      if(!bucket[i].isEmpty()) {
        list.catenate(bucket[i]);
        bucket[i].setEmpty();
      }
    }
  }
  
  public static void bucketSort(char[] s, int left, int right, Alphabet a) {
    
    int radix = a.getRadix();
    SinglyNodeList<Character> list = new SinglyNodeList<>();
    SinglyNodeList[] bucket = new SinglyNodeList[radix];
    
    for(int i=0; i<radix; i++) 
      bucket[i] = new SinglyNodeList<Character>();
    
    for(int i=left; i<=right; i++) {
      bucket[a.getDigit(s[i])].insertLast(s[i]);
    }
    
    for(int i=0; i<radix; i++) {
      if(!bucket[i].isEmpty()) {
        list.catenate(bucket[i]);
        bucket[i].setEmpty();
      }
    }
    
    for(int i=0; i<s.length; i++) 
      s[i] = list.deleteFirst();
  }
  
  public static void radixMSD(SinglyNodeList<String> list, int curDigit, int length, Alphabet a) {
    
    if(list.isEmpty()) {
      return;
    }
    int radix = a.getRadix();
    SinglyNodeList[] Bucket = new SinglyNodeList[radix];
    
    for(int k=0; k<radix; k++) {
      Bucket[k] = new SinglyNodeList<String>();
    }

    while(!list.isEmpty()) {
      String temp = (String) list.deleteFirst();
      Bucket[a.getDigit(temp, curDigit)].insertLast(temp);
    }

    if(curDigit<length-1) {
      for(int k=0; k<radix; k++) {
        if(Bucket[k].size() > 1) {
          radixMSD(Bucket[k], curDigit+1, length, a);
        }
      }
    }

    for(int k=0; k<radix; k++) {
      if(!Bucket[k].isEmpty()) {
        list.catenate(Bucket[k]);
      }
    }

  }
  
  public static void radixLSD(SinglyNodeList<String> list, int length, Alphabet a) {
    if( list.isEmpty() ) {
      return;
    }
    int radix = a.getRadix();
    SinglyNodeList[] Bucket = new SinglyNodeList[radix];
    
    for(int k=0; k<radix; k++) {
      Bucket[k] = new SinglyNodeList<String>();
    }

    for( int curDigit = length-1; curDigit > -1; curDigit--) {
      while( !list.isEmpty()) {
        String temp=(String)list.deleteFirst();
        Bucket[a.getDigit(temp,curDigit)].insertLast(temp);
      }
      for(int k=0; k<radix; k++) {
        if(!Bucket[k].isEmpty()) {
          list.catenate(Bucket[k]);
          Bucket[k].setEmpty();
        }
      }
    }
  }
}