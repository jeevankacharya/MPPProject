package org.mppproject.queries;

import org.junit.Test;
import org.mppproject.entity.Customer;
import org.mppproject.entity.Item;
import org.mppproject.entity.Order;
import org.mppproject.entity.Salesman;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AssefaQueriesTest {

    private static Salesman salesman1 = new Salesman(5001, "James Hong", "New York", 0.15);
    private static Salesman salesman2 = new Salesman(5002, "Adam BC", "London", 0.12);


    private static Customer customer1 = new Customer(3002, "Jeevan", "New York", "100", salesman1);
    private static Customer customer2 = new Customer(3003, "Thanos", "New York", "100", salesman1);


    private static Item item1 = new Item(1001, "Noodles", 20);
    private static Item item2 = new Item(1002, "Noodles", 10);

    private static List<Item> itemList1 = new ArrayList<Item>() {
        {
            add(item1);
            add(item2);
        }
    };
    private static List<Item> itemList2 = new ArrayList<Item>() {
        {
        }
    };


    private static Order order1 = new Order(1, customer1, salesman1, LocalDate.of(2012, 2, 21), itemList1);
    private static Order order2 = new Order(2, customer2, salesman1, LocalDate.of(2012, 2, 21), itemList2);

    static List<Customer> customerList = new ArrayList<Customer>() {
        {
            add(customer1);
            add(customer2);
        }
    };

    static List<Salesman> salesmanList = new ArrayList<Salesman>() {
        {
            add(salesman1);
            add(salesman2);
        }
    };
    static List<Order> orderList = new ArrayList<Order>() {
        {
            add(order1);
            add(order2);
        }
    };

    @Test
    public void MyDetailsOfOrder() {

        //verify the first order detail is equal to
        String expectd1 = "1 2012-02-21 2 Jeevan James Hong 0.15";
        assertEquals(AssefaQueries.detailsOfOrder.apply(orderList).get(0), expectd1);

        String expectd2 = "2 2012-02-21 0 Thanos James Hong 0.15";
        assertEquals(AssefaQueries.detailsOfOrder.apply(orderList).get(1), expectd2);

    }

    @Test
    public void MyGetSalesmenAscending() {

        //verify it is getting the list of salesman in ascending order
        String expectd1 = "Adam BC";
        assertEquals(AssefaQueries.getSalesmenAscending.apply(salesmanList).get(0), expectd1);
        assertNotEquals(AssefaQueries.getSalesmenAscending.apply(salesmanList).get(1), expectd1);

        String[] myarray = {"Adam BC", "James Hong"};
        List<String> expectd2 = Arrays.asList(myarray);
        assertEquals(AssefaQueries.getSalesmenAscending.apply(salesmanList), expectd2);

    }


}