package support;

import org.testng.asserts.Assertion;

public class assertion {
	
	Assertion hardassert = null;
	
	public assertion (){
		hardassert = new Assertion();
//		SoftAssert softAssert = new SoftAssert();
	}
	
	public void fail(String message){
		System.out.println("[Failed]"+message);
		hardassert.fail(message);
		
	}
	
	public void pass(String message){
		System.out.println("[Passed]"+message);
		
	}
	
	
}
