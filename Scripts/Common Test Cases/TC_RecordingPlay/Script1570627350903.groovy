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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory

if(GlobalVariable.G_LOGINRESULT == "TRUE"){
	
	recording_name = "Drain The Oceans"
	
	TestObject recording_Obj = new TestObjects()
	
	recording_Obj.addProperty("alt", ConditionType.CONTAINS, recording_name)
	
	//click on saved
	
	WebUI.click( findTestObject('Object Repository/Page_Home/a_Saved'))
	
	WebUI.delay(5)
	
	//click on recordings
	WebUI.click( findTestObject('Object Repository/Page_Recordings/a_Recordings')  )
	
	WebUI.delay(5)
	
	WebDriver driver  = DriverFactory.getWebDriver()
	
	//check if recodring exists
	recordingObjectList = WebUI.findWebElements(recording_Obj,2)
	
	if(recordingObjectList.size() > 0){
		
		recordingObjectList[0].click()
		
		WebUI.delay(5)
		
		
		
		recordingList = WebUI.findWebElements( findTestObject('Object Repository/Page_Recordings/div_RecordingList')   ,5)
		
		if(recordingList.size() > 0){
			
			WebUI.click( findTestObject('Object Repository/Page_Recordings/div_RecordingList')    )
		    WebUI.delay(6)
			
		}
		
	}
	
}