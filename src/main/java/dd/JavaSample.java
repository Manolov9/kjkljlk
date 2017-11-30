package dd;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.Assert.assertEquals;

public class JavaSample {
    static WebDriver driver;
    public static final String USERNAME = "ilianavajarova1";
    public static final String AUTOMATE_KEY = "anQesbpRtAnE2aYhxQxd";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeClass
    public static void setupTest() throws MalformedURLException {
        //Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "47.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "7");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("smoke_test", "nike_staging_gBuilder");
        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @Test
    public void BrowserStackTest() {
        //Go to www.swtestacademy.com
        driver.get("http://www.swtestacademy.com/");

        //Check title is correct
        assertEquals("Title is not correct!", "Software Test Academy", driver.getTitle());
    }


    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}