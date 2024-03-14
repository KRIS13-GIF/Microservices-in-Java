package com.example.school;


import com.example.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    private  StudentClient client;

    public void saveSchool(School school){

        schoolRepository.save(school);
    }

    public List<School>findAllSchools(){
        return schoolRepository.findAll();
    }


    public School getSchool(Integer id){
        Optional<School> school=schoolRepository.findById(id);
        if (school.isPresent()){
            return school.get();
        }
        else {
            throw new RuntimeException("No School found");
        }
    }


    public FullSchoolResponse findSchoolWithStudent(Integer schoolId) {

        Optional<School> school=schoolRepository.findById(schoolId);
        School school1=school.get();
        var students=client.findAllStudentsBySchool(schoolId); //find all students from the student microservice

        return FullSchoolResponse.builder()
                .name(school1.getName())
                .emaill(school1.getEmail())
                .students(students)
                .build();
    }
}
