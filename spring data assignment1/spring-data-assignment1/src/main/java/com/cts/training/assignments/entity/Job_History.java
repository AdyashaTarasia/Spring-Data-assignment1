package com.cts.training.assignments.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_job_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job_History 
{
    @Id
    @Column(name="job_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String employeeId;

    @Id
    @Column(name="start_date")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="job_id")
    private String jobId;

    @Column(name="department_id")
    private String departmentId;

    //Many job history can belong to One job
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="JOB_ID")
    private Jobs job;

    //Many (types of)job history's can have One department
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="DEPARTMENT_ID")
    private Departments department;

    //Many job history's(or types of) can belong to One employee
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="EMPLOYEE_ID")
    private Employees employee;
    
}
