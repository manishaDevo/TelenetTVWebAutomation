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

if (GlobalVariable.G_LOGINRESULT == 'TRUE') {
    access_pin = GlobalVariable.G_PIN

    WebUI.verifyMatch(access_pin, '^[0-9]*$', true, FailureHandling.STOP_ON_FAILURE)

    String[] access_pin_digits = access_pin.split('')

    print(((('Pin' + (access_pin_digits[0])) + (access_pin_digits[1])) + (access_pin_digits[2])) + (access_pin_digits[3]))

    WebUI.click(findTestObject('Object Repository/Page_Home/a_Saved'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/Page_Recordings/a_Recordings'))

    WebUI.delay(5)

    WebUI.verifyElementPresent(findTestObject('Object Repository/RestrictedContents/div_Adult'), 2, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/RestrictedContents/div_Adult'))

    WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Recordings/input_PIN_cell1'), 2, FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Object Repository/Page_Recordings/input_PIN_cell1'), access_pin)

    WebUI.delay(2)

  /*  WebUI.setText(findTestObject('Object Repository/Page_Recordings/input_PIN_cell2'), access_pin_digits[1])

    WebUI.delay(2)

    WebUI.setText(findTestObject('Object Repository/Page_Recordings/input_PIN_cell3'), access_pin_digits[2])

    WebUI.delay(2)

    WebUI.setText(findTestObject('Object Repository/Page_Recordings/input_PIN_cell4'), access_pin_digits[3])

    WebUI.delay(2)*/

    WebUI.click(findTestObject('Object Repository/RestrictedContents/button_SubmitPIN'))

    WebUI.verifyElementPresent(findTestObject('Object Repository/RestrictedContents/div_RestrictedContent'), 3, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/RestrictedContents/div_RestrictedContent'))

    WebUI.delay(2)

    WebUI.verifyElementPresent(findTestObject('Object Repository/RestrictedContents/button_PlayRestrictedContent'), 3, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/RestrictedContents/button_PlayRestrictedContent'))

    WebUI.delay(2)
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Recordings/input_PIN_cell1'), 2, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.setText(findTestObject('Object Repository/Page_Recordings/input_PIN_cell1'), access_pin)
	
	WebUI.delay(5)
	
	
}

