package com.example.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    public void save(@RequestBody School school){
        schoolService.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity <List<School>>findAll(){
        return ResponseEntity.ok(schoolService.findAllSchools());
    }

    @GetMapping({"/{id}"})
    public School getSchool(@PathVariable("id") Integer id){
        return schoolService.getSchool(id);
    }


    // calling all the students of the school
    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllSchools(
            @PathVariable("school-id") Integer schoolId
    ){
        return ResponseEntity.ok(schoolService.findSchoolWithStudent(schoolId));
    }


}
