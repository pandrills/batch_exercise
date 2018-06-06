package homeoffice.page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.util.Assert;

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
    private WebElement EnterReg;

    @FindBy (xpath = "//*[@name='Continue']")
    private WebElement ContinueBtn;

    @FindBy (xpath = "//*[@id='pr3']/div/ul/li[1]/span[2]")  //*[@class='reg-mark']
    private WebElement CarReg;

    @FindBy (xpath = "//*[@id='pr3']/div/ul/li[2]/span[2]/strong")  //*[@class='reg-mark']
    private WebElement CarMake;

    @FindBy (xpath = "//*[@id=pr3']/div/ul/li[3]/span[2]/strong")
    private WebElement CarColour;


    public void startSearch(){
        StartNow.click();
    }

    public void enterCarReg(String id){
        EnterReg.sendKeys(id);
    }

    public void clickContinue(){
        ContinueBtn.click();
    }

    public void verifyCarId() {
         System.out.println(CarReg.getText());
         System.out.println(CarReg.isDisplayed());

    }
}
