package problem499;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem499 {

	final static int M = 2; // Cost of Game
	final static int T = 1; // Threshold
	final static int repeats = 1000; // Repeats of Experiment
//	static int OriginalS = 2;
//	static int S; // Gamblers fortune
	static Gambler g = new Gambler(2);
	static Pot pot = new Pot();

	

	public static boolean canPlay() {
		return (g.canPay(M));
	}

	public static boolean flipCoin() {
		// True = Heads, False = Tails
		Random rand = new Random();
		return (rand.nextInt(2) == 0);
	}

	public static void playOneGame() {
		if (canPlay()) {
			g.pay(M);;
			while (flipCoin()) {
				pot.doublePot();
			}
			g.gain(pot.takePot());
		}
	}

	public static int playGames() {
		// Returns whether Gambler will win infinitely
		int turns = 0;
		while (canPlay()) {
			playOneGame();
			turns++;

		}
		return turns;
	}

	public static void print() {
		System.out.println("\n");
		System.out.println("Pot is worth : " + pot);
		System.out.println("Gambler is worth : " + g);
	}

	public static int avg(List<Integer> result) {
		int sum = 0;
		for (Integer i : result) {
			sum += i;
		}
		return sum / result.size();
	}
	
	public static void reset(){
		pot.reset();
		g.reset();
	}

	public static void main(String[] args) {
		List<Integer> results = new ArrayList<Integer>();
		System.out.println(playGames());
		for (int i = 0; i < repeats; i++) {
			int x = playGames();
			System.out.println(x);
			results.add(x);
			reset();
		}
		System.out.println("Average Is : " + avg(results));
	}
}
