package charles.test.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderBeforeAfter {

	public static void main(String[] args) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1= sdf.parse("2009-12-31");
			Date date2 = sdf.parse("2010-01-31");
			
			System.out.println(sdf.format(date1));
			System.out.println(sdf.format(date2));
			
			
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date1);
			
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date2);
			
			if(cal1.after(cal2)){
				System.out.println("date1 is after then date2");
			}
			
			if(cal1.before(cal2)){
				System.out.println("date1 is before then date2");
			}
			
			if(cal1.equals(cal2)){
				System.out.println("date1 is eequal date2");
			}
			

		}catch(Exception e){
			
		}

	}

}
