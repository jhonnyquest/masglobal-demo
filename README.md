# MAS Global API backend demo for testing request
Create a simple web application following the next steps:
1. Create a data access layer that consumes the following API as your data repository.
2. Create a Business Logic layer so you can retrieve the employees’ information
including a calculated Annual Salary following these rules:
*Create your DTO (Data Transfer Object) Classes depending on the type of Contract
that a given employee has (Hourly or Monthly).
*Make use of a Factory pattern to create the concrete classes so you can
calculate the salary depending on the type of contract.
*Employees can have to 2 types of Contracts: Hourly Salary Contract and Monthly
Salary Contract.
** For Hourly Salary Employees the Annual Salary is:
120 * HourlySalary * 12
** For Monthly Salary Employees the Annual Salary is:
MonthtlySalary * 12

## Execution Instructions
