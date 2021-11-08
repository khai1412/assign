import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CarList extends Car{
  BrandList brandList; 
  ArrayList<Brand> b;
  ArrayList<Car> lc=new ArrayList<>();
  public CarList(ArrayList<Car> lc,BrandList bList,ArrayList<Brand> b){
      this.lc=lc;
      this.brandList=bList;
      this.b=b;
  }

    CarList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  public boolean loadFromFile(String filename) throws FileNotFoundException, IOException{
    File f = new File(filename);
    if(f.exists()==false){
        return false;
    } else {
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] s1 = line.split("[,]+");
                for (int i = 0; i < s1.length; i++) {
                    s1[i] = s1[i].trim();
                }
                BrandList bl = new BrandList();

                lc.add(new Car(s1[0], b.get(bl.searchID(b, s1[1])), s1[2], s1[3], s1[4]));
                line =br.readLine();
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }


    }
    return true;
  }
    public boolean saveToFile(String filename) {
        File f = new File(filename);
        if (f.exists() == false) {
            return false;
        } else {
            try {
                FileWriter fw = new FileWriter(f);
                PrintWriter pw = new PrintWriter(fw);
                for(Car c:lc){
                    pw.println(c.toString());
                }
                fw.close();
                pw.close();
                System.out.println("Save complete");
            } catch (Exception e) {

            }
        }
        return true;

    }

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
          else System.out.println("color can not be blank");
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
          else System.out.println("color can not be blank");
        }catch(Exception e){
          System.err.println(e);
        }
      }
    while(true){
        try{
          String red="^F\\d{5}";
          System.out.print("FrameID: ");
          c.setFrameID(sc.nextLine().toUpperCase());
          if (c.getFrameID().matches(red) && this.searchFrame(c.getFrameID())==-1) break;
          else System.out.println("Frame ID can not be blank and must be in the  \"F00000\"");
        }catch(Exception e){
          System.err.println(e);
        }
      }
    while(true){
        try{
          String red="^E\\d{5}";
          System.out.print("Engine ID : ");
          c.setEngineID(sc.nextLine().toUpperCase());
          if (c.getEngineID().matches(red) && this.searchEngine(c.getEngineID())==-1) break;
          else System.out.println("Engine ID can not be blank and must be in the  \"E00000\"");
        }catch(Exception e){
          System.err.println(e);
        }
      }
    lc.add(c);
      System.out.println("Add car succsess");
  }
  public void printBasedBrandName (){
    Scanner sc=new Scanner(System.in);
      System.out.print("Input: ");
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
      System.out.print("Enter ID car to remove: ");
    String removedID=sc.nextLine();
    int pos=this.searchID(removedID);
    if (pos<0){
      System.out.println("Not found!");
      return false;
    }
    else {
        lc.remove(pos);
        System.out.println("Remove successfully");
    }
    return true;
  }
  public boolean updateCar(ArrayList<Brand> lb){
    Scanner sc=new Scanner(System.in);
      System.out.print("Enter ID to update: ");
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
          else System.out.println("color can not be blank");
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
          else System.out.println("Frame ID can not be blank and must be in the  \"F00000\"");
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
          else System.out.println("Engine ID can not be blank and must be in the  \"E00000\"");
        }catch(Exception e){
          System.err.println(e);
        }
      }
      lc.set(pos, c);
        System.out.println("Update car successfully!");
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
