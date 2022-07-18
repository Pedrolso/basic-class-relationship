package entities;

import enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;

    private Client client; //RELACAO COM O CLIENTE
    private List<OrderItem> items = new ArrayList<>(); //CRIA UMA LISTA PARA OS PEDIDOS


    //CONSTRUTOR
    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    //GETTER / SETTER
    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    //METODOS
    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() { // PERCORRE LISTA SOMANDO OS VALORES
        double sum = 0.0;
        for (OrderItem item : items) {
            //sum += item.subTotal();
            sum = sum + sum + item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: "+ moment + "\n");
        sb.append("Order status: "+status + "\n");
        sb.append("Cliente: "+client + "\n");

        for(OrderItem c: items){
            sb.append(c.getProduct());
        }
        return  sb.toString();
    }
}
