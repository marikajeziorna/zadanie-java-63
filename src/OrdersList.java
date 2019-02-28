import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdersList {
    List<Order> ordersList = new ArrayList<>();

    void add(Order order) {
        ordersList.add(order);
    }

    void createNewOrder(String name, double price) {
        boolean newOrder = ordersList.add(new Order(ordersList.size() + 1, name, price, Status.PLACE_AN_ORDER));
        System.out.println("New order was created:" + " " + newOrder);
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
