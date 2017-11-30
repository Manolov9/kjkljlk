package dd;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class JavaSample {

    public static final String USERNAME = "ilianavajarova1";
    public static final String AUTOMATE_KEY = "anQesbpRtAnE2aYhxQxd";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("device", "iPhone 8");
        //caps.setCapability("realMobile", "true");
        //caps.setCapability("os_version", "11.0");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");

        caps.setCapability("browserstack.debug", "true");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("http://www.embodee.com");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("Embodee");
        element.submit();

        System.out.println(driver.getTitle());
        driver.quit();

    }
}