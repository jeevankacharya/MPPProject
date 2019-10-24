package org.mppproject.queries;

import org.junit.Test;
import org.mppproject.entity.Customer;
import org.mppproject.entity.Item;
import org.mppproject.entity.Order;
import org.mppproject.entity.Salesman;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class QueriesJeevanTest {

    private  Salesman salesman1 = new Salesman(5001, "James Hong", "New York", 0.15);
    private  Salesman salesman2 = new Salesman(5002, "Adam BC", "London", 0.12);


    private  Customer customer1 = new Customer(3002, "Jeevan", "New York", "100", salesman1);
    private  Customer customer2 = new Customer(3003, "Thanos", "New York", "100", salesman2);


    private  Item item1 = new Item(1001, "Noodles", 20);
    private  Item item2 = new Item(1002, "Laptop", 10);

    private  List<Item> itemList1 = new ArrayList<Item>() {
        {
            add(item1);
            add(item2);
        }
    };
    private  List<Item> itemList2 = new ArrayList<Item>() {
        {
        }
    };


    private  Order order1 = new Order(1, customer1, salesman1, LocalDate.of(2012, 2, 21), itemList1);
    private  Order order2 = new Order(2, customer2, salesman2, LocalDate.of(2012, 2, 21), itemList2);

     List<Customer> customerList = new ArrayList<Customer>() {
        {
            add(customer1);
            add(customer2);
        }
    };

     List<Salesman> salesmanList = new ArrayList<Salesman>() {
        {
            add(salesman1);
            add(salesman2);
        }
    };
     List<Order> orderList = new ArrayList<Order>() {
        {
            add(order1);
            add(order2);
        }
    };

    @Test
    public void getListOfCustomer() {

        List<Customer> actual = new ArrayList<Customer>() {
            {
                add(customer1);
            }
        };
        assertEquals(QueriesJeevan.getListOfCustomer(customerList, salesmanList), actual);

    }

    @Test
    public void getTotalOrderProductSum() {
        double expected = 30.0;
        assertEquals(expected, QueriesJeevan.getTotalOrderItemPrice(orderList), 0);
    }

    @Test
    public void getListPriceByProductCategories() {
        Map<String, Set<Double>> expectedList = new HashMap<>();
        Set<Double> set = new HashSet<Double>();
        set.add(20.0);
        expectedList.put("Noodles", set);
        set = new HashSet<Double>();
        set.add(10.0);
        expectedList.put("Laptop", set);


        assertEquals(expectedList, QueriesJeevan.getListPriceByProductCategories(customerList, orderList));

    }
}