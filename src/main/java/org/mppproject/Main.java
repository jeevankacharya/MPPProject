package org.mppproject;

import org.mppproject.entity.*;
import org.mppproject.queries.*;

import java.time.LocalDate;
import java.util.*;

public class Main {

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
    private static Item item2 = new Item(1002, "Chicken", 10);
    private static Item item3 = new Item(1003, "Pizza", 5);
    private static Item item4 = new Item(1004, "Clothes", 50);
    private static Item item5 = new Item(1005, "Tablet", 80);
    private static Item item6 = new Item(1006, "Laptop", 70);
    private static Item item7 = new Item(1007, "Phone", 60);
    private static Item item8 = new Item(1008, "Charger", 30);
    private static Item item9 = new Item(1009, "CD", 12);
    private static Item item10 = new Item(1010, "Flash Drive", 5);

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

    public static void main(String[] args) {

        showCases();
    }

    private static void showCases() {

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Enter the choice ");
        System.out.println("----------------------------------------------------------------------------");

        System.out.println("A : the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12% ");
        //  System.out.println("B : make a report with customer name, city, order no. order date, purchase amount for only those customers");
        System.out.println("B : List order by price and categories");
        System.out.println("C : Total Price of Ordered Items");
        System.out.println("D : Total price for  given orders");
        System.out.println("E : See Any order lies between price range");
        System.out.println("F : List of customers and their salesman information");
        System.out.println("G : Salesman with Customers");
        System.out.println("H : Salesman with more than one order");
        System.out.println("I : Customer with less grade");
        System.out.println("J : Customer with more than one order");
        System.out.println("K : Get Customers and Salesman from same city");
        System.out.println("L : List total salesmen per city");
        System.out.println("M : List customers from New York");
        System.out.println("N : Get Details of Order");
        System.out.println("O : Salesman order by name");
        System.out.println("P : Top K items ordered by customer");
        System.out.println("Q : Customer with salesman in different city with 12% greater commission");
        System.out.println("R : Top 5 ordered items which price greater than 50$");
        System.out.println("S : Top Cities with higher number of customers");
        System.out.println("T : Current Trading Cities");
        System.out.println("Press Any other for exit");
        System.out.println("----------------------------------------------------------------------------");

        System.out.println("Enter Choice ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice.toUpperCase()) {

            case "A":

                List<Customer> listCustomer = QueriesJeevan.getListOfCustomer(customerList, salesmanList);
                System.out.println(listCustomer);
                showCases();
                break;

           /* case "B":
                List<CustomerOrder> customerOrderList = QueriesJeevan.getCustomerOrderList(customerList, orderList);
                System.out.println(customerOrderList);
                showCases();
                break;
*/
            case "B":
                Map<String, Set<Double>> listData = QueriesJeevan.getListPriceByProductCategories(customerList, orderList);
                System.out.println(listData);
                showCases();
                break;

            case "C":
                double sum = QueriesJeevan.getTotalOrderItemPrice(orderList);
                System.out.println("Total Ordered Product Sum " + sum);

                showCases();
                break;

            case "D":
                double data = MyFunctions.totalItemsPrice.apply(order1);
                System.out.println(" Ordered Product Price " + data);

                showCases();


            case "E":
//                Scanner scanner = new Scanner(System.in);

                System.out.println("--------------------------------------------");
                System.out.println("Enter the max range :");
                double max = scanner.nextDouble();
                System.out.println("Enter the min range :");
                double min = scanner.nextInt();
                System.out.println("--------------------------------------------");
                System.out.println("There are " + orderList.size() + " Please Choose 0-" + (orderList.size() - 1));
                int choose = scanner.nextInt();
                if (choose > orderList.size()) {
                    showCases();
                    break;
                }
                boolean isExits = MyFunctions.isBetweenAgivenRange.constraint(orderList.get(choose), min, max);
                System.out.println("Item Exits " + isExits);
                showCases();
                break;

            case "F":
                List<String> list = MyFunctions.sortedCustomersAndThereSalesmen.apply(customerList);
                System.out.println(list);
                showCases();
                break;

            case "G":
                List<Salesman> salesmenWithCustomers = MyFunctions.salemenWithCustomers.apply(customerList, salesmanList);
                System.out.println(salesmenWithCustomers);
                showCases();
                break;

            case "H":
                List<String> list1 = MyFunctions.listOfSalesmenWhoHaveMoreThanOneOrder.apply(orderList);
                System.out.println(list1);
                showCases();
                break;

            case "I":
                System.out.println("Enter the grade points ");
                int grade = scanner.nextInt();
                List<Customer> list2 = QueriesSameer.customerWithLessGrade(customerList, grade);
                System.out.println(list2);
                showCases();
                break;

            case "J":
                List<String> list3 = QueriesSameer.customersWhoHaveMoreThanOneOrder(orderList);
                System.out.println(list3);
                showCases();
                break;

            case "K":
                List<String> lst = QueriesAmit.getCustomersAndSalesmanFromSameCity(orderList);
                System.out.println(lst);
                showCases();
                break;

            case "L":
                List<String> ord = QueriesAmit.getTotalSalesmenPerCity(orderList);
                System.out.println(ord);
                showCases();
                break;

            case "M":
                String city = "New York";
                List<Customer> str = QueriesAmit.uniqueCustomersPerCity(city, orderList);
                for (Customer cus : str) {
                    System.out.println("First customer from New York is " + cus.getName());
                }
                showCases();
                break;

            case "N":
                List<String> list4 = AssefaQueries.detailsOfOrder.apply(orderList);
                System.out.println(list4);
                showCases();
                break;

            case "O":
                List<String> list5 = AssefaQueries.getSalesmenAscending.apply(salesmanList);
                System.out.println(list5);
                showCases();
                break;

            case "P":
                System.out.println("Enter the k :");
                int k = scanner.nextInt();
                List<String> list6 = QueriesSameer.topKItemsOrderedByTheCustomers(orderList, k);
                System.out.println(list6);
                showCases();
                break;

            case "Q":
                List<String> list7 = HHHQueries.getCustomersPerCity.apply(orderList, customerList);
                System.out.println(list7);
                showCases();
                break;

            case "R":
                List<String> list8 = HHHQueries.topFiveCurrentOrderedItems.apply(customerList, orderList);
                System.out.println(list8);
                showCases();
                break;

            case "S":
                List<String> list9 = HHHQueries.getCustomersPerCity(orderList, customerList);
                System.out.println(list9);
                showCases();
                break;

            case "T":
                List<String> list10 = HHHQueries.geteachCityTopItem(customerList, orderList);
                System.out.println(list10);
                showCases();
                break;
            default:
                System.exit(0);
                break;
        }
    }
}
