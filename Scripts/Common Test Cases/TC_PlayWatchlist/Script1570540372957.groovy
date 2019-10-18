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
import com.kms.katalon.core.testobject.ConditionType
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory

WebUI.click(findTestObject('Page_Home/a_Saved'))

WebUI.delay(7)
		
WebUI.waitForElementClickable(findTestObject('Page_Watchlist/tab_Watchlist'), 5)

WebUI.click(findTestObject('Page_Watchlist/tab_Watchlist'))

WebUI.waitForPageLoad(7)
TestObject obj = new TestObject()

dynamic_xpath = "//*[(text() = '"+ GlobalVariable.G_movieName +"')]"

obj.addProperty("xpath",ConditionType.EQUALS, dynamic_xpath )

WebUI.verifyElementPresent(obj, 5)

WebUI.click(obj)

WebUI.delay(7)

WebUI.verifyElementPresent(    findTestObject('Object Repository/Page_Watchlist/button_play')   , 2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(    findTestObject('Object Repository/Page_Watchlist/button_play'))

WebUI.delay(2)

pin_asked = WebUI.findWebElements(   findTestObject('Object Repository/Page_Recordings/input_PIN_cell1')  ,1 )

if(pin_asked.size() > 0){
	
	WebUI.setText(findTestObject('Object Repository/Page_Recordings/input_PIN_cell1'), GlobalVariable.G_PIN)
	
	WebUI.delay(5)
}


register_elements = WebUI.findWebElements(    findTestObject('Object Repository/Page_Watchlist/button_Register device') ,1 )

if(register_elements.size()>0){
	
	WebUI.click( findTestObject('Object Repository/Page_Watchlist/button_Register device')    )
}

WebUI.delay(5)



WebUI.delay(5)

WebUI.back()

WebUI.delay(5)
