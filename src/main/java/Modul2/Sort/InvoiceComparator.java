package Modul2.Sort;

import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class InvoiceComparator {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("OrderFile.csv");
        sortAll(file);
    }

    public static void sortAll(File file) throws FileNotFoundException {
        List<SomeToAgeSort> sortAge = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String stringOnFile = scanner.nextLine();
            String[] arrayInformationFile = stringOnFile.split(",");
            double nextSum = 0;
            for (int i = 8; arrayInformationFile.length >= i; i += 7) {
                nextSum += Double.parseDouble(StringUtils.removeEnd(arrayInformationFile[i], "]"));
            }
            int numSoldTelevision = (int) Arrays.stream(stringOnFile.split(",")).
                    filter(x -> x.contains("Telephone")).count();
            int numSoldTelephone = (int) Arrays.stream(stringOnFile.split(",")).
                    filter(x -> x.contains("Television")).count();
            int numSold = numSoldTelephone + numSoldTelevision;
            int agePerson = Integer.parseInt(arrayInformationFile[1].replaceAll("\\s", ""));
            sortAge.add(new SomeToAgeSort(stringOnFile, agePerson, numSold, nextSum));
        }
        sortAge.stream().sorted(Comparator.comparingInt(SomeToAgeSort::getAgePerson))
                .sorted(Comparator.comparing(SomeToAgeSort::getNumSold))
                .sorted(Comparator.comparingDouble(SomeToAgeSort::getNextSum))
                .forEach(it -> System.out.println(it.getStringOnFile()));
    }
}
