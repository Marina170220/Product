
//Создать классы, спецификации которых приведены ниже.
// Определить конструкторы и методы setТип(), getТип(), toString().
// Определить дополнительно методы в классе, создающем массив объектов.
// Задать критерий выбора данных и вывести эти данные на консоль.
// В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

//Product: id, Наименование, UPC, Производитель, Цена, Срок хранения, Количество.
//Создать массив объектов. Вывести:
//a) список товаров для заданного наименования;
//b) список товаров для заданного наименования, цена которых не превосходит заданную;
//c) список товаров, срок хранения которых больше заданного.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Product[] productList;
    static Scanner scanner;
    static Scanner userScanner;
    static String nameEnteredByUser;
    static double priceEnteredByUser;
    static int dateEnteredByUser;

    public static void main(String[] args) {
        {
            try {
                scanner = new Scanner(new File("src\\Items.txt"));
                userScanner = new Scanner(System.in);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Введите наименование продукта");
        nameEnteredByUser = userScanner.next();
        nameEnteredByUser = nameEnteredByUser.trim().toLowerCase();

        Sorter sorter = new Sorter();
        productList = new Product[8];
        Sorter.counter = 0;
        for (int i = 0; i < productList.length; i++) {
            if (scanner.hasNext()) {
                productList[i] = new Product(scanner.nextInt(), scanner.next(), scanner.nextLong(), scanner.next(), scanner.nextDouble(), scanner.nextInt(), scanner.nextInt());
                productList[i].setName(productList[i].getName().trim().toLowerCase());
                sorter.sortByName(productList[i]);
            }
        }
        scanner.close();
        if (Sorter.counter == 0) {
            sorter.itemNotFound();
        }

        System.out.println("Введите значение цены");
        priceEnteredByUser = userScanner.nextInt();

        Sorter.counter = 0;
        for (int i = 0; i < productList.length; i++) {
            sorter.sortByNameAndPrice(productList[i]);
        }
        if (Sorter.counter == 0) {
            sorter.itemNotFound();
        }

        System.out.println("Введите срок хранения");
        dateEnteredByUser = userScanner.nextInt();

        Sorter.counter = 0;
        for (int i = 0; i < productList.length; i++) {
            sorter.sortByDate(productList[i]);
        }
        if (Sorter.counter == 0) {
            sorter.itemNotFound();
        }
    }
}