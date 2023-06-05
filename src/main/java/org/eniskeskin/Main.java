package org.eniskeskin;

import org.eniskeskin.models.Company;
import org.eniskeskin.models.Customer;
import org.eniskeskin.models.Order;
import org.eniskeskin.service.CompanyService;
import org.eniskeskin.service.CustomerService;
import org.eniskeskin.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();

        //Adding customers
        Customer customer = new Customer("Aktan", 24, "Mayis");
        Customer customer2 = new Customer("Ahmet", 25, "Haziran");
        Customer customer3 = new Customer("Mehmet", 23, "Temmuz");
        Customer customer4 = new Customer("Can", 14, "Temmuz");
        Customer customer5 = new Customer("Sinem", 14, "Haziran");
        customerService.addCustomer(customer);
        customerService.addCustomer(customer2);
        customerService.addCustomer(customer3);
        customerService.addCustomer(customer4);
        customerService.addCustomer(customer5);

        //Adding companys
        CompanyService companyService = new CompanyService();
        Company company = new Company("Teksöz", "Bilişim", "hello1");
        Company company1 = new Company("Horoz", "Kırtasiye", "hello2");
        Company company2 = new Company("Migros", "Gıda", "hello3");
        Company company3 = new Company("Migros", "Eğlence", "hello4");
        companyService.addCompany(company);
        companyService.addCompany(company1);
        companyService.addCompany(company2);
        companyService.addCompany(company3);

        //Adding orders
        OrderService orderService = new OrderService();
        Order order = new Order(customer.getId(), company.getId(), "Musluk alındı", "Haziran", 1500);
        Order order2 = new Order(customer.getId(), company.getId(), "Boya alındı", "Temmuz", 3000);
        Order order3 = new Order(customer2.getId(), company2.getId(), "Yemek alındı", "Haziran", 4000);
        Order order4 = new Order(customer4.getId(), company1.getId(), "Buzdolabı alındı", "Haziran", 2000);
        Order order5 = new Order(customer.getId(), company.getId(), "Süpürge alındı", "Haziran", 2000);
        Order order6 = new Order(customer.getId(), company1.getId(), "Makas alındı", "Eylül", 100);
        Order order7 = new Order(customer4.getId(), company.getId(), "Kalem alındı", "Haziran", 50);
        Order order8 = new Order(customer4.getId(), company2.getId(), "Kalem alındı", "Haziran", 50);
        Order order9 = new Order(customer2.getId(), company.getId(), "Yemek alındı", "Haziran", 4000);
        Order order10 = new Order(customer5.getId(), company2.getId(), "Yemek alındı", "Haziran", 7000);
        Order order11 = new Order(customer5.getId(), company3.getId(), "Yemek alındı", "Haziran", 50);
        Order order12 = new Order(customer5.getId(), company3.getId(), "Yemek alındı", "Haziran", 1000);
        Order order13 = new Order(customer5.getId(), company3.getId(), "Yemek alındı", "Haziran", 1000);
        orderService.addOrder(order, customer, company);
        orderService.addOrder(order2, customer, company);
        orderService.addOrder(order3, customer2, company2);
        orderService.addOrder(order4, customer4, company1);
        orderService.addOrder(order5, customer, company);
        orderService.addOrder(order6, customer, company1);
        orderService.addOrder(order7, customer4, company);
        orderService.addOrder(order8, customer4, company2);
        orderService.addOrder(order10, customer5, company2);
        orderService.addOrder(order9, customer2, company);
        orderService.addOrder(order11, customer5, company3);
        orderService.addOrder(order12, customer5, company3);
        orderService.addOrder(order13, customer5, company3);

        //Gets all customers full name
        System.out.println(customerService.getAllCustomersFullName());
        System.out.println("------------------------------------------------");
        //Gets filtered customers by letter
        System.out.println(customerService.getFilteredCustomersByLetter("n"));
        System.out.println("------------------------------------------------");
        //Gets sum of amount of orders
        System.out.println(orderService.getSumAmountOfOrders("Haziran"));
        System.out.println("------------------------------------------------");
        //Gets orders greater than value
        System.out.println(orderService.getOrdersGreaterThanValue(1500.00));
        System.out.println("------------------------------------------------");
        //Gets average of orders greater than value
        System.out.println(orderService.getAverageOfOrderGreaterThanValue(1500.00));
        System.out.println("------------------------------------------------");
        //Gets all customers name bill amount smaller than value
        System.out.println(orderService.getOrdersSmallerThanValue(500.00));
        System.out.println("------------------------------------------------");
        //System.out.println(companyService.getCompanysAverageOfOrderSmallerThanValue(750.00));
        //System.out.println("------------------------------------------------");
    }
}