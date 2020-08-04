package com.example.userservice.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private  String name;
    private  String companyEmail;
    private String companyCeo;
    private String companyTurnover; 
    private String companyBoardOfDirectors;
    private String companySector;
    private String companyBriefWriteUp;
    
    
    

}
