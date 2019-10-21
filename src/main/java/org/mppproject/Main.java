package org.mppproject;

import org.mppproject.entity.*;
import org.mppproject.queries.QueriesJeevan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        addDataJeevan();
    }

    public static void addDataJeevan() {

        Salesman salesman1 = new Salesman(5001, "James Hong", "New York", 0.15);
        Salesman salesman2 = new Salesman(5002, "Adam BC", "London", 0.12);
        Salesman salesman3 = new Salesman(5003, "Pit Bull", "Paris", 0.14);
        Salesman salesman4 = new Salesman(5004, "Mc Baka", "Kathmandu", 0.17);
        Salesman salesman5 = new Salesman(5005, "Paulman Adam", "Turkey", 0.10);


        Customer customer1 = new Customer(3002, "Jeevan", "New York", "100", 5001);
        Customer customer2 = new Customer(3003, "Thanos", "New York", "100", 5001);
        Customer customer3 = new Customer(3004, "Hanok", "London", "100", 5002);
        Customer customer4 = new Customer(3005, "Sameer", "Paris", "100", 5003);
        Customer customer5 = new Customer(3006, "Adam", "Kathmandu", "100", 5004);
        Customer customer6 = new Customer(3007, "Amit", "Kathmandu", "100", 5004);
        Customer customer7 = new Customer(3008, "Gilbert", "Turkey", "100", 5005);


        Item item1 = new Item(1001, "Noodles", 20);
        Item item2 = new Item(1002, "Noodles", 10);
        Item item3 = new Item(1003, "Noodles", 5);
        Item item4 = new Item(1004, "Noodles", 50);
        Item item5 = new Item(1005, "Noodles", 80);
        Item item6 = new Item(1006, "Noodles", 70);
        Item item7 = new Item(1007, "Noodles", 60);
        Item item8 = new Item(1008, "Noodles", 30);
        Item item9 = new Item(1009, "Noodles", 12);
        Item item10 = new Item(1010, "Noodles", 5);

        List<Item> itemList1 = new ArrayList<Item>() {
            {
                add(item1);
                add(item2);
            }
        };
        List<Item> itemList2 = new ArrayList<Item>() {
            {
                add(item3);
                add(item4);
            }
        };
        List<Item> itemList3 = new ArrayList<Item>() {
            {
                add(item5);
                add(item6);
            }
        };
        List<Item> itemList4 = new ArrayList<Item>() {
            {
                add(item7);
                add(item8);
            }
        };
        List<Item> itemList5 = new ArrayList<Item>() {
            {
                add(item9);
                add(item10);
            }
        };
        List<Item> itemList6 = new ArrayList<Item>() {
            {
            }
        };


        Order order1 = new Order(1, 3002, 5001, LocalDate.of(2012, 2, 21), itemList1);
        Order order2 = new Order(2, 3003, 5001, LocalDate.of(2012, 2, 21), itemList2);
        Order order3 = new Order(3, 3004, 5003, LocalDate.of(2012, 2, 21), itemList3);
        Order order4 = new Order(4, 3005, 5004, LocalDate.of(2012, 2, 21), itemList4);
        Order order5 = new Order(5, 3006, 5005, LocalDate.of(2012, 2, 21), itemList5);
        Order order6 = new Order(6, 3007, 5006, LocalDate.of(2012, 2, 21), itemList6);

        List<Customer> customerList = new ArrayList<Customer>() {
            {
                add(customer1);
                add(customer2);
                add(customer3);
                add(customer4);
                add(customer5);
                add(customer6);
                add(customer7);
            }
        };

        List<Salesman> salesmanList = new ArrayList<Salesman>() {
            {
                add(salesman1);
                add(salesman2);
                add(salesman3);
                add(salesman4);
                add(salesman5);
            }
        };
        List<Order> orderList = new ArrayList<Order>() {
            {
                add(order1);
                add(order2);
                add(order3);
                add(order4);
                add(order5);
                add(order6);
            }
        };


        System.err.println("the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%");
        List<Customer> listCustomer = QueriesJeevan.getListOfCustomer(customerList, salesmanList);
        System.out.println(listCustomer);




        /*Question 10*/
        System.err.println("make a report with customer name, city, order no. order date, purchase amount for only those customers");
        List<CustomerOrder> customerOrderList = QueriesJeevan.getCustomerOrderList(customerList, orderList);
        System.out.println(customerOrderList);
    }
}
