package UITest_YourStore;

import Utils.SingleDriver;
import Utils.ParameterDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class _02_POM {
    private static WebDriver driver= SingleDriver.driver;

   public _02_POM() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "input-email")
    public WebElement inputEmail;
    @FindBy(id = "input-password")
    public WebElement password;
    @FindBy(css = "input[value='Login']")
    public WebElement loginBtn;

    @FindBy(css = "input[placeholder='Search']")
    public WebElement searchInput;

    @FindBy(css = "button[class='btn btn-default btn-lg']")
    public WebElement searchBtn;

    @FindBy(css="div.caption>h4")
    public List<WebElement> searchResults;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public WebElement addToCart;

    @FindBy(css="a[title='Shopping Cart']")
    public WebElement shopingCart;

    @FindBy(linkText="Checkout")
    public WebElement checkOut;


    @FindBy(id="input-payment-firstname")
    public WebElement inputName;

    @FindBy(id="input-payment-lastname")
    public WebElement lastName;

    @FindBy(id="input-payment-address-1")
    public WebElement addreSS;

    @FindBy(id="input-payment-city")
    public WebElement citYY;

    @FindBy(id="input-payment-postcode")
    public WebElement postCode;

    @FindBy(id="input-payment-country")
    public WebElement selectCountry;

    @FindBy(id="input-payment-zone")
    public WebElement selectState;

    @FindBy(css="select#input-payment-zone>option")
    public List<WebElement> stateOptions;

    @FindBy(id="button-payment-address")
    public WebElement continue1;

    @FindBy(id="button-shipping-address")
    public WebElement continue2;

    @FindBy(id="button-shipping-method")
    public WebElement continue3;

    @FindBy(css="input[type='checkbox']")
    public WebElement agree;

    @FindBy(id="button-payment-method")
    public WebElement continue4;

    @FindBy(id="button-confirm")
    public WebElement confirm;

    @FindBy(css="div[id='content']>h1")
    public WebElement confirmTxt;

    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }

    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void selectFunction(WebElement element, String value)
    {
        waitUntilVisible(element);
        scrollToElement(element);
        element.click();
         Select select=new Select(element);

        select.selectByVisibleText(value);
    }


    public void waitUntilClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilVisible(WebElement element){
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollToElement(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static WebDriver getDriver(){

       if (SingleDriver.driver==null){
           driver=ParameterDriver.driver;
       }
       else if(ParameterDriver.driver==null){
           driver= SingleDriver.driver;
       }

        return driver;
    }
}
