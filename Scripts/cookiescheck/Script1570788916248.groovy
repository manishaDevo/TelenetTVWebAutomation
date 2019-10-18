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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.

WebUI.navigateToUrl('https://wikiprojects.upc.biz/login.action?os_destination=%2Fpages%2Fviewpage.action%3FspaceKey%3DHZN4%26title%3DAR+14+Purchase+and+Watch+flows&permissionViolation=true#AR14PurchaseandWatchflows-2.Flow/Overview')

WebUI.setText(findTestObject('Page_Log In - Liberty Global TI Entertainment Wiki/input_Username_os_username'), 'hari.kuppudurai')

WebUI.setEncryptedText(findTestObject('Page_Log In - Liberty Global TI Entertainment Wiki/input_Password_os_password'), 
    'V35d/XPbheASJTEPzyNXhQ==')

WebUI.click(findTestObject('Page_Log In - Liberty Global TI Entertainment Wiki/input_Password_os_cookie'))

WebUI.click(findTestObject('Page_Log In - Liberty Global TI Entertainment Wiki/input_Remember me_login'))

// create file named Cookie to store username Information
File file = new File("Cookie.data");
//try { // Delete if any old file exists
file.delete();
file.createNewFile();
FileWriter fileWriter = new FileWriter(file);
BufferedWriter bufferwrite = new BufferedWriter(fileWriter);

driver = DriverFactory.getWebDriver()
driver.manage().getCookies()

//for(Cookie cook : driver.manage().getCookies()){
String writeup = cook.getName()+";"+cook.getValue()+";"+cook.getDomain()+";"+cook.getPath()+""
+ ";"+cook.getExpiry()+";"+cook.isSecure();
bufferwrite.write(writeup);
System.out.println(writeup);
bufferwrite.newLine();
//}
bufferwrite.flush();bufferwrite.close();fileWriter.close();
//}catch(Exception exp){
exp.printStackTrace();
//}




WebUI.delay(30)

WebUI.closeBrowser()

