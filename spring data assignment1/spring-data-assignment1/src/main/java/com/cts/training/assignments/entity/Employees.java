package com.cts.training.assignments.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "employee_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employees 
{
    @Id
    @Column(name="employee_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String employeeId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private Long phoneNumber;

    @Column(name="hire_date")
    private Date hireDate;

    @Column(name="job_id")
    private String jobId;

    @Column(name="salary")
    private Double salary;

    @Column(name="commission_pct")
    private String commissionPct;

    @Column(name="manager_id")
    private String managerId;

    @Column(name="department_id")
    private String departmentId;
     
    //One employee can have Many job history's
    @OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
    private List<Job_History> jobHistory=new ArrayList<>();

    //Many employees can have One job
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="JOB_ID")
    private Jobs job;

    //Many employees can belong to One department
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="employee")
    private Employees employee;

    //An employee can also have an additional role as a manager and hence have a managerId
    @OneToOne(mappedBy = "empManagerId", cascade = CascadeType.ALL)
    private Departments department;

    //A self-join One to Many mapping will be done because each manager is an employee. 
    //Hence we implement a Parent/Child relationship in Employee enitity (here) in our Employee table, 
    //I define a column "manager_id" which is mapped to the same table’s primary key. 
    //Thus for each employee I will store its manager’s id also. Manager will be yet another employee in this table.
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="manager_id")
	private Employees manager;

    @OneToMany(mappedBy="manager", cascade = CascadeType.ALL)
	private Set<Employees> subordinates = new HashSet<>();
}
