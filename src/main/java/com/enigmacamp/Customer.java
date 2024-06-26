package com.enigmacamp;

public class Customer {
    private final String name;
    private final int age;
    private final Double savingsBalance;
    private final String creditStatus;

    public Customer(String name, int age, Double savingsBalance, String creditStatus) {
        this.name = name;
        this.age = age;
        this.savingsBalance = savingsBalance;
        this.creditStatus = creditStatus;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Double getSavingsBalance() {
        return savingsBalance;
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", savingsBalance=" + savingsBalance +
                ", creditStatus='" + creditStatus + '\'' +
                '}';
    }
}
