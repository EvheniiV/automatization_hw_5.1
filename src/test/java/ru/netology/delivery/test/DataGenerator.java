package ru.netology.delivery.test;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity() {
        String[] cityes = {
                "Москва",
                "Санкт-Петербург",
                "Псков",
                "Калининград",
                "Великий Новгород",
                "Владивосток"
        };
        int rnd = new Random().nextInt(cityes.length);
        return cityes[rnd];
    }

    public static String generateName() {
        long seed = 10;
        Faker faker = new Faker(new Locale("ru"), new Random(seed));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone() {
        String phone = "+7";
        int[] tmp = new int[10];
        for (int i = 0; i < tmp.length; i++) {
            Random rn = new Random();
            tmp[i] = rn.nextInt(9 - 0 + 1) + 0;
            phone = phone + tmp[i];
        }
        return phone;
    }

}
