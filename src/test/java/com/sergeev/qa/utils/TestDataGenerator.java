package com.sergeev.qa.utils;

import com.github.javafaker.Faker;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

/**
 * Генератор тестовых данных
 * Используется для создания уникальных данных при каждом запуске
 */
public class TestDataGenerator {

    private static final Faker faker = new Faker();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String getRandomUsername() {
        return faker.name().username();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomPhone() {
        return faker.phoneNumber().cellPhone();
    }

    public static String getRandomTitle() {
        return faker.book().title();
    }

    public static String getRandomText() {
        return faker.lorem().paragraph();
    }

    public static String getRandomZipCode() {
        return faker.address().zipCode();
    }

    public static Map<String, Object> generateUserData() {
        Map<String, Object> user = new HashMap<>();
        user.put("firstName", getRandomFirstName());
        user.put("lastName", getRandomLastName());
        user.put("email", getRandomEmail());
        user.put("phone", getRandomPhone());
        return user;
    }

    public static Map<String, Object> generatePostData(String userId) {
        Map<String, Object> post = new HashMap<>();
        post.put("owner", userId);
        post.put("text", getRandomText());
        post.put("image", faker.internet().image());
        return post;
    }

    public static String objectToJsonString(Object object) throws Exception {
        return mapper.writeValueAsString(object);
    }
}