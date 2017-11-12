import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomerRecords {
    private Map<String, Customer> records;

    public CustomerRecords() {
        this.records = new HashMap<String, Customer>();
    }

    public void addCustomer(Customer c) {
        this.records.put(c.getName(), c);
    }

    public Map<String, Customer> getCustomers() {
    /*	 Breaking encapsulation !!!
		 return this.records;
		 use unmodifiableCollections instead
		 */
        return Collections.unmodifiableMap(this.records);
    }

   /* public Customer getCustomerByName(String name){
        return this.records.get(name);
    }*/

  /* Avoiding escaping references*/
    public CustomerReadOnly getCustomerByName(String name){
        return this.records.get(name);

    }
}
