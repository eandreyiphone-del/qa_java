package com.example;

import java.util.Arrays;
import java.util.List;

public class Feline extends Animal implements Predator {

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    public int getKittens() {
        return getKittens(1); // Возвращаем количество котят, заданное по умолчанию
    }

    public int getKittens(int kittensCount) {
        return kittensCount; // Метод для задания произвольного количества котят
    }
}