package pragati.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Mobile {
    private String model;
    private double price;

    public Mobile(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}

public class SearchShowList {
    public static void main(String[] args) {
 
        List<Mobile> samsungMobiles = new ArrayList<>();
        samsungMobiles.add(new Mobile("Galaxy S21", 799));
        samsungMobiles.add(new Mobile("Galaxy Note 20", 999));
        samsungMobiles.add(new Mobile("Galaxy A51", 399));
        samsungMobiles.add(new Mobile("Galaxy M31", 249));

        
        Collections.sort(samsungMobiles, Comparator.comparingDouble(Mobile::getPrice));

        
        System.out.println("Mobiles in ascending order of price:");
        for (Mobile mobile : samsungMobiles) {
            System.out.println("Model: " + mobile.getModel() + ", Price: rs" + mobile.getPrice());
        }
    }
}
