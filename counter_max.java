package elementsprocess;

public class CounterMax extends Counter {
	
	private int max;

	/**
	 * 
	 * @param value
	 * @param max
	 */
	
	public CounterMax(int value, int max) {
		super(value);
		this.max = max;
	}
	
	public void increment() {
		if (getValue() < max) {
			super.increment();
		} 
	}

	public String toString() {
		return "CounterMax [value=" + getValue() +"]";
	}

	protected int getMax() {
		return max;
	}
}
