package test;

import java.util.Calendar;

public class test1 {
	
	public static void main(String[] args) {
		
		Calendar mCalendar = Calendar.getInstance();
		mCalendar.setFirstDayOfWeek(Calendar.MONDAY);
		
		System.out.println(mCalendar.get(Calendar.YEAR));
		System.out.println(mCalendar.get(Calendar.MONTH));
		System.out.println(mCalendar.get(Calendar.DAY_OF_MONTH));

		
		System.out.println(mCalendar.getFirstDayOfWeek());
		
		
//		System.out.println(mCalendar.get(Calendar.DAY_OF_YEAR));
		System.out.println(mCalendar.get(Calendar.DAY_OF_WEEK));
//		System.out.println(mCalendar.get(Calendar.WEEK_OF_YEAR));
//		System.out.println(mCalendar.get(Calendar.MONTH));
		
		
	}

}
