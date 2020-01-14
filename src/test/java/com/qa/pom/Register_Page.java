package com.qa.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Register_Page extends Base {
    By registerLinkLocator = By.linkText("REGISTER");
    By signOnLinkLocator = By.linkText("SIGN-ON");

    By registerImagePageLocator = By.xpath("//img[@src='/images/masts/mast_register.gif']");
    By singOnImagePageLocator = By.xpath("//img[@src='/images/masts/mast_signon.gif']");
    By flightsImageLocator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");

    By usernameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");

    By userNameSigOn = By.name("userName");

    By registerButtonLocator = By.name("register");
    By signOnButtonLocator = By.name("login");

    By fontLocator = By.tagName("font");
    public Register_Page(WebDriver driver) {
        super(driver);
    }

    public void registerUser() throws InterruptedException {
        click(registerLinkLocator);
        Thread.sleep(2000);
        if (isDisplayed(registerImagePageLocator)) {
            type("fantasma", usernameLocator);
            type("fantas", passwordLocator);
            type("fantas", confirmPasswordLocator);

            click(registerButtonLocator);
        } else {
            System.out.println("Page Register not found");

        }
    }

    public String registerMessage() {
        List<WebElement> fonts = findElements(fontLocator);
        return getText(fonts.get(5));
    }

    public void signOn()throws InterruptedException{
        click(signOnLinkLocator);
        Thread.sleep(2000);
        if(isDisplayed(singOnImagePageLocator)){
            type("pecador", userNameSigOn);
            type("pecas", passwordLocator);

            click(signOnButtonLocator);
        }else{
            System.out.println("Page Register not found");
        }
    }

    public Boolean isDisplayedSignOn() {
        return isDisplayed(flightsImageLocator);
    }
}