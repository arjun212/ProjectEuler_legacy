package problem19;

import java.util.Arrays;
import java.util.List;

//Answer = 171

public class Problem19 {
	// Start = 1st Jan 1900 = 01011900 = Monday
	// DateFormat = DDMMYYYY

	public static String dateFormat(int day, int month, int year) {
		String d = (day < 10) ? "0" + String.valueOf(day) : String.valueOf(day);
		String m = (month < 10) ? "0" + String.valueOf(month) : String
				.valueOf(month);
		String y = String.valueOf(year);
		return d + m + y;
	}

	public static boolean isLeapYear(int year) {
		return ((year % 4 == 0) && (year % 100 != 0));
	}

	public static String getNextDate(String current) throws Exception {
		int day = Integer.parseInt(current.substring(0,2));
		int month = Integer.parseInt(current.substring(2,4));
		int year = Integer.parseInt(current.substring(4,8));
		
		List<Integer> SAJN = Arrays.asList(4,6,9,11);
		List<Integer> JMMJAOD = Arrays.asList(1,3,5,7,8,10,12);
		List<Integer> F = Arrays.asList(2);
		
		if (F.contains(month)) {
			//Feb
			if ((day < 28)) {
				return dateFormat(day+1, month, year);
			} else if (day == 29) {
				return dateFormat(1, month+1, year);
			} else {
				if (isLeapYear(year)) {
					return dateFormat(day+1, month, year);
				} else {
					return dateFormat(1, month+1, year);
				}
			}
		} else if (SAJN.contains(month)) {
			//30 Days
			if (day < 30) {
				return dateFormat(day+1, month, year);
			} else {
				return dateFormat(1, month+1, year);
			}
		} else if (JMMJAOD.contains(month)) {
			//31 Days
			if (day < 31) {
				return dateFormat(day+1, month, year);
			} else {
				if (month == 12) {
					return dateFormat(1,1,year+1);
				} else {
					return dateFormat(1, month+1, year);
				}
			}
		}
		System.out.println("THROWING EXCEPTION FOR DATE " + dateFormat(day, month, year));
		throw new Exception();
	}

	public static boolean isSunday(int daysSinceStart) {
		//First sunday offset by 5
		return (daysSinceStart % 7 == 5);
	}
	
	public static boolean isFirstOfMonth(String date) {
		return (Integer.parseInt(date.substring(0,2)) == 1);
	}
	
	public static void main(String[] args) throws Exception {
		
		String current = "01011901";
		int count = 0;
		int daysSinceStart = 0;
		while (!current.equals("01012001")) {
			if ((isSunday(daysSinceStart)) && (isFirstOfMonth(current))) {
				count++;
				System.out.println(current);
			}
			current = getNextDate(current);
			daysSinceStart++;
		}
		
		System.out.println(count);
	}

}
