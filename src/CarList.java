import java.util.ArrayList;
import java.util.Scanner;

public class CarList extends Car{
  BrandList brandList; 
  ArrayList<Car> lc=new ArrayList<>();
  public CarList(BrandList bList){}
//  public boolean loadFromFile(String){
//    
//  }
//  public boolean saveToFile(String){
//    
//  }

  public int searchID (String ID){
    for (int i=0;i<lc.size();i++){
      if (lc.get(i).getCarID().equalsIgnoreCase(ID)) return i;
    }
    return -1;
  }
  public int searchFrame (String fID){
    for (int i=0;i<lc.size();i++){
      if (lc.get(i).getFrameID().equalsIgnoreCase(fID)) return i;
    }
    return -1;
  }
  public int searchEngine (String eID){
    for (int i=0;i<lc.size();i++){
      if (lc.get(i).getEngineID().equalsIgnoreCase(eID)) return i;
    }
    return -1;
  }
  public void addCar(ArrayList<Brand> lb){
    Scanner sc=new Scanner(System.in);
    Car c=new Car();
    while(true){
        try{
          System.out.print("CarID: ");
          c.setCarID(sc.nextLine());
          if (this.searchID(c.getCarID())==-1) break;
          else throw new Exception();
        }catch(Exception e){
          System.err.println(e);
        }
      }
    Menu m=new Menu();
    Brand b=(Brand)m.ref_getChoice(lb);
    c.setBrand(b);
    while(true){
        try{
          System.out.print("Color: ");
          c.setColor(sc.nextLine());
          if (!c.getColor().isEmpty()) break;
          else throw new Exception();
        }catch(Exception e){
          System.err.println(e);
        }
      }
    while(true){
        try{
          String red="^F\\d{4}";
          System.out.print("FrameID: ");
          c.setFrameID(sc.nextLine().toUpperCase());
          if (c.getFrameID().matches(red) && this.searchFrame(c.getFrameID())==-1) break;
          else throw new Exception();
        }catch(Exception e){
          System.err.println(e);
        }
      }
    while(true){
        try{
          String red="^E\\d{4}";
          System.out.print("FrameID: ");
          c.setEngineID(sc.nextLine().toUpperCase());
          if (c.getEngineID().matches(red) && this.searchEngine(c.getEngineID())==-1) break;
          else throw new Exception();
        }catch(Exception e){
          System.err.println(e);
        }
      }
    lc.add(c);
  }
  public void printBasedBrandName (){
    Scanner sc=new Scanner(System.in);
    String partofname=sc.nextLine();
    int count=0;
    for(int i=0;i<lc.size();i++){
      if (lc.get(i).getBrand().getBrandName().contains(partofname)){
        System.out.println(lc.get(i).screenString());
        count++;
      }
    }
    if (count==0) System.out.println("No car is detected!");
  }
  public boolean removeCar(){
    Scanner sc=new Scanner(System.in);
    String removedID=sc.nextLine();
    int pos=this.searchID(removedID);
    if (pos<0){
      System.out.println("Not found!");
      return false;
    }
    else lc.remove(pos);
    return true;
  }
  public boolean updateCar(ArrayList<Brand> lb){
    Scanner sc=new Scanner(System.in);
    String updatedID=sc.nextLine();
    int pos=this.searchID(updatedID);
    if (pos<0){
      System.out.println("Not found!");
      return false;
    }
    else{
      
      Menu m=new Menu();
      Brand b=m.ref_getChoice(lb);
      Car c=new Car();
      c.setCarID(updatedID);
      while(true){
        try{
          System.out.print("Enter Color: ");
          c.setColor(sc.nextLine());
          if (!c.getColor().isEmpty()) break;
          else throw new Exception();
        }catch(Exception e){
          System.err.println(e);
        }
      }
      c.setBrand(b);
      while(true){
        try{
          String red="^F\\d{4}";
          System.out.print("FrameID: ");
          c.setFrameID(sc.nextLine().toUpperCase());
          if (c.getFrameID().matches(red) && this.searchFrame(c.getFrameID())==-1) break;
          else throw new Exception();
        }catch(Exception e){
          System.err.println(e);
        }
      }
    while(true){
        try{
          String red="^E\\d{4}";
          System.out.print("FrameID: ");
          c.setEngineID(sc.nextLine().toUpperCase());
          if (c.getEngineID().matches(red) && this.searchEngine(c.getEngineID())==-1) break;
          else throw new Exception();
        }catch(Exception e){
          System.err.println(e);
        }
      }
      lc.set(pos, c);
    }
    return true;
    
  }
  public void listCars(){
    lc.sort((Car t, Car t1) -> 
            t.getBrand().getBrandName().compareToIgnoreCase(t1.getBrand().getBrandName()));
    for (int i=0;i<lc.size();i++){
      Car c=lc.get(i);
      System.out.println(c.screenString());
    }
  }

}
