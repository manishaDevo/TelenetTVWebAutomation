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

WebUI.callTestCase(findTestCase('MijnTelenet/TC_Consumption'), [('nURL') : nURL, ('Username') : Username, ('Password') : Password
        , ('Env') : Env, ('Limit') : Limit, ('Language') : Language], FailureHandling.STOP_ON_FAILURE)

//WebUI.scrollToPosition(1348, 700)
WebUI.scrollToElement(findTestObject('Page_Consommation de Telenet TV/Link_LimitDeconsommation'), 5)

total_purchases = WebUI.findWebElements(findTestObject('Page_Consommation de Telenet TV/Label_TotalAmount'), 1)

if (total_purchases.size() > 0) {
    print('Purchase for this session is :' + WebUI.getText(findTestObject('Page_Consommation de Telenet TV/Label_CurrentAmount')))
}

