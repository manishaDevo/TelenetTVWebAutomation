import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

if (GlobalVariable.G_LOGINRESULT == 'TRUE') {
    WebUI.click(findTestObject('Object Repository/Page_Home/a_TV'))
	
	WebUI.delay(5)
	

    WebUI.click(findTestObject('Object Repository/Page_Watch TV/a_TV Guide'))

    WebUI.delay(5)

    TestObject obj = findTestObject('Object Repository/Page_TV Guide/div_Misfit Garage')

    if (WebUI.verifyElementPresent(obj, 7, FailureHandling.OPTIONAL)) {
		
		WebUI.callTestCase(findTestCase('Common Test Cases/TC_AddRecording'), [('seriesObj') : obj ],
			FailureHandling.STOP_ON_FAILURE)
		
    }
}


