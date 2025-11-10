package genericutilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
//pure java concepts are stored here

public class Javautility {
	public String getrequireddate(int days){
	Date date = new Date();
	//have to give MM in caps only,then only works(mam gives dd-MM-yyyy)
	SimpleDateFormat sim = new SimpleDateFormat("MM-dd-yyyy");
	sim.format(date);
	Calendar cal = sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,days);
	String requiredDate = sim.format(cal.getTime());
 return requiredDate;

}
	public int generateninedigitnumber() {
		Random random = new Random();
		int randomnum=random.nextInt(100000000,999999999);
		return randomnum;
		
	}
	
	public String getcurrentdateandtime() {
		Date d = new Date();
		//replace the  space and : with _here
		String date = d.toString().replace(" ", "_").replace(":", "_");
		return date;
	}
}
