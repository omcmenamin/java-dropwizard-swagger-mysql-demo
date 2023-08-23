package org.kainos.ea.api;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.IPayable;
import org.kainos.ea.cli.SalesEmployee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public List<IPayable> getEmployee(){
        Employee employee = new Employee(1, "Orlaith",20000);
        SalesEmployee salesEmployee = new SalesEmployee(1,"Orlaith", 20000, 1000,0.1f);

        List<IPayable> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(salesEmployee);

        for(IPayable e :employees){
            System.out.println(e.calcPay());
        }
        return employees;
    }
}
