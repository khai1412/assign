
import java.util.ArrayList;
import java.util.List;

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
    public static void main(String[] args) {
        List<Brand> a= new ArrayList<Brand>();
        BrandList b= new BrandList();
        String c="B7-2018, BMW 730Li (2018), Harman Kardon: 3.749";
        String[]d=c.split("[,]+");
        for(int i=0;i<d.length;i++){
            System.out.println(d[i]);
        }
           
    }
}
