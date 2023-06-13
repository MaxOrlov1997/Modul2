package Modul2.AllTask;

import Modul2.FillFile.ShopService;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Invoice {
    static double limitPrice = 1000;
    static String type;
    static String stringOnFile;

    public static void main(String[] args) throws IOException {
        ShopService shopService = new ShopService();
        File file = new File("OrderFile.csv");
        shopService.writeSaleInformation(file);
        countSaleProduct(file);
        amountSmallCheckBuyer(file);
        oneTypeProduct(file);
        firstThreeCheck(file);
        ageNoEighteenEars(file);
    }


    public static void ageNoEighteenEars(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<String> noEighteenEars = new ArrayList<>();
        while (scanner.hasNextLine()) {
            stringOnFile = scanner.nextLine();
            String[] arrayInformationFile = stringOnFile.split(",");
            if (Integer.parseInt(arrayInformationFile[1].replaceAll("\\s", "")) < 18) {
                noEighteenEars.add(stringOnFile);
            }
        }
        System.out.println("Покупатели меньше 18 лет ->");
        noEighteenEars.forEach(System.out::println);
    }

    public static void firstThreeCheck(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<String> firstThreeCheck = new ArrayList<>();
        while (scanner.hasNextLine()) {
            firstThreeCheck.add(scanner.nextLine());
        }
        System.out.println("Первые три чека ->");
        firstThreeCheck.stream().limit(3).forEach(System.out::println);
    }

    public static void oneTypeProduct(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<String> onlyOneTypeProduct = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String stringOnFile = scanner.nextLine();
            int numSoldTelevision = (int) Arrays.stream(stringOnFile.split(",")).
                    filter(x -> x.contains("Telephone")).count();
            int numSoldTelephone = (int) Arrays.stream(stringOnFile.split(",")).
                    filter(x -> x.contains("Television")).count();
            if (numSoldTelephone == 0 && numSoldTelevision != 0 ||
                    numSoldTelevision == 0 && numSoldTelephone != 0) {
                onlyOneTypeProduct.add(stringOnFile);
            }
        }
        System.out.println("Чеки с одинаковыми товарами ->");
        onlyOneTypeProduct.forEach(System.out::println);
        scanner.close();
    }

    public static void amountSmallCheckBuyer(File file) throws FileNotFoundException {
        TreeMap<Double, String> ollInformationBuyerAndCheck = new TreeMap<>();
        Scanner scanner = new Scanner(file);
        int checkCounterRetail = 0;
        while (scanner.hasNextLine()) {
            String stringOnFile = scanner.nextLine();
            String[] arrayInformationFile = stringOnFile.split(",");
            String informationBuyer = arrayInformationFile[0] + arrayInformationFile[1] + arrayInformationFile[2];
            String[] arrayInformationBuyer = informationBuyer.split(" ");
            double nextSum = 0;
            for (int i = 8; arrayInformationFile.length >= i; i += 7) {
                nextSum += Double.parseDouble(StringUtils.removeEnd(arrayInformationFile[i], "]"));
            }
            ollInformationBuyerAndCheck.put(nextSum, arrayInformationBuyer[1] + " "
                    + arrayInformationBuyer[2] + " " + arrayInformationBuyer[3]);
            type = (nextSum > limitPrice) ? "wholesale" : "retail";
            if (type.equals("retail")) {
                ++checkCounterRetail;
            }
        }
        System.out.println("Наименшая сумма чека и информация о покупателе "
                + ollInformationBuyerAndCheck.firstEntry());
        System.out.println("Количество чеков retail " + checkCounterRetail);
        scanner.close();
    }

    public static void countSaleProduct(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int numSold = 0;
        while (scanner.hasNextLine()) {
            String stringOnFile = scanner.nextLine();
            int numSoldTelevision = (int) Arrays.stream(stringOnFile.split(",")).
                    filter(x -> x.contains("Telephone")).count();
            int numSoldTelephone = (int) Arrays.stream(stringOnFile.split(",")).
                    filter(x -> x.contains("Television")).count();
            numSold += numSoldTelephone + numSoldTelevision;
        }
        scanner.close();
        System.out.println("Количество проданных товаров " + numSold);
    }
}
