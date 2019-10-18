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


if (GlobalVariable.G_LOGINRESULT == 'TRUE') {
	
	profile_name = "Test"
	
    WebUI.callTestCase(findTestCase('Common Test Cases/TC_AddProfile'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Common Test Cases/TC_Upd_Lang'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/Page_Home/a_Movies  Series'))

    expected_text = WebUI.getAttribute(findTestObject('Object Repository/Page_Home/a_Movies  Series'), 'text')
	
    expected_text = expected_text.trim()

    WebUI.click(findTestObject('Object Repository/Page_Home/Page_Main/Profile_Span'))

    WebUI.click(findTestObject('Object Repository/Page_Home/Page_Main/a_LogOUT'))

    WebUI.click(findTestObject('Object Repository/Page_Home/Page_Main/a_Login'))

    WebUI.callTestCase(findTestCase('Common Test Cases/TC_Login'), [('UserName') : GlobalVariable.G_UserName, ('Password') : GlobalVariable.G_Password, ('Env') : GlobalVariable.G_Env], 
        FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Object Repository/Page_Home/Page_Main/Profile_Span'))
	
	TestObject testobject = new TestObject()
	
	testobject.addProperty("href", ConditionType.EQUALS, '#')
	
	testobject.addProperty("text", ConditionType.CONTAINS,profile_name )
	
	WebUI.click(testobject)
	
	WebUI.delay(5)
	
	WebUI.click(findTestObject('Object Repository/Page_Home/a_Movies  Series'))
	
	WebUI.delay(5)
	
	WebUI.click(      findTestObject('Object Repository/Page_Home/a_Settings')   )
	
	WebUI.delay(5)
	
	actual_text = WebUI.getAttribute(findTestObject('Object Repository/Page_Home/a_Movies  Series'), 'text')
	
	actual_text=actual_text.trim()
	
	WebUI.verifyMatch(expected_text, actual_text, false, FailureHandling.STOP_ON_FAILURE)
	
	 WebUI.callTestCase(findTestCase('Common Test Cases/TC_RemoveProfile'), [:], FailureHandling.STOP_ON_FAILURE)

}

