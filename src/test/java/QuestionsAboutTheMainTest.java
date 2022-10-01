import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class QuestionsAboutTheMainTest {
    private WebDriver driver;
    private String expected;

    @Before
    public void openWebsite() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test

    public void checkResponseAboutCost_match() {
        MainPage objMainPage = new MainPage(driver);
        expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        objMainPage.cost(expected);
       }
    @Test
    public void checkResponseAboutQuantity_match() {
        MainPage objMainPage = new MainPage(driver);
        expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        objMainPage.quantity(expected);
         }
    @Test
    public void checkResponseAboutRentalTime_match() {
        MainPage objMainPage = new MainPage(driver);
        expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        objMainPage.rentalTime(expected);
          }

    @Test
    public void checkResponseAboutPossibilityOfOrderingToday_match() {
        MainPage objMainPage = new MainPage(driver);
        expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        objMainPage.possibilityOfOrderingToday(expected);
    }
    @Test
    public void checkResponseAboutTimeChangeOfUse_match() {
        MainPage objMainPage = new MainPage(driver);
        expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        objMainPage.timeChangeOfUse(expected);
        }
    @Test
    public void checkResponseAboutCharging_match() {
        MainPage objMainPage = new MainPage(driver);
        expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        objMainPage.charging(expected);
        }
    @Test
    public void checkResponseAboutOrder_match() {
        MainPage objMainPage = new MainPage(driver);
        expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        objMainPage.order(expected);
        }
    @Test
    public void checkResponseAboutDelivery_match() {
        MainPage objMainPage = new MainPage(driver);
        expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        objMainPage.delivery(expected);
        }
    @After
    public void quitWebsite(){
       driver.quit();
    }
}
