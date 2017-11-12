import java.util.UUID;


public class GenerateCustomerTask implements Runnable {

	private CustomerManager cm;
	private int totalCustomersGenerated = 0;
	
	public GenerateCustomerTask(CustomerManager cm) {
		this.cm = cm;
	}
	
	@Override
	public void run() {
		while (true) {		
		try {
			Thread.sleep((1));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Simulate user adding a customer through a web page
		String name = new UUID(1l,10l).toString();
		Customer c = new Customer(name);
		cm.addCustomer(c);
		totalCustomersGenerated++;
		cm.getNextCustomer();
		//System.out.println(totalCustomersGenerated);
		}
	}

}

