package by.itacademy.filenkovvladislav.taf.kufar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageUI extends LocatorsUI {
    private final WebDriver driver;

    public PageUI(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebSite() {
        driver.get(baseUrl);
    }

    public void clickButtonLogin() {
        driver.findElement(By.xpath(buttonLoginByXpath)).click();
    }

    public void inputLogin(String email) {
        driver.findElement(By.id(inputLoginById)).sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(By.id(inputPasswordById)).sendKeys(password);
    }

    public void clickButtonSubmit() {
        driver.findElement(By.xpath(buttonSubmitByXpath)).click();
    }

    public void closeCookie() {
        driver.findElement(By.xpath(buttonCookieByXpath)).click();
    }

    public String getAlertText(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alertText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return alertText.getText();
    }

    public void closePopUp() {
        try {
            WebDriverWait frameWait = new WebDriverWait(driver, Duration.ofSeconds(1));
            WebElement iframeElement = frameWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(iframePopUpByXpath)));
            driver.switchTo().frame(iframeElement);
            WebDriverWait buttonWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement closeButton = buttonWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(buttonClosePopUpById)));
            closeButton.click();
            driver.switchTo().defaultContent();
        } catch (TimeoutException e) {
        }
    }
}

