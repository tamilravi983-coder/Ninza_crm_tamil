package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class WorkingwithAssertion {
	@Test
	public void T1() {
		System.out.println("start");
		String S=null;
		Assert.assertNull(S);
		System.out.println("end");
		
		//Assert.assertTrue("hfdc".equals("hdfc"));
				//Assert.assertFalse("hfdc".equals("hdfc"));
		//Assert.assertEquals("hdfc", "hfdc");
		//Assert.assertNotEquals("hfdc","hdfc");
		//Assert.assertNotNull(S);--->it pass if the value is not null
		//assertnull-->it pass if it is null 
		//String S="tamil";
		//Assert.assertNotNull(S);
		//String S=null;
		//Assert.assertNotNull(S);
		
	}
@Test
public void Nonstatic() {
	SoftAssert soft = new SoftAssert();
	System.out.println("start");
	soft.assertFalse("hfdc".equals("hdfc"));
	System.out.println("end");

	//soft.assertTrue("hfdc".equals("hdfc"));//if it is true means pass,else fail
	//assertfalse means if condition is fails it pass
	//soft.assertEquals("hfdc", "hdfc");if it is equals means pass
	soft.assertAll();//if we give assertall only then only it fails,or else it will pass,to backup all assertall is used;
	
}

}
