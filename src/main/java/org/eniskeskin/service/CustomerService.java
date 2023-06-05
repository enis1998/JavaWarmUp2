package org.eniskeskin.service;

import org.eniskeskin.models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    static List<Customer> customerList = new ArrayList<>();

    public CustomerService() {
        Customer customer = new Customer("Aktan", 24, "Mayis");
        Customer customer2 = new Customer("Selim", 25, "Haziran");
        Customer customer3 = new Customer("Mertcan", 23, "Mayis");
        Customer customer4 = new Customer("Onur", 14, "Mayis");
        customerList.add(customer);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
    }
    //Adds customers
    public void addCustomer(Customer customer) { customerList.add(customer); }
    //Gets all customers full name
    public List<String> getAllCustomersFullName() {
        List<String> customers = customerList.stream().map(customer -> customer.getId() + " | " +
                customer.getFullName()).collect(Collectors.toList());
        return customers;
    }
    //Gets filtered customers by letter
    public List<String> getFilteredCustomersByLetter(String letter) {
        List<String> filteredCustomers =  customerList.stream().map(customer -> customer.getId() + " | " +
                customer.getFullName()).filter(c -> c.contains(letter.toLowerCase()) ||
        c.contains(letter.toUpperCase())).toList();
        return filteredCustomers;
    }
    //Gets filtered customers by month
    public static List<Customer> getFilteredCustomersByMonth(String month) {
        return customerList.stream().filter(customer -> customer.getDateOfReg().equals(month)).collect(Collectors.toList());
    }
    //Gets customers name by id
    public static String getCustomerNameById(int customerId) {
        return customerList.stream().filter(c -> c.getId() == customerId)
                .map(Customer::getFullName).collect(Collectors.joining());
    }
}
