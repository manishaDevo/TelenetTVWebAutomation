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
import com.kazurayam.webdriverfactory4ks.ChromeDriverFactory
import com.kazurayam.webdriverfactory4ks.ChromeProfileFinder
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver



ChromeDriverFactory cdFactory = new ChromeDriverFactory()
WebDriver driver = cdFactory.openChromeDriverWithProfileDirectory('Default')
assert driver != null
DriverFactory.changeWebDriver(driver)
WebUI.navigateToUrl('http://demoaut.katalon.com/')

String profileName = ChromeProfileFinder.getChromeProfileNameByDirectoryName('Default')
WebUI.comment("Directory \'Default\' is associated with Chrome Profile \'${profileName}\'")

WebUI.delay(3)
WebUI.closeBrowser()
