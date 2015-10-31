/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael Githinji
 */
import java.text.ParseException;
import java.util.*;

public class Date implements Comparable<Date> {

	private static int NEXT_YEAR = 2016;
	private static HashSet<Integer> monthsWith31Days = new HashSet<Integer>(
			Arrays.asList(new Integer[]{1, 3, 5, 7, 8, 10, 12}));

	private int day;
	private int month;
	private int year;
	
	private boolean isValidDate;

	public Date() {
		initDate();
	}

	public Date(String dateStr) {
		try {
			validate(dateStr);
			convert(dateStr);
			this.isValidDate = true;
		} catch (ParseException e) {
			initDate();
			this.isValidDate = false;
		}
	}

	public boolean isValidDate() {
		return isValidDate;
	}

	protected void initDate() {
		this.day = 1;
		this.month = 1;
		this.year = 1900;
	}

	protected void validate(String dateStr) throws ParseException {
		StringTokenizer st = new StringTokenizer(dateStr, "/");
		if (st.countTokens() == 3) {
			try {
				int month = Integer.parseInt(st.nextToken());
				int day = Integer.parseInt(st.nextToken());
				int year = Integer.parseInt(st.nextToken());

				boolean monthValid = month > 0 && month <= 12;
				boolean yearValid = year >= 1900 && year < NEXT_YEAR;

				if (monthValid && yearValid) {
					boolean isLeapYear = (year % 400 == 0)
							|| ((year % 4 == 0) && (year % 100 != 0));
					int maxFebDate = isLeapYear ? 29 : 28;
					int maxMonthDate = month == 2
							? maxFebDate
							: (monthsWith31Days.contains(month) ? 31 : 30);
					boolean dayValid = day > 1 && day <= maxMonthDate;
					if (dayValid) {
						return;
					}
				}

			} catch (NumberFormatException e) {
				throw new ParseException("Invalid Date Format", 0);
			}
		} else {
			throw new ParseException("Invalid Date Format", 0);
		}
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	protected void convert(String dateStr) {
		StringTokenizer st = new StringTokenizer(dateStr, "/");
		month = Integer.parseInt(st.nextToken());
		day = Integer.parseInt(st.nextToken());
		year = Integer.parseInt(st.nextToken());

	}

	@Override
	public int compareTo(Date other) {
		int result;
		if (this.year < other.year) {
			result = -1;
		} else if (this.year > other.year) {
			result = 1;
		} else {
			
			if (this.month < other.month) {
				result = -1;
			} else if (this.month > other.month) {
				result = 1;
			} else {
				if (this.day < other.day) {
					result = -1;
				} else if (this.day > other.day) {
					result = 1;
				} else {
					result = 0;
				}
			}
		}

		return result;
	}
	
	@Override
	public String toString() {
		return String.format("%s/%s/%s", month, day, year);
	}
}
