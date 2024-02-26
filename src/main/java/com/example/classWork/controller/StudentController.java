package com.example.classWork.controller;

import com.example.classWork.model.StudentModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

public class StudentController {

    final public Map<String,StudentModel> idToStudent=new HashMap<>();
    final public Map<String,List<StudentModel>> universityToStudent=new HashMap<>();
    private Map<String,List<StudentModel>> univeristyToStudent;

    @PostMapping("/addStudent")
    public  String addStudent(@RequestBody String studName, @RequestBody int studAge, @RequestBody String studAadhar, @RequestBody String studUniversity){
        String id= UUID.randomUUID().toString();

        StudentModel newStudent=new StudentModel(id,studName,studAge,studAadhar,studUniversity);
        idToStudent.put(id,newStudent);

        List<StudentModel> students=univeristyToStudent.getOrDefault(studUniversity,new ArrayList<>());
        students.add(newStudent);
        univeristyToStudent.put(studUniversity,students);
        return id;
    }
    @GetMapping("/getStudByUniversity")
    public List<StudentModel> studentByUniversity(String universityName){
        return univeristyToStudent.getOrDefault(universityName,null);
    }

    @GetMapping("/getStudById")
    public StudentModel getStudentById(String id){
        return idToStudent.getOrDefault(id,null);
    }


}
