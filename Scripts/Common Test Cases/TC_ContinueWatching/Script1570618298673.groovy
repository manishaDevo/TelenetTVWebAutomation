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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.Cookie
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory


play_same_time = "FALSE"

movie_Name = "Fantastic Beasts: The Crimes of Grindelwald"
movie_class = "ui-kit-tile-string__title"

TestObject movie_Obj = new TestObject()

movie_Obj.addProperty("text", ConditionType.CONTAINS, movie_Name)
movie_Obj.addProperty("class", ConditionType.CONTAINS, movie_class)

if(GlobalVariable.G_LOGINRESULT == "TRUE"){
	
	//Go to Saved 
	
	WebUI.click(   findTestObject('Object Repository/Page_Home/a_Saved')  )
	
	
	WebUI.delay(2)
	
	//Click on Continue Watching
	WebUI.click( findTestObject('Object Repository/Page_Recordings/a_Continue Watching'))
	
	WebUI.delay(5)
	
	//check if movie exists or not
	movies = WebUI.findWebElements(movie_Obj ,2)
	
	if(movies.size() > 0){
		
		
		//click on movie 
		WebUI.click( movie_Obj )
		
		WebUI.delay(5)
		
		WebUI.click(  findTestObject('Object Repository/Page_Watchlist/button_play')     )
		
		WebUI.delay(1)
		
		VideoURL = WebUI.getUrl()
		
		println("URL :" + VideoURL)
		
		/*String[] paramsBegin = VideoURL.split("&");
		Map<String, String> mapBegin = new HashMap<String, String>();
		for ( String param : paramsBegin)
		{
			 name = param.split("=")[0];
			 value = param.split("=")[1];
			mapBegin.put(name, value);
		}
		
		for(String name1 : mapBegin.keySet()){
			println "Values" + name1 + "\t" + mapBegin.get(name1)
		}
							
		 offset_begin = mapBegin.get("offset")*/
		
		String offset_begin = CustomKeywords.'utilities.KeywordHelper.getQueryParams'(VideoURL, "offset")
		 
		 register_devices_obj = WebUI.findWebElements(    findTestObject('Object Repository/Page_Watchlist/button_Register device')   ,2)
		 if(register_devices_obj.size()>0){
			 
			 WebUI.click(  findTestObject('Object Repository/Page_Watchlist/button_Register device')        )
			 			 
		 }
		 
		 
		 play_time = 90
		 
		 WebUI.delay(play_time)
		 
		 WebUI.back()
		 
		 
		 WebUI.delay(5)
		 
		 WebUI.click(  findTestObject('Object Repository/Page_Watchlist/button_play')     )
		 
		 WebUI.delay(1)
		 
		 VideoURL = WebUI.getUrl()
		 
		 println("URL :" + VideoURL)
		 
		/* String[] paramsEnd = VideoURL.split("&");
		 Map<String, String> mapEnd = new HashMap<String, String>();
		 for (String param : paramsEnd)
		 {
			  name = param.split("=")[0];
			  value = param.split("=")[1];
			 mapEnd.put(name, value);
		 }
		 
		 for(String name1 : mapEnd.keySet()){
			 println "Values" + name1 + "\t" + mapEnd.get(name1)
		 }
				
				 
		  offset_end = mapEnd.get("offset")*/
		 
		 String  offset_end = CustomKeywords.'utilities.KeywordHelper.getQueryParams'(VideoURL, "offset")
		 
		  
		  int offset_end_int = offset_end as Integer
		  int offset_begin_int = offset_begin as Integer
		  
		  
		  int actualy_palyed = offset_end_int - offset_begin_int
		  
		  println "offset_end_int" + offset_end_int
		  println "offset_begin_int" + offset_begin_int
		  println "ActualPlayed" + actualy_palyed
		  
		  diff = play_time - actualy_palyed
		  
		  if(diff <= 5){
			  
			  play_same_time = "TRUE"
			  
		  }
		  
		  
		 
		  WebUI.verifyMatch(play_same_time, "TRUE", false,FailureHandling.STOP_ON_FAILURE)
		 
	}
	
	/*WebUI.click(   findTestObject('Object Repository/Page_Continue Watching/img_ContinueWatch')     )
	
	
	WebUI.delay(10)
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Watchlist/button_play'), 10)
	
	WebUI.click(  findTestObject('Object Repository/Page_Watchlist/button_play')     )
	
	WebUI.delay(10)
*/	
	
}