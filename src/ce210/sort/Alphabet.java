package ce210.sort;

public class Alphabet {
  private String Sigma; // the alphabet
  private int radix;    // the alphabet length
  
  public Alphabet() {
    Sigma="0123456789";
    radix=Sigma.length();
  }
  
  public Alphabet(String s, int r) {
    Sigma = s;
    radix = r;
  }
  
  int getDigit(char c) {
    return Sigma.indexOf(c);
  }
  
  int getDigit(String s, int position) {
    return Sigma.indexOf(s.charAt(position));
  }
  
  char getLetter(int i) {
    return Sigma.charAt(i);
  }
  
  int getRadix() {
    return radix;
  }
}