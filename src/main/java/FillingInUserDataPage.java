import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FillingInUserDataPage {
    private WebDriver driver;
    //заголовок  формы заказа
    private final By TITLE_FOR_THE_ODER_FORM = By.className("Order_Header__BZXOb");
    // поля для заполнения имени заказчика
    private final By CLIENT_NAME =By.xpath("//*[@placeholder='* Имя']");
    // поле для заполнения Фамиллии заказчика

    private final By CLIENT_SECOND_NAME= By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    // поле для заполнения адреса заказчика
    private final By CLIENT_ADDRESS = By.xpath("//*[@placeholder='* Адрес: куда привезти заказ']");
    // поле для заполнения станции метро
    private final By METRO_STATION = By.className("select-search__input");
    // поле для заполнения номера телефона
    private final By PHONE_NUMBER = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    // кнопка далее
    private final By NEXT_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");


    public FillingInUserDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitTitleForTheOderForm(String expected){
        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElementLocated(TITLE_FOR_THE_ODER_FORM , expected));
    }
    public void enterClientName( String name){
       driver.findElement(CLIENT_NAME).sendKeys(name);
    }
    public void entrerClientSecondName(String secondName){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(CLIENT_SECOND_NAME));
        driver.findElement(CLIENT_SECOND_NAME).sendKeys(secondName);
    }
    public void enterClientAddress(String address){
        driver.findElement(CLIENT_ADDRESS).sendKeys(address);
    }
    public void enterStationMetro(String metro){
        driver.findElement(METRO_STATION).sendKeys(metro);
        driver.findElement(METRO_STATION).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(METRO_STATION).sendKeys(Keys.ENTER);
    }
    public void enterPhoneNumber(String number){
        driver.findElement(PHONE_NUMBER).sendKeys(number);
    }
    public void enterButtonNext(){
        driver.findElement(NEXT_BUTTON).click();

    }

}
