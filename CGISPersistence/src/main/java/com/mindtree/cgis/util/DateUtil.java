package com.mindtree.cgis.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date convertToDateFormart(String dateString) {

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}


	public static Date convertToDateFormartWithTimeStamp(String dateString) {

		Date convertedDate = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// DateFormat df = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss");

		try {
			// convertedDate = (Date)new
			// SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(dateString);
			convertedDate = df.parse(dateString);
			System.out.println(convertedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return convertedDate;

	}

	public static Date getDatebyFormatyyyyMMdd(Date date) {

		Calendar now = Calendar.getInstance();
		now.setTime(date);

		String day = Integer.toString(now.get(Calendar.DATE));
		if (day.length() == 1)
			day = "0" + day;
		String month = Integer.toString(now.get(Calendar.MONTH) + 1);
		if (month.length() == 1)
			month = "0" + month;
		String dateString = now.get(Calendar.YEAR) + "-" + month + "-" + day;

		Date dateNew = null;
		try {
			dateNew = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			// dateNew = Timestamp.valueOf(dateString+" 00:00:00");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dateNew;

	}

	
}
