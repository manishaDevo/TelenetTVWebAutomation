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


search_string = "God"
//click on search button
WebUI.click(findTestObject('Object Repository/Page_Home/a_SearchButton'))

WebUI.delay(2)

//enter string to search

WebUI.setText(findTestObject('Object Repository/Page_Home/input_Search') , search_string, FailureHandling.STOP_ON_FAILURE)

//check if search returned some query

results = WebUI.findWebElements(findTestObject('Object Repository/Page_Home/h1_Results'),2)

noResults = WebUI.findWebElements(findTestObject('Object Repository/Page_Home/span_NoResults'),2)


if(results.size() > 0){
	
	print "Results found"
}
else if(noResults.size() > 0){
	
	print "Results not found"
}
else{
	
	print "Error..Testcase Failed"
}

