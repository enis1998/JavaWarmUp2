package org.eniskeskin.service;

import org.eniskeskin.models.Company;
import org.eniskeskin.models.Customer;
import org.eniskeskin.models.Order;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class OrderService {
    static Set<Order> orderList = new HashSet<>();

    public OrderService() {
    }
    //Adds orders, related to customer and company
    public void addOrder(Order order, Customer customer, Company company){
        orderList.add(order);
        customer.getOrderList().add(order);
        company.getCompanyOrderList().add(order);
    }
    //Gets sum amount of orders by month
    public Double getSumAmountOfOrders(String month){
        List<Customer> customers = CustomerService.getFilteredCustomersByMonth(month);
        Double sum = customers.stream().mapToDouble(customer ->
                customer.getOrderList().stream().mapToDouble(Order::getTotalAmount).sum()).sum();
        return sum;
    }
    //Gets orders from one customer
    public String getOrdersFromOneCustomer(Customer customer) {
        String oneCustomer = customer.getOrderList().stream().map(order -> order.getDescription()
            + " || " + order.getTotalAmount() + " TL " + order.getMonth()).toString();
        return oneCustomer;
    }
    //Gets orders greater than value
    public List<String> getOrdersGreaterThanValue(Double value) {
        List<String> orders = orderList.stream().filter(order -> order.getTotalAmount() > value)
                .map(order -> "Customer: " + CustomerService.getCustomerNameById(order.getCustomerId()) + "\nBill Total: " +
                        order.getTotalAmount()).collect(Collectors.toList());
        return orders;
    }
    //Gets average of order greater than value
    public Double getAverageOfOrderGreaterThanValue(Double value) {
        Double avg = orderList.stream().filter(order -> order.getTotalAmount() > value)
                .mapToDouble(Order::getTotalAmount).average().getAsDouble();
        return avg;
    }
    //Gets orders smaller than value
    public List<String> getOrdersSmallerThanValue(Double value) {
        List<String> orders = orderList.stream().filter(order -> order.getTotalAmount() < value)
                .map(order -> "Customer: " + CustomerService.getCustomerNameById(order.getCustomerId())).collect(Collectors.toList());
        return orders;
    }

}

