# MAS Global API backend demo for testing request
Create a simple web application following the next steps:
1. Create a data access layer that consumes the following API as your data repository.
2. Create a Business Logic layer so you can retrieve the employees’ information
including a calculated Annual Salary following these rules:
   - Create your DTO (Data Transfer Object) Classes depending on the type of Contract
that a given employee has (Hourly or Monthly).
   - Make use of a Factory pattern to create the concrete classes so you can
calculate the salary depending on the type of contract.
   - Employees can have to 2 types of Contracts: Hourly Salary Contract and Monthly
Salary Contract.
     - For Hourly Salary Employees the Annual Salary is:
120 * HourlySalary * 12
     - For Monthly Salary Employees the Annual Salary is:
MonthtlySalary * 12

## Requisites
Before start build and deploy this project you shold be sure that you haver already installed and configured the 
following dependencies:

- Apache Tomcat 7 server or higher (recommended Tomcat 9, you can download from [here](https://tomcat.apache.org/download-90.cgi)) 
- Apache Maven client 3.6.0 or higher (you can download from [here](https://maven.apache.org/download.cgi))

## Execution Instructions

1. Clone repository using the following command: ``` git clone https://github.com/jhonnyquest/masglobal-demo.git ```
2. Once you have cloned project then execute the following maven command: ``` mvn clean install ```
3. Move file ``` {project-root}/target/masglobal.demo.api.jar ``` to your Tomcat server ``` webapps ``` folder

*Any comment or suggestion please let me know by email: jhonnymunoz@gmail.com*