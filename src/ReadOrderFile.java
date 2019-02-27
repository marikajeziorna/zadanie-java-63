import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ReadOrderFile {
    public static void main(String[] args) throws IOException {
        OrdersList ordersList = new OrdersList();

        System.out.println("Order file contains: ");
        FileReader fileReader = new FileReader("OrdersFile.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] position = line.split(";");
            Order order = new Order(Integer.parseInt(position[0]), position[1], Integer.parseInt(position[2]), Status.valueOf(position[3]));
            ordersList.add(order);
        }
        bufferedReader.close();
        printOrdersList(ordersList.getOrdersList());

        Boolean end = false;
        Scanner scanner = new Scanner(System.in);
        while (end == false) {
            System.out.print("Choose option between Sort, Add, Change Status or End program. \n");
            String value = scanner.nextLine();

            if (value.equals("Sort")) {
                System.out.print("Choose option between Name or Price or Status. \n");
                String sorting = scanner.nextLine();
                switch (sorting) {
                    case "Name":
                        ordersList.sortByName();
                        break;
                    case "Price":
                        ordersList.sortByPrice();
                        break;
                    case "Status":
                        ordersList.sortByStatus();
                        break;
                    default:
                        System.out.print("Invalid sorting.");
                        break;
                }

            } else if (value.equals("Add")) {
                System.out.print("Choose name: ");
                String name = scanner.nextLine();
                System.out.print("Choose price: ");
                int price = scanner.nextInt();
                scanner.nextLine();
                ordersList.createNewOrder(name, price);
            } else if (value.equals("Status")) {
                System.out.print("Choose order id: \n");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Choose status enum name: \n");
                String status = scanner.nextLine();
                Order order = ordersList.getOrdersList().get(id);
                try {
                    order.setStatus(Status.valueOf(status));
                } catch (IllegalArgumentException e) {
                    System.out.println("Status is unknown.");
                }
            } else if (value.equals("End")) {
                end = true;
            }
            printOrdersList(ordersList.getOrdersList());
        }
    }

    private static void printOrdersList(List<Order> ordersList) {
        for (Order order : ordersList) {
            System.out.println("Id: " + order.getId() + ", Name: " + order.getName() + ", Price: " + order.getPrice() + ", Status: " + order.getStatus().getStatusName());
        }
    }
}