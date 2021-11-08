
import java.io.IOException;
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
public class CarManager {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Brand>  b= new ArrayList<Brand>();
        ArrayList<Car>  c=new ArrayList<Car>();
        BrandList b1= new BrandList();
        //b1.loadFromFile(b, filename)
        b1.loadFromFile(b, "D:\\Java_test\\Assignment\\src\\brands.txt");
        CarList c1=new CarList(c,b1,b);
        c1.loadFromFile("D:\\Java_test\\Assignment\\src\\cars.txt");
        int choice=0;
        System.out.println("Choose one of this options");
        System.out.println("0. Exit");
        System.out.println("1. List all brands");
        System.out.println("2. Add brand");
        System.out.println("3. Search a brand based on it’s ID");
        System.out.println("4. Update a brand");
        System.out.println("5. Save brands to the file, named brands.txt");
        System.out.println("6. List all cars in ascending order of brand names");
        System.out.println("7. List cars based on a part of an input brand name");
        System.out.println("8. Add a car");
        System.out.println("9. Remove a car based on its ID");
        System.out.println("10. Update a car based on its ID");
        System.out.println("11. Save cars to file");
        
        
        do {
            while (true) {

                try {
                    System.out.print("Enter option: ");
                    choice = Integer.parseInt(sc.nextLine());
                    if(choice>=0){
                  
                    switch (choice) {
                        case 1:
                            b1.listBrands(b);
                            break;
                        case 2:
                            b1.addBrand(b);
                            break;
                        case 3:
                            String id;
                            System.out.print("Enter ID: ");
                            String ip = sc.nextLine();
                            id = sc.nextLine();
                            if (b1.searchID(b, id) == -1) {
                                System.out.println("Not found");
                            } else {
                                System.out.println(b.get(b1.searchID(b, id)));
                            }

                            break;
                        case 4:
                            b1.updateBrand(b);
                            break;
                        case 5:
                            b1.saveToFile(b, "D:\\Java_test\\Assignment\\src\\brands.txt");
                            break;
                        case 6:
                            c1.listCars();
                            break;
                        case 7:
                            c1.printBasedBrandName();
                            break;
                        case 8:
                            c1.addCar(b);
                            break;
                        case 9:
                            c1.removeCar();
                            break;
                        case 10:
                            c1.updateCar(b);
                            break;
                        case 11:
                            c1.saveToFile("D:\\Java_test\\Assignment\\src\\cars.txt");
                            break;
                        case 0:
                            choice = 0;
                    }
                    break;
                    } else {
                        System.out.println("Please enter from 0 to 11");
                        
                    }
                } catch (Exception e) {
                    //System.err.println(e);
                    System.out.println("Please enter from 0 to 11");
                    //break;
                }
            }

        } while (choice > 0 && choice <= 11);


           
    }
}
