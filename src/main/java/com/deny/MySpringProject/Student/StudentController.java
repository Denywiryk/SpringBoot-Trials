package com.deny.MySpringProject.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/Student")
public class StudentController {
private final  StudentService studentService;
  @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> hello(){

        return  studentService.getSudent();
    }

  @PostMapping
    public  void  registerNewStudent(@RequestBody Student student) throws IllegalAccessException {
      studentService.addNewStudent(student);


    }
    @DeleteMapping(path = "studentId")
    public  void  deleteStudent(@PathVariable("studentId") Long studentId){
    studentService.deleteStudent(studentId);

    }



}
