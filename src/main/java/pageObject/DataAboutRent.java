package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DataAboutRent {

    private WebDriver driver;

    // локатор текстового поля Когда привезти самокат
    private By orderTextWhenArrived = By.xpath(".//div[@class='react-datepicker__input-container']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");

    // локатор выпадающего меню календаря Когда привезти самокат
    private By orderWhenArrivedCalendar = By.xpath(".//div[@class='react-datepicker__month']/div[1]/div");

    // локатор текстового поля Срок аренды
    private By orderRentalPeriod = By.className("Dropdown-root");

    // локатор выпадающего списка поля Срок аренды
    private By orderRentalPeriodDropdownList = By.xpath(".//div[@class='Dropdown-menu']/div");

    // локатор чекбокса Черный жемчуг для поля Комментарий для курьера
    private By orderColorBike = By.xpath(".//div[@class='Order_Checkboxes__3lWSI']/label");

    // локатор текстового поля Комментарий для курьера
    private By orderCommentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // локатор кнопки Заказать
    private By orderButtonNext = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public DataAboutRent(WebDriver driver){
        this.driver = driver;
    }
    public void fillDataAboutRent(int rentWhenArrived, int rentRentalPeriod, int rentColorBike,String rentCommentForCourier) {
        driver.findElement(orderTextWhenArrived).click();
        List<WebElement> calendarDateList = driver.findElements(orderWhenArrivedCalendar);
        calendarDateList.get(rentWhenArrived).click();

        driver.findElement(orderRentalPeriod).click();
        List<WebElement> rentalPeriodList = driver.findElements(orderRentalPeriodDropdownList);
        rentalPeriodList.get(rentRentalPeriod).click();

        //driver.findElement(orderColorBike).click();
        List<WebElement> colorBikeList = driver.findElements(orderColorBike);
        colorBikeList.get(rentColorBike).click();


        driver.findElement(orderCommentForCourier).sendKeys(rentCommentForCourier);
        driver.findElement(orderButtonNext).click();
    }

    // метод ожидания прогрузки данных для заполнения блока Про аренду
    public void waitForLoadAboutRentData() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(orderTextWhenArrived));
    }

}
