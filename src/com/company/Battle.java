package com.company;

import java.util.ArrayList;
public class Battle {

    //ArrayList вместо массива: для хранения ячеек корабля
    private ArrayList<String> locationCells;

    //Имя корабля
    private String name;

    //Сеттер, принимающий целочисленный массив
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    //Сеттер для имени корабля
    public void setName(String string) {
        name = string;
    }

    //Метод, принимающий ход пользователя в качестве параметра String, проверяет, возвращает итог (мимо,попал)
    public String checkYourself(String userInput) {

        //Переменная результата
        String result = "Мимо";

        //Если ход игрока совпал с одной из ячеек корабля, то метод indexOf() вернет местоположение. Если нет, вернет "-1"
        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Потопил";
                System.out.println("Вы потопили: " + name);
            }
            else {
                result = "Попал";
            }
        }
        //Возврат "мимо", "попал" или "потопил"
        return result;
    }
}