/******************************************************************
 *
 * MAS Global - Hiring process application test.
 *
 *
 * © 2019, Jhonny Munoz All rights reserved.
 *
 ******************************************************************/

package com.masglobal.demo;

import com.masglobal.demo.dao.EmployeeDao;
import com.masglobal.demo.dto.EmployeeDTO;
import com.masglobal.demo.services.implementation.APISourceManagerImpl;
import com.masglobal.demo.services.implementation.BusinessManagerImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.masglobal.demo.utils.MockHelper.getEmployeeDaoList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Unitary tests corresponding to BusinessManager class.
 *
 * @author jmunoz
 * @since 09/03/2019
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class, properties = {"timezone=GMT", "port=4242"})
public class BusinessManagerTest {

  @Mock
  APISourceManagerImpl apiManager;

  @Autowired
  @InjectMocks
  BusinessManagerImpl businessManager;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * <b>getEmployeeTest_success</b>: should return a single EmployeeDTO identified with id and
   *      annual salary should have proper calculated value
   *
   * @author jmunoz
   * @since 09/03/2019
   */
  @Test
  public final void getEmployeeTest_success() {

    int qtty = new Random().nextInt(50) + 1;

    when(apiManager.getEmpoyees()).thenReturn(Arrays.asList(getEmployeeDaoList(qtty)));

    int id = new Random().nextInt(qtty) + 1;

    /* if id is odd then contract type is HourlySalaryEmployee if not then contract type is MonthlySalaryEmployee*/
    Double annualSalary = (id % 2 == 1) ? (double) (id * 10 * 12 * 120) : (double) (id * 100 * 12);

    EmployeeDTO employee = businessManager.getEmployee(id);

    assertNotNull(employee);
    assertEquals(annualSalary, employee.getAnnualSalary());
  }

  /**
   * <b>getEmployeeTest_success</b>: should return null value when employee ID is not found
   *
   * @author jmunoz
   * @since 09/03/2019
   */
  @Test
  public final void getEmployeeTest_notFound() {

    when(apiManager.getEmpoyees()).thenReturn(Arrays.asList(new EmployeeDao[0]));

    int id = new Random().nextInt(50) + 1;

    assertNull(businessManager.getEmployee(id));
  }

  /**
   * <b>getEmployeeTest_success</b>: should return a list of EmployeeDTO that should match with
   *      source list
   *
   * @author jmunoz
   * @since 09/03/2019
   */
  @Test
  public final void getEmployeesListTest_success() {

    int qtty = new Random().nextInt(50) + 1;

    EmployeeDao[] employeeDaoList = getEmployeeDaoList(qtty);

    when(apiManager.getEmpoyees()).thenReturn(Arrays.asList(employeeDaoList));

    List<EmployeeDTO> employeeList = businessManager.getEmployeeList();

    assertFalse(employeeList.isEmpty());
    assertEquals(qtty, employeeList.size());
  }
}