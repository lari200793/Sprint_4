import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AboutRentPage {
    private WebDriver driver;
    // дата заказа
    private final By ORDER_DATE = By.xpath(".//*[@placeholder='* Когда привезти самокат']");
    // срок аренды
    private final By ORDER_TIME = By.className("Dropdown-root");
    // меню срока аренды
    private final By RENT_ONE_DAY = By.xpath(     "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    private final By RENT_TWO_DAYS = By.xpath ( "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]");
    private final By RENT_TREE_DAYS = By.xpath ( "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]");
    private final By RENT_FOUR_DAYS = By.xpath(  "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[4]");
    private final By RENT_FIVE_DAYS = By.xpath(  "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[5]");
    private final By RENT_SIX_DAYS = By.xpath(  "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[6]");
    private final By RENT_SEVEN_DAYS = By.xpath(  "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[7]");
        // цвет самоката
    private final By COLOR_SCOOTER_BLACK = By.xpath(".//*[@class='Checkbox_Label__3wxSf' and @for='black']");
    private final By COLOR_SCOOTER_GREY = By.xpath(".//*[@class='Checkbox_Label__3wxSf' and @for='grey']");
    // комметарий для курьера
    private final By COMMENT_FOR_THE_COURIER = By.xpath(".//*[@placeholder='Комментарий для курьера']");
    // кнопка заказать
    private final By BUTTON_FOR_ORDERING_THE_RENTAL_FORM = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]");
    // кнопка да
    private final By BUTTON_YES = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");
    // заголовок формы заказа
    private final By ORDER_FORM_HEADER = By.className("Order_ModalHeader__3FDaJ");


    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String findHeaderFormRental() {
        return (driver.findElement(ORDER_FORM_HEADER).getText());
    }

    public void sendDate(String date) {
        driver.findElement(ORDER_DATE).sendKeys(date);
        driver.findElement(ORDER_DATE).sendKeys(Keys.ENTER);
    }

    public void selectOderTime( String day) {
        driver.findElement(ORDER_TIME).click();
        switch (day) {
            case "one":
                driver.findElement(RENT_ONE_DAY).click();
                break;
            case "two":
                driver.findElement(RENT_TWO_DAYS).click();
                break;
            case "three":
                driver.findElement(RENT_TREE_DAYS).click();
                break;
            case "four":
                driver.findElement(RENT_FOUR_DAYS).click();
                break;
            case "five":
                driver.findElement(RENT_FIVE_DAYS).click();
                break;
            case "six":
                driver.findElement(RENT_SIX_DAYS).click();
                break;
            case "seven":
                driver.findElement(RENT_SEVEN_DAYS).click();
                break;
        }
    }




    public void selectColourScooter(String colour) {
        if (colour == "black") {
            driver.findElement(COLOR_SCOOTER_BLACK).click();
        } else {
            driver.findElement(COLOR_SCOOTER_GREY).click();
        }
    }

    public void clickButtonOder() {
        driver.findElement(BUTTON_FOR_ORDERING_THE_RENTAL_FORM).click();
        driver.findElement(BUTTON_YES).click();
    }
    public void sendComment(String comment){
        driver.findElement(COMMENT_FOR_THE_COURIER).sendKeys(comment);
    }
}