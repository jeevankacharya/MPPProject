package org.mppproject.queries;

import org.mppproject.entity.*;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QueriesJeevan {


    //find the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%

    public static List<Customer> getListOfCustomer(List<Customer> customers, List<Salesman> salesmanList) {
        return salesmanList.parallelStream()
                .flatMap(salesman -> customers.stream().
                        filter(customer -> customer.getSalesman().getSalesmanId() == salesman.getSalesmanId() && salesman.getCommission() > 0.12))
                .collect(Collectors.toList());
    }

    //make a report with customer name, city, order number, order date, and order amount in ascending order
    // according to the order date to find that either any of the existing customers have placed no order or
    // placed one or more orders.

//    private static BiFunction<List<Customer>, List<Order>, List<CustomerOrder>> listBiFunction = (customers, orderList) -> {
//        List<CustomerOrder> list = new ArrayList<>();
//        customers.parallelStream().forEach(customer -> orderList.parallelStream().forEach(order -> {
//            if (order.getCustomer().getCustomerId() == customer.getCustomerId()) {
//                list.add(new CustomerOrder(customer.getName(), customer.getCity(), order.getOrder_No(), order.getLocalDate(),
//                        order.getOrderItems(), customer.getCustomerId(), customer.getSalesman().getSalesmanId()));
//            }
//        }));
//        return list;
//    };


    //make a report with customer name, city, order no. order date, purchase amount for only those customers
//
//    public static List<CustomerOrder> getCustomerOrderList(List<Customer> customerList, List<Order> orderList) {
//        return listBiFunction.apply(customerList, orderList);
//    }


    public static Map<String, Set<Double>> getListPriceByProductCategories(List<Customer> customerList, List<Order> orderList) {
        return ListPriceByProductCategories.apply(customerList, orderList);
    }

    //total sum price of all the orders

    public static double getTotalOrderItemPrice(List<Order> orderList) {
        return orderList.stream()
                .flatMap(order -> order.getOrderItems().stream())
                .mapToDouble(Item::getPrice).sum();
    }

    private static BiFunction<List<Customer>, List<Order>, Map<String, Set<Double>>> ListPriceByProductCategories = ((customerList, orderList) ->
            orderList.stream()
                    .flatMap(order -> order.getOrderItems().stream())
                    .collect(Collectors.groupingBy(Item::getName, Collectors.mapping(Item::getPrice, Collectors.toSet())))

    );


}
