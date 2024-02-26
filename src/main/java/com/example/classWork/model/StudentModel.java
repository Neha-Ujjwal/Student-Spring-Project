package com.example.classWork.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class StudentModel {
    public String id;
    public String studName;
    public int studAge;

    public String studAadhar;

    public String studUniversity;


    public StudentModel(String id,String studName,int age,String studAadhar,String studUniversity){
        this.id=id;
        this.studName=studName;
        this.studAge=studAge;
        this.studUniversity=studUniversity;
        this.studAadhar=studAadhar;

    }



}
