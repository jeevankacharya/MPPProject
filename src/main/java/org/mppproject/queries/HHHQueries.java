package org.mppproject.queries;

import org.mppproject.entity.Customer;
import org.mppproject.entity.Item;
import org.mppproject.entity.Order;
import org.mppproject.entity.Salesman;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HHHQueries {


    @FunctionalInterface
    public interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    @FunctionalInterface
    public interface FourFunction<A, B, C, D, R> {
        R apply(A a, B b, C c, D d);
    }

    @FunctionalInterface
    public interface FiveFunction<A, B, C, D, E, R> {
        R apply(A a, B b, C c, D d, E e);
    }

    @FunctionalInterface
    public interface SixFunction<A, B, C, D, E, F, R> {
        R apply(A a, B b, C c, D d, E e, F f);
    }

    /* @Henok Hussen Hamza
     *Query 1
     *       ----------
     * Top 5 cities with higher number of Customers
     **/

    public static BiFunction<List<Order>, List<Customer>, List<String>> getCustomersPerCity =
            (orders, customerList) -> customerList.stream()
                    .flatMap(c1 -> Map.of(c1.getName(), c1.getCity()).entrySet().stream())
                    .map(Map.Entry::getValue)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream().sorted(Comparator.comparing(e1 -> 1 - e1.getValue()))
                    .map(e -> e.getKey() + " : " + e.getValue() + "\n")
                    .limit(5)
                    .collect(Collectors.toList());

    public  static List<String> getCustomersPerCity(List<Order> oList, List<Customer> cList) {
        return getCustomersPerCity.apply(oList, cList);
    }

    /* @Henok Hussen Hamza
     *Query 1
     *       ----------
     * list of customers who have salesman living in a different city
     * with a commission of above 12%
     **/
    BiFunction<List<Customer>, List<Salesman>, List<Customer>> customersWithDiffCity =
            (custList, salList) -> salList.stream()
                    .flatMap(s1 -> custList.stream()
                            .filter(c1 -> c1.getSalesman().getSalesmanId() == s1.getSalesmanId()
                                    && !c1.getCity().equals(s1.getCity())
                                    && s1.getCommission() > 0.12))
                    .collect(Collectors.toList());


    public List<Customer> getCustomersWithDiffCity(List<Customer> cList, List<Salesman> sList) {
        return customersWithDiffCity.apply(cList, sList);
    }
    // System.out.println(Optional.ofNullable(customersListBiFunction.apply(customerList,salesmanList)));
    /* @Henok Hussen Hamza
     *Query 2
     *       ----------
     * top 5 list of items with price more than $50 which are in the order list only
     * filtered from the all customer list sorted price wise.
     * i.e, top 5 ordered items only, with price > $50 from the given customers who already ordered.
     */

    public static BiFunction<List<Customer>, List<Order>, List<String>> topFiveCurrentOrderedItems =
            (custsList, ordersList) -> custsList.stream()
                    .flatMap(c1 -> ordersList.stream()
                            .filter(o1 -> o1.getCustomer().getCustomerId() == c1.getCustomerId())
                            .flatMap(o2 -> o2.getOrderItems().stream()
                                    .filter(i1 -> i1.getPrice() > 50)))
                    .sorted((e1, e2) -> (int) e2.getPrice() - (int) e1.getPrice())
                    .map(i1 -> (i1.getName() + " : " + i1.getPrice() + ",\n")).distinct()
                    .limit(5)
                    .collect(Collectors.toList());


    public List<String> gettopFiveCurrentOrderedItems(List<Customer> cList, List<Order> oList) {
        return topFiveCurrentOrderedItems.apply(cList, oList);
    }
    /* @Henok Hussen Hamza
     *        Query 3
     *       ----------
     * shows items
     *
     */;

  public  static   Function<List<Customer>, List<String>> getCustomerCities =
            (cusList) -> cusList.stream()
                    .map(Customer::getCity)
                    .collect(Collectors.toList());

   public static Function<List<Customer>, List<Integer>> getCustomerIds =
            (cusList) -> cusList.stream()
                    .map(Customer::getCustomerId)
                    .collect(Collectors.toList());

   public static Function<List<Order>, List<Item>> getOrderedItemLists =
            (ordIteList) -> ordIteList.stream()
                    .flatMap(i -> i.getOrderItems().stream())
                    .collect(Collectors.toList());


     public  static  BiFunction<List<Customer>, List<Order>, List<String>> eachCityTopItem =
            (custsList, ordersList) -> ordersList.stream()
                    .map(o1 -> getCustomerIds.apply(custsList).stream().filter(c1 -> c1 == o1.getCustomer().getCustomerId()).distinct())
                    .flatMap(id -> getOrderedItemLists.apply(ordersList).stream())
                    .map(itemsList -> Map.of(getCustomerCities.apply(custsList).stream(), itemsList))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .flatMap(ma -> ma.getKey().entrySet().stream()).flatMap(f -> f.getKey())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream().map(f -> f.getKey())
                    .collect(Collectors.toList());

    public static List<String> geteachCityTopItem(List<Customer> cList, List<Order> oList) {
        return eachCityTopItem.apply(cList, oList);
    }

}
