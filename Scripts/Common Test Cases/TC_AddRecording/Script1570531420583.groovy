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



	
	recording_Info = WebUI.getText(seriesObj)
	WebUI.click(seriesObj)
	
	Err_Flag = 'FALSE'
	
	def imgDir = RunConfiguration.getProjectDir() + '/Screenshots/Reference'
	
	name = (imgDir + '/recording_button_add.png')
	
   File file = new File(name)
	
	
	   TestObject recording_btn = findTestObject('Object Repository/Page_Guide TV/button_Recording')
			boolean recording_btn_add_diff = CustomKeywords.'utilities.KeywordHelper.compareImages'(recording_btn, file)
			
			if(!recording_btn_add_diff){
				
				WebUI.click(recording_btn)
				
				WebUI.delay(5)
				
				WebUI.click(findTestObject('Object Repository/Page_Guide TV/button_RecordingSingle'))
				
				WebUI.delay(1)
				
				if(WebUI.verifyElementPresent(   findTestObject('Object Repository/Page_Home/div_notification_Recording_Full')      , 5)){
					
					notification_obj = findTestObject('Object Repository/Page_Home/div_notification_Recording_Full')
					notification_message = WebUI.getText(notification_obj)
					if(notification_message != null){
						print("notification :" + notification_message )
						
						List messages1 = ['Maximum','Opnamelimiet','Limit','Recording limit']
						
						List messages2 = ['Sorry','Désolé']
						
					/*	if(notification_message in messages1){
							
							println("No space for Recordings")
							 
							
						}*/
						
						for(def listItem : messages1){
							if(notification_message.contains(listItem)){
							   println("No space for Recordings")
							   break
							}
						 }
						
						/*if(notification_message in messages2){
							
							println("Some Technical Error")
							Err_Flag = 'TRUE'
							
						}*/
						for(def listItem : messages2){
							if(notification_message.contains(listItem)){
					     	   println("Some Technical Error")
							   Err_Flag = 'TRUE'
							   break
							}
						 }
					}
				}
				notifications = WebUI.findWebElements(  findTestObject('Object Repository/Page_Guide TV/notificatiion_recording'),5  )
				if(notifications.size() > 0 && Err_Flag == 'FALSE'){
				
					for(def notificationItem : notifications){
					//notification_obj = findTestObject('Object Repository/Page_Guide TV/notificatiion_recording')
					notification_message = notificationItem.getText()
					
					if(notification_message != null){
						print("notification :" + notification_message )
						print("recording_Info : " + recording_Info)
						if(notification_message.contains(recording_Info)){
							
							println("Recording is set")
							
						}
					}
					
				}
			}
		}
				
	
