package org.mppproject.queries;

import org.mppproject.entity.Customer;
import org.mppproject.entity.CustomerOrder;
import org.mppproject.entity.Order;
import org.mppproject.entity.Salesman;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QueriesAmit {

    public static List<String> getCustomersAndSalesmanFromSameCity(List<Order> orders) {
        return orders.parallelStream()
                .filter(o -> o.getCustomer().getCity().equals(o.getSalesman().getCity()))
                .map(l -> l.getCustomer().getName() + " and " + l.getSalesman().getName() + " are from " + l.getCustomer().getCity())
                .collect(Collectors.toList());
    }

    public static List<String> getTotalSalesmenPerCity(List<Order> orders) {
        return orders.parallelStream()
                .map(o -> o.getSalesman())
                .sorted(Comparator.comparing(o -> o.getCity()))
                .collect(Collectors.groupingBy(Salesman::getCity, Collectors.counting()))
                .entrySet().stream()
                .map(x -> "There are total " + x.getValue() + " salesman from " + x.getKey())
                .collect(Collectors.toList());
    }

    public static List<Customer> uniqueCustomersPerCity(String city, List<Order> orders) {
        return orders.parallelStream()
                .filter(o -> o.getSalesman().getCity().equals(city))
                .map(o -> o.getCustomer())
                .collect(Collectors.toList());
    }

}
