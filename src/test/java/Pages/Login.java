package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Login {


    public void LoginActions(WebDriver driver, String username, String password) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Launch turnUp Portal and navigate to login page
        String baseURL = "http://horse.industryconnect.io/Account/Login";
        driver.navigate().to(baseURL);

        //Identify username textbox and enter valid username
        WebElement usernameTextbox = driver.findElement(By.id("UserName"));
        usernameTextbox.sendKeys(username);

        //Identify password textbox and enter valid password
        WebElement passwordTextbox = driver.findElement(By.id("Password"));
        passwordTextbox.sendKeys(password);

        //Identify login button and click on the button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/input[1]"));
        loginButton.click();
    }

    }

