package com.videoslots.ui.steps.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BaseStep {

    private WebDriver driver;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
    }

    public enum Pather {
        id,
        className,
        name,
        xPath,
        cssSelector,
        linkText
    }

    public enum TimeOut {
        LOW(5),
        MIDDLE(10),
        HIGH(15),
        CUSTOM_MAX(60);
        private final int value;

        public int getValue() {
            return value;
        }

        private TimeOut(int value) {
            this.value = value;
        }

    }


    public void geturl(String url)
    {
        driver.get(url);
    }



    public void waitElement(WebElement element, TimeOut timeOut) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut.value);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception ex) {

        }

    }
    public void findElementClick(String path, Pather type) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TimeOut.HIGH.value);
            switch (type) {
                case className:
                    wait.until(ExpectedConditions.elementToBeClickable(By.className(path))).click();
                    break;
                case id:
                    wait.until(ExpectedConditions.elementToBeClickable(By.id(path))).click();
                    break;
                case name:
                    wait.until(ExpectedConditions.elementToBeClickable(By.name(path))).click();
                    break;
                case xPath:
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path))).click();
                    break;
                case cssSelector:
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(path))).click();
                    break;
                case linkText:
                    wait.until(ExpectedConditions.elementToBeClickable(By.linkText(path))).click();
                    break;
                default:
                    new NotFoundException();
            }

        } catch (Exception ex) { }
    }

    // This is used for non-clickable elements
    public void findElementActionClick(String path, Pather type) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TimeOut.MIDDLE.value);
            WebElement element;
            Actions actions = new Actions(driver);

            switch (type) {
                case className:
                    actions.moveToElement(driver.findElement(By.className(path))).click().perform();
                    break;
                case id:
                    actions.moveToElement(driver.findElement(By.id(path))).click().perform();
                    break;
                case name:
                    actions.moveToElement(driver.findElement(By.name(path))).click().perform();
                    break;
                case xPath:
                    actions.moveToElement(driver.findElement(By.xpath(path))).click().perform();
                    break;
                case cssSelector:
                    actions.moveToElement(driver.findElement(By.cssSelector(path))).click().perform();
                    break;
                case linkText:
                    actions.moveToElement(driver.findElement(By.linkText(path))).click().perform();
                    break;
                default:
                    new NotFoundException();
            }



        } catch (Exception ex) { }
    }

    public WebElement findElement(String path, Pather type,TimeOut timeOut) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut.value);
            WebElement element = null;
            switch (type) {
                case className:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(path)));
                    break;
                case id:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(path)));
                    break;
                case name:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(path)));
                    break;
                case xPath:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
                    break;
                case cssSelector:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path)));
                    break;
                case linkText:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(path)));
                    break;
                default:
                    new NotFoundException();
            }
            return element;
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    public void waitForElementNotPresent(String path, Pather type,TimeOut timeOut) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut.value);
            switch (type) {
                case className:
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(path)));
                    break;
                case id:
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(path)));
                    break;
                case name:
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(path)));
                    break;
                case xPath:
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(path)));
                    break;
                case cssSelector:
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(path)));
                    break;
                case linkText:
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(path)));
                    break;
                default:
                    new NotFoundException();
            }

        }
        catch (Exception ex){}
    }

    public void SelectFrame(String path, Pather type) {

        try {
            switch (type) {
                case className:
                    driver.switchTo().frame(driver.findElement(By.className(path)));
                    break;
                case id:
                    driver.switchTo().frame(driver.findElement(By.id(path)));
                    break;
                case name:
                    driver.switchTo().frame(driver.findElement(By.name(path)));
                    break;
                case xPath:
                    driver.switchTo().frame(driver.findElement(By.xpath(path)));
                    break;
                case cssSelector:
                    driver.switchTo().frame(driver.findElement(By.cssSelector(path)));
                    break;
                case linkText:
                    driver.switchTo().frame(driver.findElement(By.linkText(path)));
                    break;
                default:
                    new NotFoundException();
            }
        }
        catch (Exception ex){}
    }


    public void waitForIFrameToLoad(String path, Pather type,TimeOut timeOut) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut.value);
            switch (type) {
                case className:
                    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className(path)));
                    break;
                case id:
                    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(path)));
                    break;
                case name:
                    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name(path)));
                    break;
                case xPath:
                    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(path)));
                    break;
                case cssSelector:
                    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(path)));
                    break;
                case linkText:
                    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.linkText(path)));
                    break;
                default:
                    new NotFoundException();
            }

        }
        catch (Exception ex){}
    }

    public void waitForElementToBeClickable(String path, Pather type,TimeOut timeOut) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut.value);
            switch (type) {
                case className:
                    wait.until(ExpectedConditions.elementToBeClickable(By.className(path)));
                    break;
                case id:
                    wait.until(ExpectedConditions.elementToBeClickable(By.id(path)));
                    break;
                case name:
                    wait.until(ExpectedConditions.elementToBeClickable(By.name(path)));
                    break;
                case xPath:
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
                    break;
                case cssSelector:
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(path)));
                    break;
                case linkText:
                    wait.until(ExpectedConditions.elementToBeClickable(By.linkText(path)));
                    break;
                default:
                    new NotFoundException();
            }

        }
        catch (Exception ex){}
    }

    public boolean isTextPresent(String text) {
        List<WebElement> foundElements = driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]"));
        return foundElements.size() > 0;
    }


    public void PageScrolldown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, 1000)");

    }

    public void PageScrollup() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, 0)");
    }
    public void DriverQuit() {
        driver.quit(); }
    }
