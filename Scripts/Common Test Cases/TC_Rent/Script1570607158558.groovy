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
import com.kms.katalon.core.testobject.ConditionType

if(GlobalVariable.G_LOGINRESULT == 'TRUE'){
	
	access_pin = '9876'
	movie_Name = "Godzilla: King of the Monsters"
	//*[contains(@alt, 'Trial by Fire')]
	
	TestObject movie_Obj = new TestObject()
	
	movie_Obj.addProperty("alt", ConditionType.CONTAINS, movie_Name)
	
	
	//click MovieandSeries 
	WebUI.click(   findTestObject('Object Repository/Page_Home/a_Movies  Series')  )
	WebUI.delay(3)
	
	//click on Alacarte tab
	WebUI.click( findTestObject("Object Repository/Page_A la carte/a_A la carte") )
	
	WebUI.delay(3)
	
	
	rent_movie = WebUI.findWebElements(  movie_Obj,2)
	
	
	//If movie found then click on the movie
	if(rent_movie.size() >0){
		WebUI.click(movie_Obj)
		WebUI.delay(3)
		
		time_left = WebUI.findWebElements(findTestObject('Object Repository/Page_A la carte/div_TimeLeft'),2)
		
		//if time left div is present 
		if(time_left.size()>0){
			
			print" Movie is already purchased"
			
			}
		else{
			
			rent_button = WebUI.findWebElements(findTestObject('Object Repository/Page_A la carte/button_RENT NOW'),2)
			
			if(rent_button.size() > 0){
				
				//Click on rent
				
				WebUI.click(    findTestObject('Object Repository/Page_A la carte/button_RENT NOW')            )
				
				//Insert Pin
				WebUI.setText(findTestObject('Object Repository/Page_Recordings/input_PIN_cell1'), access_pin)
				
				//Click on Rent again
				WebUI.click( findTestObject('Object Repository/Page_A la carte/button_RENT NOW_afterPIN')  )
				
				
				WebUI.delay(5)
				
				//Pin before playing for age limit
				
				pin_textbox = WebUI.findWebElements(findTestObject('Object Repository/Page_Recordings/input_PIN_cell1'),2)
				
				if(pin_textbox.size()>0){
				
				WebUI.setText(findTestObject('Object Repository/Page_Recordings/input_PIN_cell1'), access_pin)	
				
				}
				
                 WebUI.delay(5)	
				 WebUI.back()	
				 
				 time_left = WebUI.findWebElements(findTestObject('Object Repository/Page_A la carte/div_TimeLeft'),2)
				 
				 //if time left div is present
				 if(time_left.size()>0){
					 
					 print" Movie is purchased"
					 
					 }
			  }
			
			}
		
			
	}
	
}

