package ru.netology.delivery.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class DeliveryTest {

    @Test
    void shouldSuccessfulPlanAndReplanMeeting() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue(DataGenerator.generateCity());
        $("[data-test-id='date'] input").doubleClick().sendKeys((DataGenerator.generateDate(8)));
        $("[data-test-id='name'] input").setValue(DataGenerator.generateName());
        $("[data-test-id='phone'] input").setValue(DataGenerator.generatePhone());
        $("[data-test-id='agreement']").click();
        $(".button").click();
        $(".notification").shouldHave(Condition.text("Встреча успешно запланирована на " + DataGenerator.generateDate(8)), Duration.ofSeconds(15)).should(visible);
        $("[data-test-id='date'] input").doubleClick().sendKeys((DataGenerator.generateDate(10)));
        $(".button").click();
        $(".icon-button").click();
        $(".notification").shouldHave(Condition.text("Встреча успешно запланирована на " + DataGenerator.generateDate(10)), Duration.ofSeconds(15)).should(visible);

    }

}