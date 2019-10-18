import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DF
import org.openqa.selenium.WebElement
import org.openqa.selenium.Cookie
import com.kazurayam.webdriverfactory4ks.ChromeDriverFactory
import com.kazurayam.webdriverfactory4ks.ChromeProfileFinder
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.firefox.ProfilesIni






if (Env == 'preprod') {
	URLlink = 'https://preprod360-www.telenettv.be'
	
} else if (Env == 'prod') {
	URLlink = 'https://www.telenettv.be/en.html'
} else {
	URLlink = 'NA'

	GlobalVariable.G_LOGINRESULT = 'INVALID'
}

GlobalVariable.G_Env = Env
GlobalVariable.G_UserName = UserName
GlobalVariable.G_Password = Password

if (URLlink != 'NA') {
	
	Map m = RunConfiguration.getExecutionProperties()
	String browser = m.get("drivers").get("system").get("WebUI").get("browserType")
	println " browser" + browser
	
	
	if(GlobalVariable.G_Cookies == "ON"){
		if(browser == "CHROME_DRIVER"){
		ChromeDriverFactory cdFactory = new ChromeDriverFactory()
		WebDriver driver = cdFactory.openChromeDriverWithProfileDirectory('Profile 3')
		assert driver != null
		DriverFactory.changeWebDriver(driver)
		driver.get(URLlink)
		}
		else if(browser == "FIREFOX_DRIVER"){
			def driverDir = RunConfiguration.getProjectDir() + '/Drivers/geckodriver'
			System.setProperty("webdriver.gecko.driver",
				driverDir);
			ProfilesIni profile = new ProfilesIni();
            FirefoxProfile FF = profile.getProfile("Katalon");
			FirefoxOptions optionsFF = new FirefoxOptions().setProfile(FF);
			WebDriver driver = new FirefoxDriver(optionsFF);
			WebUI.closeBrowser()
			DriverFactory.changeWebDriver(driver)	
			driver.get(URLlink)
			//WebUI.openBrowser(URLlink)
		}
		else if(browser == "SAFARI_DRIVER"){
		
			WebUI.openBrowser(URLlink)
	 }
	}
	else{
	WebUI.openBrowser(URLlink)
	}
	

	WebUI.delay(5)

	WebUI.maximizeWindow()

	WebUI.delay(2)

	
	
	loginpageTitle = WebUI.getWindowTitle()

	print('\n Title Main   === ' + loginpageTitle)

	driver = DF.getWebDriver()
	

	mainwindowhandle = driver.getWindowHandle()

	print('\n Handle :' + mainwindowhandle)

	cookies_objs = WebUI.findWebElements(findTestObject('Object Repository/Page_Home/Obj_cookies'),2)
	
	if(cookies_objs.size()> 0){
	
	WebUI.click(findTestObject('Object Repository/Page_Home/Obj_cookies'))


	WebUI.click(findTestObject('Object Repository/Page_Home/obj_Log in'))

	WebUI.switchToWindowTitle('Telenet: Meld je aan')

	loginpageTitle = WebUI.getWindowTitle()

	print('\n Title Login   === ' + loginpageTitle)

	loginwindowhandle = driver.getWindowHandle()

	print('\n Login Handle :' + loginwindowhandle + '\n')

	allhandles = driver.getWindowHandles()

	print('\n All Handles :' + allhandles + '\n')


	WebUI.setText(findTestObject('Page_Login2/obj_Login_username'), UserName)

	WebUI.setText(findTestObject('Page_Login2/obj_Login_password'), Password)

	WebUI.click(findTestObject('Page_Login2/obj_SignIn'))

	WebUI.delay(5)
	allhandles = driver.getWindowHandles()

	print('\n All Handles again:' + allhandles + '\n')

	if(loginwindowhandle in allhandles){



		err_msgs = WebUI.findWebElements(findTestObject('obj_Login_Err_Msg'), 1)

		if (err_msgs.size() > 0) {
			if (WebUI.verifyElementPresent(findTestObject('obj_Login_Err_Msg'), 2, FailureHandling.CONTINUE_ON_FAILURE)) {
				WebUI.verifyElementText(findTestObject('obj_Login_Err_Msg'), ErrMsg, FailureHandling.CONTINUE_ON_FAILURE)

				GlobalVariable.G_LOGINRESULT = 'FALSE'
				WebUI.closeBrowser()
			}
		}
		else {
			'To check the succseful accepting username and password'
			dtv_identifier = WebUI.findWebElements(findTestObject('opj_Radio_dtv_identifier'), 2)

			if (dtv_identifier.size() > 0) {
				'Select the package option '
				WebUI.click(findTestObject('opj_Radio_dtv_identifier'), FailureHandling.OPTIONAL)

				'Click on LogON Button'
				WebUI.click(findTestObject('Page_Login2/obj_Submit'), FailureHandling.OPTIONAL)

				WebUI.delay(3)
			}
		}



	}

	   WebUI.switchToDefaultContent()
	} //check if user is already logged in 
	
	
	/*notifications_objects = WebUI.findWebElements(findTestObject('Object Repository/Notifications'), 1)
	if(notifications_objects.size()>0){
		for(WebElement e: notifications_objects){

			e.click()
			e.location

		}
	}*/
	
	//WebUI.click(findTestObject('Page_Home/link_Settings'))
	//WebUI.switchToDefaultContent()
	WebUI.delay(5)
	
	profile_list = WebUI.findWebElements(findTestObject('Page_Home/Page_Main/Share_Profile_span'), 1)
	if(profile_list.size()>0){
		result = WebUI.getText(findTestObject('Page_Home/Page_Main/Share_Profile_span'))

		substring_Result = result.substring(0, 14)

		print('Hello We have successfully logined')

		print 'substring' + substring_Result
		if (WebUI.verifyMatch('Shared Profile', substring_Result, true, FailureHandling.STOP_ON_FAILURE)) {
			GlobalVariable.G_LOGINRESULT = 'TRUE'
		}

	

	}






}
else{
	
	WebUI.closeBrowser()
}