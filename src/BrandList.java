
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
        File f= new File(filename);
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
                b.add(new Brand(param[0],param[1],param[2].split("[:]")[0].trim(),Integer.parseInt(param[2].split("[:]")[1].trim())));
            }
            br.close();
            fr.close();
            }catch(Exception e){
                System.out.println(e);
            }
            
           
        }
        return true;
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
        int price=0;
        int check=0;
        while(check==0){
        System.out.print("Brand ID: ");
        brand_id=sc.nextLine();
        for(int i=0;i<b.size();i++){
          if(brand_id.equalsIgnoreCase(b.get(i).getBrandID()))  {
              check=1;
              break;
          }
        }
      }
        while(brand_name==""){
            System.out.print("Brand name: ");
            brand_name=sc.nextLine();
        }
        while(Sound_manufacturer==""){
            System.out.print("Sound manufacturer: ");
            Sound_manufacturer=sc.nextLine();
        }
        while(price ==0){
            System.out.print("Price: ");
            price=sc.nextInt();
        }
        b.add(new Brand(brand_id,brand_name,Sound_manufacturer,price));
       
    }
    public void updateBrand(ArrayList<Brand>b){
        Scanner sc= new Scanner(System.in);
        String brand_id=sc.nextLine();
        int pos=this.searchID(b, brand_id);
        if(pos<0){
            System.out.println("not found");
        } else {
        String brand_name="";
        String Sound_manufacturer=""; 
        int price=0;
        
        while(brand_name==""){
            System.out.print("Brand name: ");
            brand_name=sc.nextLine();
        }
        while(Sound_manufacturer==""){
            System.out.print("Sound manufacturer: ");
            Sound_manufacturer=sc.nextLine();
        }
        while(price ==0){
            System.out.print("Price: ");
            price=sc.nextInt();
        }
        b.set(pos, new Brand(brand_id,brand_name,Sound_manufacturer,price));

        }
    }
    public void listBrands(ArrayList<Brand>b){
        for(int i=0;i<b.size();i++){
            System.out.println(b.get(i));
        }
    }
}
