
import java.util.HashMap;
import java.util.Map;

public class Price {

	private Map<String,Double> rates;
	private Double value;
	
	public Price(Double value) {
		this.value = value;
		rates = new HashMap<String,Double>();
		rates.put("USD", 1d);
		rates.put("GBP", 0.6);
		rates.put("EUR", 0.8);
	}

	//We are mutating value in get... method  !!!
	public Double convert(String toCurrency) {
		
		if (toCurrency.equals("USD")) {
			return value;
		}
		else {
			Double conversion = rates.get("USD") / rates.get(toCurrency);
			/*value = conversion * value;
			return value;*/

			return conversion * value;

		}
	}
	
	public String toString() {
		return this.value.toString();
	}

	/* escaping reference !!!
	public Map<String,Double> getRates() {
		return rates;
	}*/

	public Double getRates(String currency) {
		return rates.get(currency);
	}
	
}
