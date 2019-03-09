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
import com.masglobal.demo.services.APISourceManager;
import com.masglobal.demo.utils.RestTemplateHelper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * API data source layer that manage all remote API data source calls
 *
 * @author jmunoz
 * @since 09/03/2019
 * @version 1.0
 *
 */
@Component
public class APISourceManagerImpl implements APISourceManager {

  private static final org.slf4j.Logger LOGGER =
      LoggerFactory.getLogger(ProxyEndpointController.class.getCanonicalName());

  private RestTemplateHelper apiExecutor;

  @Value("${employees.api.base.endpoint}")
  private String employeeEndpoint;

  public APISourceManagerImpl() {
    super();
    this.apiExecutor = new RestTemplateHelper(new RestTemplate());
  }

  /**
   * <b>getEmpoyees</b>: Request to API data source to retrieve all employees data
   *
   * @since 09/03/2019
   * @author jmunoz
   * @return {@link List<EmployeeDao>}
   */
  @Override
  public List<EmployeeDao> getEmpoyees() {
    ResponseEntity<EmployeeDao[]> response = apiExecutor.processRequestGet(
        employeeEndpoint, EmployeeDao[].class);

    if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
      return Arrays.asList(Objects.requireNonNull(response.getBody()));
    } else {
      return new ArrayList<>();
    }
  }
}
