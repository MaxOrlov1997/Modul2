package Modul2;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ShopService {
   static List<String> historyOrder = new ArrayList<>();
   static File file = new File("OrderFile.csv");
    public void writeListProduct() throws IOException {
        List <String> list= new ArrayList<>();
        File file = new File("ListProduct");
        Scanner scanner = new Scanner(file);
        int numPositionOrder =2; //ThreadLocalRandom.current().nextInt(1,6);
        for (int i = 0; i < numPositionOrder; i++) {
        while (scanner.hasNextLine()){
        int numStringONFile=1;
        int randomStringFile = ThreadLocalRandom.current().nextInt(1, 11);
        if(numStringONFile==randomStringFile){
            list.add(scanner.nextLine());
            break;
        }
            numStringONFile++;}}
        scanner.close();
        historyOrder.add(list.toString());
        writeOrderFile(list);
    }
    public static void writeOrderFile(List list) throws IOException {
        PersonService personService = new PersonService();
        String[] informationOfCheck = new String[3];
        informationOfCheck[0]= String.valueOf(LocalDateTime.now());
        informationOfCheck[1]=personService.generateNewCustomer().toString();
        informationOfCheck[2] = list.toString();
        FileWriter fileWriter = new FileWriter(file, true);;
        fileWriter.append(Arrays.toString(informationOfCheck));
            }
        }


