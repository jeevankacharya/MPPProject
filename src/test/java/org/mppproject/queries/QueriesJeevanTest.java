package org.mppproject.queries;

import org.junit.Test;
import org.mppproject.entity.Customer;
import org.mppproject.entity.Item;
import org.mppproject.entity.Order;
import org.mppproject.entity.Salesman;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QueriesJeevanTest {

    private static Salesman salesman1 = new Salesman(5001, "James Hong", "New York", 0.15);
    private static Salesman salesman2 = new Salesman(5002, "Adam BC", "London", 0.12);
    private static Salesman salesman3 = new Salesman(5003, "Pit Bull", "Paris", 0.14);
    private static Salesman salesman4 = new Salesman(5004, "Mc Baka", "Kathmandu", 0.17);
    private static Salesman salesman5 = new Salesman(5005, "Paulman Adam", "Turkey", 0.10);


    private static Customer customer1 = new Customer(3002, "Jeevan", "New York", "100", salesman1);
    private static Customer customer2 = new Customer(3003, "Thanos", "New York", "100", salesman1);
    private static Customer customer3 = new Customer(3004, "Hanok", "London", "100", salesman2);
    private static Customer customer4 = new Customer(3005, "Sameer", "Paris", "100", salesman3);
    private static Customer customer5 = new Customer(3006, "Adam", "Kathmandu", "100", salesman4);
    private static Customer customer6 = new Customer(3007, "Amit", "Kathmandu", "100", salesman4);
    private static Customer customer7 = new Customer(3008, "Gilbert", "Turkey", "100", salesman5);


    private static Item item1 = new Item(1001, "Noodles", 20);
    private static Item item2 = new Item(1002, "Noodles", 10);
    private static Item item3 = new Item(1003, "Noodles", 5);
    private static Item item4 = new Item(1004, "Noodles", 50);
    private static Item item5 = new Item(1005, "Noodles", 80);
    private static Item item6 = new Item(1006, "Noodles", 70);
    private static Item item7 = new Item(1007, "Noodles", 60);
    private static Item item8 = new Item(1008, "Noodles", 30);
    private static Item item9 = new Item(1009, "Noodles", 12);
    private static Item item10 = new Item(1010, "Noodles", 5);

    private static List<Item> itemList1 = new ArrayList<Item>() {
        {
            add(item1);
            add(item2);
        }
    };
    private static List<Item> itemList2 = new ArrayList<Item>() {
        {
            add(item3);
            add(item4);
        }
    };
    private static List<Item> itemList3 = new ArrayList<Item>() {
        {
            add(item5);
            add(item6);
        }
    };
    private static List<Item> itemList4 = new ArrayList<Item>() {
        {
            add(item7);
            add(item8);
        }
    };
    private static List<Item> itemList5 = new ArrayList<Item>() {
        {
            add(item9);
            add(item10);
        }
    };
    private static List<Item> itemList6 = new ArrayList<Item>() {
        {
        }
    };


    private static Order order1 = new Order(1, customer1, salesman1, LocalDate.of(2012, 2, 21), itemList1);
    private static Order order2 = new Order(2, customer2, salesman1, LocalDate.of(2012, 2, 21), itemList2);
    private static Order order3 = new Order(3, customer3, salesman2, LocalDate.of(2012, 2, 21), itemList3);
    private static Order order4 = new Order(4, customer4, salesman3, LocalDate.of(2012, 2, 21), itemList4);
    private static Order order5 = new Order(5, customer5, salesman4, LocalDate.of(2012, 2, 21), itemList5);
    private static Order order6 = new Order(6, customer6, salesman5, LocalDate.of(2012, 2, 21), itemList6);

    static List<Customer> customerList = new ArrayList<Customer>() {
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

    static List<Salesman> salesmanList = new ArrayList<Salesman>() {
        {
            add(salesman1);
            add(salesman2);
            add(salesman3);
            add(salesman4);
            add(salesman5);
        }
    };
    static List<Order> orderList = new ArrayList<Order>() {
        {
            add(order1);
            add(order2);
            add(order3);
            add(order4);
            add(order5);
            add(order6);
        }
    };

    @Test
    public void getListOfCustomer() {


    }

    @Test
    public void getCustomerOrderList() {

    }
}