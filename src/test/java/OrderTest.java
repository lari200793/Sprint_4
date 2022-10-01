import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
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

    public OrderTest(String name, String secondName, String address,
                     String metro, String number, String result, String date, String colour, String day, String comment)
    {
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
                {"Лариса", "Дементьева", " ул. Московская", "Маяковская", "89991837297", "Заказ оформлен" ,"30.10.20022","grey","seven",""},
                {"Тимур", "Кормышев","ул. Ленина", " Чистые пруды", "891239978872", "Заказ оформлен", "31.12.2022","black","three", "Нет домофона, предварительно позвонить"},
        };
    }

    @Before
    public void openWebsite() {
      driver = new ChromeDriver();

    }
    @Test
    public void checkOrderFirstButton_click(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickFirstButtonOrder();
        FillingInUserDataPage objFillingInUserDataPage = new FillingInUserDataPage(driver);
        String expected= "Для кого самокат";
        objFillingInUserDataPage.waitTitleForTheOderForm(expected);
    }
    @ Test
    public void checkOrderSecondButton_click(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.scrollQuestions();
        objMainPage.waitForClickSecondButtonOrder();
        objMainPage.clickSecondButtonOrder();
        FillingInUserDataPage objFillingInUserDataPage = new FillingInUserDataPage(driver);
        String expected= "Для кого самокат";
        objFillingInUserDataPage.waitTitleForTheOderForm(expected);
    }
    @Test
    public void checkValidityOfFillingOrderData_sucсess(){

        driver.get("https://qa-scooter.praktikum-services.ru/order");
        FillingInUserDataPage objFillingInUserDataPage = new FillingInUserDataPage(driver);
        objFillingInUserDataPage.enterClientName(name);
        objFillingInUserDataPage.entrerClientSecondName(secondName);
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
