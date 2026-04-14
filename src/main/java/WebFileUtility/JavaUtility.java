package WebFileUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random ran = new Random();
		int ranNum = ran.nextInt(10000);
		return ranNum;
	}

	public String getSystemdate() {
		Date dateobj = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateobj);
		return date;
	}

	public String getRequiredDate(int days) {
		Date dateobj = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf1.format(dateobj); 
		Calendar cal = sdf1.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate = sdf1.format(cal.getTime());
		return reqDate;
	}
}


