package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DataBikeOwner {

    private WebDriver driver;

    // локатор текстового поля Имя
    private By orderTextName = By.xpath(   ".//input[@placeholder='* Имя']");
    // локатор текстового поля Фамилия
    private By orderTextSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    // локатор текстового поля Адрес
    private By orderTextAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // локатор текстового поля Станция метро
    private By orderTextSubway = By.className("select-search__input");
    // локатор блока кнопок списка Станция метро
    private By orderSubwayElements = By.xpath(".//ul[@class='select-search__options']/li/button[@class='Order_SelectOption__82bhS select-search__option']");
    // локатор текстового поля Номер телефона
    private By orderTextPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // локатор кнопки Далее
    private By orderButtonNext = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    public DataBikeOwner(WebDriver driver){
        this.driver = driver;
    }
    public void fillDataBikeOwner(String ownerName, String ownerSurname, String ownerAddress, int ownerSubway, String ownerPhoneNumber) {
        driver.findElement(orderTextName).sendKeys(ownerName);
        driver.findElement(orderTextSurname).sendKeys(ownerSurname);
        driver.findElement(orderTextAddress).sendKeys(ownerAddress);
        driver.findElement(orderTextSubway).click();
        List<WebElement> options = driver.findElements(orderSubwayElements);
        options.get(ownerSubway).click();
        driver.findElement(orderTextPhoneNumber).sendKeys(ownerPhoneNumber);
        driver.findElement(orderButtonNext).click();
    }

    // метод ожидания прогрузки данных для заполнения блока Для кого самокат
    public void waitForLoadBikeOwnerData() {
        //new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(orderTextName));
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(orderTextName) ));
    }
}
