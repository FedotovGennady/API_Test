package ru.yandex.drive;

import io.restassured.http.ContentType;
import io.restassured.http.Header;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class GetFileList {
    public void GetFileList(){
        List<DiscData> fileName = given()
                        .when()
                        .header(new Header("Authorization", "y0_AgAAAABllfVRAADLWwAAAADSfy3wjBbkw3HqTzK2qB9jh2h-iPQTOL8"))
                        .contentType(ContentType.JSON)
                        .get("https://cloud-api.yandex.net/v1/disk/resources/files")
                        .then()
                        .extract().body().jsonPath().getList("items" , DiscData.class);

        List<String> nameList = fileName.stream().map(DiscData::getName).collect(Collectors.toList());
        System.out.println(nameList);
    }
}
