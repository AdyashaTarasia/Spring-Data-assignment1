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
@Table(name = "employee_region")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Regions 
{
    @Id
    @Column(name="region_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String regionId;

    @Column(name="region_name")
    private String regionName;

    //One region can have Many countries
    @OneToMany(mappedBy="region", cascade = CascadeType.ALL)
    private List<Countries> country=new ArrayList<>();
    
}
