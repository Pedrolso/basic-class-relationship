package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birth = sdf.parse(sc.nextLine());
        //System.out.println(sdf.format(birth));
        Client client = new Client(name, email, birth);


        System.out.print("Enter order data: ");
        String status = sc.nextLine();

        System.out.print("How many items to this order? ");
        int numItem = sc.nextInt();

        Product product = new Product();
        OrderItem orderItem = new OrderItem();
        Order order = new Order();

        for (int i = 1; i <= numItem; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String nameProduct = sc.nextLine();
            sc.nextLine();

            System.out.print("Price: ");
            Double priceProduct = sc.nextDouble();

            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();

            Date moment = new Date();

            product = new Product(nameProduct, priceProduct);
            orderItem = new OrderItem(quantity, priceProduct, product);
            order = new Order(moment, OrderStatus.valueOf(status), client);
        }

        System.out.println();
        System.out.println("ORDER SUMARY:");
        System.out.println(order);


    }
}
