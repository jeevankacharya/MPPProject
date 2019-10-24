package org.mppproject.queries;


import org.mppproject.entity.Customer;
import org.mppproject.entity.Order;
import org.mppproject.entity.Salesman;
import org.mppproject.functionalInterface.TriFunction;
import org.mppproject.functionalInterface.TriPredicate;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyFunctions {

    /*return the total price for a given order*/
    public static Function<Order, Double> totalItemsPrice = order ->
            order.getOrderItems()
                    .stream()
                    .map(item -> item.getPrice())
                    .mapToDouble(price -> price)
                    .sum();


    /*returns a boolean weather any item falls on that range */
    public static TriPredicate<Order, Double, Double> isBetweenAgivenRange = (order, range, range2) ->
            totalItemsPrice.apply(order) > range && totalItemsPrice.apply(order) < range2;

    public static TriFunction<List<Order>, Double, Double, List<String>> listOfCustomerDetails = (orders, range1, range2) ->
            orders.stream()
                    .filter(order -> isBetweenAgivenRange.constraint(order, range1, range2))
                    .map(order -> order.getOrder_No() + " " + order.getCustomer().getName() + " " + order.getCustomer().getCity() + " " +
                            totalItemsPrice.apply(order))
                    .collect(Collectors.toList());

    /*list of customers + their salesmans information*/
    public static Function<List<Customer>, List<String>> sortedCustomersAndThereSalesmen = customers ->
            customers.stream()
                    .sorted(Comparator.comparingInt(c -> c.getName().length()))
                    .map(c -> c.getCustomerId() + " " + c.getName() + " " + c.getCity() + " " + c.getSalesman().getName())
                    .collect(Collectors.toList());

    public static Function<List<Order>,List<String>> listOfSalesmenWhoHaveMoreThanOneOrder = list ->
            list.stream()
                    .map(l->l.getSalesman())
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                    .entrySet().stream()
                    .filter(e-> e.getValue()>1)
                    .sorted(Comparator.comparingInt(e -> e.getKey().getSalesmanId()))
                    .map(e->e.getKey().getSalesmanId()+" " + e.getKey().getName())
                    .collect(Collectors.toList());

    /*salesman with customer*/
    public static BiFunction<List<Customer>, List<Salesman>, List<Salesman>> salemenWithCustomers = (customers, salesmen) ->
            salesmen.stream()
                    .filter(salesman -> customers.stream().anyMatch(customer -> customer.getSalesman().getSalesmanId() == salesman.getSalesmanId()))
                    .collect(Collectors.toList());

    //public static Function<List<Order>,List<Order >> listOfOrdersWithTheSameSalesman =
}
