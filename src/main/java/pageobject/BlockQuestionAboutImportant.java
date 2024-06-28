package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BlockQuestionAboutImportant {

    private WebDriver driver;
    // локатор кнопки 1ого вопроса типа аккордеон
    private By questionAboutImportant = By.xpath(".//div[@class='accordion__heading']/div[@class='accordion__button']");
    // локатор блока Ответа на 1ый вопрос
    private By answerAboutImportant = By.xpath(".//div[@class='accordion__panel']/p");

    public BlockQuestionAboutImportant(WebDriver driver){
        this.driver = driver;
    }

    public void checkTextAnswerAboutImportant(String answerExpected, int numberOfQuestionandAnswerAtList) {
        WebElement element = driver.findElement(questionAboutImportant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        List<WebElement> elementsQuesiton = driver.findElements(questionAboutImportant);
        elementsQuesiton.get(numberOfQuestionandAnswerAtList).click();

        List<WebElement> elementsAnswer = driver.findElements(answerAboutImportant);
        String actualAnswer= elementsAnswer.get(numberOfQuestionandAnswerAtList).getText();

        Assert.assertEquals(answerExpected,actualAnswer);
    }

}
