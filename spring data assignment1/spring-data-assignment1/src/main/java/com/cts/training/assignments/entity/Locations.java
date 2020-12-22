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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Locations 
{
    @Id
    @Column(name="location_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String locationId;

    @Column(name="location_address")
    private String streetAddress;

    @Column(name="location_postal")
    private Integer postalCode;

    @Column(name="location_city")
    private String city;

    @Column(name="location_state")
    private String stateProvince;

    @Column(name="country_id")
    private String countryId;

    //Many locations can belong to One country
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="COUNTRY_ID")
    private Countries country;

    //One Location can belong to Many Departments
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Departments> department=new ArrayList<>();
    

    
}
