package scenarios;


import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.Login_Logout;

public class Login extends ApplicationKeywords{

	BaseClass obj;
	private Boolean status = false;
	Login_Logout loginLogout;
	
	public Login(BaseClass obj){
		super(obj);
		this.obj=obj;
	}
	
	public void loginToApplication(String brm) {		
		
		loginLogout=new Login_Logout(obj);
		String strUsername=getConfigProperty("UserName");
		String strPassword=getConfigProperty("Password");
		loginLogout.login(strUsername, strPassword);
		
		if(loginLogout.testFailure){
			status = true;
		}
		this.testFailure=status;
	}
}
