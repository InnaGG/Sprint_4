package tests;

import com.sun.org.apache.xpath.internal.operations.Or;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.HomePage;
import page_object.OrderPage;

import java.time.Duration;

public class TestsMakeAnOrder extends BaseUISettings{

    //private OrderPage orderPage = new OrderPage(driver);

    @Test
    public void orderScooterPositiveTest1(){
        homePage.clickOnMakeAnOrderHeaderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillName("Инна");
        orderPage.fillSurname("Иванова");
        orderPage.fillAddress("Октябрьская, д. 7");
        orderPage.fillSubway();
        orderPage.fillPhoneNumberField("89379234223");
        orderPage.clickContinueButton();
        orderPage.waitFor5Seconds();
        orderPage.fillInDateOfDelivery();
        orderPage.fillInLengthOfRent(3);
        orderPage.markColorOfScooter(1);
        orderPage.clickMakeAnOrderButton();
        orderPage.waitFor5Seconds();
        orderPage.clickYes();
        orderPage.waitFor5Seconds();
        boolean isSuccessFormAppeared = orderPage.isFormOfSuccessfulOrderAppeared();
        Assert.assertTrue("Форма не отображается", isSuccessFormAppeared);

    }

    @Test
    public void orderScooterPositiveTest2(){
        homePage.clickOnMakeAnOrderHeaderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillName("Иван");
        orderPage.fillSurname("Гурылев");
        orderPage.fillAddress("Октябрьская, д. 7");
        orderPage.fillSubway();
        orderPage.fillPhoneNumberField("89373454455");
        orderPage.clickContinueButton();
        orderPage.waitFor5Seconds();
        orderPage.fillInDateOfDelivery();
        orderPage.fillInLengthOfRent(2);
        orderPage.markColorOfScooter(2);
        orderPage.fillInCommentaryField("квартира на 2 этаже");
        orderPage.clickMakeAnOrderButton();
        orderPage.waitFor5Seconds();
        orderPage.clickYes();
        orderPage.waitFor5Seconds();
        boolean isSuccessFormAppeared = orderPage.isFormOfSuccessfulOrderAppeared();
        Assert.assertTrue("Форма не отображается", isSuccessFormAppeared);

    }

    @Test
    public void checkErrorsOnMakeAnOrderForm(){
        homePage.clickOnMakeAnOrderHeaderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillName("sdf");
        orderPage.fillSurname("lsdf");
        orderPage.fillAddress("sdfsdfs");
        orderPage.fillPhoneNumberField("rtgrg");
        orderPage.fillAddress("sdfsdfs");
        orderPage.waitFor5Seconds();
        boolean isAllErrorsArePresent = orderPage.isErrorMessageIsPresentName() && orderPage.isErrorMessageIsPresentSurname()
                && orderPage.isErrorMessageIsPresentAddress() && orderPage.isErrorMessageIsPresentPhoneNumber();
        Assert.assertTrue("Одно из сообщений об ошибке отсутствует!", isAllErrorsArePresent);
    }

}
