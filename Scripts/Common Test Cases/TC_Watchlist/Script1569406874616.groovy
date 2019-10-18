import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DF
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

movie_Name = "Hunter Killer"
//*[contains(@alt, 'Trial by Fire')]

TestObject movie_Obj = new TestObject()

movie_Obj.addProperty("alt", ConditionType.CONTAINS, movie_Name)

if (GlobalVariable.G_LOGINRESULT == 'TRUE') {
	
	
   
	def imgDir = RunConfiguration.getProjectDir() + '/Screenshots/Reference'
	
			name = (imgDir + '/watchlist_button_add1.png')
	
    WebUI.takeScreenshot(name,FailureHandling.OPTIONAL)
	

    WebUI.callTestCase(findTestCase('Common Test Cases/TC_AddWatchlist'), [('mediaObj') : movie_Obj], FailureHandling.STOP_ON_FAILURE)

	if (GlobalVariable.G_movieAdded != 'FALSE') {
		WebUI.callTestCase(findTestCase('Common Test Cases/TC_PlayWatchlist'), [('mediaObj') : movie_Obj], FailureHandling.STOP_ON_FAILURE)
	}
	
	
    if (GlobalVariable.G_movieAdded != 'FALSE') {
        WebUI.callTestCase(findTestCase('Common Test Cases/TC_DeleteWatchlist'), [('mediaObj') : movie_Obj], FailureHandling.STOP_ON_FAILURE)
    }
}

