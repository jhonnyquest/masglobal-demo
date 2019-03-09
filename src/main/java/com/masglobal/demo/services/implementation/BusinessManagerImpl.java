/******************************************************************
 *
 * MAS Global - Hiring process application test.
 *
 *
 * © 2019, Jhonny Munoz All rights reserved.
 *
 ******************************************************************/

package com.masglobal.demo.services.implementation;

import com.masglobal.demo.controllers.ProxyEndpointController;
import com.masglobal.demo.dao.EmployeeDao;
import com.masglobal.demo.dto.EmployeeDTO;
import com.masglobal.demo.services.APISourceManager;
import com.masglobal.demo.services.BusinessManager;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.masglobal.demo.enums.ContractType.MonthlySalaryEmployee;

/**
 * Component that manage all business logic and rules
 *
 * @author jmunoz
 * @since 09/03/2019
 * @version 1.0
 *
 */
@Component
public class BusinessManagerImpl implements BusinessManager {

  private static final org.slf4j.Logger LOGGER =
      LoggerFactory.getLogger(ProxyEndpointController.class.getCanonicalName());

  @Autowired
  APISourceManager sourceManager;

  /**
   * <b>getEmpoyee</b>: Retrieve information from a single employee
   *
   * @since 09/03/2019
   * @author jmunoz
   * @param employeeId Universal identifier of employee
   * @return {@link EmployeeDTO}
   */
  @Override
  public EmployeeDTO getEmployee(Integer employeeId) {
    List<EmployeeDao> employees = sourceManager.getEmpoyees();
    if (!employees.isEmpty()) {
      for (EmployeeDao employee : employees) {
        if(employee.getId().equals(employeeId)) {
          return mapEmployee(employee);
        }
      }
    }
    return null;
  }

  /**
   * <b>getEmpoyee</b>: Retrieve a list of information from multiple employees
   *
   * @since 09/03/2019
   * @author jmunoz
   * @return {@link List<EmployeeDTO>}
   */
  @Override
  public List<EmployeeDTO> getEmployeeList() {
    List<EmployeeDao> sourceEmployees = sourceManager.getEmpoyees();

    if (!sourceEmployees.isEmpty()) {
      List<EmployeeDTO> response = new ArrayList<>();
      for (EmployeeDao employee : sourceEmployees) {
        response.add(mapEmployee(employee));
      }
      return response;
    }
    return null;
  }

  /**
   * <b>mapEmployee</b>: Maps EmployeeDAO object into EmployeeDTO object
   *
   * @since 09/03/2019
   * @author jmunoz
   * @param employee EmployeeDAO object to be mapped {@link EmployeeDao}
   * @return {@link EmployeeDTO}
   */
  private EmployeeDTO mapEmployee(EmployeeDao employee) {
    EmployeeDTO.Builder builder = new EmployeeDTO.Builder();
    if(employee.getContractTypeName().equals(MonthlySalaryEmployee.name())) {
      builder.withAnnualSalary(employee.getMonthlySalary() * 12);
    } else {
      builder.withAnnualSalary(employee.getHourlySalary() * 12 * 120);
    }
    return builder
        .withId(employee.getId())
        .withName(employee.getName())
        .withContractTypeName(employee.getContractTypeName())
        .withRoleId(employee.getRoleId())
        .withRoleName(employee.getRoleName())
        .withRoleDescription(employee.getRoleDescription())
        .withHourlySalary(employee.getHourlySalary())
        .withMonthlySalary(employee.getMonthlySalary())
        .build();
  }
}
