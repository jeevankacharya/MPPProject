package org.mppproject.queries;

import org.junit.Assert;
import org.junit.Test;
import org.mppproject.entity.Customer;
import org.mppproject.entity.Item;
import org.mppproject.entity.Order;
import org.mppproject.entity.Salesman;
import org.mppproject.queries.QueriesSameer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QueriesSameerTest {

    Salesman salesman1 = new Salesman(5001, "Cristiano Ronaldo", "New York", 0.15);
    Salesman salesman2 = new Salesman(5002, "Stephen Curry", "San Francisco", 0.12);

    Customer customer1 = new Customer(3001, "Lebron James", "New York", "100", salesman1);
    Customer customer2 = new Customer(3002, "Lionel Messi", "Tokyo", "200", salesman2);
    Customer customer3 = new Customer(3003, "Jawad Drissi", "Denver", "300", salesman2);
    Customer customer4 = new Customer(3004, "Joeseph Castelli", "Houston", "350", salesman1);
    Customer customer5 = new Customer(3005, "Michael Angelo", "Dallas", "200", salesman2);
    Customer customer6 = new Customer(3006, "Leonard Junior", "Iowa City", "100", salesman2);

    Item item1 = new Item(1001, "Noodles", 20);
    Item item2 = new Item(1002, "Chicken", 10);
    Item item3 = new Item(1003, "Pizza", 5);
    Item item4 = new Item(1009, "Eggs", 12);
    Item item5 = new Item(1010, "Potatoes", 5);

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
        }
    };
    List<Item> itemList4 = new ArrayList<Item>() {
        {
            add(item2);
        }
    };

    Order order1 = new Order(1, customer2, salesman1, LocalDate.of(2012, 2, 21), itemList1);
    Order order2 = new Order(2, customer3, salesman2, LocalDate.of(2012, 2, 21), itemList2);
    Order order3 = new Order(3, customer4, salesman1, LocalDate.of(2012, 2, 21), itemList3);
    Order order4 = new Order(4, customer6, salesman2, LocalDate.of(2012, 2, 21), itemList4);
    Order order5 = new Order(5, customer6, salesman2, LocalDate.of(2012, 2, 21), itemList3);
    Order order6 = new Order(6, customer2, salesman2, LocalDate.of(2012, 2, 21), itemList3);

    List<Order> orderList = new ArrayList<Order>(){
        {
            add(order1);
            add(order2);
            add(order3);
            add(order4);
            add(order5);
            add(order6);
        }
    };

    List<Customer> customerList = new ArrayList<Customer>() {
        {
            add(customer1);
            add(customer2);
            add(customer3);
            add(customer4);
            add(customer5);
            add(customer6);
        }
    };

    @Test
    public void customerWithLessGrade() {

        List<Customer> result1 = new ArrayList<Customer>() {
            {
                add(customer1);
                add(customer2);
                add(customer5);
                add(customer6);
            }
        };

        Assert.assertEquals(QueriesSameer.customerWithLessGrade(customerList,300), result1);
    }

    @Test
    public void customerWithMoreThanOneOrder() {
        List<String> result2 = new ArrayList<String>() {
            {
                add("3002 Tokyo 200");
                add("3006 Iowa City 100");

            }
        };
        Assert.assertEquals(QueriesSameer.customersWhoHaveMoreThanOneOrder(orderList), result2);
    }

    @Test
    public void topKItemsOrderedByCustomers(){
        List<String> result3 = new ArrayList<String>() {
            {
                add("Potatoes");
                add("Chicken");

            }
        };

        Assert.assertEquals(QueriesSameer.topKItemsOrderedByTheCustomers(orderList,2),result3);
    }
}