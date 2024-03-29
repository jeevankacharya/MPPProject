package org.mppproject.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int customerId;
    private String name;
    private String city;
    private String grade;
    private Salesman salesman;


    public Customer(int customerId, String name, String city, String grade, Salesman salesman) {
        this.customerId = customerId;
        this.name = name;
        this.city = city;
        this.grade = grade;
        this.salesman = salesman;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }


    @Override
    public String toString() {

        return "customer_id : " + customerId + "  name : " + name + "  city : " + city + "  salesman_id : " + salesman + "\n";
    }

}
