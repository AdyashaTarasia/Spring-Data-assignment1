package com.cts.training.assignments.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "employee_department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departments 
{
    @Id
    @Column(name="department_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String departmentId;

    @Column(name="department_name")
    private String departmentName;

    @Column(name="manager_id")
    private String managerId;

    @Column(name="location_id")
    private String locationId;

    //Many departments can have One location
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="LOCATION_ID")
    private Locations location;

    //One department can have Many (types of)job history's
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Job_History> jobHistory=new ArrayList<>();

    //One department can have Many employees(belonging to the same department)
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Employees> employee=new ArrayList<>();

    /*One department's manager id can be the employee id when considered from the employee pool:
    i.e One department can have One manager who is also One employee.*/
    @OneToOne(cascade = CascadeType.ALL)
    private Employees empManagerId;
}
