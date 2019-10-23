package org.mppproject.queries;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mppproject.entity.Customer;
import org.mppproject.entity.Item;
import org.mppproject.entity.Order;
import org.mppproject.entity.Salesman;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class MyFunctionsTest {
    private static List<Salesman> salesmen = new ArrayList<>();
    private static List<Item> items = new ArrayList<>();
    private static List<Item> items2 = new ArrayList<>();
    private static List<Item> items3 = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    @Before
    public void data() {
        salesmen.add(new Salesman(1, "jon", "fairfield", 222.2));
        salesmen.add(new Salesman(2, "jean", "fair", 922.2));
        salesmen.add(new Salesman(3, "jef", "carlifonia", 232.2));
        salesmen.add(new Salesman(4, "jeav", "iowa", 62.2));
        salesmen.add(new Salesman(5, "jacob", "fair", 922.2));
        salesmen.add(new Salesman(6, "oulanya", "carlifonia", 232.2));
        salesmen.add(new Salesman(7, "paul", "iowa", 62.2));

        items.add(new Item(1, "Biscuits", 12.3));
        items.add(new Item(2, "Bucket", 11.3));
        items.add(new Item(3, "shirts", 13.3));
        items.add(new Item(4, "phones", 122.3));
        items.add(new Item(5, "screen", 1112.3));
        //total = 1271.5

        items2.add(new Item(6, "laptop", 11232.3));
        items2.add(new Item(7, "fringe", 332.3));
        items2.add(new Item(8, "table", 93.3));
        items2.add(new Item(9, "Bed", 45.3));
        items2.add(new Item(10, "carpet", 89.3));
        //total = 11792.5


        items3.add(new Item(11, "shirts", 42.3));
        items3.add(new Item(12, "shorts", 35.3));
        items3.add(new Item(8, "table", 93.3));
        items3.add(new Item(9, "Bed", 45.3));
        items3.add(new Item(10, "carpet", 89.3));
        //total = 305.5

        customers.add(new Customer(1, "gilbert", "carlifonia", "100", salesmen.get(0)));
        customers.add(new Customer(2, "henok", "carlifonia", "200", salesmen.get(1)));
        customers.add(new Customer(3, "johna", "newyork", "10", salesmen.get(2)));
        customers.add(new Customer(4, "grace", "virginia", "300", salesmen.get(3)));
        customers.add(new Customer(1, "gilbert", "carlifonia", "100", salesmen.get(0)));
        customers.add(new Customer(5, "jack", "carlifonia", "100", salesmen.get(2)));
        customers.add(new Customer(1, "gilbert", "carlifonia", "100", salesmen.get(0)));
        customers.add(new Customer(6, "godfrey", "merryland", "100", salesmen.get(2)));
        customers.add(new Customer(1, "gilbert", "carlifonia", "100", salesmen.get(0)));


        orders.add(new Order(1, customers.get(0), salesmen.get(0), LocalDate.of(2012, 2, 21), items));
        orders.add(new Order(2, customers.get(1), salesmen.get(1), LocalDate.of(2012, 2, 21), items2));
        orders.add(new Order(3, customers.get(2), salesmen.get(2), LocalDate.of(2012, 2, 21), items3));
        orders.add(new Order(4, customers.get(3), salesmen.get(3), LocalDate.of(2012, 2, 21), items));
        orders.add(new Order(5, customers.get(4), salesmen.get(0), LocalDate.of(2012, 2, 21), items2));
        orders.add(new Order(6, customers.get(5), salesmen.get(2), LocalDate.of(2012, 2, 21), items3));
        orders.add(new Order(7, customers.get(6), salesmen.get(2), LocalDate.of(2012, 2, 21), items3));
        orders.add(new Order(8, customers.get(7), salesmen.get(2), LocalDate.of(2012, 2, 21), items2));
        orders.add(new Order(9, customers.get(8), salesmen.get(1), LocalDate.of(2012, 2, 21), items2));
        orders.add(new Order(10, customers.get(0), salesmen.get(0), LocalDate.of(2012, 2, 21), items));
        orders.add(new Order(11, customers.get(7), salesmen.get(2), LocalDate.of(2012, 2, 21), items));
        orders.add(new Order(12, customers.get(0), salesmen.get(0), LocalDate.of(2012, 2, 21), items3));

    }


    @Test
    public void testTotalItemsPrice() {
        assertEquals(1271.5, MyFunctions.totalItemsPrice.apply(orders.get(0)), 0);
    }

    @Test
    public void testOrderIsBetweenAgivenRange() {
        assertEquals(true, MyFunctions.isBetweenAgivenRange.constraint(orders.get(0), 400.0, 1300.0));
    }

    @Test
    public void testListOfCustomerDetailsWhoQualify() {
        List<String> strings = new ArrayList<>();
        strings.add("1 gilbert carlifonia 1271.5");
        strings.add("3 johna newyork 305.5");
        strings.add("4 grace virginia 1271.5");
        strings.add("6 jack carlifonia 305.5");
        strings.add("7 gilbert carlifonia 305.5");
        strings.add("10 gilbert carlifonia 1271.5");
        strings.add("11 godfrey merryland 1271.5");
        strings.add("12 gilbert carlifonia 305.5");

        assertEquals(strings, MyFunctions.listOfCustomerDetails.apply(orders, 300.0, 1300.0));
    }

    @Test
    public void testSortedCustomersAndThereSalesmen() {

        List<String> strings = new ArrayList<>();
        strings.add("5 jack carlifonia jef");
        strings.add("2 henok carlifonia jean");
        strings.add("3 johna newyork jef");
        strings.add("4 grace virginia jeav");
        strings.add("1 gilbert carlifonia jon");
        strings.add("1 gilbert carlifonia jon");
        strings.add("1 gilbert carlifonia jon");
        strings.add("6 godfrey merryland jef");
        strings.add("1 gilbert carlifonia jon");

        assertEquals(strings, MyFunctions.sortedCustomersAndThereSalesmen.apply(customers));
    }

    @Test
    public void testsalemenWithCustomers() {
        List<Salesman> salesmen1 = Arrays.asList(salesmen.get(0), salesmen.get(1), salesmen.get(2), salesmen.get(3));
        assertEquals(salesmen1, MyFunctions.salemenWithCustomers.apply(customers, salesmen));
    }

    @Test
    public void testListOfSalesmenWhoHaveMoreThanOneOrder() {
        List<String> salesmen1 = Arrays.asList("1 jon", "2 jean", "3 jef");
        assertEquals(salesmen1, MyFunctions.listOfSalesmenWhoHaveMoreThanOneOrder.apply(orders));
    }

    @Test
    public void testListOfCustomersWhoHaveMoreThanOneOrder() {
//        List<String> customers = Arrays.asList("1 gilbert carlifonia 100","6 godfrey merryland 100");
//        assertEquals(customers,MyFunctions.listOfCustomersWhoHaveMoreThanOneOrder.apply(orders));
    }

    /*@Test
    public void testlistOfSalesmenWhoHaveNoOrders () {
        List<Salesman> test = Arrays.asList(new Salesman(5,"jacob","fair",922.2),
                                            new Salesman(6,"oulanya","carlifonia",232.2),
                                            new Salesman(7,"paul","iowa",62.2));
        assertEquals(test,MyFunctions.listOfSalesmenWhoHaveNoOrders.apply(orders,salesmen));
    }*/
}