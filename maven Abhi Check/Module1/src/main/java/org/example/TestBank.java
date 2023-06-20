package org.example;

import java.time.LocalDate;


import JavaAggregationDay6.Bank;
import JavaAggregationDay6.Maker;
import JavaAggregationDay6.Operator;
import assignment5.ConsumerVehicleLoan;
import assignment5.EducationalLoan;
import assignment5.HomeLoan;
import assignment5.LoanProduct;

public class TestBank {
    public static void main(String [] args){
        Bank bank=new Bank();
        Customer cust1=new Customer("Abhishek", 20000, LocalDate.of(2000, 12, 12));
        bank.registerCustomer(cust1);




        HomeLoan homeLoan = new HomeLoan();
        EducationalLoan educationLoan= new EducationalLoan();

        ConsumerVehicleLoan consumerVehcileLoan= new ConsumerVehicleLoan();
        educationLoan.setLoanProductCode("12231");
        homeLoan.setLoanProductCode("89242");
        consumerVehcileLoan.setLoanProductCode("83113");

        LoanProduct[] loanProduct={homeLoan,educationLoan,consumerVehcileLoan};
        Bank bank2= new Bank();
        bank2.printAllLoanProduct();

        bank2.printAllLoanProduct();


        Operator operator=bank2;
        Maker maker=bank2;

    }

}

