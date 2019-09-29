package mapexporter.campus.util;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HttpUtil {

        public static Response post(String src , String body){
            return given()
                    .contentType("accept: */*")
                    .contentType("application/json")
                    .body(body)
                    .when()
                    .post(src)
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();
        }

}
