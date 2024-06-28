package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class BlockConfirmOrder {

    private WebDriver driver;

    // локатор кнопки Да
    private By confirmOrderButtonYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    // локатор текста Заказ оформлен...
    private By allowConfirmText = By.className("Order_ModalHeader__3FDaJ");

    public BlockConfirmOrder(WebDriver driver){
        this.driver = driver;
    }
    public void confirmOrderForRentBikeAndCheckAllowConfirm(String expectedAllowConfirmText) {
        driver.findElement(confirmOrderButtonYes).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(allowConfirmText));
        assertTrue(driver.findElement(allowConfirmText).getText().contains(expectedAllowConfirmText));
    }
}
