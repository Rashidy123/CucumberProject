package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;
import java.util.Map;

public class AddEmployee extends CommonMethods {
    @When("user enters employees using data table and save them")
    public void user_enters_employees_using_data_table_and_save_them(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> employeenames = dataTable.asMaps();
        //from list of maps to one map at a time
        for (Map<String, String> employee :
                employeenames) {


            sendText(employee.get("firstName"), addEmployeePage.firstnameLocator);
            sendText(employee.get("middleName"), addEmployeePage.middlenameLocator);
            sendText(employee.get("lastName"), addEmployeePage.lastnameLocator);
            click(addEmployeePage.saveButton);


        }

    }

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement PimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        click(PimOption);
    }

    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
        click(addEmployeeOption);
    }

    @And("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }

    @When("user enters employee id and save it")
    public void user_enters_employee_id_and_save_it(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> employeenames = dataTable.asMaps();
        //from list of maps to one map at a time
        for (Map<String, String> employee :
                employeenames) {


            sendText(employee.get("firstName"), addEmployeePage.firstnameLocator);
            sendText(employee.get("middleName"), addEmployeePage.middlenameLocator);
            sendText(employee.get("lastName"), addEmployeePage.lastnameLocator);
            sendText("employeeID", addEmployeePage.empIdTextBox);

            click(addEmployeePage.saveButton);


        }
    }
    @When("user enters incomplete information and see error message")
    public void user_enters_incomplete_information_and_see_error_message(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeenames = dataTable.asMaps();
        //from list of maps to one map at a time
        for (Map<String, String> employee :
                employeenames) {


            sendText(employee.get("firstName"), addEmployeePage.firstnameLocator);
            sendText(employee.get("middleName"), addEmployeePage.middlenameLocator);
            sendText(employee.get("lastName"), addEmployeePage.lastnameLocator);
            sendText("employeeID", addEmployeePage.empIdTextBox);
            click(addEmployeePage.saveButton);
            WebElement error=driver.findElement(By.xpath("//div[@class='message warning fadable']"));
            error.isDisplayed();




        }
    }
}






