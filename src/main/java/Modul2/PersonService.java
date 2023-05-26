package Modul2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PersonService {
    public List<String> generateNewCustomer(){
        Customer customer = new Customer();
        List<String> list = new ArrayList<>();
        customer.age = ThreadLocalRandom.current().nextInt(10,40);
        customer.id = ThreadLocalRandom.current().nextInt(100, 1000);
        customer.email ="Nata";
        list.add(String.valueOf(customer.id));
        list.add(String.valueOf(customer.age));
        list.add(customer.email);
        return list;
    }

}
