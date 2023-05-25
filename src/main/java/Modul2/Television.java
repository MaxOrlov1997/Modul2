package Modul2;


public class Television {
    String series;
    double diagonal;
    String screenType;

    String country;
    double price;
    public void exseption(){
if(series==null|| diagonal==0|| screenType==null||country==null|| price==0){
    throw new RuntimeException("Некоректная строка");
}
    }
}
