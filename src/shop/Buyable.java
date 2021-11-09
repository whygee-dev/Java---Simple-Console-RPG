package shop;

public abstract class Buyable {
    private int price;

    public Buyable(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
