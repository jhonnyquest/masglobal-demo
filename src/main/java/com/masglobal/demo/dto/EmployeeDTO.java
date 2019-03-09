/******************************************************************
 *
 * MAS Global - Hiring process application test.
 *
 *
 * © 2019, Jhonny Munoz All rights reserved.
 *
 ******************************************************************/
package com.masglobal.demo.dto;

/**********************************************************************************************
 * Data transfer object to manage request/responses of employees
 *      note that DTO object class is built using Builder Pattern to make easier and more consistent
 *      the objects creation/update process.
 * @author jmunoz
 * @since 09/03/2019
 * @version 1.0.0
 */

public class EmployeeDTO {
  private Integer id;
  private String name;
  private String contractTypeName;
  private Integer roleId;
  private String roleName;
  private String roleDescription;
  private Double hourlySalary;
  private Double monthlySalary;
  private Double annualSalary;

  public EmployeeDTO(Integer id, String name, String contractTypeName, Integer roleId,
                     String roleName, String roleDescription, Double hourlySalary,
                     Double monthlySalary, Double annualSalary) {
    this.id = id;
    this.name = name;
    this.contractTypeName = contractTypeName;
    this.roleId = roleId;
    this.roleName = roleName;
    this.roleDescription = roleDescription;
    this.hourlySalary = hourlySalary;
    this.monthlySalary = monthlySalary;
    this.annualSalary = annualSalary;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getContractTypeName() {
    return contractTypeName;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public String getRoleDescription() {
    return roleDescription;
  }

  public Double getHourlySalary() {
    return hourlySalary;
  }

  public Double getMonthlySalary() {
    return monthlySalary;
  }

  public Double getAnnualSalary() {
    return annualSalary;
  }

  public static class Builder {
    private Integer id;
    private String name;
    private String contractTypeName;
    private Integer roleId;
    private String roleName;
    private String roleDescription;
    private Double hourlySalary;
    private Double monthlySalary;
    private Double annualSalary;

    public EmployeeDTO.Builder withId(Integer id) {
      this.id = id;
      return this;
    }

    public EmployeeDTO.Builder withName(String name) {
      this.name = name;
      return this;
    }

    public EmployeeDTO.Builder withContractTypeName(String contractTypeName) {
      this.contractTypeName = contractTypeName;
      return this;
    }

    public EmployeeDTO.Builder withRoleId(Integer roleId) {
      this.roleId = roleId;
      return this;
    }

    public EmployeeDTO.Builder withRoleName(String roleName) {
      this.roleName = roleName;
      return this;
    }

    public EmployeeDTO.Builder withRoleDescription(String roleDescription) {
      this.roleDescription = roleDescription;
      return this;
    }

    public EmployeeDTO.Builder withHourlySalary(Double hourlySalary) {
      this.hourlySalary = hourlySalary;
      return this;
    }

    public EmployeeDTO.Builder withMonthlySalary(Double monthlySalary) {
      this.monthlySalary = monthlySalary;
      return this;
    }

    public EmployeeDTO.Builder withAnnualSalary(Double annualSalary) {
      this.annualSalary = annualSalary;
      return this;
    }

    public EmployeeDTO build () {
      return new EmployeeDTO(id, name, contractTypeName, roleId, roleName, roleDescription, hourlySalary,
          monthlySalary, annualSalary);
    }
  }
}
