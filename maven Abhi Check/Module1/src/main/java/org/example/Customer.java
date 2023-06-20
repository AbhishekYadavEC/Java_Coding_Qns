package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Customer {
    private int customerId;
    private String customerName;
    private LocalDate dateOfBirth;
    private long contactNumber;
    private String emailAddress;
    private double monthlyIncome;
    private String profession;
    private double totalMonthlyExpenses;
    

    private String designation;
    public String companyName;
    //private  final String companyName
    //see default constr and param constr comments and setCompanyName() comment to see behaviour on initialization of final instance variable at diff places.
    private static int counter = 0;

    public Customer(String customerName,int customerId) {
        this.customerName=customerName;
        this.customerId=customerId;
    }

    public Customer() {

    }


    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public static int display(){
        return counter;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDateOfBith(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setTotalMonthlyExpenses(double totalMonthlyExpenses) {
        this.totalMonthlyExpenses = totalMonthlyExpenses;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setCompanyName(String companyName) {
        //final variable initialization at instance method is not possible
        //this.companyName = companyName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getDateOfBith() {
        return dateOfBirth;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public String getProfession() {
        return profession;
    }

    public double getTotalMonthlyExpenses() {
        return totalMonthlyExpenses;
    }

    public String getDesignation() {
        return designation;
    }

    public String getCompanyName() {
        return companyName;
    }
    //constr
    public Customer(String deepak, int i, LocalDate of) {
        //initialization of final instance variable is possible inside default constructor
        //this.companyName = "Nucleus Software";
        counter++;
        customerId = counter;
    }
    //param constr
    public Customer(int customerId, String customerName, LocalDate dateOfBirth, long contactNumber, String emailAddress, double monthlyIncome, String profession, double totalMonthlyExpenses, String designation, String companyName) {
        this("Abhishek", 20000, LocalDate.of(2000, 12, 12));
        //initialization of final instance variable is not possible inside parametarized constructor
        //this.companyName = "Nucleus Software";
        this.customerId = counter; //for que 2
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.monthlyIncome = monthlyIncome;
        this.profession = profession;
        this.totalMonthlyExpenses = totalMonthlyExpenses;
        this.designation = designation;
        this.companyName = companyName;
    }

    public double calculateDBR(){
        return totalMonthlyExpenses/monthlyIncome;
    }
    public double maxEligibleEMI(){
        return monthlyIncome * 0.5 * (1 - 0.2);
    }
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", contactNumber=" + contactNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", monthlyIncome=" + monthlyIncome +
                ", profession='" + profession + '\'' +
                ", totalMonthlyExpenses=" + totalMonthlyExpenses +
                ", designation='" + designation + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
    public double calculateEligibleLoanAmount(){//this method is printing as well as returning eligibleLoanAmount
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter monthly rate");
        System.out.println("sjhadf");
        int monthlyRate=scan.nextInt();
        System.out.println("Enter tenure");
        int tenure =scan.nextInt();
        double eligibleLoanAmt = (maxEligibleEMI()* ((Math.pow(1 + monthlyRate, tenure)) - 1)) / (monthlyRate * (Math.pow(1 + monthlyRate, tenure)));
        System.out.println("Elegible loan amount is :"+eligibleLoanAmt);
        return eligibleLoanAmt;
    }
}
