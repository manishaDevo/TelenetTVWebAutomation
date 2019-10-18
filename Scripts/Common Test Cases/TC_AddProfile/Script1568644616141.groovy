import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

driver = DF.getWebDriver()

allhandles = driver.getWindowHandles()

print(('\n All Handles :' + allhandles) + '\n')

if (WebUI.verifyElementPresent(findTestObject('Page_Home/Page_Main/Share_Profile_span'), 5, FailureHandling.OPTIONAL) && 
(GlobalVariable.G_LOGINRESULT == 'TRUE')) {
    WebUI.click(findTestObject('Page_Home/Page_Main/Share_Profile_span'))

    //WebElement temp = driver.findElement(By.className('select__options select__options-left-check-icon'))
   /* temp1 = WebUI.findWebElement(findTestObject('Object Repository/obj_test'), 2)

    all_list = WebUI.findWebElements(findTestObject('Object Repository/obj_test2'), 2)

    print(('\nSize' + all_list.size()) + '\n')

    number_li = all_list.size()

    xpath_manage_profile = (('/html/body/div/div/div[2]/div[1]/div[2]/span[4]/div/div/div/div/div[2]/ul/li[' + number_li) + 
    ']/a')

    TestObject to = new TestObject('Obj_Dynamic_Manage_Profile')

    to.addProperty('xpath', ConditionType.EQUALS, xpath_manage_profile)

    WebUI.click(to)
*/
	WebUI.click(findTestObject('Object Repository/Page_Preferences/Obj_Manage profiles'))
    
    WebUI.delay(10)

   // WebUI.verifyElementPresent(findTestObject('test_obj3'), 3)

    allhandles = driver.getWindowHandles()

    print(('\n All Handles :' + allhandles) + '\n')

    if (WebUI.verifyElementPresent(findTestObject('Page_Account and Profiles/span_Add profile'), 5, FailureHandling.OPTIONAL)) {
        WebUI.waitForElementClickable(findTestObject('Page_Account and Profiles/span_Add profile'), 5)

        WebUI.click(findTestObject('Page_Account and Profiles/span_Add profile'))

        WebUI.setText(findTestObject('Object Repository/Page_Account and Profiles/Obj_profile_name'), 'Test')

        allhandles = driver.getWindowHandles()

        print(('\n All Handles again :' + allhandles) + '\n')

        WebUI.delay(2)

        WebUI.click(findTestObject('Page_Account and Profiles/button_Next'))

        WebUI.delay(2)

        WebUI.waitForElementClickable(findTestObject('Page_Account and Profiles/button_Skip'), 5)

        WebUI.click(findTestObject('Page_Account and Profiles/button_Skip'))

       /* WebUI.delay(5)

        WebUI.waitForElementClickable(findTestObject('Page_Account and Profiles/button_Skip2'), 5)

        WebUI.click(findTestObject('Page_Account and Profiles/button_Skip2'))
*/
        WebUI.delay(2)

        WebUI.verifyTextPresent('Test', false /*else if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Preferences/Obj_Manage profiles'), 5, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Object Repository/Page_Preferences/Obj_Manage profiles'))

        if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Account and Profiles/obj_button_Add profile'), 5, FailureHandling.OPTIONAL)){
		WebUI.click(findTestObject('Object Repository/Page_Account and Profiles/obj_button_Add profile'))
        }
    }*/ )
    } else {
        print('Maximum limit reached to add profiles')
    }
}

