package homeoffice;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class DriverInstance {

    public  static WebDriver driver;

    //This will open the browser
    public void openBrowser() throws IOException {


        ResourceBundle config = ResourceBundle.getBundle("config");

        // TODO: lets expose this as a cli property
        String target = "URL";

        // TODO: lets expose this as a cli property
        String browser = config.getString("browser").toLowerCase();
        System.out.println("Selected browser:" + browser);

        switch( browser ) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/java/Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                System.out.println(driver);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                System.out.println(driver);
                break;
            case "remote":
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                driver = new RemoteWebDriver( new URL(config.getString("seleniumHubUrl")), capability );
                System.out.println(driver);
                break;
        }

        // TODO: arbitrary timeouts are brittle, waitFor or at least a configurable short/med/long value?
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String targetUrl = config.getString(target);
        System.out.println(targetUrl);

        driver.get(targetUrl);

        // TODO: tests are going to have to be resolution independent or this'll be a mess!
        driver.manage().window().maximize();

    }

    public void closeBrowser(){
        driver.quit();
    }

}
