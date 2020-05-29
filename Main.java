
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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Product> productList = new ArrayList<>();
    static Scanner scanner;
    static Scanner userScanner;
    static String nameEnteredByUser;
    static double priceEnteredByUser;
    static int dateEnteredByUser;

    public static void main(String[] args) {
        Sorter sorter = new Sorter();

        {
            try {
                scanner = new Scanner(new File("src\\Items.txt"));
                userScanner = new Scanner(System.in);

                while (scanner.hasNext()) {
                    productList.add(new Product(scanner.nextInt(), scanner.next(), scanner.nextLong(), scanner.next(), scanner.nextDouble(), scanner.nextInt(), scanner.nextInt()));
                }
                scanner.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Введите наименование продукта");
        nameEnteredByUser = userScanner.next();
        nameEnteredByUser = nameEnteredByUser.trim().toLowerCase();

        Sorter.counter = 0;
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).setName(productList.get(i).getName().trim().toLowerCase());
            sorter.sortByName(productList.get(i));
        }
        sorter.itemNotFound();

        System.out.println("\nВведите значение цены");
        priceEnteredByUser = userScanner.nextInt();

        Sorter.counter = 0;
        for (int i = 0; i < productList.size(); i++) {
            sorter.sortByNameAndPrice(productList.get(i));
        }
        sorter.itemNotFound();

        System.out.println("\nВведите срок хранения");
        dateEnteredByUser = userScanner.nextInt();

        Sorter.counter = 0;
        for (int i = 0; i < productList.size(); i++) {
            sorter.sortByDate(productList.get(i));
        }
        sorter.itemNotFound();
    }
}