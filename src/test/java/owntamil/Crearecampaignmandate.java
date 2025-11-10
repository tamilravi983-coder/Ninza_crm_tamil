package owntamil;

import java.io.IOException;

import genericutilities.Excelfileutility;
import genericutilities.propertyfileutility;
import objectrepository.Loginpage;

public class Crearecampaignmandate {

	public static void main(String[] args) throws IOException {
		propertyfileutility plib = new propertyfileutility();
		Excelfileutility elib = new Excelfileutility();
		
		
		String CAMPAIGN_NAME = elib.readdatafromexcelfile("campaign", 1, 2);
		String TARGET_SIZE = elib.readdatafromexcelfile("campaign", 1, 3);
		String TOAST_MSG = elib.readdatafromexcelfile("campaign", 1, 4);
		
		
		
		
		
		
		
		
		
		

	}

}
