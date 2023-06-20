package org.example;

import java.util.Scanner;

public class RepaymentSchedule {
    public static void repaymentSchedule(double loan_Amount,double interest_Rate,int loan_term){
        //find out interest
        double interest = loan_Amount * (interest_Rate/100) * (loan_term/12);
        double totalAmount = loan_Amount + interest;
        double monthlyInstallment = totalAmount / loan_term;

        double r = interest_Rate / 12;
        double outstandingPrincipal = loan_Amount;

        System.out.println("Installment Number\tOpening Balance\tInterest\tPrincipal\tInstallment");
        for (int i = 1; i <= loan_term; i++) {
            double interestComponent = outstandingPrincipal * (r / 100) * (1.0 / 12);
            double principalComponent = monthlyInstallment - interestComponent;
            outstandingPrincipal = outstandingPrincipal - principalComponent;

            System.out.println(i + "\t\t\t" + outstandingPrincipal + "\t\t" + interestComponent + "\t\t" + principalComponent + "\t\t" + monthlyInstallment);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Loan Amount: ");
        double loan_Amount=sc.nextDouble();

        System.out.print("Enter Interest rate: ");
        double interest_Rate=sc.nextDouble();

        System.out.print("Enter loan term in month: ");
        int loan_term=sc.nextInt();
        repaymentSchedule(loan_Amount,interest_Rate,loan_term);
    }
}
