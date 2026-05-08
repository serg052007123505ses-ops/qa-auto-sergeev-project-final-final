package com.sergeev.qa.api;

import com.sergeev.qa.config.ConfigLoader;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * API Client для работы с REST сервисом
 * Паттерн: Builder Pattern
 * Уровень тестирования: Интеграционное (Integration Testing)
 */
public class ApiClient {

    private final RequestSpecification requestSpec;

    public ApiClient() {
        this.requestSpec = initRequestSpec();
    }

    private RequestSpecification initRequestSpec() {
        return RestAssured
                .given()
                .baseUri(ConfigLoader.getConfig().getApiBaseUrl())
                .basePath("/" + ConfigLoader.getConfig().getApiVersion())
                .header("app-id", ConfigLoader.getConfig().getApiAppId())
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .log().all();
    }

    public Response getUsers() {
        return requestSpec
                .when()
                .get("/user")
                .then()
                .log().all()
                .extract().response();
    }

    public Response getUserById(String userId) {
        return requestSpec
                .when()
                .get("/user/" + userId)
                .then()
                .log().all()
                .extract().response();
    }

    public Response createUser(String body) {
        return requestSpec
                .when()
                .body(body)
                .post("/user/create")
                .then()
                .log().all()
                .extract().response();
    }

    public Response updateUser(String userId, String body) {
        return requestSpec
                .when()
                .body(body)
                .put("/user/" + userId)
                .then()
                .log().all()
                .extract().response();
    }

    public Response deleteUser(String userId) {
        return requestSpec
                .when()
                .delete("/user/" + userId)
                .then()
                .log().all()
                .extract().response();
    }

    public Response getPosts() {
        return requestSpec
                .when()
                .get("/post")
                .then()
                .log().all()
                .extract().response();
    }

    public Response getPostById(String postId) {
        return requestSpec
                .when()
                .get("/post/" + postId)
                .then()
                .log().all()
                .extract().response();
    }

    public Response createPost(String body) {
        return requestSpec
                .when()
                .body(body)
                .post("/post/create")
                .then()
                .log().all()
                .extract().response();
    }

    public Response updatePost(String postId, String body) {
        return requestSpec
                .when()
                .body(body)
                .put("/post/" + postId)
                .then()
                .log().all()
                .extract().response();
    }

    public Response deletePost(String postId) {
        return requestSpec
                .when()
                .delete("/post/" + postId)
                .then()
                .log().all()
                .extract().response();
    }

    public Response getComments() {
        return requestSpec
                .when()
                .get("/comment")
                .then()
                .log().all()
                .extract().response();
    }

    public Response getCommentById(String commentId) {
        return requestSpec
                .when()
                .get("/comment/" + commentId)
                .then()
                .log().all()
                .extract().response();
    }

    public Response createComment(String body) {
        return requestSpec
                .when()
                .body(body)
                .post("/comment/create")
                .then()
                .log().all()
                .extract().response();
    }
}