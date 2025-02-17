package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    @Before
    public void start(){
        openBrowserAndLaunchApplication();
        // driver = new ChromeDriver();
        // driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        // driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void end(Scenario scenario){
        //scenario class has complete information about the execution
        // driver.quit();
        byte[] pic;

        if (scenario.isFailed()) {
            pic = takeScreenshot("passed/"+scenario.getName());
        } else {
            pic = takeScreenshot("failed/"+scenario.getName());
        }

        scenario.attach(pic,"image/png",scenario.getName());

        closeBrowser();
    }

}
