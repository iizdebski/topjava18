package ru.javawebinar.topjava.web.json;

import org.junit.jupiter.api.Test;
import ru.javawebinar.topjava.model.Meal;

import java.util.List;
import static ru.javawebinar.topjava.MealTestData.*;

class JsonUtilTest {

    @Test
    void readWriteValue() throws Exception {
        String json = JsonUtil.writeValue(ADMIN_MEAL1);
        System.out.println(json);
        Meal meal = JsonUtil.readValue(json, Meal.class);
        MEAL_MATCHERS.assertMatch(meal, ADMIN_MEAL1);
    }

    @Test
    void readWriteValues() throws Exception {
        String json = JsonUtil.writeValue(MEALS);
        System.out.println(json);
        List<Meal> meals = JsonUtil.readValues(json, Meal.class);
        MEAL_MATCHERS.assertMatch(meals, MEALS);
    }

   //@Test
   // void writeOnlyAccess() throws Exception {
   //     String json = JsonUtil.writeValue(UserTestData.USER);
   //     System.out.println(json);
   //     assertThat(json, not(containsString("password")));
   //     String jsonWithPass = JsonUtil.writeAdditionProps(UserTestData.USER, "password", "newPass");
   //     System.out.println(jsonWithPass);
   //     User user = JsonUtil.readValue(jsonWithPass, User.class);
   //     assertEquals(user.getPassword(), "newPass");
   // }

}