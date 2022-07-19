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
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birth = sdf.parse(sc.nextLine());

        Client client = new Client(name, email, birth); //CLIENTE CRIADO


        System.out.print("Enter order data: ");
        String status = sc.nextLine(); //ENUM

        System.out.print("How many items to this order? ");//QUANTIDADES DE PRODUTOS
        int numItem = sc.nextInt();

        Order order = new Order(new Date(), OrderStatus.valueOf(status), client); //CONTA CRIADA
        OrderItem orderItem = new OrderItem();
        Product product = new Product();

        for (int i = 1; i <= numItem; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String pName = sc.nextLine();


            System.out.print("Price: ");
            Double priceProduct = sc.nextDouble();

            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();

            product = new Product(pName, priceProduct);//CRIANDO PRODUTO (NOME E PRECO)
            orderItem = new OrderItem(quantity, priceProduct, product);//CRIANDO ITEM DO PEDIDO (QTD E O PRODUTO)
            order.addItem(orderItem); //ADD NA LISTA DE PEDIDO
        }

        System.out.println();
        System.out.println("ORDER SUMARY:");
        System.out.println(order);

        sc.close();
    }
}
