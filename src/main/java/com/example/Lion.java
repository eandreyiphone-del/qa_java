package com.example;

import java.util.List;

public class Lion {
    private final Feline feline;
    private final boolean hasMane;

    /**
     * Инъекция готового объекта Feline в конструктор.
     */
    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens(); // Использование объекта Feline
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.eatMeat(); // Получаем рацион питания через объект Feline
    }

    public String getFamily() {
        return "Кошачьи";
    }

    public String makeSound() {
        return "Ррр!";
    }
}
