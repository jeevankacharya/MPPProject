package org.mppproject.entity;

import java.time.LocalDate;
import java.util.List;

public class CustomerOrder {

    //make a report with customer name, city, order number, order date, and order amount in ascending order
    // according to the order date to find that either any of the existing customers have placed no order or
    // placed one or more orders.

    private String customerName;
    private String city;
    private int orderNumber;
    private LocalDate orderDate;
    private List<Item> items;
    private int customerId;
    private int salesmanId;

    public String toString() {

        return "customer name : " + customerName + " city : " +
                city + " orderNumber : " + orderNumber + " orderDate : "
                + orderDate + " customerId : " + customerId + " salesmanId : " + salesmanId + "\n" + " items : " + items + "\n";
    }

    public CustomerOrder(String customerName, String city, int orderNumber, LocalDate orderDate, List<Item> items, int customerId, int salesmanId) {
        this.customerName = customerName;
        this.city = city;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.items = items;
        this.customerId = customerId;
        this.salesmanId = salesmanId;
    }


    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


}
