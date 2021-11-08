
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class BrandList {
    public BrandList(){
        
    }
    public boolean loadFromFile(ArrayList<Brand> b,String filename) throws FileNotFoundException, IOException{
        File f= new File("D:\\Java_test\\Assignment\\src\\brands.txt");
        if(f.exists()){
            try{
            BufferedReader br = null;
            FileReader fr=new FileReader(f);
            //file_stream = new FileInputStream("brand.txt");
            br = new BufferedReader(fr);
            String line=br.readLine();
            while(line != null){
                String[]param=line.split("[,]+");
                for(int i=0;i<param.length;i++){
                    param[i]=param[i].trim();
                }
                double ff=Double.parseDouble(param[2].split("[:]")[1].trim());
                //ff=Float.parseFloat(String.format("%.3f", ff));  
                //System.out.println(ff);
                b.add(new Brand(param[0],param[1],param[2].split("[:]")[0].trim(),ff));
                line=br.readLine();
            }
            br.close();
            fr.close();
            return true;
            }catch(Exception e){
                System.out.println(e);
                return true;
                
            }
            
           
        } else {
            return false;
        }
        //return true;
    }
    public boolean saveToFile(ArrayList<Brand> b,String filename){
        try{
            File f= new File(filename);
            FileWriter fw= new FileWriter(f);
            PrintWriter pw =new PrintWriter(fw);
            for(Brand i:b){
                pw.println(i.toString());
            }
            fw.close();
            pw.close();
            System.out.println("Save complete");
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
    public int searchID (ArrayList<Brand> b,String ID){
        for(int i=0;i<b.size();i++){
            if(b.get(i).getBrandID().equalsIgnoreCase(ID)){
                return i;
            }
        }
        return -1;
    }
    public Brand getUserChoice(ArrayList<Brand>b){
        Menu me=new Menu();
        return me.ref_getChoice((ArrayList<Brand>) b);
    }
    public void addBrand(ArrayList<Brand>b){
        Scanner sc= new Scanner(System.in);
        String brand_id = null;
        String brand_name="";
        String Sound_manufacturer=""; 
        double price=0;
        int check=0;
        while(check==0){
        System.out.print("Brand ID: ");
        brand_id=sc.nextLine();
        int dem=0;
        for(int i=0;i<b.size();i++){
          if(brand_id.equalsIgnoreCase(b.get(i).getBrandID()))  {
              
              break;
          }
          dem++;
        }
        if(dem==b.size()){
            check=1;
        } else {
            System.out.println("Brand ID can not be duplicated.");
        }
      }
        while(brand_name.isEmpty()==true){
            System.out.print("Brand name: ");
            brand_name=sc.nextLine();
            //System.out.println(brand_name.toString());
            if(brand_name.isEmpty()==true){
                System.out.println("Brand name can not be blank.");
            }
        }
        while(Sound_manufacturer.isEmpty()==true){
            System.out.print("Sound manufacturer: ");
            Sound_manufacturer=sc.nextLine();
            if(Sound_manufacturer.isEmpty()==true){
                System.out.println("Sound manufacturer can not be blank.");
            }
        }
        while(price <=0){
            System.out.print("Price: ");
            price=sc.nextDouble();
            if(price<=0){
                System.out.println("Price must be a positive real number.");
            }
        }
        b.add(new Brand(brand_id,brand_name,Sound_manufacturer,price));
        System.out.println("Add brand success");
    }
    public void updateBrand(ArrayList<Brand>b){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter brand ID: ");
        String brand_id=sc.nextLine();
        int pos = this.searchID(b, brand_id);
        String brand_name = "";
        String Sound_manufacturer = "";
        double price = 0;

        if (pos < 0) {
            System.out.println("not found");
        } else {
            while (brand_name.isEmpty() == true) {
                System.out.print("Brand name: ");
                brand_name = sc.nextLine();
                if (brand_name.isEmpty() == true) {
                    System.out.println("Brand name can not be blank.");
                }
            }
            while (Sound_manufacturer.isEmpty() == true) {
                System.out.print("Sound manufacturer: ");
                Sound_manufacturer = sc.nextLine();
                if (Sound_manufacturer.isEmpty() == true) {
                    System.out.println("Sound manufacturer can not be blank.");
                }
            }
            while (price <= 0) {
                System.out.print("Price: ");
                price = sc.nextDouble();
                if (price <= 0) {
                    System.out.println("Price must be a positive real number.");
                }
            }
            
            b.set(pos, new Brand(brand_id, brand_name, Sound_manufacturer, price));
            System.out.println("update successully");
           
        }
         
            
    }
    public void listBrands(ArrayList<Brand>b) {
        //boolean c= this.loadFromFile(b, "brands.txt");
        
            for(int i=0;i<b.size();i++){
            System.out.println(b.get(i));
            }
    }
}
