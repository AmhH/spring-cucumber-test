package stepdefinition;

import com.example.controller.EmployeeController;
import com.example.model.EmployeeResponse;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class PersonStepDef {

    EmployeeController employeeController = new EmployeeController();
    EmployeeResponse employeeResponse;

    /**
     * public PersonStepDef() {
     *         Given("^an employee works here$", () -> {
     *         });
     *     }
     */
    @Given("^an employee works here$")
    public void anEmployeeWorksHere(DataTable dataTable) {
    }

    @When("^the api is invoked$")
    public void theApiIsInvoked() {
        employeeResponse = employeeController.allEmployeesMethod();
    }

    @Then("^the response code is \"([^\"]*)\"$")
    public void theResponseCodeIs(String statusCode) {
        assertThat(employeeResponse.getStatus(), is(statusCode));
    }

    @And("^an employee with \"([^\"]*)\" with \"([^\"]*)\"$")
    public void anEmployeeWithWith(String id, String salary) {
        assertTrue(employeeResponse.getData().stream()
                .anyMatch(a -> id.equalsIgnoreCase(a.getId())
                        && salary.equalsIgnoreCase(a.getEmployee_salary())));
    }

    @And("^with \"([^\"]*)\" with \"([^\"]*)\"$")
    public void withWith(String arg0, String arg1) {

    }

    @And("^\"([^\"]*)\" years old$")
    public void yearsOld(String arg0)  {
    }

    @And("^employee \"([^\"]*)\"$")
    public void employee(String arg0)  {
    }

    @And("^returned value is \"([^\"]*)\"$")
    public void returnedValueIs(String arg0)  {
    }
}
