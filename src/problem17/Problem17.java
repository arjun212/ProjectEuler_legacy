package problem17;

//Answer = 21124

public class Problem17 {

	public static String convertToWord(int x) {
		if (x < 20) {
			//between 1-19
			switch (x) {
			case 0:
				return "";
			case 1:
				return "one";
			case 2:
				return "two";
			case 3:
				return "three";
			case 4:
				return "four";
			case 5:
				return "five";
			case 6:
				return "six";
			case 7:
				return "seven";
			case 8:
				return "eight";
			case 9:
				return "nine";
			case 10:
				return "ten";
			case 11:
				return "eleven";
			case 12:
				return "twelve";
			case 13:
				return "thirteen";
			case 14:
				return "fourteen";
			case 15:
				return "fifteen";
			case 16:
				return "sixteen";
			case 17:
				return "seventeen";
			case 18:
				return "eighteen";
			case 19:
				return "nineteen";
			}
		} else if (x < 100) {
			//between 20-99
			String start = "";
			switch (x - (x%10)) {
			case 20:
				start = "twenty ";
				break;
			case 30:
				start = "thirty ";
				break;
			case 40:
				start = "forty ";
				break;
			case 50:
				start = "fifty ";
				break;
			case 60:
				start = "sixty ";
				break;
			case 70:
				start = "seventy ";
				break;
			case 80:
				start = "eighty ";
				break;
			case 90:
				start = "ninety ";
				break;
			}
			start += convertToWord(x%10);
			return start;
		} else if (x < 1000) {
			//between 20-99
			String start = "";
			switch (x - (x%100)) {
			case 100:
				start = "one hundred and ";
				break;
			case 200:
				start = "two hundred and ";
				break;
			case 300:
				start = "three hundred and ";
				break;
			case 400:
				start = "four hundred and ";
				break;
			case 500:
				start = "five hundred and ";
				break;
			case 600:
				start = "six hundred and ";
				break;
			case 700:
				start = "seven hundred and ";
				break;
			case 800:
				start = "eight hundred and ";
				break;
			case 900:
				start = "nine hundred and ";
				break;
			}
			if (x%100 != 0) {
			start += convertToWord(x%100);
			} else {
				start = start.substring(0, start.length()-4);
			}
			return start;
		} else if (x == 1000) {
			return "one thousand";
		}
		return "ERROR";
	}
	
	
	public static int sizeWord(String x) {
		String a = x.replaceAll("\\s+","");
		return a.length();
	}

	public static void main(String[] args) {
		int acc = 0;
		for (int i = 1; i <= 1000; i++) {
			acc += sizeWord(convertToWord(i));
		}
		System.out.println(acc);
	}
}
