package common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.Test;

public class TestNGHooks implements ITestListener {

	@Test
	public static void getBrowserName(ITestContext context) {
		String myParameter = context.getCurrentXmlTest().getParameter("browser");
		System.out.println("The value of myParameter is: " + myParameter);
	}
}
