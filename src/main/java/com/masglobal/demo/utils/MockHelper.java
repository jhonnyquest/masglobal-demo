package com.masglobal.demo.utils;

import com.masglobal.demo.dao.EmployeeDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockHelper {

  public static final String[] NAMES = {"Jhonny Munoz", "Bob Marley", "Maxi Priest", "Elton John",
      "Michaell Jackson", "Liam Gallager"};

  public static final String[] CONTRACT_TYPES = {"HourlySalaryEmployee", "MonthlySalaryEmployee"};

  public static final String[] ROLE_NAMES = {"Administrator", "Contractor"};

  public static EmployeeDao getSingleEmpoyeeDAO (Integer id, String contractType,
                                                 Double hourlySalary, Double monthlySalary) {
    EmployeeDao employeeDao = new EmployeeDao() {{
      setId(id);
      setHourlySalary(hourlySalary);
      setMonthlySalary(monthlySalary);
      setContractTypeName(contractType);
      setName(NAMES[new Random().nextInt(NAMES.length)]);
      setRoleId(new Random().nextInt(99999));
      setRoleName(ROLE_NAMES[new Random().nextInt(ROLE_NAMES.length)]);
    }};
    return employeeDao;
  }

  public static EmployeeDao[] getEmployeeDaoList (int qtty) {

    EmployeeDao[] employeeDaos = new EmployeeDao[qtty];
    for(int i = 0 ; i < qtty ; ++i) {
      employeeDaos[i] = getSingleEmpoyeeDAO(i, CONTRACT_TYPES[i % 2 == 1 ? 0 : 1],
          (double) (i * 10),
          (double) (i * 100));
    }

    return employeeDaos;
  }
}
