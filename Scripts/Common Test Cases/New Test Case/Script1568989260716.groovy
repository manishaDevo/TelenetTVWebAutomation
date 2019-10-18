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
import java.awt.image.BufferedImage

import javax.imageio.ImageIO
import ru.yandex.qatools.ashot.comparison.ImageDiff
import ru.yandex.qatools.ashot.comparison.ImageDiffer



Map m = RunConfiguration.getExecutionProperties()
String driverProp = m.get("drivers").get("system").get("WebUI").get("browserType")
//String driverProp = m.get("drivers")
println  driverProp



def imgDir = RunConfiguration.getProjectDir() + '/Screenshots/'

		file1 = (imgDir + 'Reference/watchlist_button_add.png')
		file_img = new File(file1)
 	BufferedImage expectedImage = ImageIO.read(file_img)
		
	 file2 = (imgDir + 'Reference/actualImage.png')
	 file_img2 = new File(file2)
	 BufferedImage actualImage = ImageIO.read(file_img2)
		ImageDiffer differ = new ImageDiffer()

		ImageDiff diff = differ.makeDiff(expectedImage,actualImage)
		print "\n threeCompareImages"
		
		

		print("Difference" + diff.hasDiff())
		
		
		VideoURL = "https://www.telenettv.be/en/movies-and-series/vod-asset.html/crid%3A~~2F~~2Ftelenet.be~~2F6a71545e-100d-45c6-976b-da055fd69153/fantastic-beasts-the-crimes-of-grindelwald.html#action=watch&offset=2990"
		
		String offset_begin = CustomKeywords.'utilities.KeywordHelper.getQueryParams'(VideoURL, "offset")
	
		
		println(" offset_beginat" + offset_begin)