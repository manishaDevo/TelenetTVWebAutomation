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

if(GlobalVariable.G_LOGINRESULT == "TRUE"){
	access_pin = GlobalVariable.G_PIN
	
	WebUI.click(   findTestObject('Object Repository/Page_Home/a_Settings')  )
	
	WebUI.delay(2)
	
	WebUI.click(      findTestObject('Object Repository/Page_Preferences/a_Parental Control')  )
	
	WebUI.delay(2)
	
	WebUI.click(       findTestObject('Object Repository/Page_Parental Control/a_Edit setting')         )
	
	WebUI.delay(2)
	
	WebUI.setText(      findTestObject('Object Repository/RestrictedContents/input_PIN_cell1'),access_pin    )
	
	WebUI.click(findTestObject('Object Repository/Page_Parental Control/button_Submit'))
		
	WebUI.verifyElementPresent(    findTestObject('Object Repository/Page_Parental Control/label_Age 12')       , 2, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(   findTestObject('Object Repository/Page_Parental Control/label_Age 12')  )

	WebUI.click(   findTestObject('Object Repository/Page_Parental Control/button_Save')   )

	WebUI.delay(1)
	
	WebUI.verifyElementPresent(     findTestObject('Object Repository/Page_Parental Control/notification_msg')   , 2,  FailureHandling.STOP_ON_FAILURE)
	
	WebUI.delay(2)
	
	
	WebUI.verifyElementPresent( findTestObject('Object Repository/Page_Parental Control/span_Age 12')    , 0, FailureHandling.STOP_ON_FAILURE)
	
	
}