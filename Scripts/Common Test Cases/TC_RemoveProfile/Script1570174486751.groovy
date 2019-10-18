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


if(GlobalVariable.G_LOGINRESULT == "TRUE"){
	
	WebUI.click(    findTestObject('Object Repository/Page_Home/a_Settings')     )
	
	WebUI.delay(1)
    
	WebUI.click(    findTestObject('Object Repository/Page_Account and Profiles/a_Account and Profiles')   )
	
	WebUI.delay(2)
	
	profile_Edit = "Test"
	
	TestObject obj_Edit = new TestObject()
		
	xpath_EditObject = "(//*[@class = 'virtual-profile-row-name' and (text() = '" + profile_Edit + "')])[1]/following::a[1]"
	
	obj_Edit.addProperty("xpath", ConditionType.EQUALS, xpath_EditObject)
	
	if(WebUI.verifyElementPresent(obj_Edit, 2, FailureHandling.OPTIONAL)){
		
		
		WebUI.click(obj_Edit)
		
		if( findTestObject('Object Repository/Page_Account and Profiles/input_ProfileName_Edit')     ){
			
			profile_name = WebUI.getAttribute(       findTestObject('Object Repository/Page_Account and Profiles/input_ProfileName_Edit')    , 'value')
		
			if(profile_name == profile_Edit){
		
			WebUI.click( findTestObject('Object Repository/Page_Account and Profiles/a_Delete profile')     )
			
			WebUI.click(findTestObject('Object Repository/Page_Account and Profiles/button_Delete'))
			
			WebUI.delay(5)
			
		    WebUI.verifyTextNotPresent(profile_Edit, false)
		
		}
	 }			
	}
	
}