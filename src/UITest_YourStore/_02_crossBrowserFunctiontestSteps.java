package UITest_YourStore;

import Utils.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class _02_crossBrowserFunctiontestSteps extends ParameterDriver {

    @Test(dataProvider="getDataFromExcell")
    void Test1_searchFunctionalityCheck(String searchText)
    {
        _02_POM elements=new _02_POM();


        elements.sendKeysFunction(elements.searchInput,searchText);
        elements.clickFunction(elements.searchBtn);

        List<WebElement> searchResults=elements.searchResults;

        for (int i = 0; i < searchResults.size(); i++) {

            Assert.assertTrue(searchResults.get(i).getText().toLowerCase().contains(searchText.toLowerCase()));
        }

    }


    @Test(dataProvider="getDataFromExcell")
    void Test2_checkoutFunctionalityCheck(String searchText)
    {
        _02_POM elements=new _02_POM();


        elements.sendKeysFunction(elements.searchInput,searchText);
        elements.clickFunction(elements.searchBtn);
        elements.clickFunction(elements.addToCart);
        elements.clickFunction(elements.shopingCart);
        elements.clickFunction(elements.checkOut);

        if (elements.inputName.isDisplayed()){

            elements.sendKeysFunction(elements.inputName,"Bahrey");
            elements.sendKeysFunction(elements.lastName,"Bahre");
            elements.sendKeysFunction(elements.addreSS,"Hellind 4");
            elements.sendKeysFunction(elements.citYY,"Wisbaden");
            elements.sendKeysFunction(elements.postCode,"66763");
            elements.selectFunction(elements.selectCountry,"Germany");

            elements.selectState.click();
            List<WebElement> statelist=elements.stateOptions;

            System.out.println(statelist.size());
            WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("select#input-payment-zone>option"),100));
            System.out.println(statelist.size());
            elements.selectFunction(elements.selectState,"Hessen");
        }

        elements.clickFunction(elements.continue1);
        elements.clickFunction(elements.continue2);
        elements.clickFunction(elements.continue3);
        elements.clickFunction(elements.agree);
        elements.clickFunction(elements.continue4);
        elements.clickFunction(elements.confirm);
        WebDriverWait wait=new WebDriverWait(ParameterDriver.driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("success"));


        Assert.assertEquals(elements.confirmTxt.getText(),"Your order has been placed!");


    }




}
