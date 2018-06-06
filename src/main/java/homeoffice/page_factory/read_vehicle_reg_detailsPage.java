package homeoffice.page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by musti on 06/06/2018.
 */
public class read_vehicle_reg_detailsPage {
    WebDriver driver;
    public read_vehicle_reg_detailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy (xpath = "//a[text()='Start now']")
    private WebElement StartNow;

    @FindBy (xpath = "//*[@id='Vrm']")
    private WebElement EngterReg;

    @FindBy (xpath = "//*[@name='Continue']")
    private WebElement ContinueBtn;

    @FindBy (xpath = "//*[@class='reg-mark']")
    private WebElement CarReg;

    @FindBy (xpath = "//*[@class='reg-mark']")
    private WebElement CarMake;

    @FindBy (xpath = "//*[@class='reg-mark']")
    private WebElement CarColour;

}
