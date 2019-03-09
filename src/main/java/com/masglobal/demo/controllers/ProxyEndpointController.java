/******************************************************************
 *
 * MAS Global - Hiring process application test.
 *
 *
 * © 2019, Jhonny Munoz All rights reserved.
 *
 ******************************************************************/

package com.masglobal.demo.controllers;

import com.masglobal.demo.dto.EmployeeDTO;
import com.masglobal.demo.services.BusinessManager;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Only service exposition point of services to FE clients layer
 *
 * @author jmunoz
 * @since 09/03/2019
 * @version 1.0
 *
 */

@RestController
@RequestMapping("/v1")
public class ProxyEndpointController {

  private static final org.slf4j.Logger LOGGER =
      LoggerFactory.getLogger(ProxyEndpointController.class.getCanonicalName());

  @Autowired
  BusinessManager businessManager;

  /**
   * entry endpoint receiving ID to retrieve information from employee associated with this ID
   *
   * @since 09/03/2019
   * @author jmunoz
   * @param employeeId Universal identifier for employee
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/employees/{employee_id}", method = RequestMethod.GET)
  public ResponseEntity<Object> getEmploye(@PathVariable("employee_id") Integer employeeId) {

    ResponseEntity<Object> responseEntity;
    EmployeeDTO employee = businessManager.getEmployee(employeeId);
    if (Objects.nonNull(employee)) {
      LOGGER.info("Attempting to get employee id: {}", employeeId);
      responseEntity =  ResponseEntity.ok(employee);
      return responseEntity;
    }
    return setErrorResponse(HttpStatus.NOT_FOUND);
  }

  /**
   * entry endpoint to retrieve information from a list of employees
   *
   * @since 09/03/2019
   * @author jmunoz
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/employees", method = RequestMethod.GET)
  public ResponseEntity<Object> getEmployesList() {

    ResponseEntity<Object> responseEntity;
    List<EmployeeDTO> employeeList = businessManager.getEmployeeList();
    if (Objects.nonNull(employeeList) && !employeeList.isEmpty()) {
      LOGGER.info("Attempting to get all employees");
      responseEntity =  ResponseEntity.ok(employeeList);
      return responseEntity;
    }
    return setErrorResponse(HttpStatus.NOT_FOUND);
  }

  private ResponseEntity<Object> setErrorResponse(HttpStatus status) {
    LOGGER.error("Process has failed with errorcode: {}", status.toString());
    switch (status.value()) {
      case 404:
        HashMap<String, Object> response = new HashMap<String, Object>() {{
          put("success", false);
          put("message", HttpStatus.NOT_FOUND.toString());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return null;
  }
}
