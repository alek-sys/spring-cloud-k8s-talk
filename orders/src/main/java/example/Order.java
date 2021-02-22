package example;

import java.util.Objects;

public class Order {

    private final String title;
    private final Integer qty;

    public Order(String title, Integer qty) {
        this.title = title;
        this.qty = qty;
    }

    public String getTitle() {
        return title;
    }

    public Integer getQty() {
        return qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(title, order.title) && Objects.equals(qty, order.qty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, qty);
    }
}
