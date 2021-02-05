package apiautomation;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestAssuredApiTest {


    @Test
    public void getTest1() {


        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("http://dummy.restapiexample.com/public/api/v1/employees")
                .then()
                .assertThat()
                //performs Status code Success validation
                .statusCode(200)
                .assertThat()
                //performs assertion of employee details ar index 0
                .body("data[0].employee_name", equalTo("Tiger Nixon"))
                .body("data[0].employee_salary", equalTo(320800))
                .body("data[0].id", equalTo(1))
                .body("data[0].employee_age", equalTo(61))
                .body("data[0].profile_image", equalTo(""));


    }

    @Test
    public void getTest2() {


        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("http://dummy.restapiexample.com/api/v1/employee/1")
                .then()
                .assertThat()
                //performs Status code Success validation
                .statusCode(200)
                .assertThat()
                //performs assertion of employee details
                .body("data.employee_name", equalTo("Tiger Nixon"))
                .body("data.employee_salary", equalTo(320800))
                .body("data.id", equalTo(1))
                .body("data.employee_age", equalTo(61))
                .body("data.profile_image", equalTo(""));


    }

    @Test
    public void deleteTest() {

        given().when().delete("http://dummy.restapiexample.com/api/v1/delete/4")
                .then()
                .assertThat()
                //performs Status code Success validation
                .statusCode(200)
                .assertThat()
                .body("message", equalTo("Successfully! Record has been deleted"))

        ;
    }
}
