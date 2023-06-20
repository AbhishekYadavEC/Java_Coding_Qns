package org.example;

import assignment5.LoanProduct;
import assignment5.TotalEnum;

import java.time.LocalDate;
import java.util.Scanner;

public class LoanAgreement {
    private int loanAgreementId = 0;
    LoanProduct loanProduct;
    public static int counter = 0;
    private double loanAmount;
    private int tenure;
    private double roi;
    private TotalEnum.LoanStatus loanStatus;
    private TotalEnum.EMIPaidStatus emiPaidStatus;



    private enum LoanStatus {
        Pending,
        Approved,
        Rejected,
        Active,
        Closed
    }

    public TotalEnum.LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public TotalEnum.EMIPaidStatus getEmiPaidStatus() {
        return emiPaidStatus;
    }

    public LoanAgreement(){
        counter++;
        loanAgreementId = counter;
    }

    public LoanAgreement(int loanAgreementId, LoanProduct loanProduct, double loanAmount, int tenure, double roi, double emiPerMonth, LocalDate loanDisbursalDate, int repaymentFrequency, TotalEnum.LoanStatus loanStatus, TotalEnum.EMIPaidStatus emiPaidStatus) {
        this.loanAgreementId = loanAgreementId;
        this.loanProduct = loanProduct;
        this.loanAmount = loanAmount;
        this.tenure = tenure;
        this.roi = roi;
        this.emiPerMonth = emiPerMonth;
        this.loanDisbursalDate = loanDisbursalDate;
        this.repaymentFrequency = repaymentFrequency;
        this.loanStatus = loanStatus;
        this.emiPaidStatus = emiPaidStatus;
    }

    private double emiPerMonth;
    LocalDate loanDisbursalDate;
    private int repaymentFrequency;

    //getters and setters
    public int getLoanAgreementId() {
        return loanAgreementId;
    }

    public void setLoanAgreementId(int loanAgreementId) {
        this.loanAgreementId = loanAgreementId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public double getEmiPerMonth() {
        return emiPerMonth;
    }

    public void setEmiPerMonth(double emiPerMonth) {
        this.emiPerMonth = emiPerMonth;
    }

    public LocalDate getLoanDisbursalDate() {
        return loanDisbursalDate;
    }

    public void setLoanDisbursalDate(LocalDate loanDisbursalDate) {
        this.loanDisbursalDate = loanDisbursalDate;
    }

    public int getRepaymentFrequency() {
        return repaymentFrequency;
    }

    public void setRepaymentFrequency(int repaymentFrequency) {
        this.repaymentFrequency = repaymentFrequency;
    }

    public void calculateEMI() {
        roi = roi / (12 * 100);//one month interest
        tenure = tenure * 12;
        double emi = loanAmount * roi * (float) Math.pow(1 + roi, tenure) / (float) (Math.pow(1 + roi, tenure) - 1);
        System.out.println("Emi:"+emi);
    }
    public void generateRepaymentSchedule(int noOfInstallments, int loanAmount, int rate, int tenure) {
        for (int i = 1; i < noOfInstallments; i++) {
            System.out.println("loan amount " + loanAmount + " rate = " + rate + " tenure = " + tenure + " noOfInstallment = " + i);
        }
    }
    public double calculateLatePenalty(LocalDate currentDate) {
        double baseRate = 10.0;
        double ratePerDay = 0.05;
        //after 5th of month penalty will start
        int daysLate = currentDate.getDayOfMonth()-1 - 5;
        double penalty = baseRate + (daysLate * ratePerDay);
        return penalty;
    }
    public static double ltvCalculator(int loan_amt, double prpValue) {
        double ratio = Math.round((loan_amt / prpValue) * 100);
        return ratio;
    }
    @Override
    public String toString() {
        return "LoanAgreement{" +
                "loanAgreementId=" + loanAgreementId +
                ", loanAmount=" + loanAmount +
                ", tenure=" + tenure +
                ", roi=" + roi +
                ", emiPerMonth=" + emiPerMonth +
                ", loanDisbursalDate=" + loanDisbursalDate +
                ", repaymentFrequency=" + repaymentFrequency +
                '}';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your desired loan amount.");
        int loanAmt = sc.nextInt();
        System.out.print("Enter your property value.");
        double properteyVal = sc.nextDouble();
        double ltv = ltvCalculator(loanAmt,properteyVal);
        if ( ltv <= 80.0)
            System.out.println("Your loan to value or LTV ratio is : " + ltv + " and this is accepted.");
        else {
            System.out.println("Your loan to value of LTV ratio is :" + ltv + " and this is not accepted.");
        }
    }
}