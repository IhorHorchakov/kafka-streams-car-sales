package com.example.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.temporal.WeekFields.WEEK_BASED_YEARS;

@UtilityClass
public class RandomGenerator {
    private static final Random random = new Random();

    public <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int randomIndex = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[randomIndex];
    }

    public <T> T randomListItem(List<T> list) {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public int randomIntegerInRange(int from, int to) {
        return random.nextInt(to - from) + from;
    }

    public LocalDate randomDate() {
        return randomDateInRange(LocalDate.now().minus(10, WEEK_BASED_YEARS) ,LocalDate.now());
    }

    public LocalDate randomDateInRange(LocalDate from, LocalDate to) {
        long startEpochDay = from.toEpochDay();
        long endEpochDay = to.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}
