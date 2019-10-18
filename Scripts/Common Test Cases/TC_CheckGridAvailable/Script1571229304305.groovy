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
import groovy.time.TimeCategory as TimeCategory
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration


channel = "Nat Geo HD"
program = "Air Crash Investigation"


//if(GlobalVariable.G_LOGINRESULT == "TRUE"){
	

    WebUI.openBrowser("https://www.telenettv.be/en.html")

    WebUI.delay(2)

	Date today = new Date()
	
	String todaysDate = today.format("d/MM/yy")
	String nowTime = today.format("hh:mm")
	println(todaysDate)
	println (nowTime)
	
	Date futuredate = new Date().plus(14)
	Date pastdate = new Date().minus(7)
	
	String futuredateS = futuredate.format("d")
	String futureTimeS = futuredate.format("hh:mm")
	
	String pastdateS = pastdate.format("d")
	String pastTimeS = pastdate.format("hh:mm")
	
	println(futuredateS + " " + futureTimeS)
	println(pastdateS + " " + pastTimeS)
	
	
	WebUI.click(findTestObject('Object Repository/Page_Home/a_TV'))
	
	WebUI.delay(5)
	

    WebUI.click(findTestObject('Object Repository/Page_Watch TV/a_TV Guide'))

    WebUI.delay(5)
	
	WebUI.click(    findTestObject('Object Repository/Page_TV Guide/button_Today') )
	
	TestObject pastdateObject = new TestObject()
	
	TestObject futuredateObject = new TestObject()

	
	xpath_pastdate = "//*[@href = '#' and (text() = '" + pastdateS + "')]"
	println("xpath_pastdate :" + xpath_pastdate)
	//pastdateObject.addProperty("href", ConditionType.EQUALS, '#', false)
	pastdateObject.addProperty("xpath", ConditionType.EQUALS, xpath_pastdate)
	
	
	xpath_futuredate = "//*[@href = '#' and (text() = '" + futuredateS + "')]"
	
	println("xpath_futuredate :" + xpath_futuredate)
	
//	futuredateObject.addProperty("href", ConditionType.EQUALS, '#', false)
	futuredateObject.addProperty("xpath", ConditionType.EQUALS, xpath_futuredate)
	
	WebUI.verifyElementPresent(pastdateObject, 2, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementPresent(futuredateObject, 2, FailureHandling.STOP_ON_FAILURE)
	
	
	WebUI.delay(2)
	
	WebUI.click(futuredateObject)
	
	
	WebUI.delay(1)
	
	WebUI.click(   findTestObject('Object Repository/Page_TV Guide/button_TV Guide_fwd')  )
	
	def imgDir = RunConfiguration.getProjectDir() + '/Screenshots/Reference'
	
	name = (imgDir + '/TVGuideTimeGrid')
	
	TestObject timegrid = findTestObject('Object Repository/Page_TV Guide/div_EPGGrid_till12')

	CustomKeywords.'utilities.KeywordHelper.takeWebElementScreenshot'(timegrid, name)
	
	
	WebUI.delay(10)
//}