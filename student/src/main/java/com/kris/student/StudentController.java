package com.kris.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity <List<Student>>findAll(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity <List<Student>>findAllStudents(
            @PathVariable("school-id")Integer schoolId
    ){
        return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
    }




}
