package org.mppproject.queries;

import org.junit.Before;
import org.junit.Test;
import org.mppproject.entity.Customer;
import org.mppproject.entity.Item;
import org.mppproject.entity.Order;
import org.mppproject.entity.Salesman;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HHQueriesTest {

    HHHQueries hh= new HHHQueries();
    private List<Order> mockedOrderList;
    private  List<Salesman> mockedSalesmanList;
    private  List<Customer> mockedCustomerList;
    Order order1;
    Order order2;
    Order order3;
    Order order4;

    Salesman salesman1;
    Salesman salesman2;
    Salesman salesman3;
    Salesman salesman4;

    Customer customer1;
    Customer customer2;
    Customer customer3;
    Customer customer4;

    Item item1;
    Item item2;
    Item item3;
    Item item4;

    @Before
    public void init(){
        //populate the salesman
       salesman1 = new Salesman(5001, "James Hong", "New York", 0.15);
       salesman2 = new Salesman(5002, "Adam BC", "London", 0.12);
       salesman3 = new Salesman(5003, "Pit Bull", "Paris", 0.14);
       salesman4 = new Salesman(5004, "Mc Baka", "Kathmandu", 0.17);


       customer1 = new Customer(3002, "Jeevan", "New York", "100", salesman1);
       customer2 = new Customer(3003, "Thanos", "New York", "100", salesman1);
       customer3 = new Customer(3004, "Hanok", "London", "100", salesman2);
       customer4 = new Customer(3005, "Sameer", "Paris", "200", salesman3);

        //populate the items
        item1 = new Item(1001, "Noodles", 5);
        item2 = new Item(1002, "laptop", 100);
        item3 = new Item(1004, "Phone", 300);
        item4 = new Item(1005, "Teff", 100);

        //Add the items to the different item lists
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


        //Populate the orders
        order1 = new Order(1, customer1, salesman1, LocalDate.of(2012, 2, 21), itemList1);
        order2 = new Order(2, customer2, salesman2, LocalDate.of(2013, 9, 1), itemList2);



        //populate the customers list
        mockedCustomerList= new ArrayList<Customer>() {
            {
                add(customer1);
                add(customer2);
                add(customer3);
                add(customer4);
            }
        };

        //populate the salesman list
        mockedSalesmanList= new ArrayList<Salesman>() {
            {
                add(salesman1);
                add(salesman2);
                add(salesman3);
                add(salesman4);

            }
        };

        //populate the order list
        mockedOrderList = new ArrayList<Order>() {
            {
                add(order1);
                add(order2);
            }
        };

    }

    @Test
    public void getCustomersPerCityTest(){


        List<String> expected = new ArrayList<String>() {

            {
                add("New York : 2\n");
                add("London : 1\n");
                add("Paris : 1\n");


            }
        };
        assertEquals(expected,hh.getCustomersPerCity(mockedOrderList,mockedCustomerList));
    }

    @Test
    public void getCustomersWithDiffCity() {

        List<String> expected = new ArrayList<String>() {

            {
            }
        };
        assertEquals(expected,hh.getCustomersWithDiffCity( mockedCustomerList,mockedSalesmanList));
    }

    @Test
    public void gettopFiveCurrentOrderedItems() {

        List<String> expected = new ArrayList<String>() {

            {
                add("Phone : 300.0,\n");
                add("laptop : 100.0,\n");
                add("Teff : 100.0,\n");

            }
        };
        assertEquals(expected,hh.gettopFiveCurrentOrderedItems( mockedCustomerList,mockedOrderList));
    }

    @Test
    public void geteachCityTopItem() {

        List<String> expected = new ArrayList<String>() {

            {
                add("New York");
                add("London");
                add("Paris");

            }
        };
        assertEquals(expected,hh.geteachCityTopItem( mockedCustomerList,mockedOrderList));
    }
}