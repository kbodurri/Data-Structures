package ce210.sampleData;

public class VolosDist implements Comparable<VolosDist> {
  private String destination;
  private Double distance;
  
  public VolosDist( String destination, double distance) {
    this.destination = destination;
    this.distance = distance;
  }
  
  public String getDestination() {
    return destination;
  }
   
  public Double getDistance() {
    return distance;
  }
    
  public void setDestination(String destination) {
    this.destination = destination;
  }
   
  public void setDistance(double distance) {
    this.distance = distance;
  }
    
  public String toString() {
    return "city: "+destination+", distance: "+distance;
  }
  
  public int compareTo(VolosDist dist) {
    return distance.intValue() - dist.getDistance().intValue();
  }
  
  public boolean less(VolosDist o) {
    VolosDist v = (VolosDist) o;
    return this.distance < v.distance;
  }

  public boolean more(VolosDist o) {
	VolosDist v = (VolosDist) o;
    return this.distance > v.distance;
  }

}
