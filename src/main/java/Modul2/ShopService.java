package Modul2;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ShopService {
    static List<String> historyOrder = new ArrayList<>();

    public static void readListProduct(List <String> listInformationSale) throws IOException {
        List<String> checkList = new ArrayList<>();
        File file = new File("ListProduct");
        Scanner scanner = new Scanner(file);
        List<String> randomlist = new ArrayList<>();
        int numPositionOrder = 2; //ThreadLocalRandom.current().nextInt(1,6);
        for (int i = 0; i < numPositionOrder; i++) {
            while (scanner.hasNextLine()) {
                randomlist.add(scanner.nextLine());
            }
            int randomStringFile = ThreadLocalRandom.current().nextInt(1, 10);
            checkList.add(randomlist.get(randomStringFile));
        }
        historyOrder.add(checkList.toString());
        newFormatFile(checkList, listInformationSale);
    }

    public static void newFormatFile(List<String> list, List<String> listInformationSale){
        PersonService personService = new PersonService();
        String checkList = "[" + LocalDateTime.now() + "] " + personService.generateNewCustomer() + " " + list;
        listInformationSale.add(checkList);
    }

    public  void writeSaleInformation(File file) throws IOException {
        List <String> listInformationSale = new ArrayList<>();
        try (PrintWriter printWriter = new PrintWriter(file)) {
        for (int j = 0; j < 15; j++) {
            readListProduct(listInformationSale);
            printWriter.println(listInformationSale.get(j));}
        }
    }
}


