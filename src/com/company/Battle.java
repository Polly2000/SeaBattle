package com.company;

public class Battle {

    //Переменная подсчета количества попаданий
    int numOfHits = 0;

    //Массив для хранения адреса ячеек
    int[] locationCells;

    //Сеттер, принимающий целочисленный массив
    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    //Метод, принимающий ход пользователя в качестве параметра String, проверяет, возвращает итог (мимо,попал)
    public String checkYourself(String stringGuess) {

        //Переменная для хранения значения, введенного пользователем, преобразование полученного в тип int
        int guess = Integer.parseInt(stringGuess);

        //Переменная результата
        String result = "Мимо";

        //Цикл, повторяющий для каждого элемента массива locationCells
        for (int cell : locationCells) {

            //Условие на попадание в корабль
            if (guess == cell) {
                result = "Попал";
                numOfHits++;
                break;
            }
        }

        //Условие на уничтожение целого корабля
        if (numOfHits == locationCells.length) {
            result = "Потопил";
        }

        //Вернуть результат
        System.out.println(result);
        return result;

    }


}
