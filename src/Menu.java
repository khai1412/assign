
import static java.lang.Math.E;
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
public class Menu {
    int int_getChoice(ArrayList<Brand> options){
        Scanner sc= new Scanner(System.in);
        for(int i=0;i<options.size();i++){
            System.out.println((i+1)+" "+options.get(i));
        }
        System.out.print("Please choose an option 1 to N: ");
        int p=sc.nextInt();
        return p;
    }
    Brand ref_getChoice(ArrayList<Brand> options){
        Scanner sc= new Scanner(System.in);
        int choice =this.int_getChoice(options);
        int n=options.size();
        int p;
        do{
            p=sc.nextInt();
        } while(p<0||p>n);
        return options.get(p);
    }
}
