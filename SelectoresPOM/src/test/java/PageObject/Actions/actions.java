package PageObject.Actions;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class actions{

    protected WebDriver driver;

    public actions(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }


    protected String getText(By locator) {
        String getText = findElement(locator).getText();
        System.out.println("El texto guardado es: " + getText);
        return null;
    }

    protected void input(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    protected void getAttribute(String inputText, By locator) {
        String getAttribute = driver.findElement(locator).getAttribute(inputText);

        System.out.println("El texto guardado es: " + getAttribute);
    }

    protected String textEquals(String textExpected, By locator){
        String getText = findElement(locator).getText();
        Assert.assertEquals(textExpected,getText);
        System.out.println("El texto esperado es: " + textExpected);
        System.out.println("El texto actual es: " + getText);
        return null;
    }

    protected void typeLeft(By locator) {
        driver.findElement(locator).sendKeys(Keys.ARROW_LEFT);
    }

    protected void clear(By locator) {
        driver.findElement(locator).clear();
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    protected void scrollDown(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,1000)");
    }

    protected void scrollUp(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,-1000)");
    }

    protected void visit(String url) {
        driver.get(url);
    }

    protected void waitImplicit(By locator) {
        try {
            WebDriverWait myWaitVar = new WebDriverWait(driver, 10);
            myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.print("No se encontro el localizador: " + locator);
            driver.quit();
        }
    }

    protected void verifyLogin(String texto,By locator) {
        try{
            driver.findElement(locator).equals(texto);
            System.out.println("Error al iniciar sesión, usuario o contraseña incorrecto");
            driver.close();
        } catch (Exception e){
            System.out.println("Ingreso correctamente al login " + locator);
        }
    }

    protected void selectElement(String texto,By locator){
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(texto);
    }

    protected void takeScreenShot(String nombre) throws Exception {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String imageFileDir = System.getProperty("user.dir") + "\\imagenes\\test";
        if (imageFileDir == null)
            imageFileDir = System.getProperty("user.dir") + "\\imagenes\\test";
        FileUtils.copyFile(scrFile, new File(imageFileDir, nombre));
    }

}
