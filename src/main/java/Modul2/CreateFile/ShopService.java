package Modul2.CreateFile;

import Modul2.Information.Exception;
import Modul2.Information.PersonService;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ShopService extends Throwable {
    static List<String> historyOrder = new ArrayList<>();

    public static void readListProduct(List<String> listInformationSale) throws IOException {
        List<String> checkList = new ArrayList<>();
        File file = new File("D:\\Modul2\\src\\main\\resources\\ListProduct");
        Scanner scanner = new Scanner(file);
        List<String> randomlist = new ArrayList<>();
        int numPositionOrder = ThreadLocalRandom.current().nextInt(1, 5);
        for (int i = 0; i < numPositionOrder; i++) {
            while (scanner.hasNextLine()) {
                String stringONFile = scanner.nextLine();
                String[] exception = stringONFile.split(",");
                notCorrectString(exception);
                randomlist.add(stringONFile);
            }
            int randomStringFile = ThreadLocalRandom.current().nextInt(1, 11);
            checkList.add(randomlist.get(randomStringFile));
        }
        historyOrder.add(checkList.toString());
        newFormatFile(checkList, listInformationSale);
    }

    public static void newFormatFile(List<String> list, List<String> listInformationSale) {
        PersonService personService = new PersonService();
        String checkList = "[" + LocalDateTime.now() + "] " + personService.generateNewCustomer() + " " + list;
        listInformationSale.add(checkList);
    }

    public void writeSaleInformation(File file) throws IOException {
        List<String> listInformationSale = new ArrayList<>();
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (int j = 0; j < 15; j++) {
                readListProduct(listInformationSale);
                printWriter.println(listInformationSale.get(j));
            }
        }
    }

    public static void notCorrectString(String[] exception) {
        try {
            for (String s : exception) {
                if (s.equals(" ")) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Некоректная строка");
        }
    }
}






