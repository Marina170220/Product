
//Product: id, Наименование, UPC, Производитель, Цена, Срок хранения, Количество.
public class Product {
    int id;
    String name;
    long upc;
    String manufacturer;
    double price;
    int date;
    int amount;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", upc=" + upc +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getDate() {
        return date;
    }

    Product(int id, String name, long upc, String manufacturer, double price, int date, int amount) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.price = price;
        this.date = date;
        this.amount = amount;
    }
}
