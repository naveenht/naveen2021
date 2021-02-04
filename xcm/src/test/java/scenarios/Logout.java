package scenarios;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.Login_Logout;

public class Logout extends ApplicationKeywords{
	
	BaseClass obj;
	private Boolean status = false;
	Login_Logout loginLogout;
	
	public Logout(BaseClass obj){
		super(obj);
		this.obj=obj;
	}
	
	public void logout()
	{
		loginLogout=new Login_Logout(obj);
		loginLogout.logout();

		if(loginLogout.testFailure)
		{
			status = true;
		}
		this.testFailure=status;
	}
}
