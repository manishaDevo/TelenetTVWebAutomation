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
    WebUI.click(findTestObject('Page_Home/a_Settings'))

    WebUI.click(findTestObject('SettingsPage/Dropdown_lang'))
	
	if(GlobalVariable.G_LANGRUN == 'FALSE'){

   // WebUI.click(findTestObject('SettingsPage/Option_Nederlands'))
		WebUI.click(findTestObject('SettingsPage/Option_French'))
	GlobalVariable.G_LANGRUN = 'TRUE'

    WebUI.delay(5)
	}
	else{
		WebUI.click(findTestObject('SettingsPage/Option_English'))
		
		WebUI.delay(5)
	}
}

