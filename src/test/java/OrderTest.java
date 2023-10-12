import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderTest {
    private RemoteWebDriver driver;
    private String button;
    private String name;
    private String secondName;
    private String metro;
    private String address;
    private String number;
    private String result;
    private String date;
    private String colour;
    private String day;
    private String comment;


 //   private String rentalTime;

    public OrderTest( String button, String name, String secondName, String address,
                     String metro, String number, String result, String date, String colour, String day, String comment)
    {
        this.button = button;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metro = metro;
        this.number = number;
        this.date = date;
        this.result = result;
        this.colour = colour;
        this.day = day;
        this.comment = comment;

    }
    @Parameterized.Parameters
    public static Object[][] getDate() {
        return new Object[][]{
                { "Первая","Лариса", "Дементьева", " ул. Московская", "Маяковская", "89991837297", "Заказ оформлен" ,"30.10.20022","grey","seven",""},
                { "Вторая","Тимур", "Кормышев","ул. Ленина", " Чистые пруды", "891239978872", "Заказ оформлен", "31.12.2022","black","three", "Нет домофона, предварительно позвонить"},
        };
    }

    @Before
    public void openWebsite() throws MalformedURLException {
        DesiredCapabilities browser = new DesiredCapabilities().chrome();
        browser.setBrowserName("chrome");
        browser.setVersion("116.0");
        driver = new RemoteWebDriver(URI.create("http://192.168.0.104:4444/wd/hub").toURL(), browser);
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }


    @Test
    public void checkOrdering_success(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonOrder(button);
        FillingInUserDataPage objFillingInUserDataPage = new FillingInUserDataPage(driver);
        objFillingInUserDataPage.enterClientName(name);
        objFillingInUserDataPage.enterClientSecondName(secondName);
        objFillingInUserDataPage.enterClientAddress(address);
        objFillingInUserDataPage.enterStationMetro(metro);
        objFillingInUserDataPage.enterPhoneNumber(number);
        objFillingInUserDataPage.enterButtonNext();
        AboutRentPage objAboutRentPage = new AboutRentPage(driver);
        objAboutRentPage.sendDate(date);
        objAboutRentPage.selectOderTime(day);
        objAboutRentPage.selectColourScooter(colour);
        objAboutRentPage.sendComment(comment);
        objAboutRentPage.clickButtonOder();
        assertEquals(result,objAboutRentPage.findHeaderFormRental());

    }
    @After
    public void quitWebsite(){
        driver.quit();
    }
}
