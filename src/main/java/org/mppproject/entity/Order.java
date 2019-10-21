package org.mppproject.entity;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private int order_No;
    private int customerId;
    private int salesmanId;
    private LocalDate localDate;
    private List<Item> orderItems;

    public Order(int order_no, int customerId, int salesmanId, LocalDate localDate, List<Item> orderItems) {
        order_No = order_no;
        this.customerId = customerId;
        this.salesmanId = salesmanId;
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

    public int getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrder_No() {
        return order_No;
    }

    public void setOrder_No(int order_No) {
        this.order_No = order_No;
    }
}
