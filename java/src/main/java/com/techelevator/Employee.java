package com.techelevator;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;
    private Department department;
    private String hireDate;
    private static final double STARTING_SALARY = 60000;

    public Employee(long employeeId, String firstName, String lastName, String email, Department department, String hireDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.hireDate = hireDate;
        salary = STARTING_SALARY;
    }
    public Employee() {
    employeeId = 12;
    firstName  = "John";
    lastName   = "Smith";
    email      = "JohnSmith@yahoo.com";
    salary     = STARTING_SALARY;
    hireDate   = "May 21st";
    // come back to revisit department
    }
    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
   public String getFullName() {
     String fullName = lastName + ", "+ firstName;
     return fullName;
   }
    // convert our percent to a decimial  x/100 = my decimal
    // multiple the salary by the percent and keep track of that value
    // then add that value to salary
   public void raiseSalary(double percent) {
      percent = percent / 100;
      double partSalary = salary * percent;
      salary = partSalary + salary;
   }

   @Override
   public String toString() {
        return this.getFullName() + " (" + this.getSalary() + ") " + this.department.getName();
   }
}
