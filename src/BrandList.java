
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
public class BrandList {
    public BrandList(){
        
    }
    public int searchID (List<Brand> b,String ID){
        for(int i=0;i<b.size();i++){
            if(b.get(i).getBrandID().equalsIgnoreCase(ID)){
                return i;
            }
        }
        return -1;
    }
}
