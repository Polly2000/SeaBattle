package com.company;

public class BattleGame {

    public static void main(String[] args) {

        //Переменная для подсчета количества попыток игрока
        int numOfGuess = 0;

        //Создание объекта GameHelper, необходимого для пользовательского ввода
        GameHelper helper = new GameHelper();

        //Создание объекта потопляемого в будущем корабля :)
        Battle shipObject = new Battle();

        //Генерация случайного числа, с которого будет начинаться массив нашего корабля(массив для хранения адреса ячеек)
        int random = (int) (Math.random() * 5);

        //Массив для хранения рандомных чисел
        int[] locations = {random, random + 1, random + 2};

        //Передает кораблю местоположение массива/ячеек
        shipObject.setLocationCells(locations);

        //Переменная для проверки, не закончилась ли игра
        boolean isAlive = true;

        while (isAlive == true) {

            //Пока идет игра, программа просит ввести число
            String guess = helper.getUserInput("Введите число");

            //Сохранение полученного результата
            String result = shipObject.checkYourself(guess);

            //Увеличивается значение переменной для хранения количество попыток игрока
            numOfGuess++;

            //Когда корабль потоплен, игра заканчивается, и выводится итог
            if (result.equals("Потопил")) {
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuess + " попыток(и)");
            }
        }
    }
}

