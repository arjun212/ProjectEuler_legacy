package problem499;

public class Pot {
	
	int value;
	
	public Pot() {
		value = 1;
	}
	
	public void doublePot() {
		value *= 2;
	}

	public int takePot() {
		int val = value;
		value = 0;
		return val;
	}

	public void reset() {
		value = 1;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
}
