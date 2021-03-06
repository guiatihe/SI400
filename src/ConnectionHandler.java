package gproscraping;

import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

class SilentHtmlUnitDriver extends HtmlUnitDriver {

    SilentHtmlUnitDriver() {
        super();
        this.getWebClient().setCssErrorHandler(new SilentCssErrorHandler());
    }
}

public class ConnectionHandler {

	private static ConnectionHandler handler = null;
	public static SilentHtmlUnitDriver driver = null;
	private static WebElement user;
	private static WebElement passw;
	
	ConnectionHandler(){
		
		driver = new SilentHtmlUnitDriver();
		driver.get("https://www.gpro.net/gb/gpro.asp");
		user = driver.findElement(By.name("textLogin")); // gotten by attribute "name" in html
		user.sendKeys("barbaroto96@gmail.com");
		passw = driver.findElement(By.name("textPassword")); // gotten by attribute "name" in html
		passw.sendKeys("senha");
		passw.submit();
		
	}
	
	public static ConnectionHandler getHandler(){
		if(handler == null){
			handler = new ConnectionHandler();
			return handler;
		}
		else
			return handler;
		
	}

	public WebDriver getDriver(){
		return driver;
	}
	
	public boolean checkURL(String url){
		
		if(driver.getCurrentUrl() == url){
			return true;
		}
		else
			return false;
		
	}
        
        public void openRaceAnalisys(){
            if(this.checkURL("https://www.gpro.net/gb/gpro.asp")){
            	this.getDriver().findElement(By.xpath("//a[@href='RaceAnalysis.asp']")).click();
            }
            else{
            	this.getDriver().findElement(By.xpath("//a[@href='/gb/gpro.asp']")).click();
            	this.getDriver().findElement(By.xpath("//a[@href='RaceAnalysis.asp']")).click();
            }
        }	
        
        public void openTrackList(){
            if(this.checkURL("https://www.gpro.net/gb/gpro.asp")){
            	this.getDriver().findElement(By.xpath("//a[@href='ViewTracks.asp']")).click();
            }
            else{
            	this.getDriver().findElement(By.xpath("//a[@href='/gb/gpro.asp']")).click();
            	this.getDriver().findElement(By.xpath("//a[@href='ViewTracks.asp']")).click();
            }
        }
        
}
