import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class MainPage{
    private WebDriver driver;
    //локатор раздела вопросов о важном
    private final By QUESTION_ABOUT_THE_MAIN = By.className("accordion");
    // локатор вопроса о стоимости
    private final By QUESTION_ABOUT_THE_COST = By.id("accordion__heading-0");
    // локатор ответа о стоимости
    private final By COST_ANSWER = By.id("accordion__panel-0");
    // локатор вопроса о количестве
    private final By QUESTION_OF_QUANTITY = By.id("accordion__heading-1");
    // локатор ответа о количестве
    private final  By QUANTITY_ANSWER = By.id("accordion__panel-1");
    //локатор вопроса о времени аренды
    private final By QUESTION_ABOUT_RENTAL_TIME =By.id("accordion__heading-2");
    // локатор ответа о времени аренды
    private final By ANSWER_ABOUT_RENTAL_TIME = By.id("accordion__panel-2");
    //  локатор вопроса о возможности заказа сегодня
     private final By QUESTION_ABOUT_THE_POSSIBILITY_OF_ORDERING_TODAY = By.id("accordion__heading-3");
     // локатор ответа о возможности заказа сегодня
    private final By RESPONSE_ABOUT_THE_POSSIBILITY_OF_ORDERING_TODAY = By.id("accordion__panel-3");
    // локатор вопроса о изменении времени пользования
    private final By QUESTION_ABOUT_CHANGING_THE_TIME_OF_USE = By.id("accordion__heading-4");
    // ответ о изменении времени пользования
    private final By TIME_CHANGE_RESPONSE = By.id("accordion__panel-4");
        // вопрос о наличии зарядки
    private final By QUESTION_ABOUT_CHARGING = By.id("accordion__heading-5");
    //ответ о наличии зарядки
    private final By CHARGING_RESPONSE = By.id("accordion__panel-5");
    //вопрос об отмене заказа
    private final By QUESTION_ABOUT_CANCELING_AN_ORDER = By.id("accordion__heading-6");
    // ответ об отмене заказа
    private final By ORDER_CANCELLATION_RESPONSE = By.id("accordion__panel-6");
    // вопрос о доставке
    private final By DELIVERY_QUESTION = By.id("accordion__heading-7");
    // ответ о доставке
    private final By DELIVERY_RESPONSE = By.id("accordion__panel-7");
    // первая кнопка заказать
    private final By FIRST_ODER_BUTTON = By.className("Button_Button__ra12g");
    // вторая кнопка закзать
    private final By SECOND_ODER_BUTTON = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollQuestions() {
        WebElement element = driver.findElement(QUESTION_ABOUT_THE_MAIN);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public String  getTextAnswer (String question) {
        String answer = null;
        switch (question) {
            case "Сколько это стоит? И как оплатить?":
                driver.findElement(QUESTION_ABOUT_THE_COST).click();
                driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
                answer = driver.findElement(COST_ANSWER).getText();
            break;
            case "Хочу сразу несколько самокатов! Так можно?":
                driver.findElement(QUESTION_OF_QUANTITY).click();
                driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
                answer = driver.findElement(QUANTITY_ANSWER).getText();
                break;
            case "Как рассчитывается время аренды?":
                driver.findElement(QUESTION_ABOUT_RENTAL_TIME).click();
                driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
                answer =  driver.findElement(ANSWER_ABOUT_RENTAL_TIME).getText();
            break;
            case "Можно ли заказать самокат прямо на сегодня?":
                driver.findElement(QUESTION_ABOUT_THE_POSSIBILITY_OF_ORDERING_TODAY).click();
                driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
                answer = driver.findElement(RESPONSE_ABOUT_THE_POSSIBILITY_OF_ORDERING_TODAY).getText();
            break;
            case "Можно ли продлить заказ или вернуть самокат раньше?":
                driver.findElement(QUESTION_ABOUT_CHANGING_THE_TIME_OF_USE).click();
                driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
                answer = driver.findElement(TIME_CHANGE_RESPONSE).getText();
            break;
            case "Вы привозите зарядку вместе с самокатом?":
                driver.findElement(QUESTION_ABOUT_CHARGING).click();
                driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
                answer =  driver.findElement(CHARGING_RESPONSE).getText();
            break;
            case "Можно ли отменить заказ?":
                driver.findElement(QUESTION_ABOUT_CANCELING_AN_ORDER).click();
                driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
                answer = driver.findElement(ORDER_CANCELLATION_RESPONSE).getText();
            break;
            case "Я жизу за МКАДом, привезёте?":
                driver.findElement(DELIVERY_QUESTION).click();
                driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
                answer = driver.findElement(DELIVERY_RESPONSE).getText();
            break;

            default:
                throw new IllegalStateException("Unexpected value: " + question);
        }
        return answer;

    }

    public String text ( String  question){
        scrollQuestions();
       return( getTextAnswer(question));

    }

    public void clickButtonOrder(String button){
        switch (button){
            case "Первая":
                driver.findElement(FIRST_ODER_BUTTON).click();
            break;
            case "Вторая":
                WebElement element = driver.findElement(QUESTION_ABOUT_THE_MAIN);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(SECOND_ODER_BUTTON));
                driver.findElement(SECOND_ODER_BUTTON).click();
             break;
        }
    }


}