/******************************************************************
 *
 * MAS Global - Hiring process application test.
 *
 *
 * © 2019, Jhonny Munoz All rights reserved.
 *
 ******************************************************************/

package com.masglobal.demo.services;

import com.masglobal.demo.dto.EmployeeDTO;

import java.util.List;

/**
 * Interface to Business management layer
 *
 * @author jmunoz
 * @since 09/03/2019
 * @version 1.0
 *
 */
public interface BusinessManager {
  EmployeeDTO getEmployee(Integer employeeId);

  List<EmployeeDTO> getEmployeeList();
}
