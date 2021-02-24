package PageObject.Pages;

import PageObject.Actions.actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pageDashBoard extends actions {

    public pageDashBoard(WebDriver driver) {
        super(driver);
    }

    By dashboard = By.cssSelector("a[href='/dashboard']");
    By name = By.className("name");
    By email = By.className("email");
    By following = By.cssSelector("div.left-zone > .table-header > a");
    By projects = By.id("projects-filter-link");

    public void dashBoard() throws InterruptedException {
        click(dashboard);
        waitImplicit(name);
        textEquals("Jason Andres Fierro Hernandez",name);
        Thread.sleep(2000);
        textEquals("Jason.fierro@evertecinc.com",email);
        Thread.sleep(2000);
        textEquals("Following",following);
        Thread.sleep(2000);
        textEquals("Projects",projects);
        Thread.sleep(2000);
    }
}
