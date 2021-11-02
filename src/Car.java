
public class Car implements Comparable<Car>{
  private String carID;
  private Brand brand;
  private String color;
  private String frameID;
  private String engineID;
  
  public Car(){};

  public Car(String carID, Brand brand, String color, String frameID, String engineID) {
    this.carID = carID;
    this.brand = brand;
    this.color = color;
    this.frameID = frameID;
    this.engineID = engineID;
  }

  public String getEngineID() {
    return engineID;
  }

  public void setEngineID(String engineID) {
    this.engineID = engineID;
  }

  public String getCarID() {
    return carID;
  }

  public void setCarID(String carID) {
    this.carID = carID;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getFrameID() {
    return frameID;
  }

  public void setFrameID(String frameID) {
    this.frameID = frameID;
  }

  @Override
  public String toString() {
    return carID+", "+brand.getBrandID()+", "+color+", "+frameID+", "+engineID;
  }

  @Override
  public int compareTo(Car t) {
    int d=brand.getBrandID().compareTo(t.brand.getBrandID());
    if (d!=0) return d;
    return carID.compareTo(t.carID);
  }
  
  public String screenString(){
    return brand+",\n, "+carID+", "+color+", "+frameID+", "+engineID;
  }


}
