package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderBikeButtons {
    private WebDriver driver;
    // локатор кнопки Заказать в футере сайта
    private By orderHeaderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    // локатор кнопки Заказать в середине сайта
    private By orderMiddleButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    public OrderBikeButtons(WebDriver driver){
        this.driver = driver;
    }
    public void clickOrderHeaderButton() {
        driver.findElement(orderHeaderButton).click();
    }

    public void clickOrderMiddleButton() {
        WebElement element = driver.findElement(orderMiddleButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderMiddleButton).click();
    }

}
