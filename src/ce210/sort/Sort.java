package ce210.sort; 

public class Sort <T extends Comparable> {

  public void insertionSort(T a[], int left, int right) {
   
    for(int i=right; i>left; i--) {
      if( a[i].compareTo(a[i-1])<0 ) {
        T temp = a[i];
        a[i] = a[i-1];
        a[i-1] = temp;
      }
    }
    
    for(int i=left+2; i<= right; i++) {
      int j = i;
      T v=a[i];
      while( v.compareTo(a[j-1])<0 ) {
        a[j] = a[j-1];
        j--;
      }
      a[j] = v;
    }
  }

  public void selectionSort(T a[], int left, int right) {
    T temp;
    for(int unorderedleft = left; unorderedleft < right; unorderedleft++) {
      int min = unorderedleft;
      for( int j = unorderedleft+1; j<=right; j++) {
        if( a[j].compareTo(a[min])<0 ) {
          min = j;
        }
      }
      temp = a[unorderedleft];
      a[unorderedleft] = a[min];
      a[min] = temp;
    }
  }

  public void bubbleSort(T a[], int left, int right) {
    T temp;
    for(int i=left; i<right; i++) {
      for(int j=right; j>i; j--) {
        if( a[j].compareTo(a[j-1])<0 ) {
          temp = a[j-1];
          a[j-1] = a[j];
          a[j] = temp;
        }
      }
    }
  }

  public void shakerSort(T a[], int left, int right) {
    T temp;
    boolean leftdirection = true;
    while(left < right) {
      if(leftdirection) {
        leftdirection = !leftdirection;
        for(int j=right; j>left; j--)
          if( a[j].compareTo(a[j-1])<0 ) {
            temp = a[j-1];
            a[j-1] = a[j];
            a[j] = temp;
          }
        left++;
      }
      else {
        leftdirection = !leftdirection;
        for(int j=left; j<right; j++)
          if( a[j+1].compareTo(a[j])<0 ) {
            temp = a[j+1];
            a[j+1] = a[j];
            a[j] = temp;
          }
        right--;
      }
    }
  }

  public void quickSort( T a[], int left, int right) {
    int i=left-1, j=right;
    T temp, o = a[right];
    while(true) {
      while( a[++i].compareTo(o)<0 ) 
        ;
      while( o.compareTo(a[--j])<0 )
        if( j==left )
          break;
      if( i>= j)
        break;

      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }

    temp = a[i];
    a[i] = a[right];
    a[right] = temp;

    if( left < i-1)
      quickSort(a, left, i-1 );
    if( i+1 < right )
      quickSort(a, i+1, right);

  }

  public void makeHeap(T a[], int k, int N) {
    while(2*k+1 <= N) {
      int maxson = 2*k+1;
      T temp;
      if( maxson < N && a[maxson].compareTo(a[maxson+1]) < 0 ) {
        maxson++;
      }
      if(a[maxson].compareTo(a[k]) < 0 )
        break;
      temp = a[k];
      a[k] = a[maxson];
      a[maxson] = temp;
      k = maxson;
    }
  }

  public void heapSort(T a[], int left, int right) {
    int N = right - left;
    int k=(N%2==0)? N/2-1 : N/2;
    T temp;
    for(; k>= 0; k--)
      makeHeap(a, k, right);

    while(right > left) {
      temp = a[left];
      a[left] = a[right];
      a[right] = temp;
      makeHeap(a, left, --right);
    }
  }

  public void mergeSort(T a[], int left, int right, T b[]) {
    int l, r, middle = (right+left)/2;
        
    if(left < middle) {
      mergeSort(a, left, middle, b);
    }
    if(middle+1<right) {
      mergeSort(a, middle+1, right, b);
    }
    
    for(l=left; l<middle+1; l++) {
      b[l] = a[l];
    }
    l = left;
    for(r=middle; r<right; r++) {
      b[right+middle-r] = a[r+1];
    }

    for(int k=left; k<=right; k++) {
      if(b[r].compareTo(b[l]) < 0 ) {
        a[k] = b[r--];
      } else {
        a[k] = b[l++];
      }
    }    
    
  }



}
