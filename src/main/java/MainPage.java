import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MainPage{
    private final WebDriver driver;
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
    private final By SECOND_ODER_BUTTON = By.cssSelector("div>div>div>div>div>div>button");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollQuestions() {
        WebElement element = driver.findElement(QUESTION_ABOUT_THE_MAIN);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickQuestionAboutTheCost(){
        driver.findElement( QUESTION_ABOUT_THE_COST).click();
    }

    public void waitForCost(String expected){
        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElementLocated(COST_ANSWER, expected));
    }

    public void cost (String expected){
        scrollQuestions();
        clickQuestionAboutTheCost();
        waitForCost(expected);
    }
    public void clickQuestionOfQuantity(){
        driver.findElement( QUESTION_OF_QUANTITY).click();
    }

    public void waitForQuantity(String expected){
        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElementLocated(QUANTITY_ANSWER, expected));
    }
    public void quantity (String expected){
        scrollQuestions();
        clickQuestionOfQuantity();
        waitForQuantity(expected);
    }
    public void clickQuestionAboutRentalTime(){
        driver.findElement(QUESTION_ABOUT_RENTAL_TIME).click();
    }
        public void waitForRentalTime(String expected){
        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElementLocated(ANSWER_ABOUT_RENTAL_TIME, expected));
    }
    public void rentalTime (String expected){
        scrollQuestions();
        clickQuestionAboutRentalTime();
        waitForRentalTime(expected);
    }
    public void clickAboutThePossibilityOfOrderingToday(){
        driver.findElement(QUESTION_ABOUT_THE_POSSIBILITY_OF_ORDERING_TODAY).click();
    }

    public void waitPossibilityOfOrderingToday(String expected){
        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElementLocated(RESPONSE_ABOUT_THE_POSSIBILITY_OF_ORDERING_TODAY, expected));
    }
    public void possibilityOfOrderingToday(String expected){
        scrollQuestions();
        clickAboutThePossibilityOfOrderingToday();
        waitPossibilityOfOrderingToday(expected);
    }
    public void clickQuestionAboutChangingTheTimeOfUse(){
        driver.findElement(QUESTION_ABOUT_CHANGING_THE_TIME_OF_USE).click();
    }

    public void waitForTimeChangeResponse(String expected){
        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElementLocated(TIME_CHANGE_RESPONSE, expected));
    }

    public void timeChangeOfUse (String expected){
        scrollQuestions();
        clickQuestionAboutChangingTheTimeOfUse();
        waitForTimeChangeResponse(expected);
    }
    public void clickQuestionAboutCharging(){
        driver.findElement(QUESTION_ABOUT_CHARGING).click();
    }

    public void waitForChargingResponse(String expected){
        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElementLocated(CHARGING_RESPONSE, expected));
    }

    public void charging (String expected) {
        scrollQuestions();
        clickQuestionAboutCharging();
        waitForChargingResponse(expected);
    }
    public void clickQuestionAboutCancelingAnOrder(){
        driver.findElement(QUESTION_ABOUT_CANCELING_AN_ORDER).click();
    }

    public void waitForOrderCancellationResponse(String expected){
        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElementLocated(ORDER_CANCELLATION_RESPONSE, expected));
    }

    public void order (String expected){
        scrollQuestions();
        clickQuestionAboutCancelingAnOrder();
        waitForOrderCancellationResponse(expected);
    }
    public void clickDeliveryQuestion(){
        driver.findElement(DELIVERY_QUESTION).click();
    }

    public void waitForDeliveryResponse(String expected){
        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElementLocated(DELIVERY_RESPONSE, expected));
    }

    public void delivery (String expected){
        scrollQuestions();
        clickDeliveryQuestion();
        waitForDeliveryResponse(expected);
    }
    public void clickFirstButtonOrder(){
        driver.findElement(FIRST_ODER_BUTTON).click();
    }

    public void waitForClickSecondButtonOrder(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(SECOND_ODER_BUTTON));
    }
    public void clickSecondButtonOrder(){
        driver.findElement(SECOND_ODER_BUTTON).click();
    }


}