package iSAFE;

import baseClass.BaseClass;


public class TestDriver extends ApplicationKeywords {

	public TestDriver(BaseClass obj) {
		super(obj);
	}

	public static void main(String[] args) {
		try {
			
		} catch (Exception e) {
			writeToLogFile("error", e.toString());
		}
	}
}