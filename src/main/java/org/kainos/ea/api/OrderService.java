package org.kainos.ea.api;

import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.db.OrderDao;

import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class OrderService {

    private final OrderDao orderDao = new OrderDao();

    public List<Order> getAllOrders() throws FailedToGetOrderException {

        List<Order> orderList;
        orderList = null;
        try {
            orderList = orderDao.getAllOrders();
        } catch (SQLException e) {
            throw new FailedToGetOrderException();
        }
        try {
            //Order order = orderList.get(1);
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(orderList);
        return orderList;
    }

    public Order getOrderById(int id) throws FailedToGetOrderException, OrderDoesNotExistException {

        try {
            Order order = orderDao.getOrderById(id);

            if (order == null) {
                throw new OrderDoesNotExistException();
            }

            return order;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetOrderException();
        }

    }

//    public int createOrder(ProductRequest product) throws InvalidOrderException, FailedToCreateOrderException {
//        try {
//            String validation = orderValidator.isValidOrder(order);
//
//            if (validation !=null){
//                throw new InvalidOrderException(validation);
//            }
//            int id = orderDao.createOrder(order);
//
//            if(id == -1){
//                throw new FailedToCreateOrderException();
//            }
//            return id;
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//
//            throw new FailedToCreateOrderException();
//        }
//    }
}




        //Order order1 = new Order(1,1, new Date() );
    //Order order2 = new Order(2,2, new Date() );

    //orderList.add(order1);
    //orderList.add(order2);

// Update your `OrderService` and `Order` classes to print out the `OrderID`,
// `CustomerID` and `OrderDate` of all orders

//descending order
//        for (Order order : orderList){
//         System.out.println("Date by descending order: " + order.getOrderDate());
//     }
//         orderList.forEach(System.out::println);


//descending order
//         Collections.sort(orderList, Collections.reverseOrder());
//
//         orderList.stream().forEach(System.out::println);
//
//        System.out.println(orderDao.getAllOrders());
//
//        orderList.stream().filter(order -> order.getOrderDate().before(Date.from(Instant.now().minus(Duration.ofDays(7))))).forEach(System.out::println);

       //most recent
//        Collections.sort(orderList, Collections.reverseOrder());
//        System.out.println(orderList.get(0));
//
//        // total count of all orders
//        System.out.println(orderList.size());
//
//        //most orders
//        Map<Integer, Long> countOrderMap = orderList.stream()
//                .collect(Collectors.groupingBy(Order::getCustomerId, Collectors.counting()));
//
//        System.out.println("Customer with most orders: "
//                + Collections.max(countOrderMap.entrySet(), Map.Entry.comparingByValue()).getKey());
//
//        System.out.println("Customer with least orders: "
//                + Collections.min(countOrderMap.entrySet(), Map.Entry.comparingByValue()).getKey());



