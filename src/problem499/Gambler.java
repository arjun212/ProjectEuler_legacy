package problem499;

public class Gambler {

	int originalFortune;
	
	int currentFortune;
	
	public Gambler(int S) {
		originalFortune = S;
		currentFortune = S;
	}
	
	public void reset() {
		currentFortune = originalFortune;
	}
	
	public void gain(int x) {
		currentFortune += x;
	}
	
	public boolean canPay(int x) {
		return (currentFortune >= x);
	}
	
	public void pay(int x) {
		currentFortune -= x;
	}
	
	public String toString() {
		return String.valueOf(currentFortune);
	}
	
}
