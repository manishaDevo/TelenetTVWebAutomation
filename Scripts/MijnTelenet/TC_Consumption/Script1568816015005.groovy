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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(nURL)

WebUI.waitForPageLoad(3)

WebUI.click(findTestObject('Page_Telenetbe/div_Fermer'))

WebUI.click(findTestObject('Page_Telenet Connectez-vous/Button_Connect'))

print(('Username ' + Username) + '\n')

print(('password ' + Password) + '\n')

WebUI.sendKeys(findTestObject('Page_Telenet Connectez-vous/Input_Username'), Username)

WebUI.sendKeys(findTestObject('Page_Telenet Connectez-vous/Input_Password'), Password)

WebUI.click(findTestObject('Page_Telenet Connectez-vous/Button_Login'))

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Page_Telenetbe/Button_Service_Client'))

WebUI.waitForElementClickable(findTestObject('Page_Service Client/Button_My Telenet'), 15)

WebUI.delay(5)

WebUI.click(findTestObject('Page_Service Client/Button_My Telenet'))

not_run: WebUI.scrollToPosition(1347, 1750)

WebUI.scrollToElement(findTestObject('Page_Service Client/Link_TV_next'), 5)

WebUI.delay(15)

WebUI.click(findTestObject('Page_Service Client/Link_TV_next'))

WebUI.delay(2)

WebUI.click(findTestObject('Page_Service Client/Link_ConsumptionTV'))

WebUI.waitForPageLoad(2)

