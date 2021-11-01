/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Brand {
    private String brandID;
    private String brandName;
    private String soundBrand;
    private double price;
    public Brand(){
        
    }
    public Brand(String a,String b,String c,double d){
        this.brandID=a;
        this.brandName=b;
        this.soundBrand=c;
        this.price=d;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public void setSoundBrand(String soundBrand) {
        this.soundBrand = soundBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String toString(){
        return this.getBrandID()+", "+this.brandName+", "+this.getSoundBrand()+":"+this.getPrice();
    }
}
