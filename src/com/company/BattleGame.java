package com.company;

//import helpers.GameHelper;
import java.util.*;

public class BattleGame {
    private GameHelper helper = new GameHelper();
    private ArrayList<Battle> shipObjectList = new ArrayList<Battle>();
    private int numOfGuesses = 0;

    //Создание кораблей по имени
    private void setUpGame() {
        Battle one = new Battle();
        one.setName("Инопланетный корабль");
        Battle two = new Battle();
        two.setName("Плот робинзона");
        Battle three = new Battle();
        three.setName("Корабль твоего врага");
        shipObjectList.add(one);
        shipObjectList.add(two);
        shipObjectList.add(three);

        System.out.println("Цель - потопить три корабля: ");
        System.out.println("Кораблик1, Кораблик2, Кораблик3");
        System.out.println("Внимание! Данные устарели. Мы не знаем, сколько на самом деле кораблей.");
        System.out.println("Необходимо потопить их на минимальное количество ходов, удачи!");

        for (Battle battleToSet : shipObjectList) {

            //Запрос на место корабля
            ArrayList<String> newLocation = helper.placeBattleGame(3);

            //Вызов сеттера, чтобы передать ему местоположение корабля, какое только что получили
            battleToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!shipObjectList.isEmpty()) {
            String userGuess = helper.getUserInput("Сделай ход: ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Мимо";

        //Повторяем для всех объектов shipObjectList
        for (Battle shipObjectListTest : shipObjectList) {

            //Ищем попадание или потопление
            result = shipObjectListTest.checkYourself(userGuess);

            if (result.equals("Попал")) {
                break;
            }
            if (result.equals("Потопил")) {
                //Удаляем из списка корабль
                shipObjectList.remove(shipObjectListTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("Корабли уничтожены! Браво, Адмирал!");
        if (numOfGuesses <= 18) {
            System.out.println("Капитан, это заняло у вас всего " + numOfGuesses + "попыток");
        } else {
            System.out.println("Вы теперь матрос... " + numOfGuesses + " попыток.");
            System.out.println("Идем ко дну целым составом...");
            System.out.println("..Прощайте..");
        }
    }

    public static void main(String[] args) {
        BattleGame game = new BattleGame();
        game.setUpGame();
        game.startPlaying();
    }
}

