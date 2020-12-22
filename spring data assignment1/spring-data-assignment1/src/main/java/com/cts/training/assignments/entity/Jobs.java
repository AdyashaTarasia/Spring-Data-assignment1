package com.cts.training.assignments.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Jobs 
{
    @Id
    @Column(name="job_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String jobId;

    @Column(name="job_title")
    private String jobTitle;

    @Column(name="min_salary")
    private Integer minSalary;

    @Column(name="max_salary")
    private Integer maxSalary;

    //One job can have Many job history
    @OneToMany(mappedBy="job", cascade = CascadeType.ALL)
    private List<Job_History> jobHistory=new ArrayList<>();

    //One job can have Many employees
    @OneToMany(mappedBy="job", cascade = CascadeType.ALL)
    private List<Employees> employee=new ArrayList<>();
    
}
