package Modul2;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ShopService {
   static List<String> historyOrder = new ArrayList<>();
   static File file = new File("OrderFile.csv");
    public void writeListProduct() throws IOException {
        List <String> checkList = new ArrayList<>();
        File file = new File("ListProduct");
        Scanner scanner = new Scanner(file);
        int numPositionOrder =2; //ThreadLocalRandom.current().nextInt(1,6);
        List<String> randomlist = new ArrayList<>();
        for (int i = 0; i < numPositionOrder; i++) {
        while (scanner.hasNextLine()){
            randomlist.add(scanner.nextLine());}
        int randomStringFile = ThreadLocalRandom.current().nextInt(1, 11);
            checkList.add(randomlist.get(randomStringFile));}
        scanner.close();
        historyOrder.add(checkList.toString());
        writeOrderFile(checkList);
        System.out.println(historyOrder);
    }
    public static void writeOrderFile(List list) throws IOException {
        PersonService personService = new PersonService();
        Map<Integer, String> informationOfCheck = new HashMap<>();
        informationOfCheck.put(1, String.valueOf(LocalDateTime.now()));
        informationOfCheck.put(2, personService.generateNewCustomer().toString());
        informationOfCheck.put(3, list.toString());
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.append(informationOfCheck.toString());
            }
        }


