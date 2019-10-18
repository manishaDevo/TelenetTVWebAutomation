package utilities
import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import org.openqa.selenium.By
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.comparison.ImageDiff
import ru.yandex.qatools.ashot.comparison.ImageDiffer
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.JavascriptExecutor

class KeywordHelper {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {


		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}


	@Keyword
	def executeJavaScript(String javascript) {
		((JavascriptExecutor) DriverFactory.getWebDriver()).executeScript(javascript)
	}


	@Keyword
	def takeWebElementScreenshot(TestObject object,String path){

		WebElement element = WebUiBuiltInKeywords.findWebElement(object, 5)
		print "one"
		WebDriver driver  = DriverFactory.getWebDriver()
		print "two"

		//Screenshot screenshot = new AShot().takeScreenshot(driver, element)


		/*Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element);
		 print "three"
		 //ImageIO.write(screenshot.getImage(), "PNG", new File(System.getProperty("user.dir") + "/Screenshots/" + name + ".png"))
		 ImageIO.write(screenshot.getImage(), "PNG", new File(path))*/


		JavascriptExecutor jse = (JavascriptExecutor)driver
		jse.executeScript("arguments[0].setAttribute('style','background: red;');", element)
		Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element);
		ImageIO.write(screenshot.getImage(), "PNG", new File(path))

	}

	@Keyword
	def boolean compareImages(TestObject object, File file){

		WebElement element = WebUiBuiltInKeywords.findWebElement(object)
		WebDriver driver  = DriverFactory.getWebDriver()
		print "\n oneCompareImages"

		JavascriptExecutor jse = (JavascriptExecutor)driver
		jse.executeScript("arguments[0].setAttribute('style','background: red;');", element)

		//BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir") + "/Screenshots/Test.png"))
		BufferedImage expectedImage = ImageIO.read(file)
		Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element);

		def actualImagePath = RunConfiguration.getProjectDir() + '/Screenshots/Reference/actualImage.png'
		File actualfile = new File(actualImagePath)

		ImageIO.write(screenshot.getImage(), "PNG", actualfile)

		//BufferedImage actualImage = screenshot.getImage()

		BufferedImage actualImage = ImageIO.read(actualfile)

		print "\n twoCompareImages"

		ImageDiffer differ = new ImageDiffer()


		ImageDiff diff = differ.makeDiff(expectedImage,actualImage)
		print "\n threeCompareImages"
		return diff.hasDiff()
	}

	@Keyword
	def String getBrowserAndVersion() {
		WebDriver driver = DriverFactory.getWebDriver()
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities()
		String browserName = caps.getBrowserName()
		String browserVersion = caps.getVersion()

		print("Browser Name : "+  browserName)
		return browserName
	}


	@Keyword
	def String getQueryParams(String URL,String variable) {
		String[] URLparams = URL.split("&");

		println("URL" + URL)
		Map<String, String> mapURL = new HashMap<String, String>();
		for (String param : URLparams) {
			String queryName  = param.split("=")[0];
			String queryvalue = param.split("=")[1];
			mapURL.put(queryName, queryvalue);
		}

		for(String name1 : mapURL.keySet()){
			println "Values" + name1 + "\t" + mapURL.get(name1)
		}


		String variable_value = mapURL.get(variable)

		return variable_value
	}

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
}
