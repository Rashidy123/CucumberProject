package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginSteps extends CommonMethods {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @When("the user enters an empty username and a password")
    public void the_user_enters_an_empty_username_and_a_password() {
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }
    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        click(loginPage.loginButton);
    }
    @Then("the system should display an error message {string}")
    public void the_system_should_display_an_error_message(String string) {
        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals("Username cannot be empty", actualMessage);
    }

    @When("the user enters a username and an empty password")
    public void the_user_enters_a_username_and_an_empty_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
    }
    @Then("the system should display error message {string}")
    public void the_system_should_display_error_message(String string) {
        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals("Password is Empty", actualMessage);
    }

    @When("the user enters an invalid username and password")
    public void the_user_enters_an_invalid_username_and_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }
    @Then("an error message {string}")
    public void an_error_message(String string) {
        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals("Invalid credentials", actualMessage);
    }
    @When("the user enters a valid username and valid password")
    public void the_user_enters_a_valid_username_and_valid_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }
    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        Assert.assertEquals("Welcome Admin", dashboardPage.welcomeText.getText());
       // System.out.println("test passed");
    }




}





