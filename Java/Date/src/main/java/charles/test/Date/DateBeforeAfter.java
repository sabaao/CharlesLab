package charles.test.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBeforeAfter {

	public static void main(String[] args) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1= sdf.parse("2009-12-31");
			Date date2 = sdf.parse("2010-01-31");
			
			System.out.println(sdf.format(date1));
			System.out.println(sdf.format(date2));
			
			if(date1.after(date2)){
				System.out.println("date1 is after then date2");
			}
			
			if(date1.before(date2)){
				System.out.println("date1 is before then date2");
			}
			
			if(date1.equals(date2)){
				System.out.println("date1 is eequal date2");
			}
			

		}catch(Exception e){
			
		}

	}

}
