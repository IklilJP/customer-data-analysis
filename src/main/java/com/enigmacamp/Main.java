package com.enigmacamp;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = Arrays.asList(
                new Customer("Alice Johnson", 34, 2400.50, "baik"),
                new Customer("Bob Smith", 22, 1500.00, "baik"),
                new Customer("Charlie Davis", 41, 5600.25, "netral"),
                new Customer("Diana Reed", 29, 2900.75, "buruk"),
                new Customer("Ethan Fox", 37, 4700.00, "baik"),
                new Customer("Fiona Green", 45, 3200.50, "netral"),
                new Customer("George White", 31, 1500.00, "buruk")
        );

        //1. Hitung jumlah nasahab yang di miliki bank
        long count = customers.stream().count();
        System.out.println("Jumlah nasabah: " + count);

        //2. Hitung total saldo nasabah
        Optional<Double> allSavingsBalance = customers.stream()
                .map(Customer::getSavingsBalance)
                .reduce(Double::sum);
        allSavingsBalance.ifPresent(all -> System.out.println("Total saldo nasabah: " + all));

        //3. rata-rata saldo nasabah yang baik
        

        OptionalDouble averages = customers.stream()
                .filter(customer -> customer.getCreditStatus().equals("baik"))
                .mapToDouble(Customer::getSavingsBalance)
                .average();
        averages.ifPresent(all -> System.out.println("Rata-rata saldo nasabah yang baik: " + all));


        //4. Nasabah dengan saldo terendah
        Optional<List<Customer>> minList = customers.stream()
                .collect(Collectors.groupingBy(Customer::getSavingsBalance))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue);
        minList.ifPresent(all -> System.out.println("Nasabah dengan saldo terendah : " + all));


        //5. daftar nasabah dengan status kredit buruk

        List<Customer> badCredit = customers.stream()
                .filter(customer -> customer.getCreditStatus().equals("buruk"))
                .toList();
        System.out.println("Daftar nasabah dengan status kredit buruk: " + badCredit);


        //6. nasabah terlama

        Optional<Customer> older = customers
                .stream()
                .max((c1, c2) -> Integer.compare(c1.getAge(), c2.getAge()));
        older.ifPresent(all -> System.out.println("Nasabah terlama: " + all));

    }
}