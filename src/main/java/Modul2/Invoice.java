package Modul2;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    static double limitPrice = 1000;
    String type;

    public void produckList() {
        List listTelevision = new ArrayList<>();
        List listTelephone = new ArrayList<>();
        List listCustomer = new ArrayList<>();
        Television television = new Television();
        Telephone telephone = new Telephone();
        Customer customer = new Customer();
        double sumPriceTeleveseon = +television.price;
        double sumPriceTelephone = +telephone.price;
        listTelevision.add(television);
        listTelephone.add(telephone);
        listCustomer.add(customer);
        if (sumPriceTeleveseon + sumPriceTelephone > limitPrice) {
            type = "wholesale";
        } else type = "retail";
    }
}
