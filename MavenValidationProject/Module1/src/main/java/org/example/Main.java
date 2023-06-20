package org.example;

import JavaAggregationDay6.Bank;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Bank bank=new Bank();
        Customer cust1=new Customer("Abhishek", 20000, LocalDate.of(2000, 12, 12));
        bank.registerCustomer(cust1);
        bank.printAllLoanProduct();
        bank.calculateLTVForLoanProduct();


        assignment5.DataValidation dv1 = new assignment5.DataValidation();
        System.out.println(dv1.dataTypeValidation(1,"Integer"));


    }
}
