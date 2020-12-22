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
@Table(name = "employee_country")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Countries 
{
    @Id
    @Column(name="country_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String countryId;

    @Column(name="country_name")
    private String countryName;

    @Column(name="region_id")
    private String regionId;

    //Many countries can belong to One region
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="COUNTRY_ID")
    private Regions region;

    //One country can have Many locations
    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private List<Locations> location=new ArrayList<>();
    
}
