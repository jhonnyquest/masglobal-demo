/******************************************************************
 *
 * MAS Global - Hiring process application test.
 *
 *
 * © 2019, Jhonny Munoz All rights reserved.
 *
 ******************************************************************/

package com.masglobal.demo.services;

import com.masglobal.demo.dao.EmployeeDao;

import java.util.List;

/**
 * Interface to API data source  layer
 *
 * @author jmunoz
 * @since 09/03/2019
 * @version 1.0
 *
 */
public interface APISourceManager {
  List<EmployeeDao> getEmpoyees();
}
