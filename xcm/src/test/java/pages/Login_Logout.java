package pages;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

public class Login_Logout extends ApplicationKeywords{

	private static final String input_username="Username #cssSelector=input[id='Email']";
	private static final String input_password="Password #cssSelector=input[id='Password']";
	private static final String button_login="Login button #cssSelector=button[type='submit']";
	private static final String form_login="Login page #cssSelector=form[class='xcm-login']";
	private static final String button_addTask="Add Task #cssSelector=div[id=addTask]";
	private static final String link_profile="Profile link #cssSelector=div[id='profilelnk']";
	private static final String link_logoff="Log off #cssSelector=div[class='menu transition visible'] a:last-child";
	private static final String server_Name="#cssSelector=div.xcm-left-wrap p";
	
	public Login_Logout(BaseClass obj){
		super(obj);
	}
	
	/* 
	 * @param	:strUsername => application username
	 * 			:strPassword	=> application password
	 * @method  :enters login credentials and validates the Home page 
	 * @author 	:Suresh Kumar Ch
	 * @since  	:26/04/2019   
	 */
	
	public void login(String strUsername, String strPassword)
	{
		try{
			if(isElementPresent(form_login))
			{
				int serverlen=getText(server_Name).split(". ").length;
				testStepInfo("Server Details : "+getText(server_Name).split(". ")[serverlen-1]);
				System.out.println("Server Details : "+getText(server_Name).split(". ")[serverlen-1]);
				typeIn(input_username, strUsername);
				typeIn(input_password, strPassword);			
				clickOn(button_login);			
				if(isElementPresent(button_addTask)){
					testStepPassed("Home page is displayed");
				}
				else
				{
					testStepFailed("Home page failed to diplay");
				}
			}
			else{
				testStepFailed("Login page failed to display");
			}
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/*
	 *  @method	:expands Profile menu and selects logoff 
	 *  @author	:Suresh Kumar Ch 
	 *  @since	:26/04/2019
	 */
	
	public void logout()
	{
		try{
			if(isElementPresent(link_profile)){
				clickOn(link_profile);
				if(isElementPresent(link_logoff)){
					clickOn(link_logoff);
				}
				else{
					testStepFailed("Logoff option failed to display in drop down for Profile link");
				}
			}
			else{
				testStepFailed("Profile link failed to display in Home page");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
}
