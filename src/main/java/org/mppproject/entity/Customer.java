package org.mppproject.entity;

public class Customer {

    private int customerId;
    private String name;
    private String city;
    private String grade;
    private int salesmanId;

    public Customer(int customerId, String name, String city, String grade, int salesmanId) {
        this.customerId = customerId;
        this.name = name;
        this.city = city;
        this.grade = grade;
        this.salesmanId = salesmanId;
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

    public int getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }

    @Override
    public String toString() {

        return "customer_id : " + customerId + "  name : " + name + "  city : " + city + "  salesman_id : " + salesmanId+"\n";
    }
}
