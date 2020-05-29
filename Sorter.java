
public class Sorter implements Sort {
    static int counter;

    @Override
    public void sortByName(Product p) {
        if (p.getName().equals(Main.nameEnteredByUser)) {
            System.out.println(p.toString());
            counter++;
        }
        //если (введенное значение == наименованию продукта), {
        //выводим элемент массива
    }

    @Override
    public void sortByNameAndPrice(Product p) {
        if (p.getName().equals(Main.nameEnteredByUser) && p.getPrice() <= Main.priceEnteredByUser) {
            System.out.println(p.toString());
            counter++;
        }
        //если (введенное наименование == наименованию продукта && цена продукта <= введенной цене){
        //выводим элемент
    }

    @Override
    public void sortByDate(Product p) {
        if (p.getDate() > Main.dateEnteredByUser) {
            System.out.println(p.toString());
            counter++;
        }
        //если (срок хранения продукта > введенного значения)Х
        //выводим элемент
    }

    public void itemNotFound() {
        if (counter == 0) {
            System.out.println("К сожалению, такой товар не найден :(");
        }
    }
}
