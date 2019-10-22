package org.mppproject.entity;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private int order_No;
    private Customer customer;
    private Salesman salesman;
    private LocalDate localDate;
    private List<Item> orderItems;

    public Order(int order_no, Customer customer, Salesman salesman, LocalDate localDate, List<Item> orderItems) {
        order_No = order_no;
        this.customer = customer;
        this.salesman = salesman;
        this.localDate = localDate;
        this.orderItems = orderItems;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public List<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Item> orderItems) {
        this.orderItems = orderItems;
    }


    public int getOrder_No() {
        return order_No;
    }

    public void setOrder_No(int order_No) {
        this.order_No = order_No;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }
}
