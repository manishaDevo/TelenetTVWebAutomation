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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

//if (GlobalVariable.G_LOGINRESULT == 'TRUE') {
/*   Recording button screenshot   
 * WebUI.click(findTestObject('Page_Home/a_TV'))

    WebUI.delay(7)

    WebUI.click(  findTestObject('Object Repository/Page_Watch TV/a_TV Guide')   )

    WebUI.delay(7)
	
	WebUI.click(        findTestObject('Object Repository/Page_TV Guide/div_Misfit Garage')       )

   WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Guide TV/button_Recording'), 7)
   
    TestObject recording_add_btn = findTestObject('Object Repository/Page_Guide TV/button_Recording')

    def imgDir = RunConfiguration.getProjectDir() + '/Screenshots/Reference'

	//def imgDir = RunConfiguration.getProjectDir() + '/Screenshots/Test'
	
    name = (imgDir + '/recording_button_add.png')

    CustomKeywords.'utilities.KeywordHelper.takeWebElementScreenshot'(recording_add_btn, name)*/

    //Watchlist Button Screenshot
	
	  /*  WebUI.click(findTestObject('Page_Home/a_Movies  Series'))
	
		WebUI.delay(7)
	
        WebUI.click(findTestObject('Page_Discover/a_Movies'))	
		WebUI.delay(7)
		
		WebUI.click(findTestObject('Page_Movies/img_Fantastic'))
	
	   WebUI.waitForElementPresent(findTestObject('Page_Discover/Page_The Hangover Part II/button_Watchlist'), 7)
	   
		TestObject watchlist_add_btn = findTestObject('Page_Discover/Page_The Hangover Part II/button_Watchlist')
	
		def imgDir = RunConfiguration.getProjectDir() + '/Screenshots/Reference'
	
		//def imgDir = RunConfiguration.getProjectDir() + '/Screenshots/Test'
		
		name = (imgDir + '/watchlist_button_add.png')
	
		CustomKeywords.'utilities.KeywordHelper.takeWebElementScreenshot'(watchlist_add_btn, name)
	*/
	
//}


//TV Guide Grid

WebUI.openBrowser("https://www.telenettv.be/en.html")

WebUI.delay(2)

WebUI.click(    findTestObject('Object Repository/HOME_DUMP/a_TV') )

WebUI.delay(1)


WebUI.click(     findTestObject('Object Repository/Page_Watch TV/a_TV Guide'))

WebUI.click(    findTestObject('Object Repository/Page_TV Guide/button_Today') )
TestObject pastdateObject = new TestObject()
xpath_pastdate = "//a[contains(text(),'" + pastdateS + "')]"

Date today = new Date()

String todaysDate = today.format("d/MM/yy")

