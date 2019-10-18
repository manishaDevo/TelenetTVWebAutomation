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
import org.openqa.selenium.By

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory as DF


   GlobalVariable.G_movieAdded = 'false'
	

	WebUI.click(findTestObject('Page_Home/a_Movies  Series'))

	WebUI.delay(7)

	driver = DF.getWebDriver()

	allhandles = driver.getWindowHandles()

	print(('\n All Handles1 :' + allhandles) + '\n')

	WebUI.waitForElementClickable(findTestObject('Page_Discover/a_Movies'), 5)

	WebUI.click(findTestObject('Page_Discover/a_Movies'))

	WebUI.waitForPageLoad(5)

	allhandles = driver.getWindowHandles()

	print(('\n All Handles2 :' + allhandles) + '\n')

	//WebUI.waitForElementClickable(findTestObject('Page_Movies/img_Fantastic'), 5)

	WebUI.waitForElementClickable(mediaObj, 5)
	
	//TestObject tObj = findTestObject('Page_Films/img_Backtrace')
	//movie_Info = tObj.findPropertyValue('alt')
	//movie_Info = WebUI.getAttribute(findTestObject('Page_Movies/img_Fantastic'), 'alt')
	
	movie_Info = WebUI.getAttribute(mediaObj, 'alt')
	
	println(' Movie Info' + movie_Info)

	GlobalVariable.G_movieName = movie_Info[0..-8]

	println(' Movie Name' + GlobalVariable.G_movieName)

	//WebUI.click(findTestObject('Page_Movies/img_Fantastic'))

	WebUI.click(mediaObj)
	
	WebUI.waitForPageLoad(5)

	WebUI.waitForElementPresent(findTestObject('Page_Discover/Page_The Hangover Part II/button_Watchlist'), 7)

	if (WebUI.verifyElementPresent(findTestObject('Page_Discover/Page_The Hangover Part II/button_Watchlist'), 5, FailureHandling.OPTIONAL)) {
		def imgDir = RunConfiguration.getProjectDir() + '/Screenshots/Reference'

		name = (imgDir + '/watchlist_button_add.png')

		File file = new File(name)

		TestObject watchlist_btn = findTestObject('Page_Discover/Page_The Hangover Part II/button_Watchlist')

		boolean watchlist_add_diff = CustomKeywords.'utilities.KeywordHelper.compareImages'(watchlist_btn, file)

		watchlist_add_diff  = false
		
		if (!(watchlist_add_diff)) {
			WebUI.click(watchlist_btn)

			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_MovieNSeries/watchlist_notification'), 0)

			//WebUI.verifyElementText(findTestObject('Object Repository/Page_MovieNSeries/watchlist_notification'), 'Colette has been added to your watchlist.')
			GlobalVariable.G_movieAdded = 'true' /*WebUI.verifyElementPresent(findTestObject('Object Repository/Page_MovieNSeries/watchlist_notification'), 0)
			WebUI.verifyElementText(findTestObject('Object Repository/Page_MovieNSeries/watchlist_notification'), 'Colette has been removed from your watchlist.')
			*/
		} else {
			print(' Its already added in the system')

			GlobalVariable.G_movieAdded = 'already added'
		}
	}
	
	WebUI.delay(7)

	if (GlobalVariable.G_movieAdded != 'false') {
		allhandles = driver.getWindowHandles()

		print(('\n All Handles3 :' + allhandles) + '\n')

		//  WebUI.click(findTestObject('Page_Home/a_Movies  Series'))
		WebUI.click(findTestObject('Page_Home/a_Saved'))

		WebUI.delay(7)
		
		WebUI.waitForElementClickable(findTestObject('Page_Watchlist/tab_Watchlist'), 5)

		WebUI.click(findTestObject('Page_Watchlist/tab_Watchlist'))

		WebUI.waitForPageLoad(7)

		list = driver.findElements(By.xpath("//*[(text()='" + GlobalVariable.G_movieName + "')]"));
		/*if(list.size() > 0){
			
			print("Test case successsful")
		}
		*/
		TestObject obj = new TestObject()
		
		dynamic_xpath = "//*[(text() = '"+ GlobalVariable.G_movieName +"')]"
		
		obj.addProperty("xpath",ConditionType.EQUALS, dynamic_xpath )

		//obj.findProperty('xpath').setValue(movie_Info)
		
		WebUI.verifyElementPresent(obj, 5)
    }
  