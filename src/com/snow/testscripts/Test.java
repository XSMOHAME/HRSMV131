package com.snow.testscripts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Test {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("PST"));
		Date date = new Date();
		System.out.println(date.toString());
		System.out.println(date);
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, 2);
		calendar.add(Calendar.HOUR_OF_DAY, 2);
		System.out.println(dateFormat.format(calendar.getTime()));

		System.out.println(Calendar.DAY_OF_WEEK);

		String timeStamp = new SimpleDateFormat("dd-MM-YY-HH-mm-ss-S").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);

		Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-19");
		Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-11");

		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		System.out.println(Calendar.DAY_OF_WEEK);

		System.out.println(getWorkingDaysBetweenTwoDates(startDate, endDate, false));
	}

	public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate, boolean startToday) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int workDays = 0;

		if (Integer.parseInt(LocalTime.now().toString().split(":")[0]) <= 9 && startToday) {
			workDays++;
		}

		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		startCal.add(Calendar.DAY_OF_MONTH, 1);
		while (startCal.getTimeInMillis() < endCal.getTimeInMillis()) {
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				System.out.println("Calendar Start Time  - " + startCal.getTime());
				System.out.println("Calendar End Time  - " + endCal.getTime());

				++workDays;
				System.out.println(workDays);
			}

		}

		System.out.println(workDays);

		return workDays;
	}

}