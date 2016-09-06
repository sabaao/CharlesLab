package charles.test.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCompare {

	public static void main(String[] args) {
		try{
			/**
			 * return value is 0 if both dates are equal
			 * return value is greater than 0, if Date is after the date argument
			 * return values is less than 0, if date is before the date argument
			 */
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1= sdf.parse("2009-12-31");
			Date date2 = sdf.parse("2010-01-31");
			
			System.out.println(sdf.format(date1));
			System.out.println(sdf.format(date2));
			
			int result = date1.compareTo(date2);
			if(result>0){
				System.out.println("date1 is after then date2");
			}else if(result<0){
				System.out.println("date1 is before then date2");
			}else if(result==0){
				System.out.println("date1 is eequal date2");
			}
		}catch(Exception e){
			
		}

	}

}
