package org.mppproject.queries;

import org.mppproject.entity.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QueriesSameer {

/*
    // Bifunction to join Customer and Salesman
    public static BiFunction<List<Customer>, List<Salesman>, List<String>> biFunctionForCustomerSalesman = (customers, salesmen) -> {
        List<String> list = new ArrayList<>();

        customers.forEach(customer -> salesmen.forEach(salesman -> {
            if (salesman.equals(customer.getSalesman())) {
                list.add("Salesman '" + salesman.getName() + "' (ID: " + salesman.getSalesmanId() + ") works for " + customer.getName()
                        + " (Customer ID : " + customer.getCustomerId() +")");
            }
        }));
        return list;
    };
*/

/*
    // 3. Finding customer details for each salesman
    public static List<String> customerSalesmanMapping(List<Customer> customerList, List<Salesman> salesmanList) {
        return biFunctionForCustomerSalesman.apply(customerList, salesmanList);
    }
*/

    // 9. List of customer who has grade less than 300 in ascending order
    public static List<Customer> customerWithLessGrade(List<Customer> customerList,int grade){
        return customerList.stream()
                .filter(f-> Integer.parseInt(f.getGrade())<grade)
                .sorted(Comparator.comparing(Customer::getCustomerId))
                .collect(Collectors.toList());
    }
/*
    // Bifunction to join Customer and Order
    public static BiFunction<List<Customer>, List<Order>, List<String>> biFunctionForCustomerOrder = (customers, orderList) -> {
        List<String> list = new ArrayList<>();

        customers.forEach(customer -> orderList.forEach(order -> {
            if (order.getCustomer().equals(customer)) {
                if(!order.getOrderItems().isEmpty())
                list.add("ID: "+ customer.getCustomerId() + " | Name : " + customer.getName() + " Address : " + customer.getCity() + " Order No. : "
                        + new Integer(order.getOrder_No()).toString() + " on " + order.getLocalDate().toString()  +
                        " Orders : " + order.getOrderItems().toString());
            }
        }));
        return list;
    };*/

/*
    // 15. List of Customer with more than one orders
    public static List<String> customerWithMoreThanOneOrder(List<Customer> customerList, List<Order> orderList) {
        return biFunctionForCustomerOrder.apply(customerList, orderList);
    }
*/

    public static Function<List<Order>, List<String>> listOfCustomersWhoHaveMoreThanOneOrder = orders ->
            orders.stream()
                    .map(order -> order.getCustomer())
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                    .entrySet().stream()
                    .filter(e->e.getValue()>1)
                    .sorted(Comparator.comparing(s->s.getKey().getCustomerId()))
                    .map(c-> c.getKey().getCustomerId() + " " + c.getKey().getCity() + " " + c.getKey().getGrade())
                    .collect(Collectors.toList());

    public static List<String> customersWhoHaveMoreThanOneOrder(List<Order> orderList) {
        return listOfCustomersWhoHaveMoreThanOneOrder.apply(orderList);
    }

    // Top k items that are being ordered by the customers
    public static BiFunction<List<Order>,Integer,List<String>> topKItem = (orders, k) -> orders.stream()
             .flatMap(f -> f.getOrderItems().stream())
             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
             .entrySet().stream()
             .sorted((n1,n2)-> (int) (n2.getValue()-n1.getValue()))
             .map(m->m.getKey().getName())
             .limit(k)
             .collect(Collectors.toList());

    public static List<String> topKItemsOrderedByTheCustomers(List<Order> orderList,Integer topK) {
        return topKItem.apply(orderList,topK);
    }
}
