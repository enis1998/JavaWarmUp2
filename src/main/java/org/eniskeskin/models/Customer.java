package org.eniskeskin.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private static final AtomicInteger i = new AtomicInteger(0);
    private final int id;
    private String fullName;
    private int age;
    private String dateOfReg;
    public List<Order> orderList = new ArrayList<>();

    public Customer(int id, String fullName, int age, String dateOfReg, List<Order> orderList) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.dateOfReg = dateOfReg;
        this.orderList = orderList;
    }
    public Customer(String fullName, int age, String dateOfReg) {
        this.id = i.getAndIncrement();
        this.fullName = fullName;
        this.age = age;
        this.dateOfReg = dateOfReg;
        this.orderList = orderList;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfReg() {
        return dateOfReg;
    }

    public void setDateOfReg(String dateOfReg) {
        this.dateOfReg = dateOfReg;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }


}
