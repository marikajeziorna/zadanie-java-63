import java.util.Comparator;

public class StatusComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getStatus().ordinal() - o2.getStatus().ordinal();
    }
}
