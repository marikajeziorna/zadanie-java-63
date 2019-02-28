public class Order {
    private int id;
    private String name;
    private Status status;
    private double price;

    public Order(int id, String name, double price, Status status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }


    public void setStatus(Status status) {
        if (status.ordinal() < this.status.ordinal()) {
            System.out.println("You can't change status backward.");
        } else if (status == Status.CANCELED && this.status.ordinal() > Status.READY_TO_SEND.ordinal()) {
            System.out.println("You can't cancel order.");
        } else {
            this.status = status;
        }
    }
}
