package org.kainos.ea.cli;

public class SalesEmployee extends Employee {

    private double monthlySales;
    private float commissionRate;



    public SalesEmployee(int employeeId, String name, double salary, double monthlySales, float commissionRate) {
        super(employeeId, name, salary);
        setCommissionRate(commissionRate);
        setMonthlySales(monthlySales);
    }

    @Override
    public double calcPay(){ return getSalary()/12 + (getMonthlySales()*getCommissionRate());}
    public double getMonthlySales() { return monthlySales;}
    public void setMonthlySales(double monthlySales) {this.monthlySales = monthlySales;}
    public void setCommissionRate(float commissionRate) {this.commissionRate = commissionRate;}
    public float getCommissionRate() {return commissionRate;}
}
