package com.example;

import java.util.List;

public class Lion {
    private final Predator predator;
    private final boolean hasMane;

    public Lion(String sex, Predator predator) throws Exception {
        this.predator = predator;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return ((Feline) predator).getKittens(); // Обращаемся к методу getKittens через кастинг предатора
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat(); // Теперь используем интерфейс Predator
    }

    public String getFamily() {
        return "Кошачьи"; // Переместил метод сюда, так как больше нет прямой зависимости от Feline
    }

    public String makeSound() {
        return "Ррр!";
    }
}
