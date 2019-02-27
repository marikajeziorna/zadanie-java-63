import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdersList {
    List<Order> ordersList = new ArrayList<>();

    void add(Order order) {
        ordersList.add(order);
    }

    void changeStatus(Order order, Status status) {
        order.setStatus(status);
    }

    void sortByName() {
        Collections.sort(ordersList, new NameComparator());
    }

    void sortByPrice() {
        Collections.sort(ordersList, new PriceComparator());
    }

    void sortByStatus() {
        Collections.sort(ordersList, new StatusComparator());
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }
}
