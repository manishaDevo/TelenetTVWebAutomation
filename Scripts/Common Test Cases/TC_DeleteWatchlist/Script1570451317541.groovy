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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory as DF
        


WebUI.click(findTestObject('Page_Home/a_Saved'))

WebUI.delay(7)
		
WebUI.waitForElementClickable(findTestObject('Page_Watchlist/tab_Watchlist'), 5)

WebUI.click(findTestObject('Page_Watchlist/tab_Watchlist'))

WebUI.waitForPageLoad(7)

TestObject obj = new TestObject()

dynamic_xpath = "//*[(text() = '"+ GlobalVariable.G_movieName +"')]"

obj.addProperty("xpath",ConditionType.EQUALS, dynamic_xpath )

//obj.findProperty('xpath').setValue(movie_Info)

WebUI.verifyElementPresent(obj, 5)

/*movie_Info = WebUI.getAttribute(mediaObj, 'alt')

println(' Movie Info' + movie_Info)

GlobalVariable.G_movieName = movie_Info[0..-8]

println(' Movie Name' + GlobalVariable.G_movieName)*/


WebUI.click(obj)

WebUI.waitForElementPresent(findTestObject('Page_Discover/Page_The Hangover Part II/button_Watchlist'), 7)

if ( WebUI.verifyElementPresent(findTestObject('Page_Discover/Page_The Hangover Part II/button_Watchlist'), 2, FailureHandling.STOP_ON_FAILURE)        ) {
	WebUI.click(findTestObject('Page_Discover/Page_The Hangover Part II/button_Watchlist'))

	WebUI.verifyElementPresent(findTestObject('Object Repository/Page_MovieNSeries/watchlist_notification'), 1)

	//WebUI.verifyElementText(findTestObject('Object Repository/Page_MovieNSeries/watchlist_notification'), 'Colette has been added to your watchlist.')
	GlobalVariable.G_movieDeleted = 'true'
	WebUI.verifyElementPresent(findTestObject('Object Repository/Page_MovieNSeries/watchlist_notification'), 0)
	WebUI.verifyElementText(findTestObject('Object Repository/Page_MovieNSeries/watchlist_notification'), GlobalVariable.G_movieName + ' has been removed from your watchlist')
	
} else {
	print(' Its not there in watchlist')

	GlobalVariable.G_movieDeleted = 'already deleted'
}

	/*	def imgDir = RunConfiguration.getProjectDir() + '/Screenshots/Reference'

		browser_name = CustomKeywords.'utilities.KeywordHelper.getBrowserAndVersion'()
		
		name = ""
		
		if(browser_name == "chrome"){
			name = (imgDir + '/watchlist_button_tick_Chrome.png')
		}
		else if(browser_name == "firefox"){
			name = (imgDir + '/watchlist_button_tick_firefox.png')
		
		}
		else{
		name = (imgDir + '/watchlist_button_tick.png')
		}
		
		File file = new File(name)

		TestObject watchlist_btn = findTestObject('Page_Discover/Page_The Hangover Part II/button_Watchlist')

		boolean watchlist_add_diff = CustomKeywords.'utilities.KeywordHelper.compareImages'(watchlist_btn, file)

		if (!(watchlist_add_diff)) {
			WebUI.click(watchlist_btn)

			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_MovieNSeries/watchlist_notification'), 0)

			//WebUI.verifyElementText(findTestObject('Object Repository/Page_MovieNSeries/watchlist_notification'), 'Colette has been added to your watchlist.')
			GlobalVariable.G_movieDeleted = 'true' WebUI.verifyElementPresent(findTestObject('Object Repository/Page_MovieNSeries/watchlist_notification'), 0)
			WebUI.verifyElementText(findTestObject('Object Repository/Page_MovieNSeries/watchlist_notification'), 'Colette has been removed from your watchlist.')
			
		} else {
			print(' Its not there in watchlist')

			GlobalVariable.G_movieDeleted = 'already deleted'
		}
	}
*/	
	if(GlobalVariable.G_movieDeleted != 'false'){
		
	/*	def imgDir = RunConfiguration.getProjectDir() + '/Screenshots/Reference'
		name = (imgDir + '/watchlist_button_add.png')
		
				File file = new File(name)
		
				TestObject watchlist_btn = findTestObject('Page_Discover/Page_The Hangover Part II/button_Watchlist')
		
				boolean watchlist_delete_diff = CustomKeywords.'utilities.KeywordHelper.compareImages'(watchlist_btn, file)
		
				if(!(watchlist_delete_diff)){
				*/
							WebUI.click(findTestObject('Page_Home/a_Saved'))
					
							WebUI.delay(7)
							
							WebUI.waitForElementClickable(findTestObject('Page_Watchlist/tab_Watchlist'), 5)
					
							WebUI.click(findTestObject('Page_Watchlist/tab_Watchlist'))
					
							WebUI.waitForPageLoad(7)
							
							WebUI.verifyTextNotPresent(GlobalVariable.G_movieName, false)
			//	}
	}
	
