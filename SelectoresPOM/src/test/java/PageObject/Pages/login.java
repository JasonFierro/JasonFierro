package PageObject.Pages;

import PageObject.Actions.actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;

public class login extends actions {

    public login(WebDriver driver) {
        super(driver);
    }

    By user = By.xpath("//input[@id='Username']");
    By pass = By.xpath("//input[@id='regular-password']");
    By login = By.xpath("//input[@id='regular-signin']");
    By dashBoard = By.xpath("//td[contains(.,'Jason Andres  Fierro Hernandez')]");

    public void login() throws InterruptedException {
        waitImplicit(user);
        input("User",user);
        System.out.println("Este es el usuario: " + user);
        waitImplicit(pass);
        input("Password",pass);
        waitImplicit(login);
        click(login);
        waitImplicit(dashBoard);
        Thread.sleep(2000);
        getText(dashBoard);
        Thread.sleep(2000);
        textEquals("Jason Andres Fierro Hernandez", dashBoard);
    }
}
