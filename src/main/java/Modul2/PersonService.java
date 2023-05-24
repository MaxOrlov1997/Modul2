package Modul2;
import java.util.concurrent.ThreadLocalRandom;

public class PersonService {
    public void generateNewCustomer(){
        Customer customer = new Customer();
        customer.age = ThreadLocalRandom.current().nextInt(10,40);
        customer.id = ThreadLocalRandom.current().nextInt(100, 1000);
        //customer.email =
    }

}
