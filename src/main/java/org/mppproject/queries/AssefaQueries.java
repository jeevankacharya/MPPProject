package org.mppproject.queries;

import org.mppproject.entity.Order;
import org.mppproject.entity.Salesman;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AssefaQueries {

    //find the details of order i.e.
    //order number, order date, amount of order, which customer gives the order and
    //which salesman works for that customer and commission rate he gets for an order.

    public static Function<List<Order>, List<String>> detailsOfOrder = listOrders ->
            listOrders.stream()
                    .map(e -> (Integer) e.getOrder_No() + " " + e.getLocalDate() + " " +
                            e.getOrderItems().size() + " " + e.getCustomer().getName() + " " +
                            e.getSalesman().getName() + " " + e.getSalesman().getCommission())
                    .collect(Collectors.toList());

    //Write statement to make a list in ascending order for the salesmen who works either
    public static Function<List<Salesman>, List<String>> getSalesmenAscending =
            listSalesmen -> listSalesmen.stream()
                    .map(e -> e.getName())
                    .sorted()
                    .collect(Collectors.toList());


}
