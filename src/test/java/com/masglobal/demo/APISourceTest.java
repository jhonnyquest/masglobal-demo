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
import com.masglobal.demo.services.implementation.APISourceManagerImpl;
import com.masglobal.demo.utils.RestTemplateHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

import static com.masglobal.demo.utils.MockHelper.getEmployeeDaoList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * Unitary tests corresponding to APISourceManagerImpl class.
 *
 * @author jmunoz
 * @since 09/03/2019
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class, properties = {"timezone=GMT", "port=4242"})
public class APISourceTest {

  @Mock
  RestTemplateHelper rt;

  @Autowired
  @InjectMocks
  APISourceManagerImpl apiManager;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * <b>testGetEmpoyees_success</b>: should return a list of EmployeeDAO (simulated by mockito,
   *      please see com.masglobal.demo.util.MockHelper) that is validated against expected
   *      previously generated quantity
   *
   * @author jmunoz
   * @since 09/03/2019
   */
  @Test
  public final void testGetEmpoyees_success() {

    int qtty = new Random().nextInt(50) + 1;

    ResponseEntity<EmployeeDao[]> responseOK = new ResponseEntity<>(getEmployeeDaoList(qtty), HttpStatus.OK);

    when(rt.processRequestGet(anyString(), eq(EmployeeDao[].class))).thenReturn(responseOK);

    assertEquals(qtty, apiManager.getEmpoyees().size());

  }

  /**
   * <b>testGetEmpoyees_success</b>: should return an empty list of EmployeeDAO
   *
   * @author jmunoz
   * @since 09/03/2019
   */
  @Test
  public final void testGetEmpoyees_empty() {

    when(rt.processRequestGet(anyString(), eq(EmployeeDao[].class))).thenReturn(null);

    assertTrue(apiManager.getEmpoyees().isEmpty());

  }
}
