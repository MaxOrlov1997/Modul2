package Modul2.Sort;

class SomeToAgeSort {
    private String stringOnFile;
    private int agePerson;
    private int numSold;
    private double nextSum;

    public SomeToAgeSort(String stringOnFile, int agePerson, int numSold, double nextSum) {
        this.stringOnFile = stringOnFile;
        this.agePerson = agePerson;
        this.numSold = numSold;
        this.nextSum = nextSum;
    }

    public int getAgePerson() {
        return agePerson;
    }

    public String getStringOnFile() {
        return stringOnFile;
    }

    public int getNumSold() {
        return numSold;
    }

    public double getNextSum() {
        return nextSum;
    }
}