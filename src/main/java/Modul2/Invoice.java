package Modul2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        double sumPriceTeleveseon=0;
        sumPriceTeleveseon+= television.price;
        double sumPriceTelephone =0;
        sumPriceTelephone += telephone.price;
        listTelevision.add(television);
        listTelephone.add(telephone);
        listCustomer.add(customer);
        if (sumPriceTeleveseon + sumPriceTelephone > limitPrice) {
            type = "wholesale";
        } else type = "retail";
    }

    public static void main(String[] args) throws IOException {
        ShopService shopService = new ShopService();
        for (int i = 0; i < 15; i++) {
            shopService.writeListProduct();
        }
        File file = new File("OrderFile.csv");
        Scanner scanner = new Scanner(file);
        int numGoodsSold = 0;
        while (scanner.hasNextLine()) {
            String takeString = String.valueOf(scanner.hasNext());
            if (takeString.contains("Telephone") || takeString.contains("Television")) {
                numGoodsSold++;
            }
        }
        System.out.println("Количество проданных товаров " + numGoodsSold);
    }
}
